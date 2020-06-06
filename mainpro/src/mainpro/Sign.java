package mainpro;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Sign extends JFrame{
	private Image screenImage;// 이미지를 담는거
	private Graphics screenGraphic;
	
	private Image Background = new ImageIcon(Main.class.getResource("../image/SignBack.png")).getImage();
	private JLabel meunBar = new JLabel(new ImageIcon(Main.class.getResource("../image/menuBar.png")));
	
	private ImageIcon SignButtonImage = new ImageIcon(Main.class.getResource("../image/SignButton.png"));
	private ImageIcon SignButtonEnterImage = new ImageIcon(Main.class.getResource("../image/SignButtonEnter.png"));
	
	private JButton SignButton =new JButton(SignButtonImage);
	
	private Font fon1 = new Font("굴림", Font.PLAIN, 45);
	
	private JTextField TFId =new JTextField();
	private JPasswordField TFPass =new JPasswordField();
	
	private int mouseX, mouseY;	
	
	public Sign() {
		setUndecorated(true);// 실행시 메뉴바 안보이기
		setTitle("Test");
		setSize(600 ,615);
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
		
		SignButton.setBounds(50, 525, 500, 69);
		SignButton.setBorderPainted(false);
		SignButton.setContentAreaFilled(false);
		SignButton.setFocusPainted(false);
		SignButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				SignButton.setIcon(SignButtonEnterImage);
				SignButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//손가락 커서
			}
			@Override
			public void mouseExited(MouseEvent e){
				SignButton.setIcon(SignButtonImage);
				SignButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//기본 커서
			}
			@Override
			public void mousePressed(MouseEvent e){
				System.out.print("회원가입 기능\n");
				//패스워드 보안상 변환과정
				String pw = "";
				char[] secret_pw=TFPass.getPassword();//필드에서 패스워드를 얻어옴, char[] 배열에 저장
				for(char cha : secret_pw){ //secret_pw 배열에 저장된 암호의 자릿수 만큼 for문 돌리면서 cha에 한 글자씩 저장
					Character.toString(cha);
					//pw 에 저장하기, pw 에 값이 비어있으면 저장, 값이 있으면 이어서 저장하는 삼항연산자
					pw += (pw.equals("")) ? ""+cha+"" : ""+cha+"";
				}
				
				System.out.print(TFId.getText()+"\n");	
				System.out.print(pw + "\n");
				TFId.setText("");
				TFPass.setText("");
			}
		});
		add(SignButton);
		
		TFId.setBounds(55, 260, 490, 70);
		TFId.setFont(fon1);
		add(TFId);
		
		TFPass.setBounds(55, 425, 490, 70);
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
