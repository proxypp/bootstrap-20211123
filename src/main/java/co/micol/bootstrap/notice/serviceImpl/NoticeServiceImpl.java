package co.micol.bootstrap.notice.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.micol.bootstrap.notice.service.NoticeMapper;
import co.micol.bootstrap.notice.service.NoticeService;
import co.micol.bootstrap.notice.service.NoticeVO;
import co.micol.bootstrap.comm.DataSource;

public class NoticeServiceImpl implements NoticeService {
	private SqlSession sqlSession = DataSource.getDataSource().openSession(true);
	private NoticeMapper map = sqlSession.getMapper(NoticeMapper.class);

	@Override
	public List<NoticeVO> noticeSelectList() {
		return map.noticeSelectList();
	}

	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		return map.noticeSelect(vo);
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		return map.noticeInsert(vo);
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		return map.noticeUpdate(vo);
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
		return map.noticeDelete(vo);
	}

	@Override
	public List<NoticeVO> noticeSearchList(String searchKey) {
		return map.noticeSearchList(searchKey);
	}

}
