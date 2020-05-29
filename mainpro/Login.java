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
import javax.swing.JTextField;

public class Login extends JFrame{
	
	private Image screenImage;// 이미지를 담는거
	private Graphics screenGraphic;
	
	private Image Background = new ImageIcon(Main.class.getResource("../image/LoginBack.png")).getImage();
	private JLabel meunBar = new JLabel(new ImageIcon(Main.class.getResource("../image/menuBar.png")));
	
	
	private ImageIcon LoginButtonBasicImage = new ImageIcon(Main.class.getResource("../image/LoginButtonBasic.png"));
	private ImageIcon LoginButtonEnterImage = new ImageIcon(Main.class.getResource("../image/LoginButtonEnter.png"));
	private ImageIcon SignUpButtonImage = new ImageIcon(Main.class.getResource("../image/SignUpButton.png"));
	
	
	private JButton LoginButton =new JButton(LoginButtonBasicImage);
	private JButton SignUpButton =new JButton(SignUpButtonImage);
	
	private JTextField TFId =new JTextField();
	private JTextField TFPass =new JTextField();
	
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
		
		LoginButton.setBounds(25, 800, 550, 65);//위치 지정
		LoginButton.setBorderPainted(false);
		LoginButton.setContentAreaFilled(false);
		LoginButton.setFocusPainted(false);
		LoginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LoginButton.setIcon(LoginButtonEnterImage);
				LoginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//손가락 커서
			}
			@Override
			public void mouseExited(MouseEvent e){
				LoginButton.setIcon(LoginButtonBasicImage);
				LoginButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//기본 커서
			}
			@Override
			public void mousePressed(MouseEvent e){
				System.out.print("로그인 기능\n");
			}
		});
		add(LoginButton);
		
		SignUpButton.setBounds(370, 530, 150, 56);
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
			}
		});
		add(SignUpButton);
		
		
		TFId.setBounds(65,605,470,45);
		add(TFId);
		
		TFPass.setBounds(65,715,470,45);
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
