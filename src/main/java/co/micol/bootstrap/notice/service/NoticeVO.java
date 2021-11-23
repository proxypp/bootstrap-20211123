package co.micol.bootstrap.notice.service;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NoticeVO {
	private int no;
	private String id;
	private String name;
	private Date wdate;
	private String title;
	private String subject;
	private String fileName;
	private String pfileName;
	
	
	//여기다가 필요시 추가하면 된다.
}
