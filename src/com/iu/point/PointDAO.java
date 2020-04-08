package com.iu.point;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.util.DBConnect;

public class PointDAO {
	//DAO(Data Access Object)
	
	//1. List
	public ArrayList<PointDTO> pointList() throws Exception {
		/*와일문 밖에서 arraylist생성<>*/
		ArrayList<PointDTO> ar = new ArrayList<PointDTO>();
		
		
		//1. db연결
		Connection con = DBConnect.getConnect();
		//2. sql문 작성
		String sql ="select * from point ORDER BY num asc"; 
		//3. sql미리전송
		PreparedStatement st = con.prepareStatement(sql);
		//4. ?값 있으면  세팅.
		
		//5. 최종전송후 결과 처리
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			PointDTO pointDTO = new PointDTO();
			pointDTO.setName(rs.getString("name"));
			pointDTO.setNum(rs.getInt("num"));
			pointDTO.setKor(rs.getInt("kor"));
			pointDTO.setEng(rs.getInt("eng"));
			pointDTO.setMath(rs.getInt("math"));
			pointDTO.setTotal(rs.getInt("total"));
			pointDTO.setAvg(rs.getDouble("avg"));
			
			ar.add(pointDTO);
		}
		
		//6. 자원 해제.
		rs.close();
		st.close();
		con.close();
		
		return ar;
	}//point list end
	
	//2. SelectOne
	public PointDTO pointSelect(int num) throws Exception{
		PointDTO pointDTO = null;
		
		//1. DB연결
		Connection con = DBConnect.getConnect();
		//2. sql작성
		String sql = "select * from point where num = ?";
		//3.sql미리전송
		PreparedStatement st = con.prepareStatement(sql);
		//4.?값 있으면  세팅.
		st.setInt(1, num);
		//5. 최종전송후 결과 처리
		ResultSet rs = st.executeQuery();
			
		if(rs.next()) {
			/*객체만들어서*/
			pointDTO = new PointDTO();
			pointDTO.setName(rs.getString("name"));
			pointDTO.setNum(rs.getInt("num"));
			pointDTO.setKor(rs.getInt("kor"));
			pointDTO.setEng(rs.getInt("eng"));
			pointDTO.setMath(rs.getInt("math"));
			pointDTO.setTotal(rs.getInt("total"));
			pointDTO.setAvg(rs.getDouble("avg"));
			
		}
		
		//6. 자원 해제.
		rs.close();
		st.close();
		con.close();
		
		return pointDTO;
		
	}
	
	
	
	//3. Insert
	
	//4. Update
	
	//5. Delete
	public int pointDelete(int num) throws Exception{
		int result = 0;
		//1. DB연결
		Connection con = DBConnect.getConnect();
		//2. sql작성
		String sql = "delete point where num = ?";
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
