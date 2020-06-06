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
	private Image screenImage;// �̹����� ��°�
	private Graphics screenGraphic;
	
	private Image Background = new ImageIcon(Main.class.getResource("../image/SignBack.png")).getImage();
	private JLabel meunBar = new JLabel(new ImageIcon(Main.class.getResource("../image/menuBar.png")));
	
	private ImageIcon SignButtonImage = new ImageIcon(Main.class.getResource("../image/SignButton.png"));
	private ImageIcon SignButtonEnterImage = new ImageIcon(Main.class.getResource("../image/SignButtonEnter.png"));
	
	private JButton SignButton =new JButton(SignButtonImage);
	
	private Font fon1 = new Font("����", Font.PLAIN, 45);
	
	private JTextField TFId =new JTextField();
	private JPasswordField TFPass =new JPasswordField();
	
	private int mouseX, mouseY;	
	
	public Sign() {
		setUndecorated(true);// ����� �޴��� �Ⱥ��̱�
		setTitle("Test");
		setSize(600 ,615);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0)); // ������Ʈ�� ����� �Ͼ��
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
				SignButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//�հ��� Ŀ��
			}
			@Override
			public void mouseExited(MouseEvent e){
				SignButton.setIcon(SignButtonImage);
				SignButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//�⺻ Ŀ��
			}
			@Override
			public void mousePressed(MouseEvent e){
				System.out.print("ȸ������ ���\n");
				//�н����� ���Ȼ� ��ȯ����
				String pw = "";
				char[] secret_pw=TFPass.getPassword();//�ʵ忡�� �н����带 ����, char[] �迭�� ����
				for(char cha : secret_pw){ //secret_pw �迭�� ����� ��ȣ�� �ڸ��� ��ŭ for�� �����鼭 cha�� �� ���ھ� ����
					Character.toString(cha);
					//pw �� �����ϱ�, pw �� ���� ��������� ����, ���� ������ �̾ �����ϴ� ���׿�����
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

	// ���ΰ�ħ
	public void screenDraw(Graphics g) {
		g.drawImage(Background, 0, 0, null);// �̹����׸���
		paintComponents(g);// ������Ʈ ����Ʈ J���� �׸���
		this.repaint();
	}
	
}
