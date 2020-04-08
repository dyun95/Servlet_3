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

}
