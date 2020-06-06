package mainpro;

import java.awt.BorderLayout;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SubList extends JFrame{
	
	private Image screenImage;// 이미지를 담는거
	private Graphics screenGraphic;
	
	private Image Background = new ImageIcon(Main.class.getResource("../image/SubListBack.png")).getImage();
	private JLabel meunBar = new JLabel(new ImageIcon(Main.class.getResource("../image/menuBar.png")));
	
	private ImageIcon AddButtonImage = new ImageIcon(Main.class.getResource("../image/SubListAddButton.png"));
	private ImageIcon AddButtonEnterImage = new ImageIcon(Main.class.getResource("../image/SubListAddButtonEnter.png"));
	private ImageIcon DeleteButtonImage = new ImageIcon(Main.class.getResource("../image/SubListDeletButton.png"));
	private ImageIcon DeleteButtonEnterImage = new ImageIcon(Main.class.getResource("../image/SubListDeletButtonEnter.png"));
	private ImageIcon NextButtonImage = new ImageIcon(Main.class.getResource("../image/SubListNextButton.png"));
	private ImageIcon NextButtonEnterImage = new ImageIcon(Main.class.getResource("../image/SubListNextButtonEnter.png"));
	
	private JButton AddButton= new JButton(AddButtonImage);
	private JButton DeleteButton= new JButton(DeleteButtonImage);
	private JButton NextButton= new JButton(NextButtonImage);
	
	private JTextField AddSubTF= new JTextField();
	private JTextArea SubListA= new JTextArea();
	private JScrollPane scroll=new JScrollPane(SubListA);
	
	
	private Font fon1 = new Font("굴림", Font.PLAIN, 35);
	private Font fon2 = new Font("굴림", Font.PLAIN, 30);
	
	private int mouseX, mouseY;	
	
	public SubList() {
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
		
		AddButton.setBounds(430, 290, 135, 40);
		AddButton.setBorderPainted(false);
		AddButton.setContentAreaFilled(false);
		AddButton.setFocusPainted(false);
		AddButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				AddButton.setIcon(AddButtonEnterImage);
				AddButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//손가락 커서
			}
			@Override
			public void mouseExited(MouseEvent e){
				AddButton.setIcon(AddButtonImage);
				AddButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//기본 커서
			}
			@Override
			public void mousePressed(MouseEvent e){
				System.out.print("과목추가 기능\n");
			}
		});
		add(AddButton);
		
		
		AddSubTF.setBounds(40, 205, 525, 70);
		AddSubTF.setFont(fon1);
		add(AddSubTF);
		
		SubListA.setBounds(40, 420, 525, 305);
		SubListA.setFont(fon2);
		scroll.setBounds(40, 420, 525, 305);
		add(scroll);
		
		
		DeleteButton.setBounds(430, 750, 135, 40);
		DeleteButton.setBorderPainted(false);
		DeleteButton.setContentAreaFilled(false);
		DeleteButton.setFocusPainted(false);
		DeleteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				DeleteButton.setIcon(DeleteButtonEnterImage);
				DeleteButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//손가락 커서
			}
			@Override
			public void mouseExited(MouseEvent e){
				DeleteButton.setIcon(DeleteButtonImage);
				DeleteButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//기본 커서
			}
			@Override
			public void mousePressed(MouseEvent e){
				System.out.print("과목삭제 기능\n");
			}
		});
		add(DeleteButton);
		
		
		NextButton.setBounds(400, 820, 190, 55);
		NextButton.setBorderPainted(false);
		NextButton.setContentAreaFilled(false);
		NextButton.setFocusPainted(false);
		NextButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				NextButton.setIcon(NextButtonEnterImage);
				NextButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//손가락 커서
			}
			@Override
			public void mouseExited(MouseEvent e){
				NextButton.setIcon(NextButtonImage);
				NextButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//기본 커서
			}
			@Override
			public void mousePressed(MouseEvent e){
				System.out.print("다음으로 기능\n");
			}
		});
		add(NextButton);
		
		
		
		
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
