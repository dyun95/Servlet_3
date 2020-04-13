package com.iu.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iu.member.MemberDTO;

/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter("/AdminFilter")
public class AdminFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//필터는 형변환을 해야한다. 
		HttpSession session = ((HttpServletRequest)request).getSession();
		
		//밑에처럼 하면 오류  형변환 해야함
		//MemberDTO memberDTO = session.getAttribute("member");
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		
		
		String command = ((HttpServletRequest)request).getPathInfo();
		
		
		
		//로그인햇는지 확인
		if(memberDTO != null) {
			//햇으면 아이디가 admin인사람
			String id = memberDTO.getId();
			if(id.equals("admin")) {
				//admin
				System.out.println("Admin");
				chain.doFilter(request, response);
			}else {
				//admin 아닌경우 일반사용자.
				System.out.println("Member");
				((HttpServletResponse)response).sendRedirect("../member/memberLogin");
				
				
				
				/* 나중에 해결
				 * //보내기전에 세팅 request.setAttribute("result", "권한이 필요");
				 * request.setAttribute("path", "../");
				 * 
				 * RequestDispatcher view =
				 * request.getRequestDispatcher("../common/result.jsp"); view.forward(request,
				 * response);
				 */
			}
			
		}else {
			//로그인이 안된 상태
			//로그인하게끔 리다이렉트
			((HttpServletResponse)response).sendRedirect("../member/memberLogin");
		}
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
