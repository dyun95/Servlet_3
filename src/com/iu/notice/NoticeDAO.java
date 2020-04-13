package com.iu.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.iu.util.DBConnect;

public class NoticeDAO {

	// 1 list
	public ArrayList<NoticeDTO> noticeList() throws Exception {

		ArrayList<NoticeDTO> ar = new ArrayList<NoticeDTO>();

		Connection con = DBConnect.getConnect();

		String sql = "select * from notice ORDER BY no asc";

		PreparedStatement st = con.prepareStatement(sql);

		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			NoticeDTO noticeDTO = new NoticeDTO();
			noticeDTO.setNo(rs.getInt("no"));
			noticeDTO.setSubject(rs.getString("subject"));
			noticeDTO.setContent(rs.getString("content"));
			noticeDTO.setId(rs.getString("id"));
			noticeDTO.setNdate(rs.getDate("ndate"));
			noticeDTO.setHit(rs.getInt("hit"));
			
			ar.add(noticeDTO);
		}
		rs.close();
		st.close();
		con.close();
		
		return ar;
	}
	//select one
	public NoticeDTO noticeSelect(int num)throws Exception{
		NoticeDTO noticeDTO = null;
		
		Connection con = DBConnect.getConnect();
		
		String sql = "select * from notice where no = ?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, num);
		
		ResultSet rs = st.executeQuery();
		
		if (rs.next()) {
			noticeDTO = new NoticeDTO();
			noticeDTO.setNo(rs.getInt("no"));
			noticeDTO.setSubject(rs.getString("subject"));
			noticeDTO.setContent(rs.getString("content"));
			noticeDTO.setId(rs.getString("id"));
			noticeDTO.setNdate(rs.getDate("ndate"));
			noticeDTO.setHit(rs.getInt("hit"));
			
			
		}
		rs.close();
		st.close();
		con.close();
		
		return noticeDTO;
		
		
		
	}
	
	//update
	public int noticeMod(NoticeDTO noticeDTO) throws Exception{
		int result = 0;
		//1 연결
		Connection con = DBConnect.getConnect();
		//2. 쿼리문 작성.
		String sql = "UPDATE notice set subject= ?, content= ?,id=? where no = ?";
		//3. 미리보내기
		PreparedStatement st = con.prepareStatement(sql);
		
		//?세팅 **********
		
		st.setString(1, noticeDTO.getSubject());
		st.setString(2, noticeDTO.getContent());
		st.setString(3, noticeDTO.getId());	
		st.setInt(4, noticeDTO.getNo());
		
		
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
		
		
	}
	
	// add
	public int noticeAdd(NoticeDTO noticeDTO)throws Exception{
		int result = 0;				
		Connection con = DBConnect.getConnect();
		String sql = "INSERT INTO notice VALUES (notice_seq.nextval,?,?,?,sysdate,0)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, noticeDTO.getSubject());
		st.setString(2, noticeDTO.getContent());
		st.setString(3, noticeDTO.getId());
		
		
		
		result = st.executeUpdate();
		st.close();
		con.close();

		return result;
		
	}
	
	
	//delete
	
	public int noticeDelete(int num) throws Exception{
		int result = 0;
		//1. DB연결
		Connection con = DBConnect.getConnect();
		//2. sql작성
		String sql = "delete notice where no = ?";
		//3.sql미리전송
		PreparedStatement st = con.prepareStatement(sql);
		//4.?값 있으면  세팅.
		st.setInt(1, num);
		result = st.executeUpdate();
		//5. 최종전송후 결과 처리
		
		//6. 자원 해제.
		st.close();
		con.close();
		
		return result;
		
	}
	
	
	
	
	
	
}