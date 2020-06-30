package mainpro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

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

public class SubList extends JFrame {

	// 그림 크기 설정 값
	int P_D_button_Weight = 90;
	int P_D_button_High = 30;
	int Next_button_Weight = 130;
	int Next_button_High = 30;

	//
	ArrayList<Sub_dater> backup;
	DB sub_db = new DB();

	private Image screenImage;// 이미지를 담는거
	private Graphics screenGraphic;

	private Image Background = new ImageIcon(Main.class.getResource("../image/SubListBack.png")).getImage();
	private JLabel meunBar = new JLabel(new ImageIcon(Main.class.getResource("../image/menuBar.png")));

	private ImageIcon AddButtonImage = new ImageIcon(Main.class.getResource("../image/SubListAddButton.png"));
	private ImageIcon AddButtonEnterImage = new ImageIcon(Main.class.getResource("../image/SubListAddButtonEnter.png"));
	private ImageIcon DeleteButtonImage = new ImageIcon(Main.class.getResource("../image/SubListDeleteButton.png"));
	private ImageIcon DeleteButtonEnterImage = new ImageIcon(
			Main.class.getResource("../image/SubListDeleteButtonEnter.png"));
	private ImageIcon NextButtonImage = new ImageIcon(Main.class.getResource("../image/SubListNextButton.png"));
	private ImageIcon NextButtonEnterImage = new ImageIcon(
			Main.class.getResource("../image/SubListNextButtonEnter.png"));
	private ImageIcon SearchImage = new ImageIcon(Main.class.getResource("../image/SubListSearchButton.png"));
	private ImageIcon ResetImage = new ImageIcon(Main.class.getResource("../image/SubListResetButton.png"));

	// 이미지 크기 변환

	Image Search = SearchImage.getImage();
	Image searchImgA = Search.getScaledInstance(70, 35, Image.SCALE_SMOOTH);
	ImageIcon SEARCH_ButtonImage = new ImageIcon(searchImgA);

	Image Reset = ResetImage.getImage();
	Image resetImg = Reset.getScaledInstance(83, 35, Image.SCALE_SMOOTH);
	ImageIcon RESET_ButtonImage = new ImageIcon(resetImg);

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

	private JButton AddButton = new JButton(ADD_ButtonImage);
	private JButton DeleteButton = new JButton(DELETE_ButtonImage);
	private JButton NextButton = new JButton(NEXT_ButtonImage);
	private JButton SearchButton = new JButton(SEARCH_ButtonImage);
	private JButton ResetButton = new JButton(RESET_ButtonImage);
	//
	JLabel sub_name = new JLabel("과목명");
	JTextField subject = new JTextField(10) {
		public void setBorder(Border border) { // 테두리 투명화

		}
	}; // 과목명

	private Font fon1 = new Font("굴림", Font.PLAIN, 20);
	private Font fon2 = new Font("굴림", Font.PLAIN, 30);
	private Font fon3 = new Font("굴림", Font.PLAIN, 15);
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

// 창 중앙설정
		Dimension frameSize = getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
//

		meunBar.setBounds(0, 0, 600, 30);
		meunBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}

		});
		meunBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(meunBar);

		// 검색 버튼 관리
		SearchButton.setBounds(385, 455, 70, 35);
		SearchButton.setBorderPainted(false);
		SearchButton.setContentAreaFilled(false);
		SearchButton.setFocusPainted(false);
		SearchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				SearchButton.setIcon(SEARCH_ButtonImage);
				SearchButton.setCursor(new Cursor(Cursor.HAND_CURSOR));// 손가락 커서
			}

			@Override
			public void mouseExited(MouseEvent e) {
				SearchButton.setIcon(SEARCH_ButtonImage);
				SearchButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 기본 커서
			}
		});
		add(SearchButton);
		SearchButton.addActionListener(new action());
		//

		// 초기화 버튼 관리
		ResetButton.setBounds(470, 453, 83, 35);
		ResetButton.setBorderPainted(false);
		ResetButton.setContentAreaFilled(false);
		ResetButton.setFocusPainted(false);
		ResetButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ResetButton.setIcon(RESET_ButtonImage);
				ResetButton.setCursor(new Cursor(Cursor.HAND_CURSOR));// 손가락 커서
			}

			@Override
			public void mouseExited(MouseEvent e) {
				ResetButton.setIcon(RESET_ButtonImage);
				ResetButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 기본 커서
			}
		});
		add(ResetButton);
		ResetButton.addActionListener(new action());
		//

		// 추가 버튼 관리
		AddButton.setBounds(470, 365, P_D_button_Weight, P_D_button_High);
		AddButton.setBorderPainted(false);
		AddButton.setContentAreaFilled(false);
		AddButton.setFocusPainted(false);
		AddButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				AddButton.setIcon(ADD_ButtonImage_E);
				AddButton.setCursor(new Cursor(Cursor.HAND_CURSOR));// 손가락 커서
			}

			@Override
			public void mouseExited(MouseEvent e) {
				AddButton.setIcon(ADD_ButtonImage);
				AddButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 기본 커서
			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.out.print("과목추가 기능\n");
			}
		});
		add(AddButton);
		AddButton.addActionListener(new action());
		//

		// 목록
		add(scroll);
		model = (DefaultListModel) list.getModel();
		list.setFont(fon3);
		scroll.setBounds(60, 598, 505, 130);
		//

		add(scroll_l);
		model_l = (DefaultListModel) list_l.getModel();
		list_l.setFont(fon3);
		scroll_l.setBounds(60, 174, 505, 176);

		for (int i = 0; i < sub_db.Result_list.size(); i++) {
			model_l.addElement(sub_db.Result_list.get(i));
		}

		add(subject);
		subject.setBounds(150, 455, 185, 36);
		subject.setFont(fon3);
		// 과목 입력

		// 삭제 버튼 관리
		DeleteButton.setBounds(470, 747, P_D_button_Weight, P_D_button_High);
		DeleteButton.setBorderPainted(false);
		DeleteButton.setContentAreaFilled(false);
		DeleteButton.setFocusPainted(false);
		DeleteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				DeleteButton.setIcon(DELETE_ButtonImage_E);
				DeleteButton.setCursor(new Cursor(Cursor.HAND_CURSOR));// 손가락 커서
			}

			@Override
			public void mouseExited(MouseEvent e) {
				DeleteButton.setIcon(DELETE_ButtonImage);
				DeleteButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 기본 커서
			}

			@Override
			public void mousePressed(MouseEvent e) {
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
				NextButton.setCursor(new Cursor(Cursor.HAND_CURSOR));// 손가락 커서
			}

			@Override
			public void mouseExited(MouseEvent e) {
				NextButton.setIcon(NEXT_ButtonImage);
				NextButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 기본 커서
			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.out.print("다음으로 기능\n");
			}
		});
		add(NextButton);
		NextButton.addActionListener(new action());
		//

	}

	public class action implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == AddButton) { // 추가 버튼 처리 이벤트

				model.addElement(list_l.getSelectedValue());

			}
			//
			else if (e.getSource() == DeleteButton) { // 삭제 버튼 처리 이벤트
				model.removeElement(list.getSelectedValue());
			}
//
			else if (e.getSource() == NextButton) { // 다음 버튼 처리 이벤트

				new ConditionIN(model);
				dispose();
			}

			else if (e.getSource() == SearchButton) {
				String text;
				text = subject.getText();

				if (!text.equals("")) {
					model_l.removeAllElements();

					for (int i = 0; i < sub_db.Result_list.size(); i++) {
						if (text.equals(sub_db.Name.get(i))) {
							model_l.addElement(sub_db.Result_list.get(i));
						}
					}
				}

				subject.setText("");
			}

			else if (e.getSource() == ResetButton) {
				model_l.removeAllElements();
				for (int i = 0; i < sub_db.Result_list.size(); i++) {
					model_l.addElement(sub_db.Result_list.get(i));
				}
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
