package com.iu.point;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//0408
/**
 * Servlet implementation class PointController
 */
@WebServlet("/PointController")
public class PointController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PointController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 한글 인코딩 처리는 항상 맨위에 작성
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// pathInfo
		String command = request.getPathInfo();

		// Method post, get 인가 
		String method = request.getMethod();

		// 클라에게 보낼방식 Foward(true), redirect(false) 선택
		boolean check = true;

		// URL (path)를 담을 변수
		String path = "";

		if (command.equals("/pointList")) {
			/* System.out.println("List"); */
			/* 1. lib에다가 ojdbc6.jar 복사붙이기 */
			
			
			path = "../WEB-INF/views/point/pointList.jsp";
			
		} else if (command.equals("/pointAdd")) {
			/* System.out.println("Add"); */
			if(method.equals("POST")) {
			/* 포스트일떄 체크값 변경 패스변경*/
				
			}else {
				path = "../WEB-INF/views/point/pointAdd.jsp";
			}
			
		} else if (command.equals("/pointMod")) {
			/* System.out.println("Mod"); */
			if(method.equals("POST")) {
				/*포스트일때*/
			}else {
				path = "../WEB-INF/views/point/pointMod.jsp";
			}
			
		} else if (command.equals("/pointSelect")) {
			/* System.out.println("Select"); */
			path = "../WEB-INF/views/point/pointSelect.jsp";
			
		} else if (command.equals("/pointDelete")) {
			/* System.out.println("Delete"); */
			
		} else {
			System.out.println("ETC");
		}
		
		//어디로 보낼건지 
		if(check) {
			RequestDispatcher view = request.getRequestDispatcher(path);
			view.forward(request, response);
		}else {
			//false 는 리다이렉트
			response.sendRedirect(path);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
