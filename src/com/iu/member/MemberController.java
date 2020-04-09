package com.iu.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bouncycastle.pqc.math.linearalgebra.GoppaCode.MaMaPe;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private MemberService memberService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        this.memberService = new MemberService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//pathInfo
		String command = request.getPathInfo();
		//Method
		String method = request.getMethod();
		//forward (t) redirect (f)
		boolean check = true;
		
		//url 
		String path = "";
		
		try {
				
		if (command.equals("/memberJoin")) {
			
			if (method.equals("POST")) {
				MemberDTO memberDTO = new MemberDTO();
				memberDTO.setId(request.getParameter("id"));
				memberDTO.setPw(request.getParameter("pw"));
				memberDTO.setName(request.getParameter("name"));
				memberDTO.setEmail(request.getParameter("email"));
				memberDTO.setPhone(request.getParameter("phone"));
				memberDTO.setAge(Integer.parseInt(request.getParameter("age")));
				check = false;
				int result = memberService.memberJoin(memberDTO);
				String msg = "가입실패";
				path = "../";
			}else {
				path = "../WEB-INF/views/member/memberJoin.jsp";
			}
			
		}else if(command.equals("/memberLogin")) {
			if (method.equals("POST")) {
				MemberDTO memberDTO = new MemberDTO();
				memberDTO.setId(request.getParameter("id"));
				memberDTO.setPw(request.getParameter("pw"));
			
				memberDTO = memberService.memberLogin(memberDTO);
				if(memberDTO !=null) {
					/* 세션은 request 에 있음*/
					HttpSession session = request.getSession();
					session.setAttribute("member", memberDTO);
					
					check = false;
					path = "../";
				}else {
					request.setAttribute("result", "Login-fail");
					request.setAttribute("path", "./memberLogin");
					path="../WEB-INF/views/common/result.jsp";
				}
				
			}else {
				path="../WEB-INF/views/member/memberLogin.jsp";
			}
			
		}else if(command.equals("/memberLogout")) {
			/* 로그아웃할려면 세션에있는 멤버를 지울거야*/
			HttpSession session = request.getSession();
			//session.removeAttribute("member"); 세션을 지우는방법
			//세션을 강제로 종료 invalidate();
			// 세션은 브라우저마다 생성된다.
			session.invalidate();
			
			check = false;
			path = "../";
			
		}else if(command.equals("/memberPage")) {
			if(method.equals("POST")) {
				String name = request.getParameter("name");
				
				MemberDTO memberDTO = memberService.memberPage(name);
				request.setAttribute("dto", memberDTO);
				
				path="../WEB-INF/views/member/memberPage.jsp";
			}
			
		}else {
			System.out.println("ETC");
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
