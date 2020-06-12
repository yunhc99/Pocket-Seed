package mainpro;

public class Main {
		//GUI 크기 설정 함수입니다.
		public static final int SCREEN_WIDTH = 600;
		public static final int SCREEN_HEIGHT = 900;
		
		
		//데이터 베이스 관련 입력 함수입니다 맞게 변경 해주세요
		public static final String url = "jdbc:mysql://localhost/seed?useSSL=false";
		public static final String id = "root";
		public static final String pw = "0000";
	public static void main(String[] args)
	{
		new Login();
		//new Sign();
		//new SubList();
		//new ConditionIN();
		//new Outcome();
	}
}
