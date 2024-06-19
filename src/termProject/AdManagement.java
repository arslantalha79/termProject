package termProject;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.beans.beancontext.BeanContext;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.PublicKey;
import java.text.Bidi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.imgscalr.Scalr;

public class AdManagement extends JFrame {
	private JPanel contentPane;
	private CardLayout cardLayout;
	private String line;
	private String[] strArray;
	private FileReader fr;
	private BufferedReader br;
	private FileWriter fw;
	private BufferedWriter bw;
	private Advert advert;
	private int advertId;

	public AdManagement(User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ilan Yonetimi");
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

		JLabel lblIlanYonetimiBaslik = new JLabel("Ilan Yonetimi");
		lblIlanYonetimiBaslik.setBounds(40, 40, 210, 30);
		lblIlanYonetimiBaslik.setFont(new Font("Elephant", Font.PLAIN, 24));
		lblIlanYonetimiBaslik.setHorizontalAlignment(SwingConstants.CENTER);
		panelMain.add(lblIlanYonetimiBaslik);

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(600, 1500));
		panel.setLayout(new FlowLayout(SwingConstants.CENTER, 2, 2));
		panel.setBorder(new LineBorder(Color.black));
		panel.setBounds(65, 100, 600, 1500);

		JLabel lblIlanEkle = new JLabel("Ilan Ekle");
		lblIlanEkle.setBounds(545, 535, 120, 38);
		lblIlanEkle.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIlanEkle.setHorizontalAlignment(SwingConstants.CENTER);
		lblIlanEkle.setVerticalTextPosition(SwingConstants.CENTER);
		lblIlanEkle.setHorizontalTextPosition(SwingConstants.CENTER);
		Image imgIlanEkle = new ImageIcon(this.getClass().getResource("/butonilanEkle.png")).getImage();
		lblIlanEkle.setIcon(new ImageIcon(imgIlanEkle));
		panelMain.add(lblIlanEkle);

		JLabel lblIlanSil = new JLabel("Ilan Sil");
		lblIlanSil.setBounds(545, 580, 120, 38);
		lblIlanSil.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIlanSil.setHorizontalAlignment(SwingConstants.CENTER);
		lblIlanSil.setVerticalTextPosition(SwingConstants.CENTER);
		lblIlanSil.setHorizontalTextPosition(SwingConstants.CENTER);
		Image imgIlanSil = new ImageIcon(this.getClass().getResource("/butonilanSil.png")).getImage();
		lblIlanSil.setIcon(new ImageIcon(imgIlanSil));
		panelMain.add(lblIlanSil);

		JScrollPane sPane = new JScrollPane(panel);
		sPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sPane.setPreferredSize(new Dimension(600, 400));
		sPane.setBounds(65, 100, 600, 400);
		panelMain.add(sPane);

		lblHesapBilgileri.addMouseListener(new MouseAdapter() {
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

			@Override
			public void mouseClicked(MouseEvent e) {
				AccInformationPage accInformationPage = new AccInformationPage(user);
				setVisible(false);
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

		lblIlanEkle.addMouseListener(new MouseAdapter() {
			String advertImagePath;

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

				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				panelMain.removeAll();

				JLabel lblIlanEkleBaslik = new JLabel("Ilan Ekleme");
				lblIlanEkleBaslik.setBounds(60, 43, 170, 30);
				lblIlanEkleBaslik.setFont(new Font("Elephant", Font.PLAIN, 24));
				lblIlanEkleBaslik.setHorizontalAlignment(SwingConstants.CENTER);
				panelMain.add(lblIlanEkleBaslik);

				JLabel lblIlanBaslik = new JLabel("Ilan Baslık :");
				lblIlanBaslik.setBounds(70, 110, 150, 24);
				lblIlanBaslik.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
				lblIlanBaslik.setHorizontalAlignment(SwingConstants.LEFT);
				panelMain.add(lblIlanBaslik);

				JTextField tfIlanBaslik = new JTextField("");
				tfIlanBaslik.setBounds(220, 110, 150, 24);
				tfIlanBaslik.setFont(new Font("Tahoma", Font.PLAIN, 20));
				tfIlanBaslik.setHorizontalAlignment(SwingConstants.RIGHT);
				panelMain.add(tfIlanBaslik);

				JLabel lblCategory = new JLabel("Kategori :");
				lblCategory.setBounds(70, 150, 100, 24);
				lblCategory.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
				lblCategory.setHorizontalAlignment(SwingConstants.LEFT);
				panelMain.add(lblCategory);

				JComboBox cbCategories = new JComboBox();
				cbCategories.setModel(new DefaultComboBoxModel(
						new String[] { "Otomobil", "Arazi,SUV&Pickup", "Elektrikli Araçlar" }));
				cbCategories.setBounds(220, 150, 150, 24);
				panelMain.add(cbCategories);

				JLabel lblVehicleTable = new JLabel("Arac Plakası : ");
				lblVehicleTable.setBounds(70, 192, 150, 24);
				lblVehicleTable.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
				lblVehicleTable.setHorizontalAlignment(SwingConstants.LEFT);
				panelMain.add(lblVehicleTable);

				JTextField tfVehicleTable = new JTextField("");
				tfVehicleTable.setFont(new Font("Tahoma", Font.PLAIN, 20));
				tfVehicleTable.setBounds(220, 192, 150, 24);
				tfVehicleTable.setHorizontalAlignment(SwingConstants.RIGHT);
				panelMain.add(tfVehicleTable);

				JLabel lblVTableMessage = new JLabel(
						"(Plaka karakterleri arasında boşluk bırakmayınız. Örn : 34EP9466)");
				lblVTableMessage.setBounds(386, 194, 330, 20);
				lblVTableMessage.setFont(new Font("Tahoma", Font.PLAIN, 11));
				panelMain.add(lblVTableMessage);

				JLabel lblBrandName = new JLabel("Marka : ");
				lblBrandName.setBounds(70, 235, 90, 24);
				lblBrandName.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
				lblBrandName.setHorizontalAlignment(SwingConstants.LEFT);
				panelMain.add(lblBrandName);

				JTextField tfBrandName = new JTextField("");
				tfBrandName.setFont(new Font("Tahoma", Font.PLAIN, 20));
				tfBrandName.setBounds(220, 235, 150, 24);
				tfBrandName.setHorizontalAlignment(SwingConstants.RIGHT);
				panelMain.add(tfBrandName);

				JLabel lblModelName = new JLabel("Model : ");
				lblModelName.setBounds(70, 275, 90, 24);
				lblModelName.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
				lblModelName.setHorizontalAlignment(SwingConstants.LEFT);
				panelMain.add(lblModelName);

				JTextField tfModelName = new JTextField("");
				tfModelName.setBounds(220, 275, 150, 24);
				tfModelName.setFont(new Font("Tahoma", Font.PLAIN, 20));
				tfModelName.setHorizontalAlignment(SwingConstants.RIGHT);
				panelMain.add(tfModelName);

				JLabel lblModelYear = new JLabel("Model Yılı :");
				lblModelYear.setBounds(70, 318, 130, 24);
				lblModelYear.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
				lblModelYear.setHorizontalAlignment(SwingConstants.LEFT);
				panelMain.add(lblModelYear);

				JTextField tfModelYear = new JTextField("");
				tfModelYear.setFont(new Font("Tahoma", Font.PLAIN, 20));
				tfModelYear.setBounds(220, 318, 150, 24);
				tfModelYear.setHorizontalAlignment(SwingConstants.RIGHT);
				panelMain.add(tfModelYear);

				JLabel lblMileage = new JLabel("Kilometre : ");
				lblMileage.setBounds(70, 355, 130, 24);
				lblMileage.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
				lblMileage.setHorizontalAlignment(SwingConstants.LEFT);
				panelMain.add(lblMileage);

				JTextField tfMileage = new JTextField("");
				tfMileage.setBounds(220, 355, 150, 24);
				tfMileage.setFont(new Font("Tahoma", Font.PLAIN, 20));
				tfMileage.setHorizontalAlignment(SwingConstants.RIGHT);
				panelMain.add(tfMileage);

				JLabel lblColor = new JLabel("Renk : ");
				lblColor.setBounds(70, 397, 60, 24);
				lblColor.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
				lblColor.setHorizontalAlignment(SwingConstants.LEFT);
				panelMain.add(lblColor);

				JComboBox cbColors = new JComboBox();
				cbColors.setModel(new DefaultComboBoxModel(
						new String[] { "Beyaz", "Bej", "Bordo", "Füme", "Gri", "Kahverengi", "Kırmızı", "Lacivert",
								"Mavi", "Mor", "Sarı", "Siyah", "Turkuaz", "Turuncu", "Yesil" }));
				cbColors.setBounds(220, 395, 150, 24);
				panelMain.add(cbColors);

				JLabel lblGear = new JLabel("Vites : ");
				lblGear.setBounds(70, 441, 60, 24);
				lblGear.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
				lblGear.setHorizontalAlignment(SwingConstants.LEFT);
				panelMain.add(lblGear);

				JPanel panelGearTypes = new JPanel();
				panelGearTypes.setBounds(130, 440, 350, 24);
				panelGearTypes.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
				panelMain.add(panelGearTypes);

				JRadioButton rbManuel = new JRadioButton("Manuel");
				panelGearTypes.add(rbManuel);

				JRadioButton rbAutomatic = new JRadioButton("Otomatik");
				panelGearTypes.add(rbAutomatic);

				JRadioButton rbSemiautomatic = new JRadioButton("Yarı-otomatik");
				panelGearTypes.add(rbSemiautomatic);

				ButtonGroup bg = new ButtonGroup();
				bg.add(rbSemiautomatic);
				bg.add(rbAutomatic);
				bg.add(rbManuel);

				JLabel lblMotorPower = new JLabel("Motor Gücü :");
				lblMotorPower.setBounds(70, 485, 130, 24);
				lblMotorPower.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
				lblMotorPower.setHorizontalAlignment(SwingConstants.LEFT);
				panelMain.add(lblMotorPower);

				JTextField tfMotorPower = new JTextField();
				tfMotorPower.setBounds(220, 485, 150, 24);
				tfMotorPower.setFont(new Font("Tahoma", Font.PLAIN, 20));
				tfMotorPower.setHorizontalAlignment(SwingConstants.RIGHT);
				panelMain.add(tfMotorPower);

				JLabel lblAdvertImagePath = new JLabel("Arac Resmi : ");
				lblAdvertImagePath.setBounds(70, 532, 120, 24);
				lblAdvertImagePath.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
				lblAdvertImagePath.setHorizontalAlignment(SwingConstants.LEFT);
				panelMain.add(lblAdvertImagePath);

				JLabel lblAdvertImageIcon = new JLabel("");
				lblAdvertImageIcon.setBounds(258, 513, 90, 90);
				Image imgAdvertImageIcon = new ImageIcon(this.getClass().getResource("/ilanResimEkle.png")).getImage();
				lblAdvertImageIcon.setIcon(new ImageIcon(imgAdvertImageIcon));
				panelMain.add(lblAdvertImageIcon);

				JLabel lblPrice = new JLabel("Fiyat :");
				lblPrice.setBounds(70, 610, 130, 24);
				lblPrice.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
				lblPrice.setHorizontalAlignment(SwingConstants.LEFT);
				panelMain.add(lblPrice);

				JTextField tfPrice = new JTextField();
				tfPrice.setBounds(220, 610, 150, 24);
				tfPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
				tfPrice.setHorizontalAlignment(SwingConstants.RIGHT);
				panelMain.add(tfPrice);

				JLabel lblIlanEkle2 = new JLabel("Ilan Ekle");
				lblIlanEkle2.setBounds(162, 700, 120, 38);
				lblIlanEkle2.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblIlanEkle2.setHorizontalAlignment(SwingConstants.CENTER);
				lblIlanEkle2.setVerticalTextPosition(SwingConstants.CENTER);
				lblIlanEkle2.setHorizontalTextPosition(SwingConstants.CENTER);
				Image imgIlanEkle2 = new ImageIcon(this.getClass().getResource("/butonilanEkle.png")).getImage();
				lblIlanEkle2.setIcon(new ImageIcon(imgIlanEkle2));
				panelMain.add(lblIlanEkle2);

				panelMain.revalidate();
				panelMain.repaint();

				lblAdvertImageIcon.addMouseListener(new MouseAdapter() {
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
						setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
						JFileChooser fileChooser = new JFileChooser();
						fileChooser.setCurrentDirectory(new File(System.getProperty("user.home") + "/Pictures"));
						fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
						int result = fileChooser.showOpenDialog(null);

						if (result == JFileChooser.APPROVE_OPTION) {
							File selectedFile = fileChooser.getSelectedFile();
							JOptionPane.showMessageDialog(null, "Resim eklendi!");
							advertImagePath = new String();
							advertImagePath = selectedFile.getAbsolutePath().replace("\\", "/");
						}
					}
				});

				lblIlanEkle2.addMouseListener(new MouseAdapter() {
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
						setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
						boolean found = false;

						try {
							fr = new FileReader("adverts.txt");
							br = new BufferedReader(fr);

							while ((line = br.readLine()) != null) {
								strArray = line.split(",");
								if (strArray[4].equals(tfVehicleTable.getText().trim())) {
									found = true;
									break;
								}

							}
							fr.close();
						} catch (Exception e2) {
							System.out.println("File reading unsuccessful");
						}

						if (found == false) {
							Random rand = new Random();
							advertId = rand.nextInt(1000);

							try {
								fr = new FileReader("adverts.txt");
								br = new BufferedReader(fr);
								while ((line = br.readLine()) != null) {
									strArray = line.split(",");
									if (Integer.parseInt(strArray[0]) == advertId) {
										advertId = rand.nextInt();
									}
								}
							} catch (Exception e2) {
								System.out.println("File reading unsuccessful");
							} finally {
								try {
									fr.close();
								} catch (IOException e1) {
									System.out.println("File closing unsuccessful");
								}
							}

							String selectedValueOfGearType = new String();
							if (rbAutomatic.isSelected()) {
								selectedValueOfGearType = "Otomatik";
							}
							if (rbManuel.isSelected()) {
								selectedValueOfGearType = "Manuel";
							}
							if (rbSemiautomatic.isSelected()) {
								selectedValueOfGearType = "Yarı otomatik";
							}

							String category = cbCategories.getSelectedItem().toString();
							category = category.replace(",", "&");

							advert = new Advert(advertId, user.getId(), tfIlanBaslik.getText().trim(), category,
									tfVehicleTable.getText().trim(), tfBrandName.getText().trim(),
									tfModelName.getText().trim(), Integer.parseInt(tfModelYear.getText().trim()),
									Integer.parseInt(tfMileage.getText().trim()), cbColors.getSelectedItem().toString(),
									selectedValueOfGearType, Integer.parseInt(tfMotorPower.getText().trim()),
									advertImagePath, Integer.parseInt(tfPrice.getText().trim()));

							try {
								fw = new FileWriter("adverts.txt", true);
								bw = new BufferedWriter(fw);

								String line2 = advertId + "," + user.getId() + "," + tfIlanBaslik.getText().trim() + ","
										+ category + "," + tfVehicleTable.getText().trim() + ","
										+ tfBrandName.getText().trim() + "," + tfModelName.getText().trim() + ","
										+ Integer.parseInt(tfModelYear.getText().trim()) + ","
										+ Integer.parseInt(tfMileage.getText().trim()) + ","
										+ cbColors.getSelectedItem().toString() + "," + selectedValueOfGearType + ","
										+ Integer.parseInt(tfMotorPower.getText().trim()) + ","
										+ Integer.parseInt(tfPrice.getText().trim()) + "," + advertImagePath;
								bw.write(line2);
								bw.newLine();
								bw.close();

							} catch (IOException e1) {
								System.out.println("File not found!");
							}

							JOptionPane.showMessageDialog(null, "İlan eklendi!");
						} else {
							JLabel lblErrorMessage = new JLabel('"' + tfVehicleTable.getText().trim() + '"'
									+ " plakalı araç sistemde zaten mevcut!");
							lblErrorMessage.setBounds(30, 660, 390, 22);
							lblErrorMessage.setFont(new Font("Tahoma", Font.PLAIN, 17));
							lblErrorMessage.setForeground(Color.red);
							lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
							panelMain.add(lblErrorMessage);

							Timer timer = new Timer(800, new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									lblErrorMessage.setVisible(false);

								}
							});
							timer.setRepeats(false);
							timer.start();
							panelMain.revalidate();
							panelMain.repaint();
						}
					}
				});
			}
		});

		try {
			fr = new FileReader("adverts.txt");
			br = new BufferedReader(fr);

			while ((line = br.readLine()) != null) {
				strArray = line.split(",");
				if (strArray[1].equals(Integer.toString(user.getId()))) {
					JLabel lblAdvert = new JLabel(strArray[2]);
					lblAdvert.setLayout(new GroupLayout(lblAdvert));
					lblAdvert.setPreferredSize(new Dimension(575, 80));
					lblAdvert.setHorizontalAlignment(SwingConstants.CENTER);
					lblAdvert.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 26));
					lblAdvert.setBorder(new LineBorder(Color.black));

					JLabel imgAdvert = new JLabel("");
					imgAdvert.setBounds(10, 10, 120, 60);

					String imgAdvertPath = strArray[13];
					File imgAdvertFile = new File(imgAdvertPath);
					if (imgAdvertFile.exists()) {
						Image imgAdvertIcon = new ImageIcon(imgAdvertPath).getImage();
						imgAdvert.setIcon(new ImageIcon(imgAdvertIcon));
					} else {
						System.out.println("Image file not found : " + imgAdvertPath);
					}
					lblAdvert.add(imgAdvert);
					panel.add(lblAdvert);

					lblAdvert.addMouseListener(new MouseAdapter() {
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
							setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
							panelMain.removeAll();
							JLabel lblComeBackIcon = new JLabel("");
							Image imgComeBack = new ImageIcon(this.getClass().getResource("/comeBackIcon.png"))
									.getImage();
							lblComeBackIcon.setIcon(new ImageIcon(imgComeBack));
							lblComeBackIcon.setBounds(20, 12, 35, 35);
							panelMain.add(lblComeBackIcon);

							JLabel lblAdvertImage = new JLabel("");
							lblAdvertImage.setHorizontalAlignment(SwingConstants.CENTER);
							lblAdvertImage.setBounds(555, 120, 400, 280);
							panelMain.add(lblAdvertImage);

							JLabel advertPrice = new JLabel();
							advertPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
							advertPrice.setForeground(Color.red);
							advertPrice.setHorizontalAlignment(SwingConstants.CENTER);
							advertPrice.setBounds(685, 410, 130, 24);
							panelMain.add(advertPrice);

							JLabel advertTitle = new JLabel();
							advertTitle.setFont(new Font("Elephant", Font.PLAIN, 26));
							advertTitle.setHorizontalAlignment(SwingConstants.CENTER);
							advertTitle.setBounds(605, 450, 300, 30);
							panelMain.add(advertTitle);

							JLabel lblAdvertId = new JLabel("Ilan Id :");
							lblAdvertId.setBounds(230, 520, 90, 24);
							lblAdvertId.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
							lblAdvertId.setHorizontalAlignment(SwingConstants.LEFT);
							panelMain.add(lblAdvertId);

							JLabel advertId = new JLabel();
							advertId.setBounds(400, 520, 150, 24);
							advertId.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
							advertId.setHorizontalAlignment(SwingConstants.LEFT);
							advertId.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
							panelMain.add(advertId);

							JLabel lblAdvertCategory = new JLabel("Kategori : ");
							lblAdvertCategory.setBounds(230, 610, 100, 24);
							lblAdvertCategory.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
							lblAdvertCategory.setHorizontalAlignment(SwingConstants.LEFT);
							panelMain.add(lblAdvertCategory);

							JLabel advertCategory = new JLabel();
							advertCategory.setBounds(400, 610, 150, 24);
							advertCategory.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
							advertCategory.setHorizontalAlignment(SwingConstants.LEFT);
							advertCategory.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
							panelMain.add(advertCategory);

							JLabel lblAdvertVTable = new JLabel("Araç Plakası : ");
							lblAdvertVTable.setBounds(230, 690, 140, 24);
							lblAdvertVTable.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
							lblAdvertVTable.setHorizontalAlignment(SwingConstants.LEFT);
							panelMain.add(lblAdvertVTable);

							JLabel advertVTable = new JLabel();
							advertVTable.setBounds(400, 690, 150, 24);
							advertVTable.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
							advertVTable.setHorizontalAlignment(SwingConstants.LEFT);
							advertVTable.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
							panelMain.add(advertVTable);

							JLabel lblAdvertMotorPower = new JLabel("Motor Gücü : ");
							lblAdvertMotorPower.setBounds(230, 770, 140, 24);
							lblAdvertMotorPower.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
							lblAdvertMotorPower.setHorizontalAlignment(SwingConstants.LEFT);
							panelMain.add(lblAdvertMotorPower);

							JLabel advertMotorPower = new JLabel();
							advertMotorPower.setBounds(400, 770, 150, 24);
							advertMotorPower.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
							advertMotorPower.setHorizontalAlignment(SwingConstants.LEFT);
							advertMotorPower.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
							panelMain.add(advertMotorPower);

							JLabel lblAdvertBrand = new JLabel("Marka :");
							lblAdvertBrand.setBounds(620, 520, 90, 24);
							lblAdvertBrand.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
							lblAdvertBrand.setHorizontalAlignment(SwingConstants.LEFT);
							panelMain.add(lblAdvertBrand);

							JLabel advertBrand = new JLabel();
							advertBrand.setBounds(780, 520, 130, 24);
							advertBrand.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
							advertBrand.setHorizontalAlignment(SwingConstants.LEFT);
							advertBrand.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
							panelMain.add(advertBrand);

							JLabel lblAdvertModel = new JLabel("Model : ");
							lblAdvertModel.setBounds(620, 610, 100, 24);
							lblAdvertModel.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
							lblAdvertModel.setHorizontalAlignment(SwingConstants.LEFT);
							panelMain.add(lblAdvertModel);

							JLabel advertModel = new JLabel();
							advertModel.setBounds(780, 610, 130, 24);
							advertModel.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
							advertModel.setHorizontalAlignment(SwingConstants.LEFT);
							advertModel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
							panelMain.add(advertModel);

							JLabel lblAdvertModelYear = new JLabel("Model Yılı : ");
							lblAdvertModelYear.setBounds(620, 690, 120, 24);
							lblAdvertModelYear.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
							lblAdvertModelYear.setHorizontalAlignment(SwingConstants.LEFT);
							panelMain.add(lblAdvertModelYear);

							JLabel advertModelYear = new JLabel();
							advertModelYear.setBounds(780, 690, 130, 24);
							advertModelYear.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
							advertModelYear.setHorizontalAlignment(SwingConstants.LEFT);
							advertModelYear.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
							panelMain.add(advertModelYear);

							JLabel lblAdvertMileage = new JLabel("Kilometre :");
							lblAdvertMileage.setBounds(980, 520, 100, 24);
							lblAdvertMileage.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
							lblAdvertMileage.setHorizontalAlignment(SwingConstants.LEFT);
							panelMain.add(lblAdvertMileage);

							JLabel advertMileage = new JLabel();
							advertMileage.setBounds(1100, 520, 130, 24);
							advertMileage.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
							advertMileage.setHorizontalAlignment(SwingConstants.LEFT);
							advertMileage.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
							panelMain.add(advertMileage);

							JLabel lblAdvertColor = new JLabel("Renk : ");
							lblAdvertColor.setBounds(980, 610, 70, 24);
							lblAdvertColor.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
							lblAdvertColor.setHorizontalAlignment(SwingConstants.LEFT);
							panelMain.add(lblAdvertColor);

							JLabel advertColor = new JLabel();
							advertColor.setBounds(1100, 610, 130, 24);
							advertColor.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
							advertColor.setHorizontalAlignment(SwingConstants.LEFT);
							advertColor.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
							panelMain.add(advertColor);

							JLabel lblAdvertGear = new JLabel("Vites : ");
							lblAdvertGear.setBounds(980, 690, 70, 24);
							lblAdvertGear.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
							lblAdvertGear.setHorizontalAlignment(SwingConstants.LEFT);
							panelMain.add(lblAdvertGear);

							JLabel advertGear = new JLabel();
							advertGear.setBounds(1100, 690, 130, 24);
							advertGear.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
							advertGear.setHorizontalAlignment(SwingConstants.LEFT);
							advertGear.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
							panelMain.add(advertGear);

							try {
								fr = new FileReader("adverts.txt");
								br = new BufferedReader(fr);

								while ((line = br.readLine()) != null) {
									strArray = line.split(",");
									if (strArray[2].equals(lblAdvert.getText().trim())) {
										advertId.setText(strArray[0]);
										advertTitle.setText(strArray[2]);
										advertCategory.setText(strArray[3]);
										advertVTable.setText(strArray[4]);
										advertBrand.setText(strArray[5]);
										advertModel.setText(strArray[6]);
										advertModelYear.setText(strArray[7]);
										advertMileage.setText(strArray[8]);
										advertColor.setText(strArray[9]);
										advertGear.setText(strArray[10]);
										advertMotorPower.setText(strArray[11]);
										advertPrice.setText(strArray[12] + " TL");

										advertId.setHorizontalAlignment(SwingConstants.RIGHT);
										advertCategory.setHorizontalAlignment(SwingConstants.RIGHT);
										advertVTable.setHorizontalAlignment(SwingConstants.RIGHT);
										advertMotorPower.setHorizontalAlignment(SwingConstants.RIGHT);
										advertBrand.setHorizontalAlignment(SwingConstants.RIGHT);
										advertModel.setHorizontalAlignment(SwingConstants.RIGHT);
										advertModelYear.setHorizontalAlignment(SwingConstants.RIGHT);
										advertMileage.setHorizontalAlignment(SwingConstants.RIGHT);
										advertColor.setHorizontalAlignment(SwingConstants.RIGHT);
										advertGear.setHorizontalAlignment(SwingConstants.RIGHT);

										BufferedImage resizedImage = resizeImage(ImageIO.read(new File(strArray[13])),
												380, 214);
										ImageIcon imageIcon = new ImageIcon(resizedImage);
										lblAdvertImage.setIcon(imageIcon);
									}
								}
							} catch (Exception e2) {
								System.out.println("File reading unsuccessful");
							}
							panelMain.revalidate();
							panelMain.repaint();

							lblComeBackIcon.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent e) {
									panelMain.removeAll();
									panelMain.add(lblIlanYonetimiBaslik);
									panelMain.add(sPane);
									panelMain.add(lblIlanEkle);
									panelMain.add(lblIlanSil);
									panelMain.revalidate();
									panelMain.repaint();
								}
							});
						}
					});
				}
			}
		} catch (IOException e1) {
			System.out.println("File reading unsuccessful");
		}

		lblIlanSil.addMouseListener(new MouseAdapter() {
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
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				panelMain.removeAll();

				JLabel lblIlanSilBaslik = new JLabel("Ilanı Silme");
				lblIlanSilBaslik.setBounds(60, 43, 170, 30);
				lblIlanSilBaslik.setFont(new Font("Elephant", Font.PLAIN, 24));
				lblIlanSilBaslik.setHorizontalAlignment(SwingConstants.CENTER);
				panelMain.add(lblIlanSilBaslik);

				JTextField txVehicleTable = new JTextField("Arac plakasını giriniz");
				txVehicleTable.setFont(new Font("Tahoma", Font.PLAIN, 24));
				txVehicleTable.setOpaque(true);
				txVehicleTable.setBounds(80, 120, 250, 38);
				txVehicleTable.setHorizontalAlignment(SwingConstants.CENTER);
				panelMain.add(txVehicleTable);

				JLabel lblVTableMessage = new JLabel(
						"(Plaka karakterleri arasında boşluk bırakmayınız. Örn : 34EP9466)");
				lblVTableMessage.setBounds(50, 175, 330, 20);
				lblVTableMessage.setFont(new Font("Tahoma", Font.PLAIN, 11));
				panelMain.add(lblVTableMessage);

				JLabel lblIlanSil2 = new JLabel("Ilan Sil");
				lblIlanSil2.setBounds(370, 120, 120, 38);
				lblIlanSil2.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblIlanSil2.setHorizontalAlignment(SwingConstants.CENTER);
				lblIlanSil2.setVerticalTextPosition(SwingConstants.CENTER);
				lblIlanSil2.setHorizontalTextPosition(SwingConstants.CENTER);
				Image imgIlanSil = new ImageIcon(this.getClass().getResource("/butonilanSil.png")).getImage();
				lblIlanSil2.setIcon(new ImageIcon(imgIlanSil));
				panelMain.add(lblIlanSil2);
				panelMain.revalidate();
				panelMain.repaint();

				lblIlanSil2.addMouseListener(new MouseAdapter() {
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
						boolean found = false;
						try {
							fr = new FileReader("adverts.txt");
							br = new BufferedReader(fr);
							while ((line = br.readLine()) != null) {
								strArray = line.split(",");
								if (strArray[1].equals(Integer.toString(user.getId()))
										&& strArray[4].equals(txVehicleTable.getText().trim())) {
									found = true;
									break;
								}
							}
						} catch (Exception e1) {
							System.out.println("File reading unsuccessful");
						} finally {
							try {
								fr.close();
							} catch (Exception e2) {
								System.out.println("File closing unsuccessful");
							}
						}

						if (found) {
							txVehicleTable.setBorder(new LineBorder(Color.black));
							try {
								fr = new FileReader("adverts.txt");
								br = new BufferedReader(fr);
								fw = new FileWriter("copyAdverts.txt");
								bw = new BufferedWriter(fw);
								while ((line = br.readLine()) != null) {
									strArray = line.split(",");
									if (!strArray[4].equals(txVehicleTable.getText().trim())) {
										bw.write(line);
										bw.newLine();
									}
								}
							} catch (Exception e1) {
								System.out.println("File reading unsuccessful");
							} finally {
								try {
									fr.close();
									bw.close();
								} catch (Exception e2) {
									System.out.println("File closing unsuccessful");
								}
							}
							JOptionPane.showMessageDialog(null, "Ilan silindi!");
						} else {
							txVehicleTable.setBorder(new LineBorder(Color.red));
							JLabel lblNotFoundVTableMessage = new JLabel("Bu plaka sistemde mevcut değildir!");
							lblNotFoundVTableMessage.setBounds(510, 130, 330, 20);
							lblNotFoundVTableMessage.setForeground(Color.red);
							lblNotFoundVTableMessage.setFont(new Font("Tahoma", Font.PLAIN, 17));
							panelMain.add(lblNotFoundVTableMessage);

							Timer timer = new Timer(800, new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									lblNotFoundVTableMessage.setVisible(false);
								}
							});
							timer.setRepeats(false);
							timer.start();
						}
						try {
							fr = new FileReader("copyAdverts.txt");
							br = new BufferedReader(fr);
							fw = new FileWriter("adverts.txt");
							bw = new BufferedWriter(fw);

							while ((line = br.readLine()) != null) {
								bw.write(line);
								bw.newLine();
							}
						} catch (Exception e2) {
							System.out.println("File reading unsuccessful");
						} finally {
							try {
								fr.close();
								bw.close();
							} catch (Exception e3) {
								System.out.println("File Proccess Error");
							}
						}
						panelMain.revalidate();
						panelMain.repaint();
					}
				});

			}
		});

	}

	public static BufferedImage resizeImage(BufferedImage originalImage, int width, int height) {
		return Scalr.resize(originalImage, Scalr.Method.QUALITY, Scalr.Mode.AUTOMATIC, width, height);
	}
}
