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
//서블렛
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
					/* 파라미터는 사라지기때문에 세션으로 담아야함 로그인*/
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
			//로그인한 사람만 들어갈수 있으니 
			/*  오류 발생한 이유 : request 속성명을  불러와서 안떳음.*/
			//   / 가야하니까 
			path="../WEB-INF/views/member/memberPage.jsp";
			
		}else if(command.equals("/memberDelete")) {
			 HttpSession session= request.getSession();
			 //세션은 오브젝트 객체이기에 감싸야함.
			 MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
			System.out.println(memberDTO.getId());
			int result = memberService.memberDelete(memberDTO);
			
			if(result>0) {
				session.invalidate();
			}
			check=false;
			path="../";
			
			
			
		}else if(command.equals("/memberUpdate")) {
			
			if(method.equals("POST")) {
				//db가서 업데이트
				HttpSession session = request.getSession();
				MemberDTO memberDTO = new MemberDTO();
				memberDTO.setId(request.getParameter("id"));
				memberDTO.setPw(request.getParameter("pw"));
				memberDTO.setName(request.getParameter("name"));
				memberDTO.setEmail(request.getParameter("email"));
				memberDTO.setPhone(request.getParameter("phone"));
				memberDTO.setAge(Integer.parseInt(request.getParameter("age")));
				//위 데이터 가지고 업데이트
				int result = memberService.memberUpdate(memberDTO);
				
				
				if(result>0) {
					//세션데이터를 바뀐 데이터로 수정
					session.setAttribute("member", memberDTO);
				}
				
				
				//리다이렉트로 인덱스
				check=false;
				path = "../";
				
				
				
			}else {
				//get이라면 여기 가서 데이터 입력하면 post로
				path = "../WEB-INF/views/member/memberUpdate.jsp";
			}
			
		}
		else {
			System.out.println("ETC");
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(check) {
			// jsp로 가기위해서 forward
			//forward (t) 
			RequestDispatcher view = request.getRequestDispatcher(path);
			view.forward(request, response);
		}else {
			//redirect (f)
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
