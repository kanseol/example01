package com.example.example01.sample02;

import java.sql.*;

// 드라이버 : jdbc 표준을 각 DB업체가 구현
// 			wdm 표준을 각 하드웨어 업체가 구현
// 연결(Connection) : db 연결 객체
public class JDBCTest {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		// xe : 오라클 서버의 id(sid). 오라클 xe버전의 sid는 무조건 xe
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "TIGER";
		
		// 드라이버를 메모리에 로딩한다 -> 생성자 호출 직전
		Connection connection = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("연결 객체 : " + connection);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버를 찾을 수 없습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
