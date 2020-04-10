package com.iu.notice;

import java.util.ArrayList;

public class NoticeService {
	
	private NoticeDAO noticeDAO;
	
	public NoticeService() {
		this.noticeDAO = new NoticeDAO();
	}
	

	//1. list
	public ArrayList<NoticeDTO> noticeList() throws Exception {
		return noticeDAO.noticeList();
	}
	//2. select
	public NoticeDTO noticeSelect(int num)throws Exception{
		return noticeDAO.noticeSelect(num);
		
	}
	//3 delete
	public int noticeDelete(int num) throws Exception{
		return noticeDAO.noticeDelete(num);
		
	}
		
	//4.add
	public int noticeAdd(NoticeDTO noticeDTO)throws Exception {
		return noticeDAO.noticeAdd(noticeDTO);
		
		
	}
	//5. update 
	public int noticeMod(NoticeDTO noticeDTO)throws Exception{
		return noticeDAO.noticeMod(noticeDTO);
		
		
	}
	
	
	
}
