package termProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class AccInformationPage extends JFrame {
	private JPanel contentPane;
	private FileReader fr;
	private BufferedReader br;
	private FileWriter fw;
	private BufferedWriter bw;

	public AccInformationPage(User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Kullanıcı Hesap Bilgileri");
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setVisible(true);
		setLocationRelativeTo(null);

		JPanel panelNorth = new JPanel();
		panelNorth.setPreferredSize(new Dimension(HEIGHT, 98));
		panelNorth.setLayout(new GroupLayout(panelNorth));
		Image imgIconNorth = new ImageIcon(this.getClass().getResource("/sahibindenLogo2.png")).getImage();
		panelNorth.setBackground(new Color(83, 85, 104));
		contentPane.add(panelNorth, BorderLayout.NORTH);

		JLabel lblIconNorth = new JLabel();
		lblIconNorth.setBounds(24, 35, 200, 40);
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
		lblNameSurname.setBounds(1680, 32, 200, 37);
		lblNameSurname.setForeground(SystemColor.window);
		lblNameSurname.setBorder(new LineBorder(Color.white));
		lblNameSurname.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 17));
		lblNameSurname.setHorizontalAlignment(SwingConstants.CENTER);
		panelNorth.add(lblNameSurname);

		JPanel panelWest = new JPanel();
		panelWest.setPreferredSize(new Dimension(297, WIDTH));
		panelWest.setBackground(new Color(83, 85, 104));
		contentPane.add(panelWest, BorderLayout.WEST);

		JLabel lblIlanYonetimi = new JLabel("Ilan Yönetimi");
		lblIlanYonetimi.setBounds(70, 43, 117, 22);
		lblIlanYonetimi.setForeground(SystemColor.window);
		lblIlanYonetimi.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 17));
		lblIlanYonetimi.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblHesapBilgileri = new JLabel("Hesap Bilgilerim");
		lblHesapBilgileri.setBounds(64, 82, 130, 22);
		lblHesapBilgileri.setForeground(SystemColor.window);
		lblHesapBilgileri.setHorizontalAlignment(SwingConstants.CENTER);
		lblHesapBilgileri.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 17));

		JLabel lblCikisYap = new JLabel("Çıkıs Yap");
		lblCikisYap.setBounds(85, 120, 80, 22);
		lblCikisYap.setForeground(SystemColor.window);
		lblCikisYap.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 17));
		lblCikisYap.setHorizontalAlignment(SwingConstants.CENTER);

		panelWest.setLayout(new GroupLayout(panelWest));
		panelWest.add(lblIlanYonetimi);
		panelWest.add(lblHesapBilgileri);
		panelWest.add(lblCikisYap);

		JPanel panelMain = new JPanel();
		panelMain.setLayout(new GroupLayout(panelMain));
		contentPane.add(panelMain, BorderLayout.CENTER);

		JLabel lblHesapBilgileriBaslik = new JLabel("Hesap Bilgileri");
		lblHesapBilgileriBaslik.setBounds(40, 40, 210, 30);
		lblHesapBilgileriBaslik.setFont(new Font("Elephant", Font.PLAIN, 24));
		lblHesapBilgileriBaslik.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblId = new JLabel("Id :");
		lblId.setBounds(55, 120, 50, 22);
		lblId.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 18));

		JLabel lblidInput = new JLabel(Integer.toString(user.getId()));
		lblidInput.setBounds(110, 120, 50, 22);
		lblidInput.setHorizontalAlignment(SwingConstants.RIGHT);
		lblidInput.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblidInput.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 17));

		JLabel lblName = new JLabel("Isim :");
		lblName.setBounds(55, 164, 50, 22);
		lblName.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 18));

		JLabel lblnameInput = new JLabel(user.getName());
		lblnameInput.setBounds(118, 163, 130, 22);
		lblnameInput.setHorizontalAlignment(SwingConstants.RIGHT);
		lblnameInput.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblnameInput.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 17));

		JLabel lblSurname = new JLabel("Soyisim :");
		lblSurname.setBounds(55, 208, 75, 22);
		lblSurname.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 18));

		JLabel lblsurnameInput = new JLabel(user.getSurname());
		lblsurnameInput.setBounds(142, 206, 100, 22);
		lblsurnameInput.setHorizontalAlignment(SwingConstants.RIGHT);
		lblsurnameInput.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblsurnameInput.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 17));

		JLabel lblAge = new JLabel("Yas : ");
		lblAge.setBounds(55, 250, 50, 22);
		lblAge.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 18));

		JLabel lblageInput = new JLabel(Integer.toString(user.getAge()));
		lblageInput.setBounds(117, 248, 50, 22);
		lblageInput.setHorizontalAlignment(SwingConstants.RIGHT);
		lblageInput.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblageInput.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 17));

		JLabel lblTelNumber = new JLabel("Tel No :");
		lblTelNumber.setBounds(55, 295, 65, 22);
		lblTelNumber.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 18));

		JLabel lbltelNoInput = new JLabel(user.getTelNumber());
		lbltelNoInput.setBounds(133, 293, 150, 22);
		lbltelNoInput.setHorizontalAlignment(SwingConstants.RIGHT);
		lbltelNoInput.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbltelNoInput.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 17));

		JLabel lblJob = new JLabel("Meslek :");
		lblJob.setBounds(55, 345, 70, 22);
		lblJob.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 18));

		JLabel lbljobInput = new JLabel(user.getJob());
		lbljobInput.setBounds(138, 344, 140, 22);
		lbljobInput.setHorizontalAlignment(SwingConstants.RIGHT);
		lbljobInput.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbljobInput.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 17));

		JLabel lblUserName = new JLabel("Kullanıcı adı : ");
		lblUserName.setBounds(55, 393, 140, 22);
		lblUserName.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 18));

		JLabel lbluserNameInput = new JLabel(user.getUserName());
		lbluserNameInput.setBounds(210, 391, 150, 22);
		lbluserNameInput.setHorizontalAlignment(SwingConstants.RIGHT);
		lbluserNameInput.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbluserNameInput.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 17));

		JLabel lblbutonHesabıSil = new JLabel("Hesabı Sil");
		lblbutonHesabıSil.setBounds(224, 450, 120, 38);
		lblbutonHesabıSil.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblbutonHesabıSil.setVerticalTextPosition(SwingConstants.CENTER);
		lblbutonHesabıSil.setHorizontalTextPosition(SwingConstants.CENTER);
		Image imgButonHesapSil = new ImageIcon(this.getClass().getResource("/butonHesabıSil.png")).getImage();
		lblbutonHesabıSil.setIcon(new ImageIcon(imgButonHesapSil));

		JLabel lblbutonBilgileriGuncelle = new JLabel("Bilgileri Güncelle");
		lblbutonBilgileriGuncelle.setBounds(90, 450, 120, 38);
		lblbutonBilgileriGuncelle.setHorizontalAlignment(SwingConstants.CENTER);
		lblbutonBilgileriGuncelle.setVerticalTextPosition(SwingConstants.CENTER);
		lblbutonBilgileriGuncelle.setHorizontalTextPosition(SwingConstants.CENTER);
		lblbutonBilgileriGuncelle.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Image imgButonBilgileriGuncelle = new ImageIcon(this.getClass().getResource("/butonBilgileriGuncelle.png")).getImage();
		lblbutonBilgileriGuncelle.setIcon(new ImageIcon(imgButonBilgileriGuncelle));

		panelMain.add(lblHesapBilgileriBaslik);
		panelMain.add(lblId);
		panelMain.add(lblidInput);
		panelMain.add(lblName);
		panelMain.add(lblnameInput);
		panelMain.add(lblSurname);
		panelMain.add(lblsurnameInput);
		panelMain.add(lblAge);
		panelMain.add(lblageInput);
		panelMain.add(lblTelNumber);
		panelMain.add(lbltelNoInput);
		panelMain.add(lblJob);
		panelMain.add(lbljobInput);
		panelMain.add(lblUserName);
		panelMain.add(lbluserNameInput);
		panelMain.add(lblbutonBilgileriGuncelle);
		panelMain.add(lblbutonHesabıSil);

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

		lblNameSurname.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblNameSurname.setText("<html><u>" + user.getName() + " " + user.getSurname() + "</u></html>");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				lblNameSurname.setText(user.getName() + " " + user.getSurname());
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				UserAccountPage uAP = new UserAccountPage(user);
			}
		});

		lblbutonBilgileriGuncelle.addMouseListener(new MouseAdapter() {
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
				panelMain.remove(lblnameInput);
				panelMain.remove(lblsurnameInput);
				panelMain.remove(lblageInput);
				panelMain.remove(lbljobInput);
				panelMain.remove(lbluserNameInput);
				panelMain.remove(lbltelNoInput);
				panelMain.remove(lblbutonHesabıSil);

				JTextField tfnameInput = new JTextField(lblnameInput.getText());
				tfnameInput.setBounds(118, 163, 130, 22);
				tfnameInput.setBorder(new LineBorder(Color.black));
				tfnameInput.setHorizontalAlignment(SwingConstants.RIGHT);

				JTextField tfsurnameInput = new JTextField(lblsurnameInput.getText());
				tfsurnameInput.setBounds(142, 206, 100, 22);
				tfsurnameInput.setBorder(new LineBorder(Color.black));
				tfsurnameInput.setHorizontalAlignment(SwingConstants.RIGHT);

				JTextField tfageInput = new JTextField(lblageInput.getText());
				tfageInput.setBounds(117, 248, 50, 22);
				tfageInput.setBorder(new LineBorder(Color.black));
				tfageInput.setHorizontalAlignment(SwingConstants.RIGHT);

				JTextField tftelNoInput = new JTextField(lbltelNoInput.getText());
				tftelNoInput.setBounds(133, 293, 150, 22);
				tftelNoInput.setBorder(new LineBorder(Color.black));
				tftelNoInput.setHorizontalAlignment(SwingConstants.RIGHT);

				JTextField tfjobInput = new JTextField(lbljobInput.getText());
				tfjobInput.setBounds(138, 344, 140, 22);
				tfjobInput.setBorder(new LineBorder(Color.black));
				tfjobInput.setHorizontalAlignment(SwingConstants.RIGHT);

				JTextField tfuserNameInput = new JTextField(lbluserNameInput.getText());
				tfuserNameInput.setBounds(210, 391, 150, 22);
				tfuserNameInput.setBorder(new LineBorder(Color.black));
				tfuserNameInput.setHorizontalAlignment(SwingConstants.RIGHT);

				JLabel lblbutonKaydet = new JLabel("Kaydet");
				lblbutonKaydet.setBounds(224, 450, 120, 38);
				lblbutonKaydet.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblbutonKaydet.setVerticalTextPosition(SwingConstants.CENTER);
				lblbutonKaydet.setHorizontalTextPosition(SwingConstants.CENTER);
				Image imgbutonKaydet = new ImageIcon(this.getClass().getResource("/butonKaydet.png")).getImage();
				lblbutonKaydet.setIcon(new ImageIcon(imgbutonKaydet));

				panelMain.add(tfnameInput);
				panelMain.add(tfsurnameInput);
				panelMain.add(tfageInput);
				panelMain.add(tftelNoInput);
				panelMain.add(tfjobInput);
				panelMain.add(tfuserNameInput);
				panelMain.add(lblbutonKaydet);

				panelMain.revalidate();
				panelMain.repaint();

				lblbutonKaydet.addMouseListener(new MouseAdapter() {
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

						String line;
						String strArray[];
						boolean found = false;
						try {
							fr = new FileReader("users.txt");
							br = new BufferedReader(fr);

							while ((line = br.readLine()) != null) {
								strArray = line.split(",");
								if (!lbluserNameInput.getText().trim().equals(tfuserNameInput.getText().trim())) {
									if (strArray[4].equals(tfuserNameInput.getText().trim())) {
										found = true;
										break;
									}
								}
							}
						} catch (IOException e1) {
							System.out.println("File reading unsuccessful");
						}finally {
							if (fr != null) {
								try {
									fr.close();
								} catch (Exception e3) {
									System.out.println(
											"Read operation successful however close operation unsuccessful...");
								}
							}
						}
						if (found) {
							tfuserNameInput.setBorder(new LineBorder(Color.red));
							JLabel lblErrorMessage = new JLabel("Bu kullanıcı adı bir baskasına ait!");
							lblErrorMessage.setForeground(Color.red);
							lblErrorMessage.setBounds(380, 392, 300, 22);
							lblErrorMessage.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 17));
							panelMain.add(lblErrorMessage);

							Timer timer = new Timer(1200, new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									lblErrorMessage.setVisible(false);
								}

							});
							timer.setRepeats(false);
							timer.start();
							contentPane.revalidate();
							contentPane.repaint();

						} else {
							panelMain.remove(tfnameInput);
							panelMain.remove(tfsurnameInput);
							panelMain.remove(tfageInput);
							panelMain.remove(tfjobInput);
							panelMain.remove(tfuserNameInput);
							panelMain.remove(tftelNoInput);
							panelMain.remove(lblbutonKaydet);

							try {
								fr = new FileReader("users.txt");
								br = new BufferedReader(fr);
								FileWriter fw = new FileWriter("copyUsers.txt");
								BufferedWriter bw = new BufferedWriter(fw);

								while ((line = br.readLine()) != null) {
									strArray = line.split(",");
									if (user.getId() == Integer.parseInt(strArray[0])) {
										strArray[1] = tfnameInput.getText().trim();
										strArray[2] = tfsurnameInput.getText().trim();
										strArray[3] = tfageInput.getText().trim();
										strArray[4] = tfuserNameInput.getText().trim();

										if (!tftelNoInput.getText().equals("") || !tfjobInput.getText().equals("")) {
											if (tftelNoInput.getText().equals("")) {
												line = user.getId() + "," + strArray[1] + "," + strArray[2] + ","
														+ strArray[3] + "," + strArray[4] + "," + user.getPassword()
														+ "," + user.getSecurityQuestion() + "," + user.getAnswer()
														+ "," + "null" + "," + tfjobInput.getText().trim();
											} else if (tfjobInput.getText().equals(""))  {
												line = user.getId() + "," + strArray[1] + "," + strArray[2] + ","
														+ strArray[3] + "," + strArray[4] + "," + user.getPassword()
														+ "," + user.getSecurityQuestion() + "," + user.getAnswer()
														+ "," + tftelNoInput.getText().trim() + "," + "null";
											}else {
												line = user.getId() + "," + strArray[1] + "," + strArray[2] + ","
														+ strArray[3] + "," + strArray[4] + "," + user.getPassword()
														+ "," + user.getSecurityQuestion() + "," + user.getAnswer()
														+ "," + tftelNoInput.getText().trim() + "," + tfjobInput.getText().trim();
											}
										} else {
											line = user.getId() + "," + strArray[1] + "," + strArray[2] + ","
													+ strArray[3] + "," + strArray[4] + "," + user.getPassword() + ","
													+ user.getSecurityQuestion() + "," + user.getAnswer();
										}
										user.setName(tfnameInput.getText().trim());
										user.setSurname(tfsurnameInput.getText().trim());
										user.setAge(Integer.parseInt(tfageInput.getText().trim()));
										user.setUserName(tfuserNameInput.getText());
										user.setTelNumber(tftelNoInput.getText().trim());
										user.setJob(tfjobInput.getText().trim());
									}
									bw.write(line);
									bw.newLine();
								}
								try {
									bw.close();
								} catch (Exception e2) {
									System.out.println(
											"Write operation successful however close operation unsuccessful...");
								}
							} catch (IOException e1) {
								System.out.println("File reading unsuccessful");
							} finally {
								if (fr != null) {
									try {
										fr.close();
									} catch (Exception e3) {
										System.out.println(
												"Read operation successful however close operation unsuccessful...");
									}
								}
							}

							lblnameInput.setText(tfnameInput.getText());
							lblsurnameInput.setText(tfsurnameInput.getText());
							lblageInput.setText(tfageInput.getText());
							lbljobInput.setText(tfjobInput.getText());
							lbluserNameInput.setText(tfuserNameInput.getText());
							lbltelNoInput.setText(tftelNoInput.getText());

							panelMain.add(lblnameInput);
							panelMain.add(lblsurnameInput);
							panelMain.add(lblageInput);
							panelMain.add(lbltelNoInput);
							panelMain.add(lbljobInput);
							panelMain.add(lbluserNameInput);
							panelMain.add(lblbutonHesabıSil);

							contentPane.revalidate();
							contentPane.repaint();
						}
						
						
						try {
							fr = new FileReader("copyUsers.txt");
							br = new BufferedReader(fr);
							fw = new FileWriter("users.txt");
							bw = new BufferedWriter(fw);	
							
							while ((line = br.readLine()) != null) {
								bw.write(line);
								bw.newLine();
							}
							
						} catch (Exception e1) {
							e1.printStackTrace();
						}finally {
							try {
								fr.close();
								bw.close();
							} catch (Exception e2) {
								e2.printStackTrace();
							}
						}
					}
					
				});

			}
		});

		lblbutonHesabıSil.addMouseListener(new MouseAdapter() {
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
				int result = JOptionPane.showConfirmDialog(contentPane, "Hesabı silmek istediğinize emin misiniz?","Onay",JOptionPane.YES_NO_OPTION);
			
				if (result == JOptionPane.YES_OPTION) {
					setVisible(false);
					ArrayList<String> lines = new ArrayList<String>();
					String[] lineArray;
					
					try {
						String line;
						
						fr = new FileReader("users.txt");
						br = new BufferedReader(fr);
						
						while ((line = br.readLine()) != null) {
							lineArray = line.split(",");
							if (user.getId()!= Integer.parseInt(lineArray[0])) {
								lines.add(line);
							}
						}
						
					} catch (IOException e1) {
						System.out.println("File reading unsuccessful");
					}finally {
						try {
							fr.close();
						} catch (IOException e1) {
							System.out.println("File closing unsuccessful");
						}
					}
					
					try {
						fw = new FileWriter("users.txt");
						bw = new BufferedWriter(fw);
						
						for (String line : lines) {
							bw.write(line);
							bw.newLine();
						}
						
					} catch (IOException e1) {
						System.out.println("File writing unsuccessful");
					}finally {
						try {
							bw.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					
				}
			}
			
		});

	}
}
