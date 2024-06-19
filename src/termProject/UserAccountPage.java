package termProject;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.awt.*;
import java.awt.event.*;

public class UserAccountPage extends JFrame{
		private JPanel contentPane;
	
	public UserAccountPage(User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 449);
		setTitle("Kullanıcı Hesabı");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		setVisible(true);
		
		JPanel panelNorth = new JPanel();
		panelNorth.setLayout(new GroupLayout(panelNorth));
		Image imgIconNorth = new ImageIcon(this.getClass().getResource("/sahibindenLogo2.png")).getImage();
		panelNorth.setBackground(new Color(83, 85, 104));
		panelNorth.setPreferredSize(new Dimension(WIDTH,100));
		contentPane.add(panelNorth, BorderLayout.NORTH);

		JLabel lblIconNorth = new JLabel();
		lblIconNorth.setBounds(17, 28, 200, 45);
		lblIconNorth.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				MainPage mp = new MainPage(user);
				setVisible(false);
			}
		});
		lblIconNorth.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconNorth.setIcon(new ImageIcon(imgIconNorth));
		panelNorth.add(lblIconNorth);

		JLabel lblNameSurname = new JLabel(user.getName() + " " + user.getSurname());
		lblNameSurname.setForeground(SystemColor.window);
		lblNameSurname.setBorder(new LineBorder(Color.white));
		lblNameSurname.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 17));
		lblNameSurname.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameSurname.setBounds(1675, 32, 190, 36);
		panelNorth.add(lblNameSurname);

		JPanel panelWest = new JPanel();
		panelWest.setLayout(new GroupLayout(panelWest));
		panelWest.setBackground(new Color(83, 85, 104));
		panelWest.setPreferredSize(new Dimension(280,HEIGHT));
		contentPane.add(panelWest, BorderLayout.WEST);

		JLabel lblIlanYonetimi = new JLabel("Ilan Yönetimi");
		lblIlanYonetimi.setBounds(77, 55, 120, 25);
		lblIlanYonetimi.setForeground(SystemColor.window);
		lblIlanYonetimi.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 17));
		lblIlanYonetimi.setHorizontalAlignment(SwingConstants.CENTER);
		panelWest.add(lblIlanYonetimi);
		
		JLabel lblCikisYap = new JLabel("Çıkıs Yap");
		lblCikisYap.setBounds(70, 150, 130, 28);
		lblCikisYap.setForeground(SystemColor.window);
		lblCikisYap.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 17));
		lblCikisYap.setHorizontalAlignment(SwingConstants.CENTER);
		panelWest.add(lblCikisYap);
		
		JLabel lblHesapBilgileri = new JLabel("Hesap Bilgilerim");
		lblHesapBilgileri.setBounds(72, 90, 130, 50);
		lblHesapBilgileri.setForeground(SystemColor.window);
		lblHesapBilgileri.setHorizontalAlignment(SwingConstants.CENTER);
		lblHesapBilgileri.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 17));
		panelWest.add(lblHesapBilgileri);

		JPanel panelMain = new JPanel();
		contentPane.add(panelMain, BorderLayout.CENTER);
		panelMain.setLayout(new GroupLayout(panelMain));

		lblIlanYonetimi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdManagement adManagement = new AdManagement(user);
				setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblIlanYonetimi.setForeground(new Color(2, 40, 62));
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblIlanYonetimi.setForeground(SystemColor.window);
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});

		lblHesapBilgileri.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				AccInformationPage accInformationPage = new AccInformationPage(user);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblHesapBilgileri.setForeground(new Color(2, 40, 62));
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblHesapBilgileri.setForeground(SystemColor.window);
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});

		lblCikisYap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblCikisYap.setForeground(new Color(2, 40, 62));
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblCikisYap.setForeground(SystemColor.window);
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
	}
}

