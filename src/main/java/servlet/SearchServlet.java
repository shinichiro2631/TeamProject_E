package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Book;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String keyword = request.getParameter("keyword");
		    
		    // データベースからキーワードを含む図書を検索
		    List<Book> bookList = searchBooks(keyword);
		    
		    // 検索結果をリクエスト属性に設定して、JSPに渡す
		    request.setAttribute("bookList", bookList);
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		    dispatcher.forward(request, response);
		  }
		  
		  private List<Book> searchBooks(String keyword) {return null;
			
		    // データベースからキーワードを含む図書を検索する処理
		  }
		
}

