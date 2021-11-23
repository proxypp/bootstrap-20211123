package co.micol.bootstrap.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.bootstrap.comm.Command;
import co.micol.bootstrap.notice.service.NoticeService;
import co.micol.bootstrap.notice.serviceImpl.NoticeServiceImpl;

public class NoticeList implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		//공지사항 처리 해서
		NoticeService noticeDao = new NoticeServiceImpl();
		request.setAttribute("notices", noticeDao.noticeSelectList());
		
		return "notice/noticeList"; //타일즈를 사용하지 않음.
	}

}
