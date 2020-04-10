package com.iu.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.iu.util.DBConnect;

public class MemberDAO {

	//회원가입add insert
	public int memberJoin(MemberDTO memberDTO) throws Exception{
		int result =0;
		
		Connection con = DBConnect.getConnect();
		String sql ="INSERT INTO member VALUES (?,?,?,?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		st.setString(3, memberDTO.getName());
		st.setString(4, memberDTO.getEmail());
		st.setString(5, memberDTO.getPhone());
		st.setInt(6, memberDTO.getAge());
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		return result;
	}
	//로그인 
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception{
		Connection con = DBConnect.getConnect();
		String sql = "select * from member where id=? and pw=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			memberDTO.setName(rs.getString("name"));
			memberDTO.setEmail(rs.getString("email"));
			memberDTO.setPhone(rs.getString("phone"));
			memberDTO.setAge(rs.getInt("age"));
			
		}else {
			memberDTO = null;
			
		}
		rs.close();
		st.close();
		con.close();
		
		return memberDTO;
		// 끝나면 서비스로
	}
	//delete
	public int memberDelete(MemberDTO memberDTO) throws Exception{
		Connection con = DBConnect.getConnect();
		String sql = "delete member where id = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, memberDTO.getId());
		int result = st.executeUpdate();
		 
		st.close();
		con.close();
		
		return result;
	}
	
	
	//update
	public int memberUpdate(MemberDTO memberDTO) throws Exception {
		int result =0;
		Connection con = DBConnect.getConnect();
		//2. 쿼리문 작성.
		String sql = "UPDATE member set name= ?, email= ?,phone=? ,age=? where id = ?";
		//3. 미리보내기
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, memberDTO.getName());
		st.setString(2, memberDTO.getEmail());
		st.setString(3, memberDTO.getPhone());
		st.setInt(4, memberDTO.getAge());
		st.setString(5, memberDTO.getId());
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		return result;
	}
	
		
	
	
	
}
