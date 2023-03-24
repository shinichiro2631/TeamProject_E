package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Account;

/**
 * Servlet implementation class RegisterConfirmServlet
 */
@WebServlet("/RegisterConfirmServlet")
public class RegisterConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String password = request.getParameter("pw");
        String confirmPassword = request.getParameter("confirm_password");
        // パスワードが一致しているかをチェックする
        if (!password.equals(confirmPassword)) {
            // 一致していない場合はエラーメッセージを設定する
            request.setAttribute("errorMessage", "パスワードが一致しません");
            // エラーメッセージを表示するためのJSPにフォワードする
            RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
            dispatcher.forward(request, response);
            return;
        }
		
		String name = request.getParameter("name");
		String user_name = request.getParameter("user_name");
		String telstr = request.getParameter("tel");
		int tel = Integer.parseInt(telstr);
		String mail = request.getParameter("mail");
		String pw = request.getParameter("pw");
		
		Account account = new Account(-1, name, user_name, tel, mail, pw, null, null);
		// セッションスコープのインスタンス取得
		HttpSession session = request.getSession();
		
		// セッションスコープに値の保存
		// 第1引数：キー
		// 第2引数：保存する値
		session.setAttribute("input_data", account);
		
		String view = "WEB-INF/view/confirm.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
