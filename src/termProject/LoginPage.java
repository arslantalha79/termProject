package termProject;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class LoginPage extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private BufferedReader br;
	private String line;
	private String[] strArray;
	private boolean found = false;
	private FileReader fr;
	private JTextField tfUserName;
	private JPasswordField pfPassword;
	private Timer timer;
	private User user;

	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);
		setTitle("Giriş ekranı");
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(255, 229, 0));
		setVisible(true);

		JLabel lblLogo1 = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/sahibinenLogo.png")).getImage();
		lblLogo1.setIcon(new ImageIcon(img1));
		lblLogo1.setBounds(74, 50, 50, 51);
		contentPane.add(lblLogo1);

		JLabel lblLogo2 = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/sahibindenLogo2.png")).getImage();
		lblLogo2.setIcon(new ImageIcon(img2));
		lblLogo2.setBounds(117, 50, 205, 51);
		contentPane.add(lblLogo2);

		JLabel lblUserName = new JLabel("User Name :");
		lblUserName.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 16));
		lblUserName.setBounds(70, 143, 95, 27);
		contentPane.add(lblUserName);

		tfUserName = new JTextField();
		tfUserName.setBounds(165, 143, 163, 27);
		contentPane.add(tfUserName);
		tfUserName.setColumns(15);

		JLabel lblPassword = new JLabel("Password    : ");
		lblPassword.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 16));
		lblPassword.setBounds(71, 180, 95, 33);
		contentPane.add(lblPassword);

		pfPassword = new JPasswordField();
		pfPassword.setEchoChar('*');
		pfPassword.setBounds(165, 180, 163, 28);
		contentPane.add(pfPassword);

		JLabel lblPasswordForgot = new JLabel("Forgot you password?");
		lblPasswordForgot.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 12));
		lblPasswordForgot.setBounds(215, 210, 115, 20);
		contentPane.add(lblPasswordForgot);

		lblPasswordForgot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblPasswordForgot.setText("<html><u>Forgot you password?</u></html>");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblPasswordForgot.setText("Forgot you password?");
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				String userName = JOptionPane.showInputDialog("Kullanıcı adınız : ");

				try {
					fr = new FileReader("users.txt");
					br = new BufferedReader(fr);
					while ((line = br.readLine()) != null) {
						strArray = line.split(",");
						if ((strArray[4].equals(userName.trim()))) {
							found = true;
							String answer = JOptionPane.showInputDialog(strArray[6] + " ?");
							if (answer.equals(strArray[7].trim())) {
								JOptionPane.showMessageDialog(null,"Sifreniz : " + strArray[5]);
								break;
							}else {
								JOptionPane.showMessageDialog(null,"Hatalı Cevap!");
								break;
							}
						}
					}
					if (!found) {
						JOptionPane.showMessageDialog(null, "Böyle bir kullanıcı bulunamadı!");
					}
				} catch (Exception e2) {
					System.out.println("File reading error occurred...");
				}finally {
					if (fr != null) {
						try {
							fr.close();
						} catch (IOException exp) {
							System.out.println("Read operattion successful however close unsuccessful...");
						}
					}
				}
			}
		});

		JLabel lblButonLogin = new JLabel("Login");
		lblButonLogin.setFont(new Font("Imprint MT Shadow", Font.BOLD, 12));
		lblButonLogin.setVerticalTextPosition(SwingConstants.CENTER);
		lblButonLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		Image imgButonLogin = new ImageIcon(this.getClass().getResource("/butonLogin2.png")).getImage();
		lblButonLogin.setIcon(new ImageIcon(imgButonLogin));
		lblButonLogin.setBounds(90, 255, 100, 27);
		contentPane.add(lblButonLogin);

		lblButonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				found = false;
				
				try {
					fr = new FileReader("users.txt");
					br = new BufferedReader(fr);
					
					while ((line = br.readLine()) != null) {
						strArray = line.split(",");
						if ((strArray[4].equals(tfUserName.getText().trim()))) {
							found = true;
							if (strArray[5].equals(pfPassword.getText().trim())) {
								setVisible(false);
								if (strArray.length == 8) {
									user = new User(Integer.parseInt(strArray[0]),strArray[1], strArray[2], Integer.parseInt(strArray[3]), strArray[4],
											strArray[5],strArray[6],strArray[7]);
								}else if (strArray.length == 10) {
									user = new User(Integer.parseInt(strArray[0]),strArray[1], strArray[2], Integer.parseInt(strArray[3]), strArray[4],
											strArray[5],strArray[6],strArray[7],strArray[8],strArray[9]);
								}
								MainPage mp = new MainPage(user);

							} else {
								JLabel lblPasswordMessage = new JLabel("Wrong Password! Try Again");
								lblPasswordMessage.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 14));
								lblPasswordMessage.setBounds(112, 300, 200, 33);
								contentPane.add(lblPasswordMessage);

								timer = new Timer(1000, new ActionListener() {
									@Override
									public void actionPerformed(ActionEvent e) {
										lblPasswordMessage.setVisible(false);

									}
								});
								timer.setRepeats(false);
								timer.start();
								contentPane.revalidate();
								contentPane.repaint();
							}
						} 
					}if (!found) {
						JLabel lblUserMessage = new JLabel("There is not a such user..");
						lblUserMessage.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 14));
						lblUserMessage.setBounds(123, 300, 200, 33);
						contentPane.add(lblUserMessage);
						timer = new Timer(1000, new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								lblUserMessage.setVisible(false);

							}
						});
						timer.setRepeats(false);
						timer.start();
						contentPane.revalidate();
						contentPane.repaint();
					}
				} catch (IOException ex) {
					System.out.println("File reading error occurred...");
				} finally {
					if (fr != null) {
						try {
							fr.close();
						} catch (IOException exp) {
							System.out.println("Read operattion successful however close unsuccessful...");
						}
					}
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblButonLogin.setForeground(Color.white);
				Image imgLoginButton = new ImageIcon(this.getClass().getResource("/butonLogin3.png")).getImage();
				lblButonLogin.setIcon(new ImageIcon(imgLoginButton));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblButonLogin.setForeground(Color.black);
				Image imgButonLogin = new ImageIcon(this.getClass().getResource("/butonLogin2.png")).getImage();
				lblButonLogin.setIcon(new ImageIcon(imgButonLogin));
			}
		});

		JLabel lblButonRegister = new JLabel("Sign Up Now!");
		lblButonRegister.setFont(new Font("Imprint MT Shadow", Font.BOLD, 13));
		lblButonRegister.setVerticalTextPosition(SwingConstants.CENTER);
		lblButonRegister.setHorizontalTextPosition(SwingConstants.CENTER);
		Image imgButonRegister = new ImageIcon(this.getClass().getResource("/butonLogin2.png")).getImage();
		lblButonRegister.setIcon(new ImageIcon(imgButonRegister));
		lblButonRegister.setBounds(205, 255, 100, 27);
		contentPane.add(lblButonRegister);

		lblButonRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblButonRegister.setForeground(Color.white);
				Image imgButonRegister = new ImageIcon(this.getClass().getResource("/butonLogin3.png")).getImage();
				lblButonRegister.setIcon(new ImageIcon(imgButonRegister));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblButonRegister.setForeground(Color.black);
				Image imgButonLogin = new ImageIcon(this.getClass().getResource("/butonLogin2.png")).getImage();
				lblButonRegister.setIcon(new ImageIcon(imgButonLogin));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				RegisterPage rp = new RegisterPage();
			}

		});
	}
}

