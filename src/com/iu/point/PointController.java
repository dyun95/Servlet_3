package com.iu.point;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PointController
 */
@WebServlet("/PointController")
public class PointController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PointService pointService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PointController() {
        super();
        this.pointService = new PointService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//한글 Encoding 처리
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//pathInfo
		String command = request.getPathInfo();
		
		//Method 형식
		String method = request.getMethod();
		
		//Forward(true), redirect(false) 선택
		boolean check = true;
		
		//URL(path)를 담을 변수
		String path="";
		
		try {
			
		
		if(command.equals("/pointList")) {
			 
			ArrayList<PointDTO> ar = pointService.pointList();
			request.setAttribute("list", ar);
			
			
			path="../WEB-INF/views/point/pointList.jsp";
			
		}else if(command.equals("/pointAdd")) {
			
			if(method.equals("POST")) {
				PointDTO pointDTO = new PointDTO();
				pointDTO.setName(request.getParameter("name"));
				pointDTO.setNum(Integer.parseInt(request.getParameter("num")));
				pointDTO.setKor(Integer.parseInt(request.getParameter("kor")));
				pointDTO.setEng(Integer.parseInt(request.getParameter("eng")));
				pointDTO.setMath(Integer.parseInt(request.getParameter("math")));
				int result = pointService.pointAdd(pointDTO);
				String msg="점수 등록 실패";
				if(result>0) {
					msg = "점수 등록 성공";
				}				
				
				request.setAttribute("result", msg);
				request.setAttribute("path", "./pointList");
				path = "../WEB-INF/views/common/result.jsp";
				
			}else {
				path="../WEB-INF/views/point/pointAdd.jsp";
			}
			
			
			
		}else if(command.equals("/pointMod")) {
			
			if(method.equals("POST")) {
				PointDTO pointDTO = new PointDTO();
				pointDTO.setName(request.getParameter("name"));
				pointDTO.setNum(Integer.parseInt(request.getParameter("num")));
				pointDTO.setKor(Integer.parseInt(request.getParameter("kor")));
				pointDTO.setEng(Integer.parseInt(request.getParameter("eng")));
				pointDTO.setMath(Integer.parseInt(request.getParameter("math")));
				
				int result = pointService.pointMod(pointDTO);
				
				String msg = "점수 수정 실패";
				
				if(result>0) {
					msg = "점수 수정 성공";
					request.setAttribute("path", "./pointSelect?num="+pointDTO.getNum());
				}else {
					request.setAttribute("path", "./pointList");
				}
				
				request.setAttribute("result", msg);
				
				path="../WEB-INF/views/common/result.jsp";
				
			}else {
				int num = Integer.parseInt(request.getParameter("num"));
				PointDTO pointDTO = pointService.pointSelect(num);
				request.setAttribute("dto", pointDTO);
				path="../WEB-INF/views/point/pointMod.jsp";
			}
			
			
		}else if(command.equals("/pointSelect")) {
			
			int num = Integer.parseInt(request.getParameter("num"));
			
			PointDTO pointDTO = pointService.pointSelect(num);
			
			request.setAttribute("dto", pointDTO);
			
			path="../WEB-INF/views/point/pointSelect.jsp";
			
			
		}else if(command.equals("/pointDelete")) {
			int num = Integer.parseInt(request.getParameter("num"));
			
			int result = pointService.pointDelete(num);
			
			check=false;
			path="./pointList";
			
		}else {
			System.out.println("ETC");
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		// 
		if(check) {
			RequestDispatcher view = request.getRequestDispatcher(path);
			view.forward(request, response);
		}else {
			response.sendRedirect(path);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
