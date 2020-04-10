package com.iu.notice;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iu.point.PointDTO;



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
						

					
						noticeDTO.setNo(Integer.parseInt(request.getParameter("no")));
						noticeDTO.setSubject (request.getParameter("subject"));
						noticeDTO.setContent(request.getParameter("content"));
						noticeDTO.setId(request.getParameter("id"));
						noticeDTO.setNdate(( request.getParameter("ndate")));
						noticeDTO.setHit( Integer.parseInt(request.getParameter("hit")));
						int result = noticeService.noticeAdd(noticeDTO);
						String msg = "게시판 등록 실패";
						
						if(result>0) {
							msg = "게시판 등록 성공";
						}				
						
						request.setAttribute("result", msg);
						request.setAttribute("path", "./noticeList");
						path = "../WEB-INF/views/common/result.jsp";
						
					}else {
						path="../WEB-INF/views/point/noticeAdd.jsp";
					}
					
					
				}else if(command.equals("/noticeMod")) {
					if(method.equals("POST")) {
						
						NoticeDTO noticeDTO = new NoticeDTO();
						noticeDTO.setNo(Integer.parseInt(request.getParameter("no")));
						noticeDTO.setSubject (request.getParameter("subject"));
						noticeDTO.setContent(request.getParameter("content"));
						noticeDTO.setId(request.getParameter("id"));
						noticeDTO.setHit( Integer.parseInt(request.getParameter("hit")));
						int result = noticeService.noticeAdd(noticeDTO);
						
						
						
						String msg = "게시판 수정 실패";
						
						if(result>0) {
							msg = "게시판 수정 성공";
							request.setAttribute("path", "./noticeSelect?no="+noticeDTO.getNo());
						}else {
							request.setAttribute("path", "./notcieList");
						}
						
						request.setAttribute("result", msg);
						
						path="../WEB-INF/views/common/result.jsp";
						
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
