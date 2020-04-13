package com.iu.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter("/EncodingFilter")
public class EncodingFilter implements Filter {
	//선언한것을 담은다음
	private String enc;
	

    /**
     * Default constructor. 
     */
	
    public EncodingFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// Filter 객체가 소멸될때 실행되는 메서드
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 요청이 발생하면 실행
		
		//enc로 담은 값 : UTF-8 을 선언
		request.setCharacterEncoding(enc);
		
		System.out.println("Encoding Filter IN");
		
		chain.doFilter(request, response);
		
		response.setCharacterEncoding("UTF-8");
		System.out.println("Encoding Filter OUT");
		// 다음 필터 또는 Servlet으로 전달.
		
		// 응답이 발생하면 실행
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		//Filter 객체가 생성후 초기화 메서드
		
		//이값을 위에 올리려면 private 으로 선언하고
		enc = fConfig.getInitParameter("enc");
		
		
	}

}
