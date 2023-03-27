package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDAO;
import dao.HistoryDAO;
import dto.Book;

/**
 * Servlet implementation class History
 */
@WebServlet("/History")
public class HistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		int account_id = Integer.parseInt(request.getParameter("Account"));
		int book_id = Integer.parseInt(request.getParameter("Book"));
		
		Book book = BookDAO.searchIDBook(book_id);
		int due_date =0;
		if(book.getNew_old() == "新") {
			due_date=7;
		} else {
			due_date=14;
		}
		int i = HistoryDAO.registerHistory(book_id, account_id, due_date);
		
		// セッションスコープのインスタンス取得
				HttpSession session = request.getSession();
				
				// セッションスコープに値の保存
				// 第1引数：キー
				// 第2引数：保存する値
				session.setAttribute("input_dataB", book);
				
		String view = "WEB-INF/view/lendsuccess.jsp";
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
