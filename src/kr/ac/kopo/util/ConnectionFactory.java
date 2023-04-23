package kr.ac.kopo.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	// throws Exception 을 써도 잡힐 지 모르겠을때 트라이-캐치. 트라이-캐치 쓰기 싫으면 밑에서 익셉션을 throws해줌
	
	public Connection getConnection() throws Exception {
		
		Connection conn = null;
		
		
//		try {
		 Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";
			conn = DriverManager.getConnection(url, user, password);
		 
			
			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		return conn;
	}
	
	
}
