package com.iu.point;

import java.io.IOException;
import java.util.ArrayList;

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
	
	//여기도 생성
	private PointService pointService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	//여기도 서비스생성
	public PointController() {
		super();
		this.pointService = new PointService();
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

		try {
						
		
		if (command.equals("/pointList")) {
			/* System.out.println("List"); */
			/* lib에다가 ojdbc6.jar 복사붙이기 */
			
				/* .서비스에 리스트를 ar로 담아서 */
				ArrayList<PointDTO> ar = pointService.pointList();
				/*여기서 데이터 보냄 pointList에다가 보냄*/
				request.setAttribute("list", ar);
					
			
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
			
			int num =Integer.parseInt(request.getParameter("num"));
			
			PointDTO pointDTO = pointService.pointSelect(num);
			
			request.setAttribute("dto", pointDTO);
			
			
			path = "../WEB-INF/views/point/pointSelect.jsp";
			
		} else if (command.equals("/pointDelete")) {
			/* System.out.println("Delete"); */
		int num = Integer.parseInt(request.getParameter("num"));
		int result = pointService.pointDelete(num);
		check = false;
		/*리다이렉트로 pointList로 보냄.*/
		path="./pointList";

			
			
		} else {
			System.out.println("ETC");
		}
		} catch (Exception e) {
			e.printStackTrace();
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
