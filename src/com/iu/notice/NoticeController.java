package com.iu.notice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NoticeController
 */
@WebServlet("/NoticeController")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private NoticeService noticeService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeController() {
        super();
        this.noticeService = new NoticeService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 인코딩 처리.
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
							
				
				if(command.equals("/noticeList")) {
					 //서비스에 리스트로 가세요
					
					ArrayList<NoticeDTO> ar = noticeService.noticeList();
					request.setAttribute("list", ar);
					
					path="../WEB-INF/views/notice/noticeList.jsp";
					
				}else if(command.equals("/noticeAdd")) {
					
					if(method.equals("POST")) {
						
						NoticeDTO noticeDTO = new NoticeDTO();
						

						noticeDTO.setSubject (request.getParameter("subject"));
						noticeDTO.setContent(request.getParameter("content"));
						noticeDTO.setId(request.getParameter("id"));						
						int result = noticeService.noticeAdd(noticeDTO);
							
						check = false;
						path = "../";
						
					}else {
						path="../WEB-INF/views/notice/noticeAdd.jsp";
					}
					
					
				}else if(command.equals("/noticeMod")) {
					if(method.equals("POST")) {
						
						NoticeDTO noticeDTO = new NoticeDTO();
						noticeDTO.setNo(Integer.parseInt(request.getParameter("no")));
						noticeDTO.setSubject (request.getParameter("subject"));
						noticeDTO.setContent(request.getParameter("content"));
						noticeDTO.setId(request.getParameter("id"));
						
						int result = noticeService.noticeAdd(noticeDTO);
						
						/* check = false; 안되면 추가1  */
						/*path="./noticeList";   체크펄스 해도 안되면 밑에 지욱 2번추가*/
						path="../WEB-INF/views/notice/noticeList.jsp";
						
					}else {
						int num = Integer.parseInt(request.getParameter("no"));
						NoticeDTO noticeDTO = noticeService.noticeSelect(num);
						request.setAttribute("dto", noticeDTO);
						path="../WEB-INF/views/notice/noticeMod.jsp";
					}
					
				}else if(command.equals("/noticeSelect")) {
					int num = Integer.parseInt(request.getParameter("no"));
					
					NoticeDTO noticeDTO = noticeService.noticeSelect(num);
					
					request.setAttribute("dto", noticeDTO);
					
					path="../WEB-INF/views/notice/noticeSelect.jsp";
					
				}else if(command.equals("/noticeDelete")) {
					int num = Integer.parseInt(request.getParameter("no"));
					
					int result = noticeService.noticeDelete(num);
					
					check=false;
					path="./noticeList";
					
					
				}
				
				
				
				else{
					System.out.println("ETC");
					
				}	
				} catch (Exception e) {
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