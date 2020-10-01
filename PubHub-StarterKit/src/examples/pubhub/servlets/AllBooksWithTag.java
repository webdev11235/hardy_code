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
import examples.pubhub.utilities.DAOUtilities;

/**
 * Servlet implementation class AllBooksWithTag
 */
@WebServlet("/AllBooksWithTag")
public class AllBooksWithTag extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllBooksWithTag() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String tagName = request.getParameter("tagName");
		BookTagDAO dao = DAOUtilities.getBookTagDAO();
		List<Book> booksWithTag = dao.getBooksWithTag(tagName);
		
		if (booksWithTag.size() != 0) {
			request.setAttribute("booksWithTag", booksWithTag);
			request.getRequestDispatcher("ViewBooksWithTag.jsp").forward(request, response);
		}
		else {
			request.getSession().setAttribute("message", "There are no books with the tag " + tagName);
			request.getSession().setAttribute("messageClass", "alert-danger");
			request.getRequestDispatcher("ViewBooksWithTag.jsp").forward(request, response);
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
