package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import dto.Book;

/**
 * Servlet implementation class RegisterBookServlet
 */
@WebServlet("/RegisterBookServlet")
public class RegisterBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String isbn = request.getParameter("isbn");
		int no = Integer.parseInt(request.getParameter("new_old"));		// intに変換
		String new_old = no == 0 ? "新" : "旧";  // 三項演算子
		System.out.println(new_old);
		String publisher = request.getParameter("publisher");
		int count = Integer.parseInt(request.getParameter("count"));
		
		int result=0;
		
		for(int i=1; i<=count; i++) {
		Book book = new Book(0, title, author, isbn, new_old, publisher);
		result = BookDAO.registerBook(book);
		}
		
		String view = "";
		if(result == 1) {
			view = "WEB-INF/view/book-succes.jsp";
		} else {
			view = "WEB-INF/view/book-fail.jsp";
		}
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
