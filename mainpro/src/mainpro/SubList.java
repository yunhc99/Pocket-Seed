package mainpro;

import java.awt.BorderLayout;
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

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class SubList extends JFrame{

	// 그림 크기 설정 값
	int P_D_button_Weight = 90;
	int P_D_button_High = 30;
	int Next_button_Weight = 130;
	int Next_button_High = 30;

	//

	private Image screenImage;// 이미지를 담는거
	private Graphics screenGraphic;

	private Image Background = new ImageIcon(Main.class.getResource("../image/SubListBack.png")).getImage();
	private JLabel meunBar = new JLabel(new ImageIcon(Main.class.getResource("../image/menuBar.png")));

	private ImageIcon AddButtonImage = new ImageIcon(Main.class.getResource("../image/SubListAddButton.png"));
	private ImageIcon AddButtonEnterImage = new ImageIcon(Main.class.getResource("../image/SubListAddButtonEnter.png"));
	private ImageIcon DeleteButtonImage = new ImageIcon(Main.class.getResource("../image/SubListDeleteButton.png"));
	private ImageIcon DeleteButtonEnterImage = new ImageIcon(Main.class.getResource("../image/SubListDeleteButtonEnter.png"));
	private ImageIcon NextButtonImage = new ImageIcon(Main.class.getResource("../image/SubListNextButton.png"));
	private ImageIcon NextButtonEnterImage = new ImageIcon(Main.class.getResource("../image/SubListNextButtonEnter.png"));


	// 이미지 크기 변환


	Image ADD = AddButtonImage.getImage();
	Image changeImgA = ADD.getScaledInstance(P_D_button_Weight, P_D_button_High, Image.SCALE_SMOOTH);
	ImageIcon ADD_ButtonImage = new ImageIcon(changeImgA);

	Image ADD_E = AddButtonEnterImage.getImage();
	Image changeImgA_E = ADD_E.getScaledInstance(P_D_button_Weight, P_D_button_High, Image.SCALE_SMOOTH);
	ImageIcon ADD_ButtonImage_E = new ImageIcon(changeImgA_E);

	Image DELETE = DeleteButtonImage.getImage();
	Image changeImgD = DELETE.getScaledInstance(P_D_button_Weight, P_D_button_High, Image.SCALE_SMOOTH);
	ImageIcon DELETE_ButtonImage = new ImageIcon(changeImgD);

	Image DELETE_E = DeleteButtonEnterImage.getImage();
	Image changeImgD_E = DELETE_E.getScaledInstance(P_D_button_Weight, P_D_button_High, Image.SCALE_SMOOTH);
	ImageIcon DELETE_ButtonImage_E = new ImageIcon(changeImgD_E);

	Image NEXT = NextButtonImage.getImage();
	Image changeImgN = NEXT.getScaledInstance(Next_button_Weight, Next_button_High, Image.SCALE_SMOOTH);
	ImageIcon NEXT_ButtonImage = new ImageIcon(changeImgN);

	Image NEXT_E = NextButtonEnterImage.getImage();
	Image changeImgN_E = NEXT_E.getScaledInstance(Next_button_Weight, Next_button_High, Image.SCALE_SMOOTH);
	ImageIcon NEXT_ButtonImage_E = new ImageIcon(changeImgN_E);

	private JButton AddButton= new JButton(ADD_ButtonImage);
	private JButton DeleteButton= new JButton(DELETE_ButtonImage);
	private JButton NextButton= new JButton(NEXT_ButtonImage);
	//

	// 요일
	String[] day = {" ", "월", "화", "수", "목", "금"};
	String[] date = {" ", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
	JComboBox day1 = new JComboBox(day); //요일1
	JComboBox date1 = new JComboBox(date); //1의 시간
	JComboBox date2 = new JComboBox(date); //1의 시간
	JComboBox date3 = new JComboBox(date); //1의 시간
	JComboBox day2 = new JComboBox(day); //요일2
	JComboBox date2_1 = new JComboBox(date); //2의 시간
	JComboBox date2_2 = new JComboBox(date); //2의 시간
	JComboBox date2_3 = new JComboBox(date); //2의 시간
	JTextField subject = new JTextField(10); //과목명
	JTextField subject_number = new JTextField(10); //과목 학점
	JTextField human_number = new JTextField(10); //과목 인원
	//

	private Font fon1 = new Font("굴림", Font.PLAIN, 20);
	private Font fon2 = new Font("굴림", Font.PLAIN, 30);

	private int mouseX, mouseY;

	DefaultListModel model_l;
    JList list_l = new JList(new DefaultListModel());
    JScrollPane scroll_l = new JScrollPane(list_l) {
	public void setBorder(Border border) { // 테두리 투명화

	}
    };
	// 목록 보여주는 창
	DefaultListModel model;
    JList list = new JList(new DefaultListModel());
    JScrollPane scroll = new JScrollPane(list) {
	public void setBorder(Border border) { // 테두리 투명화

	}
};
	//

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

		// 추가 버튼 관리
		AddButton.setBounds(470, 290, P_D_button_Weight, P_D_button_High);
		AddButton.setBorderPainted(false);
		AddButton.setContentAreaFilled(false);
		AddButton.setFocusPainted(false);
		AddButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				AddButton.setIcon(ADD_ButtonImage_E);
				AddButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//손가락 커서
			}
			@Override
			public void mouseExited(MouseEvent e){
				AddButton.setIcon(ADD_ButtonImage);
				AddButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//기본 커서
			}
			@Override
			public void mousePressed(MouseEvent e){
				System.out.print("과목추가 기능\n");
			}
		});
		add(AddButton);
		AddButton.addActionListener(new action());
		//

		// 목록
		add(scroll);
		model = (DefaultListModel)list.getModel();
		list.setFont(fon1);
		scroll.setBounds(60,540,505,188);
		//


		add(scroll_l);
		model_l = (DefaultListModel)list_l.getModel();
		list_l.setFont(fon1);
		scroll_l.setBounds(60,178,505,84);


		// 과목 입력

		add(day1);
		add(day2);
		add(date1);
		add(date2);
		add(date3);
		add(date2_1);
		add(date2_2);
		add(date2_3);
		add(subject);
		add(subject_number);
		add(human_number);

		subject.setBounds(60,360,140,25);
		subject_number.setBounds(60,395,50,25);
		human_number.setBounds(140,395,50,25);
		day1.setBounds(230,360,45,25);
		date1.setBounds(280,360,45,25);
		date2.setBounds(330,360,45,25);
		date3.setBounds(380,360,45,25);
		day2.setBounds(230,395,45,25);
		date2_1.setBounds(280,395,45,25);
		date2_2.setBounds(330,395,45,25);
		date2_3.setBounds(380,395,45,25);
		//

		// 삭제 버튼 관리
		DeleteButton.setBounds(470, 750, P_D_button_Weight, P_D_button_High);
		DeleteButton.setBorderPainted(false);
		DeleteButton.setContentAreaFilled(false);
		DeleteButton.setFocusPainted(false);
		DeleteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				DeleteButton.setIcon(DELETE_ButtonImage_E);
				DeleteButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//손가락 커서
			}
			@Override
			public void mouseExited(MouseEvent e){
				DeleteButton.setIcon(DELETE_ButtonImage);
				DeleteButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//기본 커서
			}
			@Override
			public void mousePressed(MouseEvent e){
				System.out.print("과목삭제 기능\n");
			}
		});
		add(DeleteButton);
		DeleteButton.addActionListener(new action());
		//
		
		// 다음 버튼 관리
		NextButton.setBounds(430, 820, Next_button_Weight, Next_button_High);
		NextButton.setBorderPainted(false);
		NextButton.setContentAreaFilled(false);
		NextButton.setFocusPainted(false);
		NextButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				NextButton.setIcon(NEXT_ButtonImage_E);
				NextButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//손가락 커서
			}
			@Override
			public void mouseExited(MouseEvent e){
				NextButton.setIcon(NEXT_ButtonImage);
				NextButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//기본 커서
			}
			@Override
			public void mousePressed(MouseEvent e){
				System.out.print("다음으로 기능\n");
			}
		});
		add(NextButton);
		NextButton.addActionListener(new action());
		//



	}

	public class action implements ActionListener{

		public void actionPerformed(ActionEvent e) {

	if(e.getSource()==AddButton) { // 추가 버튼 처리 이벤트

		String a,b,c,d,r,result,b2,c2,d2,r2;
		String s_num, h_num;
		s_num=subject_number.getText();
		h_num=human_number.getText();
		a=subject.getText();
		b=day1.getSelectedItem().toString();
		c=date1.getSelectedItem().toString();
		d=date2.getSelectedItem().toString();
		r=date3.getSelectedItem().toString();
		b2=day2.getSelectedItem().toString();
		c2=date2_1.getSelectedItem().toString();
		d2=date2_2.getSelectedItem().toString();
		r2=date2_3.getSelectedItem().toString();

	if(!(c==" ")&&!(d==" ")&&!(r==" ")&&(c2==" ")&&(d2==" ")&&(r2==" ")) { // 첫째 과목 셋, 둘째 영
		model.addElement(a+ "  " + b + " " + c + "," + d + ","+ r + "  " + "학점: " + s_num + "  인원: " + h_num);
		subject.setText("");
		subject_number.setText("");
		human_number.setText("");
	}
	else if(!(c==" ")&&!(d==" ")&&(r==" ")&&(c2==" ")&&(d2==" ")&&(r2==" ")) { // 첫째 과목 둘, 둘째 영
		model.addElement(a+ "  " + b + " " + c + ","+ d  + "  " + "학점: " + s_num + "  인원: " + h_num);
		subject.setText("");
		subject_number.setText("");
		human_number.setText("");
	}
	else if(!(c==" ")&&(d==" ")&&(r==" ")&&(c2==" ")&&(d2==" ")&&(r2==" ")) { // 첫째 과목 하나, 둘째 영
		model.addElement(a+ "  " + b + " " + c + "  " + "학점: " + s_num + "  인원: " + h_num);
		subject.setText("");
		subject_number.setText("");
		human_number.setText("");
	}
	else if(!(c==" ")&&(d==" ")&&(r==" ")&&!(c2==" ")&&(d2==" ")&&(r2==" ")) { // 첫째 과목 하나, 둘째 하나만
		model.addElement(a+ "  " + b + " " + c +" / "+ b2 + " " + c2 + "  " + "학점: " + s_num + "  인원: " + h_num);
		subject.setText("");
		subject_number.setText("");
		human_number.setText("");
	}
	else if(!(c==" ")&&(d==" ")&&(r==" ")&&!(c2==" ")&&!(d2==" ")&&(r2==" ")) { // 첫째 과목 하나, 둘째 두개
		model.addElement(a+ "  " + b + " " + c +" / "+ b2 + " " + c2 + "," + d2 + "  " + "학점: " + s_num + "  인원: " + h_num);
		subject.setText("");
		subject_number.setText("");
		human_number.setText("");
	}
	else if(!(c==" ")&&!(d==" ")&&(r==" ")&&!(c2==" ")&&(d2==" ")&&(r2==" ")) { // 첫째 과목 둘, 둘째 하나만
		model.addElement(a+ "  " + b + " " + c + "," + d + " / "+ b2 + " " + c2 + "  " + "학점: " + s_num + "  인원: " + h_num);
		subject.setText("");
		subject_number.setText("");
		human_number.setText("");
	}
	else if(!(c==" ")&&!(d==" ")&&(r==" ")&&!(c2==" ")&&!(d2==" ")&&(r2==" ")) { // 첫째 과목 둘, 둘째 두개
		model.addElement(a+ "  " + b + " " + c + "," + d + " / "+ b2 + " " + c2 + "," + d2 + "  " + "학점: " + s_num + "  인원: " + h_num);
		subject.setText("");
		subject_number.setText("");
		human_number.setText("");
	}
	else {
		System.out.println("잘못입력함");
	}


	}
	//
	else if(e.getSource()==DeleteButton) { // 삭제 버튼 처리 이벤트
		model.removeElement(list.getSelectedValue());
	}
//
	else if(e.getSource()==NextButton) { // 다음 버튼 처리 이벤트

		new ConditionIN(model);
		dispose();
	}
		//
		}
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
