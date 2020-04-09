package com.iu.point;

import java.util.ArrayList;

public class PointService {
	
	private PointDAO pointDAO;
	
	//공식 위 퍼블릭 클래스이름과동일하게
	public PointService() {
		this.pointDAO = new PointDAO();
	
	}
	
	//1. List
	public ArrayList<PointDTO> pointList() throws Exception {
		return  pointDAO.pointList();
	}
	
	//2.select
	public PointDTO pointSelect(int num) throws Exception {
		return pointDAO.pointSelect(num);
	}
	
	//3.delete
	public int pointDelete(int num) throws Exception{
		return pointDAO.pointDelete(num);
		
	}
	//4.Insert
	//DAO에 있는 데이터를 받아와서 
	public int pointAdd(PointDTO pointDTO) throws Exception {
		pointDTO.setTotal(pointDTO.getKor() + pointDTO.getEng() + pointDTO.getMath());
		pointDTO.setAvg(pointDTO.getTotal() / 3.0);

		int result = pointDAO.pointAdd(pointDTO);

		return result;

	}
	//5.Update
	public int pointMod(PointDTO pointDTO) throws Exception {
		pointDTO.setTotal(pointDTO.getKor() + pointDTO.getEng() + pointDTO.getMath());
		pointDTO.setAvg(pointDTO.getTotal() / 3.0);
		 
		 
		int result = pointDAO.pointMod(pointDTO);
		return result;
	}
	

}
