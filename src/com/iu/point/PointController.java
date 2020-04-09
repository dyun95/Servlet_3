package com.iu.point;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//0408서블렛 3번
/**
 * Servlet implementation class PointController
 */
@WebServlet("/PointController")
public class PointController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 여기도 생성
	private PointService pointService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	// 여기도 서비스생성
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
				/* 여기서 데이터 보냄 pointList에다가 보냄 */
				request.setAttribute("list", ar);

				path = "../WEB-INF/views/point/pointList.jsp";

			} else if (command.equals("/pointAdd")) {
				/* System.out.println("Add"); */
				if (method.equals("POST")) {
					/* 포스트일떄 체크값 변경 패스변경 */
					PointDTO pointDTO = new PointDTO();
					String name = request.getParameter("name");
					/* 가져오는 파리미터값이 동일해야함. F12 네트워크 눌러서*/
					int num = Integer.parseInt(request.getParameter("num"));
					int kor = Integer.parseInt(request.getParameter("kor"));
					int eng = Integer.parseInt(request.getParameter("eng"));
					int math = Integer.parseInt(request.getParameter("math"));

					// dto에다가 웹에서 입력한거 옮겨서 세팅 하고 데배로 전송할거임. 합쳐서 할려면 밑에처럼
					/* pointDTO.setName(request.getParameter("name")); */
					/* pointDTO.setNum(Integer.parseInt(request.getParameter("num"))); */
					
					pointDTO.setName(name);
					pointDTO.setNum(num);
					pointDTO.setKor(kor);
					pointDTO.setEng(eng);
					pointDTO.setMath(math);

					//서비스에서 받아온거
					int result = pointService.pointAdd(pointDTO);
					
					/* 포워드로 보내면 문제점 : 데이터들이 보이질 않음
					 * path = "../WEB-INF/views/point/pointList.jsp";
					 *  */
					
					/* 리다이렉트로 보내줘야 한다.*/
					check = false;
					path = "./pointList"; 

					if (result > 0) {
						System.out.println("추가완료");
						RequestDispatcher view = request.getRequestDispatcher(path);
						view.forward(request, response);
					} else {
						response.sendRedirect("./pointAdd");
						System.out.println("실패");
					}

				}

				else {
					/* 겟일떄*/
					path = "../WEB-INF/views/point/pointAdd.jsp";
				}

			} else if (command.equals("/pointMod")) {
				/* System.out.println("Mod"); */
				
				
				if (method.equals("POST")) {
					/* 포스트일때 */
					
					PointDTO pointDTO = new PointDTO();
					String name = request.getParameter("name");
					/* 가져오는 파리미터값이 동일해야함. F12 네트워크 눌러서*/
					int num = Integer.parseInt(request.getParameter("num"));
					int kor = Integer.parseInt(request.getParameter("kor"));
					int eng = Integer.parseInt(request.getParameter("eng"));
					int math = Integer.parseInt(request.getParameter("math"));


					pointDTO.setName(name);
					pointDTO.setNum(num);
					pointDTO.setKor(kor);
					pointDTO.setEng(eng);
					pointDTO.setMath(math);
					
					int result = pointService.pointMod(pointDTO);
					check = false;
					
					
					path = "./pointSelect?num="+pointDTO.getNum();
					
				} else {
					int num = Integer.parseInt(request.getParameter("num"));
					
					PointDTO pointDTO= pointService.pointSelect(num);
					request.setAttribute("dto", pointDTO);
					
					path = "../WEB-INF/views/point/pointMod.jsp";
				}

			} else if (command.equals("/pointSelect")) {
				/* System.out.println("Select"); */

				int num = Integer.parseInt(request.getParameter("num"));

				PointDTO pointDTO = pointService.pointSelect(num);

				request.setAttribute("dto", pointDTO);

				path = "../WEB-INF/views/point/pointSelect.jsp";

			} else if (command.equals("/pointDelete")) {
				/* System.out.println("Delete"); */
				int num = Integer.parseInt(request.getParameter("num"));
				int result = pointService.pointDelete(num);
				check = false;
				/* 리다이렉트로 pointList로 보냄. */
				path = "./pointList";

			} else {
				System.out.println("ETC");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 어디로 보낼건지
		if (check) {
			RequestDispatcher view = request.getRequestDispatcher(path);
			view.forward(request, response);
		} else {
			// false 는 리다이렉트
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
