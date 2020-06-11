package mainpro;
import java.sql.*;
public class DBManager {
		
		private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		private final String DB_URL = "jdbc:mysql://localhost/student_db?&useSSL=false";
		private final String USER_NAME = "pocketseed";
		private final String PASSWORD = "0000";
		
		public DBManager(){
			Connection conn = null;
			Statement state = null;
			
			try {
				Class.forName(JDBC_DRIVER);
				conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
				System.out.println("[  MYSQL Connection ]\n");
				state = conn.createStatement();
				
				String sql;
				sql = "SELECT * FROM student";
				ResultSet rs = state.executeQuery(sql);
				
				while(rs.next())
				{
					
					String number = rs.getString("nummber");
					String name = rs.getString("name");
					String id = rs.getString("id");
					String password = rs.getString("password");
					System.out.println("Number: " + number + "\nName : "+ name + "\n");
					System.out.println("ID: " + id + "\nPassword : "+ password + "\n--------------------\n");
				}
				rs.close();
				state.close();
				conn.close();
			}catch(Exception e) {
			//예외 발생시 처리문
			}finally {
				try {
					if(state!=null)
						state.close();
				}catch(SQLException ex1) {
					//
				}
				
				try {
					if(conn!=null)
						conn.close();
				}catch(SQLException ex1) {
					//
				}
			}
		System.out.println("MYSQL close");
		}
}