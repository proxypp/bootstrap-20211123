package co.micol.bootstrap.comm;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.bootstrap.comm.main.Buttons;
import co.micol.bootstrap.comm.main.Login;
import co.micol.bootstrap.main.MainCommand;
import co.micol.bootstrap.member.command.LoginCheck;
import co.micol.bootstrap.member.command.Logout;
import co.micol.bootstrap.notice.command.NoticeList;

/**
 * 메인 컨트롤러 
 */

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String , Command> map = new HashMap<String, Command>();
       
    public FrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainCommand()); //시작하는 곳.
		map.put("/noticeList.do", new NoticeList()); //공지사항 목록.
		map.put("/buttons.do", new Buttons()); //buttons.html 호출.
		map.put("/login.do", new Login());  //로그인 폼 호출.
		map.put("/loginCheck.do", new LoginCheck());  //로그인 처리.
		map.put("/logout.do", new Logout()); //로그아웃.
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length());

		Command command = map.get(page);
		String viewPage = command.run(request, response);
		
		if (!viewPage.endsWith(".do")) {
			if (viewPage.startsWith("ajax:")) {
				//ajax 처리 루틴.
				//response.setContentType("text/html; charset=UTF-8");
				//response.getWriter().append(viewPage.substring(5));
				return;
			}
			if(viewPage.endsWith(".jsp")) {
				viewPage = "WEB-INF/views/"+viewPage;
			}else {				
				viewPage = viewPage+".tiles";  //타일즈 레이아웃 사용하기 위해
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}
}
