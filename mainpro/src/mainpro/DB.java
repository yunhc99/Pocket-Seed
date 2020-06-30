package mainpro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DB {

	ArrayList<String> Name = new ArrayList<String>();
	ArrayList<String> Day1 = new ArrayList<String>();
	ArrayList<String> Day1_date1 = new ArrayList<String>();
	ArrayList<String> Day1_date2 = new ArrayList<String>();
	ArrayList<String> Day1_date3 = new ArrayList<String>();
	ArrayList<String> Day2 = new ArrayList<String>();
	ArrayList<String> Day2_date1 = new ArrayList<String>();
	ArrayList<String> Day2_date2 = new ArrayList<String>();
	ArrayList<String> Day2_date3 = new ArrayList<String>();
	ArrayList<String> People = new ArrayList<String>();
	ArrayList<String> Grade = new ArrayList<String>();
	ArrayList<String> Result_list = new ArrayList<String>();

	Connection con = null;
	Statement stmt = null;
	String url = "jdbc:mysql://localhost/sublist?serverTimezone=UTC";
	String user = "root";
	String passwd = "1111";

	DB() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println("드라이버 로딩 오류: " + e.getMessage());
			return;
		}

		try {
			con = DriverManager.getConnection(url, user, passwd);
			stmt = con.createStatement();
			// 테이블에 있는 모든 레코드 검색
			ResultSet result = stmt.executeQuery("SELECT * FROM list_sub");

			// result 객체에 저장된 질의 결과로부터 행의 정보 얻음
			while (result.next()) {
				Name.add(result.getString("Name"));
				Day1.add(result.getString("Day1"));
				Day1_date1.add(result.getString("Day1_date1"));
				Day1_date2.add(result.getString("Day1_date2"));
				Day1_date3.add(result.getString("Day1_date3"));
				Day2.add(result.getString("Day2"));
				Day2_date1.add(result.getString("Day2_date1"));
				Day2_date2.add(result.getString("Day2_date2"));
				Day2_date3.add(result.getString("Day2_date3"));
				People.add(result.getString("People"));
				Grade.add(result.getString("Grade"));
			}
			stmt.close();
			con.close();

			for(int i=0; i<Name.size();i++) {
				if(!(Day1_date1.get(i)==null)&&!(Day1_date2.get(i)==null)&&!(Day1_date3.get(i)==null)&&(Day2_date1.get(i)==null)&&(Day2_date2.get(i)==null)&&(Day2_date3.get(i)==null)) { // 첫째 과목 셋, 둘째 영
					Result_list.add(Name.get(i)+ "  " + Day1.get(i) + " " + Day1_date1.get(i) + "," + Day1_date2.get(i) + ","+ Day1_date3.get(i) + "  " + "학점: " + Grade.get(i) + "  인원: " + People.get(i));
				}
				else if(!(Day1_date1.get(i)==null)&&!(Day1_date2.get(i)==null)&&(Day1_date3.get(i)==null)&&(Day2_date1.get(i)==null)&&(Day2_date2.get(i)==null)&&(Day2_date3.get(i)==null)) { // 첫째 과목 둘, 둘째 영
					Result_list.add(Name.get(i)+ "  " + Day1.get(i) + " " + Day1_date1.get(i) + ","+ Day1_date2.get(i)  + "  " + "학점: " + Grade.get(i) + "  인원: " + People.get(i));
				}
				else if(!(Day1_date1.get(i)==null)&&(Day1_date2.get(i)==null)&&(Day1_date3.get(i)==null)&&(Day2_date1.get(i)==null)&&(Day2_date2.get(i)==null)&&(Day2_date3.get(i)==null)) { // 첫째 과목 하나, 둘째 영
					Result_list.add(Name.get(i)+ "  " + Day1.get(i) + " " + Day1_date1.get(i) + "  " + "학점: " + Grade.get(i) + "  인원: " + People.get(i));
				}
				else if(!(Day1_date1.get(i)==null)&&(Day1_date2.get(i)==null)&&(Day1_date3.get(i)==null)&&!(Day2_date1.get(i)==null)&&(Day2_date2.get(i)==null)&&(Day2_date3.get(i)==null)) { // 첫째 과목 하나, 둘째 하나만
					Result_list.add(Name.get(i)+ "  " + Day1.get(i) + " " + Day1_date1.get(i) +" / "+ Day2.get(i) + " " + Day2_date1.get(i) + "  " + "학점: " + Grade.get(i) + "  인원: " + People.get(i));
				}
				else if(!(Day1_date1.get(i)==null)&&(Day1_date2.get(i)==null)&&(Day1_date3.get(i)==null)&&!(Day2_date1.get(i)==null)&&!(Day2_date2.get(i)==null)&&(Day2_date3.get(i)==null)) { // 첫째 과목 하나, 둘째 두개
					Result_list.add(Name.get(i)+ "  " + Day1.get(i) + " " + Day1_date1.get(i) +" / "+ Day2.get(i) + " " + Day2_date1.get(i) + "," + Day2_date2.get(i) + "  " + "학점: " + Grade.get(i) + "  인원: " + People.get(i));
				}
				else if(!(Day1_date1.get(i)==null)&&!(Day1_date2.get(i)==null)&&(Day1_date3.get(i)==null)&&!(Day2_date1.get(i)==null)&&(Day2_date2.get(i)==null)&&(Day2_date3.get(i)==null)) { // 첫째 과목 둘, 둘째 하나만
					Result_list.add(Name.get(i)+ "  " + Day1.get(i) + " " + Day1_date1.get(i) + "," + Day1_date2.get(i) + " / "+ Day2.get(i) + " " + Day2_date1.get(i) + "  " + "학점: " + Grade.get(i) + "  인원: " + People.get(i));
				}
				else if(!(Day1_date1.get(i)==null)&&!(Day1_date2.get(i)==null)&&(Day1_date3.get(i)==null)&&!(Day2_date1.get(i)==null)&&!(Day2_date2.get(i)==null)&&(Day2_date3.get(i)==null)) { // 첫째 과목 둘, 둘째 두개
					Result_list.add(Name.get(i)+ "  " + Day1.get(i) + " " + Day1_date1.get(i) + "," + Day1_date2.get(i) + " / "+ Day2.get(i) + " " + Day2_date1.get(i) + "," + Day2_date2.get(i) + "  " + "학점: " + Grade.get(i) + "  인원: " + People.get(i));
				}
			}

		} catch (SQLException ex) {
			System.err.println("Select 오류: " + ex.getMessage());
		}

	}

}
