package mainpro;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Login extends JFrame{
	
	private Image screenImage;// 이미지를 담는거
	private Graphics screenGraphic;
	
	private Image Background = new ImageIcon(Main.class.getResource("../image/LoginBack.png")).getImage();
	private JLabel meunBar = new JLabel(new ImageIcon(Main.class.getResource("../image/menuBar.png")));
	
	
	private ImageIcon LoginButtonBasicImage = new ImageIcon(Main.class.getResource("../image/LoginButtonBasic.png"));
	private ImageIcon LoginButtonEnterImage = new ImageIcon(Main.class.getResource("../image/LoginButtonEnter.png"));
	private ImageIcon SignUpButtonImage = new ImageIcon(Main.class.getResource("../image/SignUpButton.png"));
	
	
	// 이미지 크기 변환
	Image LoginB = LoginButtonBasicImage.getImage();
	Image changeImgB = LoginB.getScaledInstance(480, 50, Image.SCALE_SMOOTH);
	ImageIcon LoginButtonBasicImage_c = new ImageIcon(changeImgB);
	
	Image LoginE = LoginButtonEnterImage.getImage();
	Image changeImgE = LoginE.getScaledInstance(480, 50, Image.SCALE_SMOOTH);
	ImageIcon LoginButtonEnterImage_E = new ImageIcon(changeImgE);
	
	private JButton LoginButton =new JButton(LoginButtonBasicImage_c);
	private JButton SignUpButton =new JButton(SignUpButtonImage);
	//
	

	private Font fon1 = new Font("굴림", Font.PLAIN, 30);
	
	
	private JTextField TFId =new JTextField(){ 
		public void setBorder(Border border) { // textfield에 대한 테두리 투명화
			
		}
	};
	private JPasswordField TFPass =new JPasswordField(){ 
		public void setBorder(Border border) { // textfield에 대한 테두리 투명화
			
		}
	};
	

	
	private int mouseX, mouseY;	
	
	
	
	public Login() {
		setUndecorated(true);// 실행시 메뉴바 안보이기
		setTitle("Test");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0)); // 컴포넌트의 배경이 하얀색
		setLayout(null);
		
		meunBar.setBounds(0, 0, 600, 30);
		meunBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX= e.getX();
				mouseY= e.getY();
			}
			
		});
		meunBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x=e.getXOnScreen();
				int y=e.getYOnScreen();
				setLocation(x-mouseX, y-mouseY);
			}
		});
		add(meunBar);	
		
		LoginButton.setBounds(60, 800, 480, 50);//위치 지정
		LoginButton.setBorderPainted(false);
		LoginButton.setContentAreaFilled(false);
		LoginButton.setFocusPainted(false);
		LoginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e){
				System.out.print("로그인 기능\n");
				//패스워드 보안상 변환과정
				String pw = "";
				String id = "";
				char[] secret_pw=TFPass.getPassword();//필드에서 패스워드를 얻어옴, char[] 배열에 저장
				for(char cha : secret_pw){ //secret_pw 배열에 저장된 암호의 자릿수 만큼 for문 돌리면서 cha에 한 글자씩 저장
					Character.toString(cha);
					//pw 에 저장하기, pw 에 값이 비어있으면 저장, 값이 있으면 이어서 저장하는 삼항연산자
					pw += (pw.equals("")) ? ""+cha+"" : ""+cha+"";
				}
				id=TFId.getText();
				System.out.print(id +"\n");	
				System.out.print(pw + "\n");
				TFId.setText("");
				TFPass.setText("");
				
				//DB연동 시작
				Connection conn = null;
		        Statement stmt = null;
		        try{
		            Class.forName("com.mysql.jdbc.Driver");
		 
		            conn = DriverManager.getConnection(Main.url, Main.id, Main.pw);
		 
		            System.out.println("Successfully Connected!");
		 
		            //DB와 연결된 conn 객체로부터 Statement 객체 획득.
		            stmt = conn.createStatement();
		 
		            //query 만들기
		            //String rootid="root";		            
		            ResultSet result = stmt.executeQuery("SELECT * FROM user WHERE id='"+id+"'" );
		            
		            while (result.next()) {
						String data1=result.getString("id");
				       	String data2=result.getString("pass");
				       	if(data1.equals(id)) {
				       		if(data2.equals(pw)) {
				       			System.out.println("login Success");
				       			//로그인 성공시 시퀸스
				       			//과목목록창으로 이동
				       			new SubList();
								dispose();
				       			
				       		}else {
				       			System.out.println("pass fail");
				       			//패스워드 틀림 경고문
				       		}
				       	}else {
				       		System.out.println("id fail");
				       		//아이디 틀림 경고문
				       	}
		            }		            		        		           
		            //query문 날리기		            
		            System.out.println("ALL Success end");
		            
		            
		            
		        }catch(ClassNotFoundException e1){
		            e1.printStackTrace();
		        }
		        catch(SQLException e1){
		            e1.printStackTrace();
		        }
		        finally{
		            try{
		                //자원 해제
		                if(conn != null && !conn.isClosed())
		                    conn.close();
		            } catch(SQLException e1){
		                e1.printStackTrace();
		            }
		        }
				
				
				
			}//로그인 이벤트 끝
		});
		add(LoginButton);
	    LoginButton.addActionListener(new action()); // 로그인 버튼 액션 이벤트 부여
		
		SignUpButton.setBounds(420, 565, 100, 40);
		SignUpButton.setBorderPainted(false);
		SignUpButton.setContentAreaFilled(false);
		SignUpButton.setFocusPainted(false);
		SignUpButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				SignUpButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//손가락 커서
			}
			@Override
			public void mouseExited(MouseEvent e){
				SignUpButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//기본 커서
			}
			@Override
			public void mousePressed(MouseEvent e){
				System.out.print("회원가입 기능\n");
				new Sign();
				dispose();
			}
		});
		add(SignUpButton);
		SignUpButton.addActionListener(new action()); // 회원가입 버튼 액션 이벤트 부여
		 
		TFId.setBounds(65,605,470,45);
		TFId.setFont(fon1);
		add(TFId);
		
		TFPass.setBounds(65,715,470,45);
		TFPass.setFont(fon1);
		add(TFPass);
		
	}
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	// 새로고침
	public void screenDraw(Graphics g) {
		g.drawImage(Background, 0, 0, null);// 이미지그리기
		paintComponents(g);// 컴포넌트 프린트 J라벨을 그리기
		this.repaint();
	}
	
	public class action implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
if(e.getSource()==SignUpButton) {
	new Sign();
	dispose();
}
		}
		
	}
	
}
