package co.micol.bootstrap.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.bootstrap.comm.Command;
import co.micol.bootstrap.member.service.MemberService;
import co.micol.bootstrap.member.service.MemberVO;
import co.micol.bootstrap.member.serviceImpl.MemberServiceImpl;

public class LoginCheck implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		//로그인 처리 하는 곳.
		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo = memberDao.memberSelect(vo);
		String viewPage = null;
		if (vo != null) {
			HttpSession session = request.getSession();
			session.setAttribute("id", vo.getId());
			session.setAttribute("name", vo.getName());
			session.setAttribute("author", vo.getAuthor());
			viewPage = "main.do";
			
		}else {
			viewPage = "main/login";
		}
		return viewPage;
	}

}
