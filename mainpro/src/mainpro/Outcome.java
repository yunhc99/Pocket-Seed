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
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Outcome extends JFrame{
	private Image screenImage;// �̹����� ���°�
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

	private JButton BackButton= new JButton(BackButtonImage);
	private JButton SaveButton= new JButton(SaveButtonImage);
	private JButton ExitButton= new JButton(ExitButtonImage);
	private JButton RightButton= new JButton(RightButtonImage);
	private JButton LeftButton= new JButton(LeftButtonImage);


	String header[]= {"����", "��", "ȭ","��","��","��"};
	String contect[][]= {
			{"1","��","��","Ʈ","��","��"},
			{"2","��","��","Ʈ","��","��"},
			{"3","��","��","Ʈ","��","��"}
	};

	DefaultTableModel model = new DefaultTableModel(contect,header);
	private JTable SubS=new JTable(model);
	private JScrollPane TabelS= new JScrollPane(SubS);


	private int mouseX, mouseY;

	public Outcome() {
		setUndecorated(true);// ������ �޴��� �Ⱥ��̱�
		setTitle("Test");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0)); // ������Ʈ�� ������ �Ͼ���
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

		RightButton.setBounds(325, 558, 90, 70);
		RightButton.setBorderPainted(false);
		RightButton.setContentAreaFilled(false);
		RightButton.setFocusPainted(false);
		RightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				//RightButton.setIcon(RightButtonEnterImage);
				RightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//�հ��� Ŀ��
			}
			@Override
			public void mouseExited(MouseEvent e){
				//RightButton.setIcon(RightButtonImage);
				RightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//�⺻ Ŀ��
			}
			@Override
			public void mousePressed(MouseEvent e){
				System.out.print("������ ����\n");
			}
		});
		add(RightButton);

		LeftButton.setBounds(182, 558, 90, 70);
		LeftButton.setBorderPainted(false);
		LeftButton.setContentAreaFilled(false);
		LeftButton.setFocusPainted(false);
		LeftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				//RightButton.setIcon(RightButtonEnterImage);
				LeftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//�հ��� Ŀ��
			}
			@Override
			public void mouseExited(MouseEvent e){
				//RightButton.setIcon(RightButtonImage);
				LeftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//�⺻ Ŀ��
			}
			@Override
			public void mousePressed(MouseEvent e){
				System.out.print("���� ����\n");
			}
		});
		add(LeftButton);

		BackButton.setBounds(40, 820, 160, 45);
		BackButton.setBorderPainted(false);
		BackButton.setContentAreaFilled(false);
		BackButton.setFocusPainted(false);
		BackButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				BackButton.setIcon(BackButtonEnterImage);
				BackButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//�հ��� Ŀ��
			}
			@Override
			public void mouseExited(MouseEvent e){
				BackButton.setIcon(BackButtonImage);
				BackButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//�⺻ Ŀ��
			}
			@Override
			public void mousePressed(MouseEvent e){
				System.out.print("�ڷΰ��� ����\n");
			}
		});
		add(BackButton);

		SaveButton.setBounds(220, 820, 160, 45);
		SaveButton.setBorderPainted(false);
		SaveButton.setContentAreaFilled(false);
		SaveButton.setFocusPainted(false);
		SaveButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				SaveButton.setIcon(SaveButtonEnterImage);
				SaveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//�հ��� Ŀ��
			}
			@Override
			public void mouseExited(MouseEvent e){
				SaveButton.setIcon(SaveButtonImage);
				SaveButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//�⺻ Ŀ��
			}
			@Override
			public void mousePressed(MouseEvent e){
				System.out.print("���� ����\n");
			}
		});
		add(SaveButton);

		ExitButton.setBounds(400, 820, 160, 45);
		ExitButton.setBorderPainted(false);
		ExitButton.setContentAreaFilled(false);
		ExitButton.setFocusPainted(false);
		ExitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ExitButton.setIcon(ExitButtonEnterImage);
				ExitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//�հ��� Ŀ��
			}
			@Override
			public void mouseExited(MouseEvent e){
				ExitButton.setIcon(ExitButtonImage);
				ExitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//�⺻ Ŀ��
			}
			@Override
			public void mousePressed(MouseEvent e){
				System.exit(0);
			}
		});
		add(ExitButton);

		TabelS.setBounds(35, 205, 530, 340);
		SubS.setBounds(35, 205, 530, 340);
		add(TabelS);
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	// ���ΰ�ħ
	public void screenDraw(Graphics g) {
		g.drawImage(Background, 0, 0, null);// �̹����׸���
		paintComponents(g);// ������Ʈ ����Ʈ J������ �׸���
		this.repaint();
	}

}
