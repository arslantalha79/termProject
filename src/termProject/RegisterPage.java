package termProject;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class RegisterPage extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Timer timer;
	private int userId = 1;

	public RegisterPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocation(761, 317);
		setTitle("Kayıt ekranı");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setSize(400, 400);
		contentPane.setBackground(new Color(255, 229, 0));
		setVisible(true);

		JLabel lblRegisterText = new JLabel("Register!");
		lblRegisterText.setFont(new Font("Elephant", Font.BOLD, 24));
		lblRegisterText.setBounds(140, 38, 200, 29);
		contentPane.add(lblRegisterText);

		JLabel lblComeBackIcon = new JLabel("");
		Image imgComeBack = new ImageIcon(this.getClass().getResource("/comeBackIcon.png")).getImage();
		lblComeBackIcon.setIcon(new ImageIcon(imgComeBack));
		lblComeBackIcon.setBounds(20, 12, 35, 35);
		contentPane.add(lblComeBackIcon);

		JLabel lblName = new JLabel("Name         :");
		lblName.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 14));
		lblName.setBounds(47, 91, 100, 27);
		contentPane.add(lblName);

		JTextField tfName = new JTextField("");
		tfName.setBounds(158, 89, 180, 23);
		contentPane.add(tfName);

		JLabel lblSurname = new JLabel("Surname    :");
		lblSurname.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 14));
		lblSurname.setBounds(47, 121, 100, 27);
		contentPane.add(lblSurname);

		JTextField tfSurname = new JTextField("");
		tfSurname.setBounds(158, 122, 180, 23);
		contentPane.add(tfSurname);

		JLabel lblAge = new JLabel("Age            :");
		lblAge.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 14));
		lblAge.setBounds(47, 153, 100, 27);
		contentPane.add(lblAge);

		JTextField tfAge = new JTextField("");
		tfAge.setBounds(158, 152, 180, 23);
		contentPane.add(tfAge);

		JLabel lblUserName = new JLabel("User Name :");
		lblUserName.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 14));
		lblUserName.setBounds(47, 181, 100, 27);
		contentPane.add(lblUserName);

		JTextField tfUserName = new JTextField("");
		tfUserName.setBounds(158, 181, 180, 23);
		contentPane.add(tfUserName);

		JLabel lblPassword = new JLabel("Password  :");
		lblPassword.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 14));
		lblPassword.setBounds(47, 211, 100, 27);
		contentPane.add(lblPassword);

		JPasswordField pfPassword = new JPasswordField("");
		pfPassword.setBounds(158, 212, 180, 23);
		pfPassword.setEchoChar('*');
		contentPane.add(pfPassword);
		
		JLabel lblSecurityQuestion = new JLabel("Security Question:");
		lblSecurityQuestion.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 12));
		lblSecurityQuestion.setBounds(47, 243, 100, 27);
		contentPane.add(lblSecurityQuestion);

		JTextField tfSecurityQuestion = new JTextField("");
		tfSecurityQuestion.setBounds(158, 243, 180, 23);
		contentPane.add(tfSecurityQuestion);
		
		JLabel lblAnswer = new JLabel("Answer     :");
		lblAnswer.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 14));
		lblAnswer.setBounds(47, 273, 100, 27);
		contentPane.add(lblAnswer);

		JTextField tfAnswer = new JTextField("");
		tfAnswer.setBounds(158, 273, 180, 23);
		contentPane.add(tfAnswer);

		JButton btnRegister = new JButton("Register");
		btnRegister.setBackground(new Color(255, 229, 0));
		btnRegister.setFont(new Font("Imprint MT Shadow", Font.BOLD, 14));
		btnRegister.setBounds(110, 310, 180, 30);
		btnRegister.setBorder(BorderFactory.createLineBorder(Color.black));
		contentPane.add(btnRegister);

		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegister.setForeground(Color.white);
				btnRegister.setBackground(Color.black);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnRegister.setForeground(Color.black);
				btnRegister.setBackground(new Color(255, 229, 0));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (tfName.getText().equals("") || tfSurname.getText().equals("") || tfAge.getText().equals("") || 
						tfUserName.getText().equals("") || pfPassword.getText().equals("")) {
					JLabel lblErrorMesage = new JLabel("Fill in the blank fields!");
					lblErrorMesage.setForeground(Color.red);
					lblErrorMesage.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 14));
					lblErrorMesage.setBounds(140, 340, 150, 22);
					contentPane.add(lblErrorMesage);

					timer = new Timer(2000, new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							lblErrorMesage.setVisible(false);
						}
					});
					timer.setRepeats(false);
					timer.start();
					contentPane.revalidate();
					contentPane.repaint();
				} else {
					BufferedReader br = null;
					FileReader fr = null;
					boolean found = false;
					String[] strArray;
					String line;

					try {
						fr = new FileReader("users.txt");
						br = new BufferedReader(fr);
						while ((line = br.readLine()) != null) {
							strArray = line.split(",");
							if (strArray[4].equals(tfUserName.getText().trim())) {
								found = true;
								break;
							} 
						}
						try {
							fr.close();
						} catch (Exception e2) {
							System.out.println("File closing unsuccessful");
						}
						
						if (found) {
							JLabel lblErrorMesage = new JLabel("This user is registered in the system");
							lblErrorMesage.setForeground(Color.red);
							lblErrorMesage.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 14));
							lblErrorMesage.setBounds(96, 340, 250, 22);
							contentPane.add(lblErrorMesage);

							timer = new Timer(2000, new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									lblErrorMesage.setVisible(false);
								}
							});
							timer.setRepeats(false);
							timer.start();
							contentPane.revalidate();
							contentPane.repaint();
						}else {
							
							Random rand = new Random();
							userId = rand.nextInt(1000);
							
							try {
								fr = new FileReader("users.txt");
								br = new BufferedReader(fr);
								while ((line = br.readLine()) != null) {
									strArray = line.split(",");
									if (Integer.parseInt(strArray[0]) == userId) {
										userId = rand.nextInt();
									}
								}
							} catch (Exception e2) {
								System.out.println("File reading unsuccessful");
							}
							
							FileWriter fw = new FileWriter("users.txt",true);
							BufferedWriter bw = new BufferedWriter(fw);
							line = userId + "," + tfName.getText().trim() + "," + tfSurname.getText().trim() + "," + tfAge.getText().trim() + 
									"," + tfUserName.getText().trim() + "," + pfPassword.getText().trim() + 
									"," + tfSecurityQuestion.getText().trim() + "," + tfAnswer.getText().trim() +"\r\n";
							bw.write(line);
							bw.close();
							
							JLabel lblSuccessMesage = new JLabel("Registration Successful!");
							lblSuccessMesage.setForeground(Color.red);
							lblSuccessMesage.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 14));
							lblSuccessMesage.setBounds(130, 340, 250, 22);
							contentPane.add(lblSuccessMesage);

							timer = new Timer(700, new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									lblSuccessMesage.setVisible(false);
									setVisible(false);
									LoginPage lp = new LoginPage();
								}
							});
							timer.setRepeats(false);
							timer.start();
							contentPane.revalidate();
							contentPane.repaint();
						}
					} catch (Exception e2) {
						System.out.println("File reading unsuccessful!");
					}finally {
						if (fr != null) {
							try {
								fr.close();
							} catch (Exception e3) {
								System.out.println("Read operation successful however close operation unsuccessful...");
							}
						}
					}
				}
			}
		});

		lblComeBackIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				LoginPage lp = new LoginPage();
			}
		});
	}
}

