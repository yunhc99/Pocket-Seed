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
import javax.swing.border.Border;

public class Login extends JFrame{

	private Image screenImage;// �̹����� ���°�
	private Graphics screenGraphic;

	private Image Background = new ImageIcon(Main.class.getResource("../image/LoginBack.png")).getImage();
	private JLabel meunBar = new JLabel(new ImageIcon(Main.class.getResource("../image/menuBar.png")));


	private ImageIcon LoginButtonBasicImage = new ImageIcon(Main.class.getResource("../image/LoginButtonBasic.png"));
	private ImageIcon LoginButtonEnterImage = new ImageIcon(Main.class.getResource("../image/LoginButtonEnter.png"));
	private ImageIcon SignUpButtonImage = new ImageIcon(Main.class.getResource("../image/SignUpButton.png"));


	// �̹��� ũ�� ��ȯ
	Image LoginB = LoginButtonBasicImage.getImage();
	Image changeImgB = LoginB.getScaledInstance(480, 50, Image.SCALE_SMOOTH);
	ImageIcon LoginButtonBasicImage_c = new ImageIcon(changeImgB);

	Image LoginE = LoginButtonEnterImage.getImage();
	Image changeImgE = LoginE.getScaledInstance(480, 50, Image.SCALE_SMOOTH);
	ImageIcon LoginButtonEnterImage_E = new ImageIcon(changeImgE);

	private JButton LoginButton =new JButton(LoginButtonBasicImage_c);
	private JButton SignUpButton =new JButton(SignUpButtonImage);
	//


	private Font fon1 = new Font("����", Font.PLAIN, 30);


	private JTextField TFId =new JTextField(){
		public void setBorder(Border border) { // textfield�� ���� �׵θ� ����ȭ

		}
	};
	private JPasswordField TFPass =new JPasswordField(){
		public void setBorder(Border border) { // textfield�� ���� �׵θ� ����ȭ

		}
	};



	private int mouseX, mouseY;



	public Login() {
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

		LoginButton.setBounds(60, 800, 480, 50);//��ġ ����
		LoginButton.setBorderPainted(false);
		LoginButton.setContentAreaFilled(false);
		LoginButton.setFocusPainted(false);
		LoginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LoginButton.setIcon(LoginButtonEnterImage_E);
				LoginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//�հ��� Ŀ��
			}
			@Override
			public void mouseExited(MouseEvent e){
				LoginButton.setIcon(LoginButtonBasicImage_c);
				LoginButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//�⺻ Ŀ��
			}
			@Override
			public void mousePressed(MouseEvent e){
				System.out.print("�α��� ����\n");
				//�н����� ���Ȼ� ��ȯ����
				String pw = "";
				char[] secret_pw=TFPass.getPassword();//�ʵ忡�� �н����带 ������, char[] �迭�� ����
				for(char cha : secret_pw){ //secret_pw �迭�� ������ ��ȣ�� �ڸ��� ��ŭ for�� �����鼭 cha�� �� ���ھ� ����
					Character.toString(cha);
					//pw �� �����ϱ�, pw �� ���� ���������� ����, ���� ������ �̾ �����ϴ� ���׿�����
					pw += (pw.equals("")) ? ""+cha+"" : ""+cha+"";
				}

				System.out.print(TFId.getText()+"\n");
				System.out.print(pw + "\n");
				TFId.setText("");
				TFPass.setText("");
			}
		});
		add(LoginButton);

		SignUpButton.setBounds(420, 565, 100, 40);
		SignUpButton.setBorderPainted(false);
		SignUpButton.setContentAreaFilled(false);
		SignUpButton.setFocusPainted(false);
		SignUpButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				SignUpButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//�հ��� Ŀ��
			}
			@Override
			public void mouseExited(MouseEvent e){
				SignUpButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//�⺻ Ŀ��
			}
			@Override
			public void mousePressed(MouseEvent e){
				System.out.print("ȸ������ ����\n");
			}
		});
		add(SignUpButton);


		TFId.setBounds(65,605,470,45);
		TFId.setFont(fon1);
		add(TFId);

		TFPass.setBounds(65,715,470,45);
		TFPass.setFont(fon1);
		add(TFPass);

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
