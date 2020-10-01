package examples.pubhub.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examples.pubhub.dao.BookTagDAO;
import examples.pubhub.model.Book;
import examples.pubhub.model.BookTag;
import examples.pubhub.utilities.DAOUtilities;

/**
 * Servlet implementation class TagsOfBook
 */
@WebServlet("/TagsOfBook")
public class TagsOfBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TagsOfBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String isbn13 = request.getParameter("isbn13");
		BookTagDAO dao = DAOUtilities.getBookTagDAO();
		List<BookTag> tagsOfBook = dao.getBookTags(isbn13);
		
		if (tagsOfBook.size() != 0) {
			request.setAttribute("tagsOfBook", tagsOfBook);
			request.getRequestDispatcher("ViewTagsOfBook.jsp").forward(request, response);
		}
		else {
			request.getSession().setAttribute("message", "Tags for book with isbn " + isbn13 + " do not exist");
			request.getSession().setAttribute("messageClass", "alert-danger");
			request.getRequestDispatcher("ViewTagsOfBook.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}*/

}
