package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testDB {
	
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String url = "jdbc:postgresql://localhost:5432/dokotsubu";
		String username = "postgres";
		String password = "1234";
		if(true){
			try{
				//ドライバクラスをロードする．
				Class.forName("org.postgresql.Driver").newInstance();
				System.out.println("load DB success");
				
				//データベースへ接続
				//conn = DriverManager.getConnection("jdbc:postgresql://localhost/testdb?user=postgres&password=password");
				conn = DriverManager.getConnection(url, username, password);
				System.out.println("connect DB success");
				
				Statement stmt2 = conn.createStatement ();
				String sql = "SELECT * FROM test";
				ResultSet rs2 = stmt2.executeQuery (sql);
				while(rs2.next()){
					System.out.print(rs2.getInt("id") + ", ");
					System.out.println(rs2.getString("name"));
				}
			}catch (Exception e){
				e.printStackTrace();
			}
			finally{
				try{
					if(conn != null){
						conn.close();
					}
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}

	}

}
