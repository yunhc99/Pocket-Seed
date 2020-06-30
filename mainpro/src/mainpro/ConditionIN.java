package mainpro;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;



public class ConditionIN extends JFrame{

	// 버튼 위치
	int N_S_button_Weight = 75;
	int N_S_button_High = 75;
	int B_S_button_Weight = 130;
	int B_S_button_High = 30;
	//

	//과목 정보들
	ArrayList<Sub_dater> information_nec ;
	ArrayList<Sub_dater> information_sel ;
	ArrayList<Sub_dater> information_sum;
	Sub_dater sub_dater;
    Day_dater day_dater = new Day_dater();
	//

	private Image screenImage;// 이미지를 담는거
	private Graphics screenGraphic;

	private Image Background = new ImageIcon(Main.class.getResource("../image/ConditionINBack.png")).getImage();
	private JLabel meunBar = new JLabel(new ImageIcon(Main.class.getResource("../image/menuBar.png")));

	private ImageIcon BackButtonImage = new ImageIcon(Main.class.getResource("../image/ConditionBackButton.png"));
	private ImageIcon BackButtonEnterImage = new ImageIcon(Main.class.getResource("../image/ConditionBackButtonEnter.png"));
	private ImageIcon EndSeachButtonImage = new ImageIcon(Main.class.getResource("../image/ConditionEndSeachButton.png"));
	private ImageIcon EndSeachButtonEnterImage = new ImageIcon(Main.class.getResource("../image/ConditionEndSeachButtonEnter.png"));
	private ImageIcon NecessarySubButtonImage = new ImageIcon(Main.class.getResource("../image/ConditionNecessarySubButton.png"));
	private ImageIcon NecessarySubButtonEnterImage = new ImageIcon(Main.class.getResource("../image/ConditionNecessarySubButtonEnter.png"));
	private ImageIcon SelectSubButtonImage = new ImageIcon(Main.class.getResource("../image/ConditionSelectSubButton.png"));
	private ImageIcon SelectSubButtonEnterImage = new ImageIcon(Main.class.getResource("../image/ConditionSelectSubButtonEnter.png"));

	Image BACK = BackButtonImage.getImage();
	Image changeImgB = BACK.getScaledInstance(B_S_button_Weight, B_S_button_High, Image.SCALE_SMOOTH);
	ImageIcon BACK_ButtonImage = new ImageIcon(changeImgB);

	Image BACK_E = BackButtonEnterImage.getImage();
	Image changeImgB_E = BACK_E.getScaledInstance(B_S_button_Weight, B_S_button_High, Image.SCALE_SMOOTH);
	ImageIcon BACK_ButtonImage_E = new ImageIcon(changeImgB_E);

	Image SEARCH = EndSeachButtonImage.getImage();
	Image changeImgS = SEARCH.getScaledInstance(B_S_button_Weight, B_S_button_High, Image.SCALE_SMOOTH);
	ImageIcon SEARCH_ButtonImage = new ImageIcon(changeImgS);

	Image SEARCH_E = EndSeachButtonEnterImage.getImage();
	Image changeImgS_E = SEARCH_E.getScaledInstance(B_S_button_Weight, B_S_button_High, Image.SCALE_SMOOTH);
	ImageIcon SEARCH_ButtonImage_E = new ImageIcon(changeImgS_E);

	Image NEC = NecessarySubButtonImage.getImage();
	Image changeImgN = NEC.getScaledInstance(N_S_button_Weight, N_S_button_High, Image.SCALE_SMOOTH);
	ImageIcon NEC_ButtonImage = new ImageIcon(changeImgN);

	Image NEC_E = NecessarySubButtonEnterImage.getImage();
	Image changeImgN_E = NEC_E.getScaledInstance(N_S_button_Weight, N_S_button_High, Image.SCALE_SMOOTH);
	ImageIcon NEC_ButtonImage_E = new ImageIcon(changeImgN_E);

	Image SELECT = SelectSubButtonImage.getImage();
	Image changeImgSE = SELECT.getScaledInstance(N_S_button_Weight, N_S_button_High, Image.SCALE_SMOOTH);
	ImageIcon SELECT_ButtonImage = new ImageIcon(changeImgSE);

	Image SELECT_E = SelectSubButtonEnterImage.getImage();
	Image changeImgSE_E = SELECT_E.getScaledInstance(N_S_button_Weight, N_S_button_High, Image.SCALE_SMOOTH);
	ImageIcon SELECT_ButtonImage_E = new ImageIcon(changeImgSE_E);

	private JButton BackButton=new JButton(BACK_ButtonImage);
	private JButton EndSeachButton=new JButton(SEARCH_ButtonImage);
	private JButton NecessarySubButton=new JButton(NEC_ButtonImage);
	private JButton SelectSubButton=new JButton(SELECT_ButtonImage);

	JList nec_list;
    JList sel_list;
    JList sum_list;
    DefaultListModel sel_model;
    DefaultListModel nec_model;
    DefaultListModel sum_model;

    //체크박스
    JCheckBox monday = new JCheckBox("월요일", false) ;

    JCheckBox tuesday = new JCheckBox("화요일", false);
    JCheckBox wednesday = new JCheckBox("수요일", false);
    JCheckBox thursday = new JCheckBox("목요일", false);
    JCheckBox friday = new JCheckBox("금요일", false);
    //


    //학점
	private JTextField GradesF= new JTextField() {
public void setBorder(Border border) { // 테두리 투명화
}
	};
	//

	private Font fon1 = new Font("굴림", Font.PLAIN, 20);

	private int mouseX, mouseY;

	public ConditionIN(DefaultListModel model) {
		setUndecorated(true);// 실행시 메뉴바 안보이기
		setTitle("Test");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0)); // 컴포넌트의 배경이 하얀색
		setLayout(null);

		meunBar.setBounds(0, 0, 800, 30);
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

		// 필수 선택 창
		sum_list = new JList(new DefaultListModel());
		sel_list = new JList(model);
		nec_list = new JList(new DefaultListModel());
		JScrollPane nec_scroll = new JScrollPane(nec_list) {
			public void setBorder(Border border) { // 테두리 투명화
		}
			};
		JScrollPane sel_scroll = new JScrollPane(sel_list) {
				public void setBorder(Border border) { // 테두리 투명화

		}
		};

		add(nec_scroll);
		add(sel_scroll);

		nec_model = (DefaultListModel)nec_list.getModel();
		sel_model = (DefaultListModel)sel_list.getModel();
		sum_model = (DefaultListModel)sum_list.getModel();

		nec_scroll.setBounds(355, 175, 200, 340);
sel_scroll.setBounds(45, 175, 200, 340);
		//

monday.setBackground(Color.WHITE);
tuesday.setBackground(Color.WHITE);
wednesday.setBackground(Color.WHITE);
thursday.setBackground(Color.WHITE);
friday.setBackground(Color.WHITE);

		// 필수 화살표 버튼
		NecessarySubButton.setBounds(265, 250, N_S_button_Weight, N_S_button_High);
		NecessarySubButton.setBorderPainted(false);
		NecessarySubButton.setContentAreaFilled(false);
		NecessarySubButton.setFocusPainted(false);
		NecessarySubButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				NecessarySubButton.setIcon(NEC_ButtonImage_E);
				NecessarySubButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//손가락 커서
			}
			@Override
			public void mouseExited(MouseEvent e){
				NecessarySubButton.setIcon(NEC_ButtonImage);
				NecessarySubButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//기본 커서
			}
			@Override
			public void mousePressed(MouseEvent e){
				System.out.print("필수과목 기능\n");
			}
		});
		add(NecessarySubButton);
	    NecessarySubButton.addActionListener(new action());
		//

		// 선택 화살표 버튼
		SelectSubButton.setBounds(265, 380, N_S_button_Weight, N_S_button_High);
		SelectSubButton.setBorderPainted(false);
		SelectSubButton.setContentAreaFilled(false);
		SelectSubButton.setFocusPainted(false);
		SelectSubButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				SelectSubButton.setIcon(SELECT_ButtonImage_E);
				SelectSubButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//손가락 커서
			}
			@Override
			public void mouseExited(MouseEvent e){
				SelectSubButton.setIcon(SELECT_ButtonImage);
				SelectSubButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//기본 커서
			}
			@Override
			public void mousePressed(MouseEvent e){
				System.out.print("선택과목 기능\n");
			}
		});
		add(SelectSubButton);
		SelectSubButton.addActionListener(new action());
		//

		// 검색 버튼
		EndSeachButton.setBounds(430, 820, B_S_button_Weight, B_S_button_High);
		EndSeachButton.setBorderPainted(false);
		EndSeachButton.setContentAreaFilled(false);
		EndSeachButton.setFocusPainted(false);
		EndSeachButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				EndSeachButton.setIcon(SEARCH_ButtonImage_E);
				EndSeachButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//손가락 커서
			}
			@Override
			public void mouseExited(MouseEvent e){
				EndSeachButton.setIcon(SEARCH_ButtonImage);
				EndSeachButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//기본 커서
			}
			@Override
			public void mousePressed(MouseEvent e){
				System.out.print("검색 기능\n");
			}
		});
		add(EndSeachButton);
		EndSeachButton.addActionListener(new action());
		//

		// 뒤로가기 버튼
		BackButton.setBounds(40, 820, B_S_button_Weight, B_S_button_High);
		BackButton.setBorderPainted(false);
		BackButton.setContentAreaFilled(false);
		BackButton.setFocusPainted(false);
		BackButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				BackButton.setIcon(BACK_ButtonImage_E);
				BackButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//손가락 커서
			}
			@Override
			public void mouseExited(MouseEvent e){
				BackButton.setIcon(BACK_ButtonImage);
				BackButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//기본 커서
			}
			@Override
			public void mousePressed(MouseEvent e){
				System.out.print("뒤로 기능\n");
			}
		});
		add(BackButton);
		BackButton.addActionListener(new action());
		//

		//학점 텍스트
		GradesF.setBounds(60, 725, 500, 45);
	    GradesF.setFont(fon1);
		add(GradesF);
		//

		//체크박스 관리
		add(monday);
		add(tuesday);
		add(wednesday);
		add(thursday);
		add(friday);

		//체크박스 이벤트 부여
		monday.addItemListener(new Listen());
		tuesday.addItemListener(new Listen());
		wednesday.addItemListener(new Listen());
		thursday.addItemListener(new Listen());
		friday.addItemListener(new Listen());
		//

		monday.setBounds(68, 597, 65, 48);
		tuesday.setBounds(168, 597, 65, 48);
		wednesday.setBounds(268, 597, 65, 48);
		thursday.setBounds(368, 597, 65, 48);
		friday.setBounds(468, 597, 65, 48);
//


	}

	public class action implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==SelectSubButton) { // 선택 화살표 클릭
				sel_model.addElement(nec_list.getSelectedValue());
				nec_model.removeElement(nec_list.getSelectedValue());
			}
			else if(e.getSource()==NecessarySubButton) { // 필수 화살표 클릭
				nec_model.addElement(sel_list.getSelectedValue());
				sel_model.removeElement(sel_list.getSelectedValue());
			}

			else if(e.getSource()==BackButton) {

				new SubList();
				dispose();

			}

			else if(e.getSource()==EndSeachButton) { // 검색 버튼 클릭
				information_nec = new ArrayList<>();
				information_sel = new ArrayList<>();
				day_dater.subject_check_num = Integer.valueOf(GradesF.getText()); //학점
				//System.out.println(day_dater.subject_check_num);
				for(int i=0;i<nec_model.getSize();i++) {
					information_nec.add(new Sub_dater((String) nec_model.getElementAt(i))); //필수
					sum_model.addElement((String) nec_model.getElementAt(i));
				}

				for(int h=0;h<sel_model.getSize();h++) {
					information_sel.add(new Sub_dater((String) sel_model.getElementAt(h))); //선택
					sum_model.addElement((String) sel_model.getElementAt(h));

				}


				Result_process nec_result = new Result_process(information_nec, day_dater);
				if(nec_result.grade_check!=1) {
			    Result_process_select sel_result = new Result_process_select(information_sel, day_dater, nec_result.select_grade);

			    if(sel_result.list_base.size()!=0) {
			    Result result = new Result(nec_result.list_base, sel_result.list_base);
			    if(result.list_base.size()!=0) {
				   new Outcome(result.list_base, sel_model, nec_model, sum_model);
				   dispose();
			    }
			    if(result.list_base.size()==0) {
			    JOptionPane.showMessageDialog(null, "조건에 맞는 과목이 없습니다.");
			    }
			    }
			    else {
			    	if(nec_result.list_base.size()!=0&&nec_result.sub_grade==day_dater.subject_check_num) {
			    	new Outcome(nec_result.list_base, sel_model, nec_model, sum_model);
			    	  dispose();
			    	}
			    if(nec_result.list_base.size()==0&&nec_result.sub_grade!=day_dater.subject_check_num) {
			    	JOptionPane.showMessageDialog(null, "조건에 맞는 과목이 없거나 학점이 맞지 않습니다.");
			    }
			    }

				}
				if(nec_result.grade_check==1) {
					JOptionPane.showMessageDialog(null, "필수학점이 조건학점을 넘습니다.");
				}


			}
		}
	}

	public class Listen implements ItemListener{ //체크박스 관리

		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getItem()==monday) { // 월요일 체크박스 클릭 처리
				if(e.getStateChange()== ItemEvent.SELECTED) {
					day_dater.monday = true;
				}
				else {
					day_dater.monday = false;
				}
			}
             else if(e.getItem()==tuesday) { // 화요일 체크박스 클릭 처리
	if(e.getStateChange()== ItemEvent.SELECTED) {
		day_dater.tuesday = true;
	}
	else {
		day_dater.tuesday = false;
	}
			}
			else if(e.getItem()==wednesday) { // 수요일 체크박스 클릭 처리
				if(e.getStateChange()== ItemEvent.SELECTED) {
					day_dater.wednesday = true;
				}
				else {
					day_dater.wednesday = false;
				}
			}
    else if(e.getItem()==thursday) { // 목요일 체크박스 클릭 처리
	if(e.getStateChange()== ItemEvent.SELECTED) {
		day_dater.thursday = true;
	}
	else {
		day_dater.thursday = false;
	}
			}
    else if(e.getItem()==friday) { // 금요일 체크박스 클릭 처리
	if(e.getStateChange()== ItemEvent.SELECTED) {
		day_dater.friday = true;
	}
	else {
		day_dater.friday = false;
	}
          }
		}
	}


	public void paint(Graphics g) {
		screenImage = createImage(800, 900);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	// 새로고침
	public void screenDraw(Graphics g) {
		g.drawImage(Background, 0, 0, null);// 이미지 그리기
		paintComponents(g);// 컴포넌트 프린트 J라벨을 그리기
		this.repaint();
	}
}
