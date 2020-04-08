package com.iu.point;

import java.io.IOException;
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

		// Method 형식
		String method = request.getMethod();

		// 클라에게 보낼방식 Foward(true), redirect(false) 선택
		boolean check = true;

		// path를 담을 변수
		String path = "";

		if (command.equals("/pointList")) {
			System.out.println("List");
		} else if (command.equals("/pointAdd")) {
			System.out.println("Add");
		} else if (command.equals("/pointMod")) {
			System.out.println("Mod");
		} else if (command.equals("/pointSelect")) {
			System.out.println("Select");
		} else if (command.equals("/pointDelete")) {
			System.out.println("Delete");
		} else {
			System.out.println("ETC");
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
