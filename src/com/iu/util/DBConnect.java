package com.iu.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	// 테스트 전용 메인
	public static void main(String[] args) {
		try {
			// static 있기에 객체생성안하고 클래스명만
			Connection con = DBConnect.getConnect();
			System.out.println(con);
		} catch (Exception e) {
			/* e.printStackTrace() 써야 콘솔창에 오류 봄*/
			e.printStackTrace();
		}

	}
	//DB연결할려면 Connection 필요
	public static Connection getConnect() throws Exception {
		// 1. 로그인 정보 4가지
		//logon deny
				//1. ID/PW가 틀렸을 경우
				//2. DB에 해당 유저가 생성되지 않은 경우
				//3. 유저의 권한이 적용 되지 않은 경우
		String user="user02";
		String password="user02";

		//1. ip, port, xe 정보가 틀린경우
		//2. 물리적으로 연결이 안되거나, 서버가 종료된경우
		//3. Listener 문제, DB 재시동
		
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		//class not found
		//1. diver명이 틀린경우
		//2. jdbc(ojdbc6.jar)가 없는 경우
		
		String driver="oracle.jdbc.driver.OracleDriver";

		// 2. 드라이버를 메모리에 로딩
		Class.forName(driver);
		// 3. 로그인 Connection 객체 봔환.
		Connection con = DriverManager.getConnection(url, user, password);

		return con;

	}
}