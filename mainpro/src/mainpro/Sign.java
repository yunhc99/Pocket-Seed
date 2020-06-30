package mainpro;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Sign extends JFrame{
	private Image screenImage;// 이미지를 담는거
	private Graphics screenGraphic;

	private Image Background = new ImageIcon(Main.class.getResource("../image/SignBack.png")).getImage();
	private JLabel meunBar = new JLabel(new ImageIcon(Main.class.getResource("../image/menuBar.png")));

	private ImageIcon SignButtonImage = new ImageIcon(Main.class.getResource("../image/SignButton.png"));
	private ImageIcon SignButtonEnterImage = new ImageIcon(Main.class.getResource("../image/SignButtonEnter.png"));


	// 이미지 크기 변환
		Image Sign_B = SignButtonImage.getImage();
		Image changeImgB = Sign_B.getScaledInstance(330, 45, Image.SCALE_SMOOTH);
		ImageIcon SignButtonBasicImage_c = new ImageIcon(changeImgB);

		Image Sign_E = SignButtonEnterImage.getImage();
		Image changeImgE = Sign_E.getScaledInstance(330, 45, Image.SCALE_SMOOTH);
		ImageIcon SignButtonEnterImage_E = new ImageIcon(changeImgE);


		private JButton SignButton =new JButton(SignButtonBasicImage_c);
		//




	private Font fon1 = new Font("굴림", Font.PLAIN, 25);

	private JTextField TFId =new JTextField(){
		public void setBorder(Border border) { // textfield에 대한 테두리 투명화

		}
	};
	private JPasswordField TFPass =new JPasswordField(){
		public void setBorder(Border border) { // textfield에 대한 테두리 투명화

		}
	};

	private int mouseX, mouseY;

	public Sign() {
		setUndecorated(true);// 실행시 메뉴바 안보이기
		setTitle("Test");
		setSize(400 ,500);
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

		SignButton.setBounds(38, 380, 330, 45);
		SignButton.setBorderPainted(false);
		SignButton.setContentAreaFilled(false);
		SignButton.setFocusPainted(false);
		SignButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				SignButton.setIcon(SignButtonEnterImage_E);
				SignButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//손가락 커서
			}
			@Override
			public void mouseExited(MouseEvent e){
				SignButton.setIcon(SignButtonBasicImage_c);
				SignButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//기본 커서
			}
			@Override
			public void mousePressed(MouseEvent e){
				System.out.print("회원가입 기능\n");
				int x=0;//1이라면 회원가입 실패
				//패스워드 보안상 변환과정
				String pw = "";
				String id = "";
				char[] secret_pw=TFPass.getPassword();//필드에서 패스워드를 얻어옴, char[] 배열에 저장
				for(char cha : secret_pw){ //secret_pw 배열에 저장된 암호의 자릿수 만큼 for문 돌리면서 cha에 한 글자씩 저장
					Character.toString(cha);
					//pw 에 저장하기, pw 에 값이 비어있으면 저장, 값이 있으면 이어서 저장하는 삼항연산자
					pw += (pw.equals("")) ? ""+cha+"" : ""+cha+"";
				}


				id= TFId.getText();
				System.out.print(id +"\n");
				System.out.print(pw + "\n");
				TFId.setText("");
				TFPass.setText("");

				//DB 연동 부분
				Connection conn = null;
		        Statement stmt = null;
		        try{
		            Class.forName("com.mysql.cj.jdbc.Driver");

		            conn = DriverManager.getConnection(Main.url, Main.id, Main.pw);


		            //DB와 연결된 conn 객체로부터 Statement 객체 획득.
		            stmt = conn.createStatement();

		            //query 만들기
		            String sql="INSERT INTO user VALUES "+"('"+id+"','"+pw+"')";


		            //query문 날리기
		            stmt.execute(sql);
		            //회원 가입 완료  시퀸스 입력

		        }catch(ClassNotFoundException e1){
		            e1.printStackTrace();
		        }
		        catch(SQLException e1){
		            e1.printStackTrace();
		            x++;
		            JOptionPane.showMessageDialog(null, "중복되는 아이디입니다.");
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

		        //결과창 올리기
				//회원가입완료시 로그인창으로 돌아가기
		        if(x==0) {
		        	new Login();
		        	JOptionPane.showMessageDialog(null, "회원가입을 완료했습니다.");
		        	dispose();
		        }
			}
		});
		add(SignButton);

		TFId.setBounds(45, 175, 310, 45);
		TFId.setFont(fon1);
		add(TFId);

		TFPass.setBounds(45, 285, 310, 45);
		TFPass.setFont(fon1);
		TFPass.setEchoChar('*');
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

}
