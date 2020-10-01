package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Book;
import model.BookTag;
import utilities.DAOUtilities;

public class BookTagDAOImpl implements BookTagDAO {
	Connection connection = null;
	PreparedStatement stmt = null;

	@Override
	public boolean addBookTag(String tagName, String isbn13) {
		
		try {
			connection = DAOUtilities.getConnection();
			String sql = "INSERT INTO book_tags VALUES (?, ?)";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, isbn13);
			stmt.setString(2, tagName);
			
			if (stmt.executeUpdate() != 0) {
				return true;
			}
			else {
				return false;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			closeResources();
		}
		
	}

	@Override
	public boolean removeBookTag(String tagName, String isbn13) {
		try {
			connection = DAOUtilities.getConnection();
			String sql = "DELETE FROM book_tags WHERE isbn_13 = ? AND tag_name = ?";
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, isbn13);
			stmt.setString(2, tagName);
			
			if (stmt.executeUpdate() != 0) {
				return true;
			}
			else {
				return false;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			closeResources();
		}
	}

	@Override
	public List<BookTag> getBookTags(String isbn13) {
		List<BookTag> bookTags = new ArrayList<BookTag>();
		try {
			connection = DAOUtilities.getConnection();
			String sql = "SELECT * FROM book_tags WHERE isbn_13 = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, isbn13);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				String tagName = rs.getString("tag_name");
				BookTag bookTag = new BookTag(isbn13, tagName);
				bookTags.add(bookTag);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeResources();
		}
		return bookTags;
	}

	@Override
	public List<Book> getBooksWithTag(String tagName) {
		List<Book> books = new ArrayList<Book>();
		
		try {
			connection = DAOUtilities.getConnection();
			String sql = "SELECT * FROM books WHERE isbn_13 IN (SELECT isbn_13 FROM book_tags WHERE tag_name = ?)";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, tagName);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Book book = new Book();
				book.setIsbn13(rs.getString("isbn_13"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPublishDate(rs.getDate("publish_date").toLocalDate());
				book.setPrice(rs.getDouble("price"));
				book.setContent(rs.getBytes("content"));
				
				books.add(book);
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeResources();
		}
		return books;
	}
	
	private void closeResources() {
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			System.out.println("Could not close statement!");
			e.printStackTrace();
		}
		
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			System.out.println("Could not close connection!");
			e.printStackTrace();
		}
	}

}
