package mainpro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Outcome extends JFrame{

	DefaultListModel sel_model;
    DefaultListModel nec_model;
    DefaultListModel sum_model;
	private Image screenImage;// 이미지를 담는거
	private Graphics screenGraphic;

	private Image Background = new ImageIcon(Main.class.getResource("../image/OutcomeBack.png")).getImage();
	private JLabel meunBar = new JLabel(new ImageIcon(Main.class.getResource("../image/menuBar.png")));

	private ImageIcon BackButtonImage = new ImageIcon(Main.class.getResource("../image/OutcomeBackButton.png"));
	private ImageIcon BackButtonEnterImage = new ImageIcon(Main.class.getResource("../image/OutcomeBackButtonEnter.png"));
	private ImageIcon SaveButtonImage = new ImageIcon(Main.class.getResource("../image/OutcomeSaveButton.png"));
	private ImageIcon SaveButtonEnterImage = new ImageIcon(Main.class.getResource("../image/OutcomeSaveButtonEnter.png"));
	private ImageIcon ExitButtonImage = new ImageIcon(Main.class.getResource("../image/OutcomeExitButton.png"));
	private ImageIcon ExitButtonEnterImage = new ImageIcon(Main.class.getResource("../image/OutcomeExitButtonEnter.png"));

	private ImageIcon RightButtonImage = new ImageIcon(Main.class.getResource("../image/OutcomeRightButton.png"));
	private ImageIcon LeftButtonImage = new ImageIcon(Main.class.getResource("../image/OutcomeLeftButton.png"));

	ArrayList<ArrayList<Sub_dater>> list_base_base;

	int count_subject = 0;
	// 이미지 크기 변환
			Image Back_B = BackButtonImage.getImage();
			Image BB = Back_B.getScaledInstance(130, 30, Image.SCALE_SMOOTH);
			ImageIcon BackButton_B = new ImageIcon(BB);

			Image Back_E = BackButtonEnterImage.getImage();
			Image BE = Back_E.getScaledInstance(130, 30, Image.SCALE_SMOOTH);
			ImageIcon BackButton_E = new ImageIcon(BE);

			Image Save_B = SaveButtonImage.getImage();
			Image SB = Save_B.getScaledInstance(130, 30, Image.SCALE_SMOOTH);
			ImageIcon SaveButton_B = new ImageIcon(SB);

			Image Save_E = SaveButtonEnterImage.getImage();
			Image SE = Save_E.getScaledInstance(130, 30, Image.SCALE_SMOOTH);
			ImageIcon SaveButton_E = new ImageIcon(SE);

			Image Exit_B = ExitButtonImage.getImage();
			Image EB = Exit_B.getScaledInstance(130, 30, Image.SCALE_SMOOTH);
			ImageIcon ExitButton_B = new ImageIcon(EB);

			Image Exit_E = ExitButtonEnterImage.getImage();
			Image EE = Exit_E.getScaledInstance(130, 30, Image.SCALE_SMOOTH);
			ImageIcon ExitButton_E = new ImageIcon(EE);

			Image Right_B = RightButtonImage.getImage();
			Image RB = Right_B.getScaledInstance(80, 70, Image.SCALE_SMOOTH);
			ImageIcon RightButton_B = new ImageIcon(RB);

			Image Left_E = LeftButtonImage.getImage();
			Image LE = Left_E.getScaledInstance(80, 70, Image.SCALE_SMOOTH);
			ImageIcon LeftButton_E = new ImageIcon(LE);

			//



	private JButton BackButton= new JButton(BackButton_B);
	private JButton SaveButton= new JButton(SaveButton_B);
	private JButton ExitButton= new JButton(ExitButton_B);
	private JButton RightButton= new JButton(RightButton_B);
	private JButton LeftButton= new JButton(LeftButton_E);


	String header[]= {"시간", "월", "화","수","목","금"};



	String contect[][]= {
			{"09:30~10:20","","","","",""},
			{"10:30~11:20","","","","",""},
			{"11:30~12:20","","","","",""},
			{"12:30~13:20","","","","",""},
			{"13:30~14:20","","","","",""},
			{"14:30~15:20","","","","",""},
			{"15:30~17:20","","","","",""},
			{"17:30~18:20","","","","",""},
			{"18:30~19:20","","","","",""}
	};



	private int mouseX, mouseY;

	public Outcome(ArrayList<ArrayList<Sub_dater>> list_base_base, DefaultListModel sel_model, DefaultListModel nec_model,
			DefaultListModel sum_model) {

		this.sel_model = sel_model;
		this.nec_model = nec_model;
		this.sum_model = sum_model;
		this.list_base_base = list_base_base;





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




		for(int u=0 ; u<list_base_base.get(0).size(); u++) {
		if(list_base_base.get(0).get(u).Day_first.equals("월")){
count(1, u);
		}
if(list_base_base.get(0).get(u).Day_first.equals("화")){
	count(2, u);
		}
if(list_base_base.get(0).get(u).Day_first.equals("수")){
	count(3, u);
}
if(list_base_base.get(0).get(u).Day_first.equals("목")){
	count(4, u);
}
if(list_base_base.get(0).get(u).Day_first.equals("금")){
	count(5, u);
}
if(list_base_base.get(0).get(u).Day_Second.equals("월")){
	count2(1, u);
}
if(list_base_base.get(0).get(u).Day_Second.equals("화")){
	count2(2, u);
}
if(list_base_base.get(0).get(u).Day_Second.equals("수")){
	count2(3, u);
}
if(list_base_base.get(0).get(u).Day_Second.equals("목")){
	count2(4, u);
}
if(list_base_base.get(0).get(u).Day_Second.equals("금")){
	count2(5, u);
}
		}



		JTable table = new JTable(contect, header);

		JScrollPane scroll = new JScrollPane(table);

		meunBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x=e.getXOnScreen();
				int y=e.getYOnScreen();
				setLocation(x-mouseX, y-mouseY);
			}
		});
		add(meunBar);

		RightButton.setBounds(332, 558, 80, 70);
		RightButton.setBorderPainted(false);
		RightButton.setContentAreaFilled(false);
		RightButton.setFocusPainted(false);
		RightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				//RightButton.setIcon(RightButtonEnterImage);
				RightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//손가락 커서
			}
			@Override
			public void mouseExited(MouseEvent e){
				//RightButton.setIcon(RightButtonImage);
				RightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//기본 커서
			}
			@Override
			public void mousePressed(MouseEvent e){
				System.out.print("오른쪽 기능\n");
			}
		});
		add(RightButton);
		RightButton.addActionListener(new action());

		LeftButton.setBounds(182, 558, 80, 70);
		LeftButton.setBorderPainted(false);
		LeftButton.setContentAreaFilled(false);
		LeftButton.setFocusPainted(false);
		LeftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				//RightButton.setIcon(RightButtonEnterImage);
				LeftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//손가락 커서
			}
			@Override
			public void mouseExited(MouseEvent e){
				//RightButton.setIcon(RightButtonImage);
				LeftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//기본 커서
			}
			@Override
			public void mousePressed(MouseEvent e){
				System.out.print("왼쪽 기능\n");
			}
		});
		add(LeftButton);
		LeftButton.addActionListener(new action());

		BackButton.setBounds(40, 820, 130, 30);
		BackButton.setBorderPainted(false);
		BackButton.setContentAreaFilled(false);
		BackButton.setFocusPainted(false);
		BackButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				BackButton.setIcon(BackButton_E);
				BackButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//손가락 커서
			}
			@Override
			public void mouseExited(MouseEvent e){
				BackButton.setIcon(BackButton_B);
				BackButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//기본 커서
			}
			@Override
			public void mousePressed(MouseEvent e){
				System.out.print("뒤로가기 기능\n");
			}
		});
		add(BackButton);
		BackButton.addActionListener(new action());

		SaveButton.setBounds(235, 820, 130, 30);
		SaveButton.setBorderPainted(false);
		SaveButton.setContentAreaFilled(false);
		SaveButton.setFocusPainted(false);
		SaveButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				SaveButton.setIcon(SaveButton_E);
				SaveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//손가락 커서
			}
			@Override
			public void mouseExited(MouseEvent e){
				SaveButton.setIcon(SaveButton_B);
				SaveButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//기본 커서
			}
			@Override
			public void mousePressed(MouseEvent e){				
		        String saveFileExtension = "png";		       		       
		        
		        Dimension frameSize = getSize();
		        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();		        
		        
		        try {
		        	setLocation((screenSize.width - frameSize.width)/2,(screenSize.height - frameSize.height)/2);
		            Robot robot = new Robot();
		            //Rectangle rectangle = new Rectangle(500, 500, Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);		            
		            Rectangle rectangle = new Rectangle((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2,
		            		Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		            BufferedImage image = robot.createScreenCapture(rectangle);
		            image.setRGB(0,0,100);
		            		            		          
		            JFileChooser fileChooser = new JFileChooser();
		            fileChooser.setFileFilter(new FileNameExtensionFilter("*.png", "png"));
		            if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
		                File file = fileChooser.getSelectedFile();		               
		                ImageIO.write(image, saveFileExtension, new File(file.getAbsolutePath()+"."+saveFileExtension));
		                JOptionPane.showMessageDialog(null, "이미지 저장 완료");
		            } else {
		                System.out.println("No file choosen!");
		            }		        		            		            		            		            		            
		            
		        }catch (Exception e1){
		            e1.printStackTrace();
		        }		            			   		         		        		        
				System.out.print("저장 기능 완료\n");
			}
		});
		add(SaveButton);
		SaveButton.addActionListener(new action());

		ExitButton.setBounds(430, 820, 130, 30);
		ExitButton.setBorderPainted(false);
		ExitButton.setContentAreaFilled(false);
		ExitButton.setFocusPainted(false);
		ExitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ExitButton.setIcon(ExitButton_E);
				ExitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//손가락 커서
			}
			@Override
			public void mouseExited(MouseEvent e){
				ExitButton.setIcon(ExitButton_B);
				ExitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//기본 커서
			}
			@Override
			public void mousePressed(MouseEvent e){
				System.exit(0);
			}
		});
		add(ExitButton);

		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.setRowHeight(35);


		scroll.setBounds(38, 205, 525, 335);
		add(scroll);
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

	public void count(int i, int u) {
		if(list_base_base.get(0).get(u).Date_first_1.equals("1")) {
			contect[0][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_first_2.equals("1")) {
			contect[0][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_first_3.equals("1")) {
			contect[0][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_first_1.equals("2")) {
			contect[1][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_first_2.equals("2")) {
			contect[1][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_first_3.equals("2")) {
			contect[1][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_first_1.equals("3")) {
			contect[2][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_first_2.equals("3")) {
			contect[2][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_first_3.equals("3")) {
			contect[2][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_first_1.equals("4")) {
			contect[3][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_first_2.equals("4")) {
			contect[3][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_first_3.equals("4")) {
			contect[3][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_first_1.equals("5")) {
			contect[4][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_first_2.equals("5")) {
			contect[4][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_first_3.equals("5")) {
			contect[4][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_first_1.equals("6")) {
			contect[5][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_first_2.equals("6")) {
			contect[5][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_first_3.equals("6")) {
			contect[5][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_first_1.equals("7")) {
			contect[6][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_first_2.equals("7")) {
			contect[6][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_first_3.equals("7")) {
			contect[6][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_first_1.equals("8")) {
			contect[7][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_first_2.equals("8")) {
			contect[7][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_first_3.equals("8")) {
			contect[7][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_first_1.equals("9")) {
			contect[8][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_first_2.equals("9")) {
			contect[8][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_first_3.equals("9")) {
			contect[8][i]= list_base_base.get(0).get(u).subject_name;
		}
	}

	public void count2(int i, int u) {
		if(list_base_base.get(0).get(u).Date_Second_1.equals("1")) {
			contect[0][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_Second_2.equals("1")) {
			contect[0][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_Second_3.equals("1")) {
			contect[0][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_Second_1.equals("2")) {
			contect[1][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_Second_2.equals("2")) {
			contect[1][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_Second_3.equals("2")) {
			contect[1][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_Second_1.equals("3")) {
			contect[2][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_Second_2.equals("3")) {
			contect[2][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_Second_3.equals("3")) {
			contect[2][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_Second_1.equals("4")) {
			contect[3][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_Second_2.equals("4")) {
			contect[3][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_Second_3.equals("4")) {
			contect[3][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_Second_1.equals("5")) {
			contect[4][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_Second_2.equals("5")) {
			contect[4][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_Second_3.equals("5")) {
			contect[4][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_Second_1.equals("6")) {
			contect[5][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_Second_2.equals("6")) {
			contect[5][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_Second_3.equals("6")) {
			contect[5][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_Second_1.equals("7")) {
			contect[6][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_Second_2.equals("7")) {
			contect[6][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_Second_3.equals("7")) {
			contect[6][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_Second_1.equals("8")) {
			contect[7][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_Second_2.equals("8")) {
			contect[7][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_Second_3.equals("8")) {
			contect[7][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_Second_1.equals("9")) {
			contect[8][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_Second_2.equals("9")) {
			contect[8][i]= list_base_base.get(0).get(u).subject_name;
		}
		if(list_base_base.get(0).get(u).Date_Second_3.equals("9")) {
			contect[8][i]= list_base_base.get(0).get(u).subject_name;
		}
	}

	public class action implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {


			if(e.getSource()==SaveButton) {

			}


			if(e.getSource()==LeftButton) {
				count_subject--;
				if(count_subject<0) {
					count_subject=list_base_base.size()-1;
				}

				for(int y=0; y<9; y++) {
					for(int i=1; i<6 ; i++) {
				contect[y][i]="";
					}
				}

					for(int u=0 ; u<list_base_base.get(0).size(); u++) {
						if(list_base_base.get(count_subject).get(u).Day_first.equals("월")){
				count(1, u);
						}
				if(list_base_base.get(count_subject).get(u).Day_first.equals("화")){
					count(2, u);
						}
				if(list_base_base.get(count_subject).get(u).Day_first.equals("수")){
					count(3, u);
				}
				if(list_base_base.get(count_subject).get(u).Day_first.equals("목")){
					count(4, u);
				}
				if(list_base_base.get(count_subject).get(u).Day_first.equals("금")){
					count(5, u);
				}
				if(list_base_base.get(count_subject).get(u).Day_Second.equals("월")){
					count2(1, u);
				}
				if(list_base_base.get(count_subject).get(u).Day_Second.equals("화")){
					count2(2, u);
				}
				if(list_base_base.get(count_subject).get(u).Day_Second.equals("수")){
					count2(3, u);
				}
				if(list_base_base.get(count_subject).get(u).Day_Second.equals("목")){
					count2(4, u);
				}
				if(list_base_base.get(count_subject).get(u).Day_Second.equals("금")){
					count2(5, u);
				}
						}

			}




if(e.getSource()==RightButton) {
	count_subject++;

	if(count_subject==list_base_base.size()) {
		count_subject=0;
	}

for(int y=0; y<9; y++) {
	for(int i=1; i<6 ; i++) {
contect[y][i]="";
	}
}
	for(int u=0 ; u<list_base_base.get(0).size(); u++) {
		if(list_base_base.get(count_subject).get(u).Day_first.equals("월")){
count(1, u);
		}
if(list_base_base.get(count_subject).get(u).Day_first.equals("화")){
	count(2, u);
		}
if(list_base_base.get(count_subject).get(u).Day_first.equals("수")){
	count(3, u);
}
if(list_base_base.get(count_subject).get(u).Day_first.equals("목")){
	count(4, u);
}
if(list_base_base.get(count_subject).get(u).Day_first.equals("금")){
	count(5, u);
}
if(list_base_base.get(count_subject).get(u).Day_Second.equals("월")){
	count2(1, u);
}
if(list_base_base.get(count_subject).get(u).Day_Second.equals("화")){
	count2(2, u);
}
if(list_base_base.get(count_subject).get(u).Day_Second.equals("수")){
	count2(3, u);
}
if(list_base_base.get(count_subject).get(u).Day_Second.equals("목")){
	count2(4, u);
}
if(list_base_base.get(count_subject).get(u).Day_Second.equals("금")){
	count2(5, u);
}
		}
}

if(e.getSource()==BackButton) {
	new ConditionIN(sum_model);
	dispose();
}

		}

	}



}
