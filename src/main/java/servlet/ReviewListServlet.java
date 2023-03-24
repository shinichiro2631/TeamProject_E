package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountDAO;
import dao.BookDAO;
import dao.ReviewDAO;
import dto.Account;
import dto.Book;
import dto.Review;

/**
 * Servlet implementation class ReviewListServlet
 */
@WebServlet("/ReviewListServlet")
public class ReviewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn = request.getParameter("isbn");
		Book book = BookDAO.searchisbnBook(isbn);
		request.setAttribute("book", book);
		List<Review> review = ReviewDAO.getReview(isbn);
		request.setAttribute("reviewlist", review);
		List<Account> account = new ArrayList<>();
		for(Review r : review) {
			Account ac = AccountDAO.searchidAccount(r.getAccount_id());
			account.add(ac);
		}
		request.setAttribute("accountlist", account);
		String view = "WEB-INF/view/book-review.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
