package mainpro;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ConditionIN extends JFrame{
	private Image screenImage;// �̹����� ���°�
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

	private JButton BackButton=new JButton(BackButtonImage);
	private JButton EndSeachButton=new JButton(EndSeachButtonImage);
	private JButton NecessarySubButton=new JButton(NecessarySubButtonImage);
	private JButton SelectSubButton=new JButton(SelectSubButtonImage);

	private JTextField GradesF= new JTextField();

	private JTextArea SelectSubListA= new JTextArea();
	private JTextArea  NecessarySubListA= new JTextArea();
	private JScrollPane SelectScroll=new JScrollPane(SelectSubListA);
	private JScrollPane NecessaryScroll=new JScrollPane(NecessarySubListA);

	private JCheckBox week1=new JCheckBox("��" );
	private JCheckBox week2=new JCheckBox("ȭ" );
	private JCheckBox week3=new JCheckBox("��" );
	private JCheckBox week4=new JCheckBox("��" );
	private JCheckBox week5=new JCheckBox("��" );
	private ButtonGroup week=new ButtonGroup();

	private int mouseX, mouseY;

	public ConditionIN() {
		setUndecorated(true);// ������ �޴��� �Ⱥ��̱�
		setTitle("Test");
		setSize(800, 900);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0)); // ������Ʈ�� ������ �Ͼ���
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

		NecessarySubButton.setBounds(350, 180, 100, 100);
		NecessarySubButton.setBorderPainted(false);
		NecessarySubButton.setContentAreaFilled(false);
		NecessarySubButton.setFocusPainted(false);
		NecessarySubButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				NecessarySubButton.setIcon(NecessarySubButtonEnterImage);
				NecessarySubButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//�հ��� Ŀ��
			}
			@Override
			public void mouseExited(MouseEvent e){
				NecessarySubButton.setIcon(NecessarySubButtonImage);
				NecessarySubButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//�⺻ Ŀ��
			}
			@Override
			public void mousePressed(MouseEvent e){
				System.out.print("�ʼ����� ����\n");
			}
		});
		add(NecessarySubButton);

		SelectSubButton.setBounds(350, 415, 100, 100);
		SelectSubButton.setBorderPainted(false);
		SelectSubButton.setContentAreaFilled(false);
		SelectSubButton.setFocusPainted(false);
		SelectSubButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				SelectSubButton.setIcon(SelectSubButtonEnterImage);
				SelectSubButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//�հ��� Ŀ��
			}
			@Override
			public void mouseExited(MouseEvent e){
				SelectSubButton.setIcon(SelectSubButtonImage);
				SelectSubButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//�⺻ Ŀ��
			}
			@Override
			public void mousePressed(MouseEvent e){
				System.out.print("���ð��� ����\n");
			}
		});
		add(SelectSubButton);

		EndSeachButton.setBounds(45, 800, 200, 50);
		EndSeachButton.setBorderPainted(false);
		EndSeachButton.setContentAreaFilled(false);
		EndSeachButton.setFocusPainted(false);
		EndSeachButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				EndSeachButton.setIcon(EndSeachButtonEnterImage);
				EndSeachButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//�հ��� Ŀ��
			}
			@Override
			public void mouseExited(MouseEvent e){
				EndSeachButton.setIcon(EndSeachButtonImage);
				EndSeachButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//�⺻ Ŀ��
			}
			@Override
			public void mousePressed(MouseEvent e){
				System.out.print("�˻� ����\n");
			}
		});
		add(EndSeachButton);

		BackButton.setBounds(550, 800, 200, 50);
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
				System.out.print("�ڷ� ����\n");
			}
		});
		add(BackButton);


		SelectSubListA.setBounds(50, 175, 285, 340);
		SelectScroll.setBounds(50, 175, 285, 340);
		add(SelectScroll);

		NecessarySubListA.setBounds(465, 175, 285, 340);
		NecessaryScroll.setBounds(465, 175, 285, 340);
		add(NecessaryScroll);

		GradesF.setBounds(45, 725, 700, 45);
		add(GradesF);


		week.add(week1);
		week.add(week2);
		week.add(week3);
		week.add(week4);
		week.add(week5);
		week1.setBounds(70, 600, 50, 50);
		week2.setBounds(220, 600, 50, 50);
		week3.setBounds(370, 600, 50, 50);
		week4.setBounds(520, 600, 50, 50);
		week5.setBounds(670, 600, 50, 50);
		add(week1);
		add(week2);
		add(week3);
		add(week4);
		add(week5);


	}

	public void paint(Graphics g) {
		screenImage = createImage(800, 900);
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
