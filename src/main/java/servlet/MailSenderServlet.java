package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MailSenderServlet
 */
@WebServlet("/MailSenderServlet")
public class MailSenderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailSenderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String view = "/WEB-INF/view/Mail_Sending.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String[] to = request.getParameterValues("to[]");
		    String subject = request.getParameter("subject");
		    String body = request.getParameter("body");

		    // 定型文の作成
		    String standardSubject = "図書延滞のお知らせ";
		    String standardBody = "いつもお世話になっております。";

		    // 件名と本文を定型文に置換する
		    if (subject == null || subject.isEmpty()) {
		        subject = standardSubject;
		    }
		    else {
		        subject = standardSubject + " - " + subject;
		    }

		    if (body == null || body.isEmpty()) {
		        body = standardBody;
		    }
		    else {
		        body = standardBody + "\n\n" + body;
		    }
		    response.setContentType("text/html; charset=UTF-8");
		    response.setCharacterEncoding("UTF-8");
		    PrintWriter out = response.getWriter();
		    out.println("<html><head><title>送信完了</title></head><body>");
		    out.println("<p>送信が完了しました。</p>");
		    out.println("<p>件名： " + subject + "</p>");
		    out.println("<p>本文： " + body + "</p>");
		    out.println("</body></html>");
		}

		private void doGet() {
			// TODO 自動生成されたメソッド・スタブ

		}
	}