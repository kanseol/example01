package com.example.example01.sample03;

import java.sql.*;

public class UserManagerApp {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "scott";
	private String password = "TIGER";
	
	public void add(User user) throws ClassNotFoundException, SQLException {
		// 1. Connection : 서버에 대한 연결 객체
		Connection conn = null;
		Class.forName(driver);
		conn = DriverManager.getConnection(url, username, password);
		
		// 2. PreparedStatement : 실행할 sql문을 담고 있는 객체. 반드시 ;이 있으면 안된다 -> invalid character
		PreparedStatement pstmt = conn.prepareStatement("insert into users values(?,?,?)");
		
		// 만약 user가 spring, 홍길동, 1234라면 -> insert into users values('spring','홍길동','1234')
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getPasswrod());
		
		// 3. sql문 실행
		pstmt.executeUpdate();
		
		// 4. jdbc 관련 객체를 역순으로 닫는다
		pstmt.close();
		conn.close();
	}
	
	public void get(String id) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Class.forName(driver);
		conn = DriverManager.getConnection(id, driver, password);
		
		PreparedStatement pstmt = conn.prepareStatement("select id, name, password from users where id=?");
		pstmt.setString(1, id);
		
		// select문은 insert, update, delete와 다르다 : 실행 메소드도 다르고 결과도 다르다
		// ResultSet : select문의 검색 결과
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		
		User user = new User();
		user.setId(rs.getString(1));
		user.setName(rs.getString(2));
		user.setPasswrod(rs.getString(3));
		System.out.println("검색 결과 : " + user);
		
		rs.close();
		pstmt.close();
		conn.close();
	}
}
