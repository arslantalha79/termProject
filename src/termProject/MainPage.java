package termProject;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.channels.NonWritableChannelException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.imgscalr.Scalr;

public class MainPage extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private FileReader fr;
	private BufferedReader br;
	private String line;
	private String[] strArray;
	private JLabel lblComeBackIcon;
	
	public MainPage(User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		setLocationRelativeTo(null);
		setSize(400,400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("Ana Sayfa");
		contentPane.setLayout(new BorderLayout(15, 0));
		setVisible(true);
				
		JPanel panelNorth = new JPanel();
		panelNorth.setLayout(new GroupLayout(panelNorth));
		Image imgIconNorth = new ImageIcon(this.getClass().getResource("/sahibindenLogo2.png")).getImage();
		panelNorth.setBackground(new Color(83, 85, 104));
		panelNorth.setPreferredSize(new Dimension(WIDTH,100));
		contentPane.add(panelNorth, BorderLayout.NORTH);

		JLabel lblIconNorth = new JLabel();
		lblIconNorth.setBounds(17, 28, 200, 45);
		lblIconNorth.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconNorth.setIcon(new ImageIcon(imgIconNorth));
		panelNorth.add(lblIconNorth);
		
		JLabel lblNameSurname = new JLabel(user.getName() + " " + user.getSurname());
		lblNameSurname.setBounds(1675, 32, 190, 36);
		lblNameSurname.setBorder(new LineBorder(Color.white));
		lblNameSurname.setForeground(SystemColor.window);
		lblNameSurname.setBorder(new LineBorder(Color.white));
		lblNameSurname.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 17));
		lblNameSurname.setHorizontalAlignment(SwingConstants.CENTER);
		panelNorth.add(lblNameSurname);

		JPanel panelWest = new JPanel();
		panelWest.setLayout(new GroupLayout(panelWest));
		panelWest.setBackground(new Color(83, 85, 104));
		panelWest.setPreferredSize(new Dimension(280,HEIGHT));
		contentPane.add(panelWest, BorderLayout.WEST);

		JLabel lblKategoriler = new JLabel("<html><u>Kategoriler</u></html>");
		lblKategoriler.setForeground(new Color(255, 255, 255));
		lblKategoriler.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblKategoriler.setBounds(80, 10, 150, 30);
		panelWest.add(lblKategoriler);

		JLabel lblOtomobil = new JLabel("Otomobil");
		lblOtomobil.setBounds(92, 55, 90, 25);
		lblOtomobil.setForeground(SystemColor.window);
		lblOtomobil.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 17));
		lblOtomobil.setHorizontalAlignment(SwingConstants.CENTER);
		panelWest.add(lblOtomobil);
		
		JLabel lblElektrikliAraclar = new JLabel("Elektrikli Araçlar");
		lblElektrikliAraclar.setBounds(70, 160, 130, 28);
		lblElektrikliAraclar.setForeground(SystemColor.window);
		lblElektrikliAraclar.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 17));
		lblElektrikliAraclar.setHorizontalAlignment(SwingConstants.CENTER);
		panelWest.add(lblElektrikliAraclar);
		
		JLabel lblASP = new JLabel("<html><div style='text-align: center;'>Arazi<br/>SUV&Pickup</div></html>");
		lblASP.setForeground(SystemColor.window);
		lblASP.setBounds(77, 90, 115, 50);
		lblASP.setHorizontalAlignment(SwingConstants.CENTER);
		lblASP.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 17));
		panelWest.add(lblASP);

		JPanel panelMain = new JPanel();
		contentPane.add(panelMain, BorderLayout.CENTER);

		GroupLayout gl_panelMain = new GroupLayout(panelMain);
		panelMain.setLayout(gl_panelMain);

		lblOtomobil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setTitle("Otomobil");
				panelMain.removeAll();
				panelMain.setLayout(new GroupLayout(panelMain));
				
				JLabel lblCarCategoryView = new JLabel("Otomobil");
				lblCarCategoryView.setFont(new Font("Elephant", Font.PLAIN, 36));
				lblCarCategoryView.setHorizontalAlignment(SwingConstants.CENTER);
				lblCarCategoryView.setBounds(42, 65, 200, 40);
				panelMain.add(lblCarCategoryView);
				
				JPanel panelCarCategory = new JPanel();
				panelCarCategory.setLayout(new FlowLayout(SwingConstants.CENTER,40,25));
				panelCarCategory.setPreferredSize(new Dimension(1500,2000));
				panelMain.add(panelCarCategory);
				
				JScrollPane paneCarCategory = new JScrollPane(panelCarCategory);
				paneCarCategory.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				paneCarCategory.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				paneCarCategory.setBounds(50, 150, 1500, 700);
				panelMain.add(paneCarCategory);
				
				try {
					fr = new FileReader("adverts.txt");
					br = new BufferedReader(fr);
					
					while ((line = br.readLine()) != null) {
						strArray = line.split(",");
						
						if (strArray[3].equals("Otomobil")) {
							JPanel panelAdvert = new JPanel();
							panelAdvert.setPreferredSize(new Dimension(200,250));
							panelAdvert.setBorder(new LineBorder(new Color(225,225,225),2));
							
							JPanel panelAdvert_1 = new JPanel();
							panelAdvert_1.setPreferredSize(new Dimension(190,240));
							panelAdvert_1.setLayout(new FlowLayout(FlowLayout.CENTER,15,20));
							
							JLabel lblAdvertImage = new JLabel();
							lblAdvertImage.setFont(new Font("Elephant",Font.PLAIN,12));
							lblAdvertImage.setBorder(new LineBorder(Color.black));
							lblAdvertImage.setPreferredSize(new Dimension(150,120));
							lblAdvertImage.setHorizontalAlignment(SwingConstants.CENTER);
							lblAdvertImage.setVerticalTextPosition(JLabel.BOTTOM);
					        lblAdvertImage.setHorizontalTextPosition(JLabel.CENTER);
					        
					        String imgAdvertPath = strArray[13];
							File imgAdvertFile = new File(imgAdvertPath);
							if (imgAdvertFile.exists()) {
								Image imgAdvertIcon = new ImageIcon(imgAdvertPath).getImage();
								lblAdvertImage.setIcon(new ImageIcon(imgAdvertIcon));
							} else {
								System.out.println("Image file not found : " + imgAdvertPath);
							}
							panelAdvert_1.add(lblAdvertImage);
							
							JLabel lblAdvertTitle = new JLabel(strArray[2]);
							lblAdvertTitle.setHorizontalAlignment(SwingConstants.CENTER);
							lblAdvertTitle.setPreferredSize(new Dimension(150,26));
							lblAdvertTitle.setFont(new Font("Elephant",Font.PLAIN,14));
							lblAdvertTitle.setBorder(new LineBorder(Color.black));
							panelAdvert_1.add(lblAdvertTitle);
							
							JLabel lblAdvertPrice = new JLabel(strArray[12] + "TL");
							lblAdvertPrice.setPreferredSize(new Dimension(150,22));
							lblAdvertPrice.setHorizontalAlignment(SwingConstants.CENTER);
							lblAdvertPrice.setFont(new Font("Tahoma",Font.BOLD,17));
							lblAdvertPrice.setForeground(Color.red);
							panelAdvert_1.add(lblAdvertPrice);
							
							panelAdvert.add(panelAdvert_1);
							panelCarCategory.add(panelAdvert);
							
							final Advert advert = new Advert(Integer.parseInt(strArray[0]), Integer.parseInt(strArray[1]), strArray[2], strArray[3],
									strArray[4], strArray[5],
									strArray[6], Integer.parseInt(strArray[7]),
									Integer.parseInt(strArray[8]), strArray[9],
									strArray[10], Integer.parseInt(strArray[11]),
									strArray[13],Integer.parseInt(strArray[12]));
							
							panelAdvert.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseEntered(MouseEvent e) {
									setCursor(new Cursor(Cursor.HAND_CURSOR));
									panelAdvert.setBackground(new Color(225,225,225));
								}
								@Override
								public void mouseExited(MouseEvent e) {
									setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
									panelAdvert.setBackground(new Color(238,238,238));
								}
								@Override
								public void mouseClicked(MouseEvent e) {
									setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
									panelMain.removeAll();
									panelAdvert.setBackground(new Color(238,238,238));
									lblComeBackIcon = new JLabel("");
									Image imgComeBack = new ImageIcon(this.getClass().getResource("/comeBackIcon.png"))
											.getImage();
									lblComeBackIcon.setIcon(new ImageIcon(imgComeBack));
									lblComeBackIcon.setBounds(20, 25, 35, 35);
									panelMain.add(lblComeBackIcon);

									JLabel lblAdvertImage = new JLabel("");
									lblAdvertImage.setHorizontalAlignment(SwingConstants.CENTER);
									lblAdvertImage.setBounds(555, 120, 400, 280);
									panelMain.add(lblAdvertImage);

									JLabel advertPrice = new JLabel(Integer.toString(advert.getPrice()) + "TL");
									advertPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
									advertPrice.setForeground(Color.red);
									advertPrice.setHorizontalAlignment(SwingConstants.CENTER);
									advertPrice.setBounds(685, 410, 130, 24);
									panelMain.add(advertPrice);

									JLabel advertTitle = new JLabel(advert.getAdvertTitle());
									advertTitle.setFont(new Font("Elephant", Font.PLAIN, 26));
									advertTitle.setHorizontalAlignment(SwingConstants.CENTER);
									advertTitle.setBounds(605, 450, 300, 30);
									panelMain.add(advertTitle);

									JLabel lblAdvertId = new JLabel("Ilan Id :");
									lblAdvertId.setBounds(230, 520, 90, 24);
									lblAdvertId.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									lblAdvertId.setHorizontalAlignment(SwingConstants.LEFT);
									panelMain.add(lblAdvertId);

									JLabel advertId = new JLabel(Integer.toString(advert.getId()));
									advertId.setBounds(400, 520, 150, 24);
									advertId.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									advertId.setHorizontalAlignment(SwingConstants.RIGHT);
									advertId.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
									panelMain.add(advertId);

									JLabel lblAdvertCategory = new JLabel("Kategori : ");
									lblAdvertCategory.setBounds(230, 610, 100, 24);
									lblAdvertCategory.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									lblAdvertCategory.setHorizontalAlignment(SwingConstants.LEFT);
									panelMain.add(lblAdvertCategory);

									JLabel advertCategory = new JLabel(advert.getCategory());
									advertCategory.setBounds(400, 610, 150, 24);
									advertCategory.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									advertCategory.setHorizontalAlignment(SwingConstants.RIGHT);
									advertCategory.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
									panelMain.add(advertCategory);

									JLabel lblAdvertVTable = new JLabel("Araç Plakası : ");
									lblAdvertVTable.setBounds(230, 690, 140, 24);
									lblAdvertVTable.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									lblAdvertVTable.setHorizontalAlignment(SwingConstants.LEFT);
									panelMain.add(lblAdvertVTable);

									JLabel advertVTable = new JLabel(advert.getVehicleTable());
									advertVTable.setBounds(400, 690, 150, 24);
									advertVTable.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									advertVTable.setHorizontalAlignment(SwingConstants.RIGHT);
									advertVTable.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
									panelMain.add(advertVTable);

									JLabel lblAdvertMotorPower = new JLabel("Motor Gücü : ");
									lblAdvertMotorPower.setBounds(230, 770, 140, 24);
									lblAdvertMotorPower.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									lblAdvertMotorPower.setHorizontalAlignment(SwingConstants.LEFT);
									panelMain.add(lblAdvertMotorPower);

									JLabel advertMotorPower = new JLabel(Integer.toString(advert.getMotorPower()));
									advertMotorPower.setBounds(400, 770, 150, 24);
									advertMotorPower.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									advertMotorPower.setHorizontalAlignment(SwingConstants.RIGHT);
									advertMotorPower.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
									panelMain.add(advertMotorPower);

									JLabel lblAdvertBrand = new JLabel("Marka :");
									lblAdvertBrand.setBounds(620, 520, 90, 24);
									lblAdvertBrand.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									lblAdvertBrand.setHorizontalAlignment(SwingConstants.LEFT);
									panelMain.add(lblAdvertBrand);

									JLabel advertBrand = new JLabel(advert.getBrandName());
									advertBrand.setBounds(780, 520, 130, 24);
									advertBrand.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									advertBrand.setHorizontalAlignment(SwingConstants.RIGHT);
									advertBrand.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
									panelMain.add(advertBrand);

									JLabel lblAdvertModel = new JLabel("Model : ");
									lblAdvertModel.setBounds(620, 610, 100, 24);
									lblAdvertModel.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									lblAdvertModel.setHorizontalAlignment(SwingConstants.LEFT);
									panelMain.add(lblAdvertModel);

									JLabel advertModel = new JLabel(advert.getModelName());
									advertModel.setBounds(780, 610, 130, 24);
									advertModel.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									advertModel.setHorizontalAlignment(SwingConstants.RIGHT);
									advertModel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
									panelMain.add(advertModel);

									JLabel lblAdvertModelYear = new JLabel("Model Yılı : ");
									lblAdvertModelYear.setBounds(620, 690, 120, 24);
									lblAdvertModelYear.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									lblAdvertModelYear.setHorizontalAlignment(SwingConstants.LEFT);
									panelMain.add(lblAdvertModelYear);

									JLabel advertModelYear = new JLabel(Integer.toString(advert.getModelYear()));
									advertModelYear.setBounds(780, 690, 130, 24);
									advertModelYear.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									advertModelYear.setHorizontalAlignment(SwingConstants.RIGHT);
									advertModelYear.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
									panelMain.add(advertModelYear);

									JLabel lblAdvertMileage = new JLabel("Kilometre :");
									lblAdvertMileage.setBounds(980, 520, 100, 24);
									lblAdvertMileage.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									lblAdvertMileage.setHorizontalAlignment(SwingConstants.LEFT);
									panelMain.add(lblAdvertMileage);

									JLabel advertMileage = new JLabel(Integer.toString(advert.getMileage()));
									advertMileage.setBounds(1100, 520, 130, 24);
									advertMileage.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									advertMileage.setHorizontalAlignment(SwingConstants.RIGHT);
									advertMileage.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
									panelMain.add(advertMileage);

									JLabel lblAdvertColor = new JLabel("Renk : ");
									lblAdvertColor.setBounds(980, 610, 70, 24);
									lblAdvertColor.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									lblAdvertColor.setHorizontalAlignment(SwingConstants.LEFT);
									panelMain.add(lblAdvertColor);

									JLabel advertColor = new JLabel(advert.getColor());
									advertColor.setBounds(1100, 610, 130, 24);
									advertColor.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									advertColor.setHorizontalAlignment(SwingConstants.RIGHT);
									advertColor.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
									panelMain.add(advertColor);

									JLabel lblAdvertGear = new JLabel("Vites : ");
									lblAdvertGear.setBounds(980, 690, 70, 24);
									lblAdvertGear.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									lblAdvertGear.setHorizontalAlignment(SwingConstants.LEFT);
									panelMain.add(lblAdvertGear);

									JLabel advertGear = new JLabel(advert.getGear());
									advertGear.setBounds(1100, 690, 130, 24);
									advertGear.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									advertGear.setHorizontalAlignment(SwingConstants.RIGHT);
									advertGear.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
									panelMain.add(advertGear);
									
									
									try {
										BufferedImage resizedImage = resizeImage(ImageIO.read(new File(imgAdvertPath)),
												380, 214);
										ImageIcon imageIcon = new ImageIcon(resizedImage);
										lblAdvertImage.setIcon(imageIcon);
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									
									
									panelMain.revalidate();
									panelMain.repaint();
									
									lblComeBackIcon.addMouseListener(new MouseAdapter() {
										@Override
										public void mouseClicked(MouseEvent e) {
											panelMain.removeAll();
											panelMain.add(lblCarCategoryView);
											panelMain.add(paneCarCategory);
											panelMain.revalidate();
											panelMain.repaint();
										}
									});
								}
							});
						}
					}
				} catch (Exception e2) {
					System.out.println("File reading unsuccessful");
				}finally {
					try {
						fr.close();
					} catch (Exception e3) {
						System.out.println("File closing unsuccessful");
					}
				}
				
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
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblOtomobil.setForeground(new Color(2, 40, 62));
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblOtomobil.setForeground(SystemColor.window);
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});

		lblASP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setTitle("Arazi,SUV&Pickup");
				panelMain.removeAll();
				panelMain.setLayout(new GroupLayout(panelMain));
				
				JLabel lblOSPCategoryView = new JLabel("Arazi,SUV&Pickup");
				lblOSPCategoryView.setFont(new Font("Elephant", Font.PLAIN, 36));
				lblOSPCategoryView.setHorizontalAlignment(SwingConstants.CENTER);
				lblOSPCategoryView.setBounds(42, 65, 380, 40);
				panelMain.add(lblOSPCategoryView);
				
				JPanel panelOSPCategory = new JPanel();
				panelOSPCategory.setLayout(new FlowLayout(SwingConstants.CENTER,40,25));
				panelOSPCategory.setPreferredSize(new Dimension(1500,2000));
				panelMain.add(panelOSPCategory);
				
				JScrollPane paneOSPCategory = new JScrollPane(panelOSPCategory);
				paneOSPCategory.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				paneOSPCategory.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				paneOSPCategory.setBounds(50, 150, 1500, 700);
				panelMain.add(paneOSPCategory);
				
				try {
					fr = new FileReader("adverts.txt");
					br = new BufferedReader(fr);
					
					while ((line = br.readLine()) != null) {
						strArray = line.split(",");
						
						if (strArray[3].equals("Arazi&SUV&Pickup")) {
							JPanel panelAdvert = new JPanel();
							panelAdvert.setPreferredSize(new Dimension(200,250));
							panelAdvert.setBorder(new LineBorder(new Color(225,225,225),2));
							
							JPanel panelAdvert_1 = new JPanel();
							panelAdvert_1.setPreferredSize(new Dimension(190,240));
							panelAdvert_1.setLayout(new FlowLayout(FlowLayout.CENTER,15,20));
							
							JLabel lblAdvertImage = new JLabel();
							lblAdvertImage.setFont(new Font("Elephant",Font.PLAIN,12));
							lblAdvertImage.setBorder(new LineBorder(Color.black));
							lblAdvertImage.setPreferredSize(new Dimension(150,120));
							lblAdvertImage.setHorizontalAlignment(SwingConstants.CENTER);
							lblAdvertImage.setVerticalTextPosition(JLabel.BOTTOM);
					        lblAdvertImage.setHorizontalTextPosition(JLabel.CENTER);
					        
					        String imgAdvertPath = strArray[13];
							File imgAdvertFile = new File(imgAdvertPath);
							if (imgAdvertFile.exists()) {
								Image imgAdvertIcon = new ImageIcon(imgAdvertPath).getImage();
								lblAdvertImage.setIcon(new ImageIcon(imgAdvertIcon));
							} else {
								System.out.println("Image file not found : " + imgAdvertPath);
							}
							panelAdvert_1.add(lblAdvertImage);
							
							JLabel lblAdvertTitle = new JLabel(strArray[2]);
							lblAdvertTitle.setHorizontalAlignment(SwingConstants.CENTER);
							lblAdvertTitle.setPreferredSize(new Dimension(150,26));
							lblAdvertTitle.setFont(new Font("Elephant",Font.PLAIN,14));
							lblAdvertTitle.setBorder(new LineBorder(Color.black));
							panelAdvert_1.add(lblAdvertTitle);
							
							JLabel lblAdvertPrice = new JLabel(strArray[12] + "TL");
							lblAdvertPrice.setPreferredSize(new Dimension(150,22));
							lblAdvertPrice.setHorizontalAlignment(SwingConstants.CENTER);
							lblAdvertPrice.setFont(new Font("Tahoma",Font.BOLD,17));
							lblAdvertPrice.setForeground(Color.red);
							panelAdvert_1.add(lblAdvertPrice);
							
							panelAdvert.add(panelAdvert_1);
							panelOSPCategory.add(panelAdvert);
							
							final Advert advert = new Advert(Integer.parseInt(strArray[0]), Integer.parseInt(strArray[1]), strArray[2], strArray[3],
									strArray[4], strArray[5],
									strArray[6], Integer.parseInt(strArray[7]),
									Integer.parseInt(strArray[8]), strArray[9],
									strArray[10], Integer.parseInt(strArray[11]),
									strArray[13],Integer.parseInt(strArray[12]));
							
							panelAdvert.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseEntered(MouseEvent e) {
									setCursor(new Cursor(Cursor.HAND_CURSOR));
									panelAdvert.setBackground(new Color(225,225,225));
								}
								@Override
								public void mouseExited(MouseEvent e) {
									setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
									panelAdvert.setBackground(new Color(238,238,238));
								}
								@Override
								public void mouseClicked(MouseEvent e) {
									setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
									panelMain.removeAll();
									panelAdvert.setBackground(new Color(238,238,238));
									lblComeBackIcon = new JLabel("");
									Image imgComeBack = new ImageIcon(this.getClass().getResource("/comeBackIcon.png"))
											.getImage();
									lblComeBackIcon.setIcon(new ImageIcon(imgComeBack));
									lblComeBackIcon.setBounds(20, 25, 35, 35);
									panelMain.add(lblComeBackIcon);

									JLabel lblAdvertImage = new JLabel("");
									lblAdvertImage.setHorizontalAlignment(SwingConstants.CENTER);
									lblAdvertImage.setBounds(555, 120, 400, 280);
									panelMain.add(lblAdvertImage);

									JLabel advertPrice = new JLabel(Integer.toString(advert.getPrice()) + "TL");
									advertPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
									advertPrice.setForeground(Color.red);
									advertPrice.setHorizontalAlignment(SwingConstants.CENTER);
									advertPrice.setBounds(685, 410, 130, 24);
									panelMain.add(advertPrice);

									JLabel advertTitle = new JLabel(advert.getAdvertTitle());
									advertTitle.setFont(new Font("Elephant", Font.PLAIN, 26));
									advertTitle.setHorizontalAlignment(SwingConstants.CENTER);
									advertTitle.setBounds(605, 450, 300, 30);
									panelMain.add(advertTitle);

									JLabel lblAdvertId = new JLabel("Ilan Id :");
									lblAdvertId.setBounds(230, 520, 90, 24);
									lblAdvertId.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									lblAdvertId.setHorizontalAlignment(SwingConstants.LEFT);
									panelMain.add(lblAdvertId);

									JLabel advertId = new JLabel(Integer.toString(advert.getId()));
									advertId.setBounds(400, 520, 150, 24);
									advertId.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									advertId.setHorizontalAlignment(SwingConstants.RIGHT);
									advertId.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
									panelMain.add(advertId);

									JLabel lblAdvertCategory = new JLabel("Kategori : ");
									lblAdvertCategory.setBounds(230, 610, 100, 24);
									lblAdvertCategory.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									lblAdvertCategory.setHorizontalAlignment(SwingConstants.LEFT);
									panelMain.add(lblAdvertCategory);

									JLabel advertCategory = new JLabel(advert.getCategory());
									advertCategory.setBounds(400, 610, 150, 24);
									advertCategory.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									advertCategory.setHorizontalAlignment(SwingConstants.RIGHT);
									advertCategory.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
									panelMain.add(advertCategory);

									JLabel lblAdvertVTable = new JLabel("Araç Plakası : ");
									lblAdvertVTable.setBounds(230, 690, 140, 24);
									lblAdvertVTable.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									lblAdvertVTable.setHorizontalAlignment(SwingConstants.LEFT);
									panelMain.add(lblAdvertVTable);

									JLabel advertVTable = new JLabel(advert.getVehicleTable());
									advertVTable.setBounds(400, 690, 150, 24);
									advertVTable.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									advertVTable.setHorizontalAlignment(SwingConstants.RIGHT);
									advertVTable.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
									panelMain.add(advertVTable);

									JLabel lblAdvertMotorPower = new JLabel("Motor Gücü : ");
									lblAdvertMotorPower.setBounds(230, 770, 140, 24);
									lblAdvertMotorPower.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									lblAdvertMotorPower.setHorizontalAlignment(SwingConstants.LEFT);
									panelMain.add(lblAdvertMotorPower);

									JLabel advertMotorPower = new JLabel(Integer.toString(advert.getMotorPower()));
									advertMotorPower.setBounds(400, 770, 150, 24);
									advertMotorPower.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									advertMotorPower.setHorizontalAlignment(SwingConstants.RIGHT);
									advertMotorPower.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
									panelMain.add(advertMotorPower);

									JLabel lblAdvertBrand = new JLabel("Marka :");
									lblAdvertBrand.setBounds(620, 520, 90, 24);
									lblAdvertBrand.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									lblAdvertBrand.setHorizontalAlignment(SwingConstants.LEFT);
									panelMain.add(lblAdvertBrand);

									JLabel advertBrand = new JLabel(advert.getBrandName());
									advertBrand.setBounds(780, 520, 130, 24);
									advertBrand.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									advertBrand.setHorizontalAlignment(SwingConstants.RIGHT);
									advertBrand.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
									panelMain.add(advertBrand);

									JLabel lblAdvertModel = new JLabel("Model : ");
									lblAdvertModel.setBounds(620, 610, 100, 24);
									lblAdvertModel.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									lblAdvertModel.setHorizontalAlignment(SwingConstants.LEFT);
									panelMain.add(lblAdvertModel);

									JLabel advertModel = new JLabel(advert.getModelName());
									advertModel.setBounds(780, 610, 130, 24);
									advertModel.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									advertModel.setHorizontalAlignment(SwingConstants.RIGHT);
									advertModel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
									panelMain.add(advertModel);

									JLabel lblAdvertModelYear = new JLabel("Model Yılı : ");
									lblAdvertModelYear.setBounds(620, 690, 120, 24);
									lblAdvertModelYear.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									lblAdvertModelYear.setHorizontalAlignment(SwingConstants.LEFT);
									panelMain.add(lblAdvertModelYear);

									JLabel advertModelYear = new JLabel(Integer.toString(advert.getModelYear()));
									advertModelYear.setBounds(780, 690, 130, 24);
									advertModelYear.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									advertModelYear.setHorizontalAlignment(SwingConstants.RIGHT);
									advertModelYear.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
									panelMain.add(advertModelYear);

									JLabel lblAdvertMileage = new JLabel("Kilometre :");
									lblAdvertMileage.setBounds(980, 520, 100, 24);
									lblAdvertMileage.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									lblAdvertMileage.setHorizontalAlignment(SwingConstants.LEFT);
									panelMain.add(lblAdvertMileage);

									JLabel advertMileage = new JLabel(Integer.toString(advert.getMileage()));
									advertMileage.setBounds(1100, 520, 130, 24);
									advertMileage.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									advertMileage.setHorizontalAlignment(SwingConstants.RIGHT);
									advertMileage.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
									panelMain.add(advertMileage);

									JLabel lblAdvertColor = new JLabel("Renk : ");
									lblAdvertColor.setBounds(980, 610, 70, 24);
									lblAdvertColor.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									lblAdvertColor.setHorizontalAlignment(SwingConstants.LEFT);
									panelMain.add(lblAdvertColor);

									JLabel advertColor = new JLabel(advert.getColor());
									advertColor.setBounds(1100, 610, 130, 24);
									advertColor.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									advertColor.setHorizontalAlignment(SwingConstants.RIGHT);
									advertColor.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
									panelMain.add(advertColor);

									JLabel lblAdvertGear = new JLabel("Vites : ");
									lblAdvertGear.setBounds(980, 690, 70, 24);
									lblAdvertGear.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									lblAdvertGear.setHorizontalAlignment(SwingConstants.LEFT);
									panelMain.add(lblAdvertGear);

									JLabel advertGear = new JLabel(advert.getGear());
									advertGear.setBounds(1100, 690, 130, 24);
									advertGear.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									advertGear.setHorizontalAlignment(SwingConstants.RIGHT);
									advertGear.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
									panelMain.add(advertGear);
									
									
									try {
										BufferedImage resizedImage = resizeImage(ImageIO.read(new File(imgAdvertPath)),
												380, 214);
										ImageIcon imageIcon = new ImageIcon(resizedImage);
										lblAdvertImage.setIcon(imageIcon);
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									
									
									panelMain.revalidate();
									panelMain.repaint();
									
									lblComeBackIcon.addMouseListener(new MouseAdapter() {
										@Override
										public void mouseClicked(MouseEvent e) {
											panelMain.removeAll();
											panelMain.add(lblOSPCategoryView);
											panelMain.add(paneOSPCategory);
											panelMain.revalidate();
											panelMain.repaint();
										}
									});
								}
							});
						}
					}
				} catch (Exception e2) {
					System.out.println("File reading unsuccessful");
				}finally {
					try {
						fr.close();
					} catch (Exception e3) {
						System.out.println("File closing unsuccessful");
					}
				}
				
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
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblASP.setForeground(new Color(2, 40, 62));
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblASP.setForeground(SystemColor.window);
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});

		lblElektrikliAraclar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setTitle("Elektrikli Araçlar");
				panelMain.removeAll();
				panelMain.setLayout(new GroupLayout(panelMain));
				
				JLabel lblECarCategoryView = new JLabel("Elektrikli Araçlar");
				lblECarCategoryView.setFont(new Font("Elephant", Font.PLAIN, 36));
				lblECarCategoryView.setHorizontalAlignment(SwingConstants.CENTER);
				lblECarCategoryView.setBounds(42, 65, 380, 40);
				panelMain.add(lblECarCategoryView);
				
				JPanel panelECarCategory = new JPanel();
				panelECarCategory.setLayout(new FlowLayout(SwingConstants.CENTER,40,25));
				panelECarCategory.setPreferredSize(new Dimension(1500,2000));
				panelMain.add(panelECarCategory);
				
				JScrollPane paneECarCategory = new JScrollPane(panelECarCategory);
				paneECarCategory.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				paneECarCategory.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				paneECarCategory.setBounds(50, 150, 1500, 700);
				panelMain.add(paneECarCategory);
				
				try {
					fr = new FileReader("adverts.txt");
					br = new BufferedReader(fr);
					
					while ((line = br.readLine()) != null) {
						strArray = line.split(",");
						
						if (strArray[3].equals("Elektrikli Araçlar")) {
							JPanel panelAdvert = new JPanel();
							panelAdvert.setPreferredSize(new Dimension(200,250));
							panelAdvert.setBorder(new LineBorder(new Color(225,225,225),2));
							
							JPanel panelAdvert_1 = new JPanel();
							panelAdvert_1.setPreferredSize(new Dimension(190,240));
							panelAdvert_1.setLayout(new FlowLayout(FlowLayout.CENTER,15,20));
							
							JLabel lblAdvertImage = new JLabel();
							lblAdvertImage.setFont(new Font("Elephant",Font.PLAIN,12));
							lblAdvertImage.setBorder(new LineBorder(Color.black));
							lblAdvertImage.setPreferredSize(new Dimension(150,120));
							lblAdvertImage.setHorizontalAlignment(SwingConstants.CENTER);
							lblAdvertImage.setVerticalTextPosition(JLabel.BOTTOM);
					        lblAdvertImage.setHorizontalTextPosition(JLabel.CENTER);
					        
					        String imgAdvertPath = strArray[13];
							File imgAdvertFile = new File(imgAdvertPath);
							if (imgAdvertFile.exists()) {
								Image imgAdvertIcon = new ImageIcon(imgAdvertPath).getImage();
								lblAdvertImage.setIcon(new ImageIcon(imgAdvertIcon));
							} else {
								System.out.println("Image file not found : " + imgAdvertPath);
							}
							panelAdvert_1.add(lblAdvertImage);
							
							JLabel lblAdvertTitle = new JLabel(strArray[2]);
							lblAdvertTitle.setHorizontalAlignment(SwingConstants.CENTER);
							lblAdvertTitle.setPreferredSize(new Dimension(150,26));
							lblAdvertTitle.setFont(new Font("Elephant",Font.PLAIN,14));
							lblAdvertTitle.setBorder(new LineBorder(Color.black));
							panelAdvert_1.add(lblAdvertTitle);
							
							JLabel lblAdvertPrice = new JLabel(strArray[12] + "TL");
							lblAdvertPrice.setPreferredSize(new Dimension(150,22));
							lblAdvertPrice.setHorizontalAlignment(SwingConstants.CENTER);
							lblAdvertPrice.setFont(new Font("Tahoma",Font.BOLD,17));
							lblAdvertPrice.setForeground(Color.red);
							panelAdvert_1.add(lblAdvertPrice);
							
							panelAdvert.add(panelAdvert_1);
							panelECarCategory.add(panelAdvert);
							
							final Advert advert = new Advert(Integer.parseInt(strArray[0]), Integer.parseInt(strArray[1]), strArray[2], strArray[3],
									strArray[4], strArray[5],
									strArray[6], Integer.parseInt(strArray[7]),
									Integer.parseInt(strArray[8]), strArray[9],
									strArray[10], Integer.parseInt(strArray[11]),
									strArray[13],Integer.parseInt(strArray[12]));
							
							panelAdvert.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseEntered(MouseEvent e) {
									setCursor(new Cursor(Cursor.HAND_CURSOR));
									panelAdvert.setBackground(new Color(225,225,225));
								}
								@Override
								public void mouseExited(MouseEvent e) {
									setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
									panelAdvert.setBackground(new Color(238,238,238));
								}
								@Override
								public void mouseClicked(MouseEvent e) {
									setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
									panelMain.removeAll();
									panelAdvert.setBackground(new Color(238,238,238));
									lblComeBackIcon = new JLabel("");
									Image imgComeBack = new ImageIcon(this.getClass().getResource("/comeBackIcon.png"))
											.getImage();
									lblComeBackIcon.setIcon(new ImageIcon(imgComeBack));
									lblComeBackIcon.setBounds(20, 25, 35, 35);
									panelMain.add(lblComeBackIcon);

									JLabel lblAdvertImage = new JLabel("");
									lblAdvertImage.setHorizontalAlignment(SwingConstants.CENTER);
									lblAdvertImage.setBounds(555, 120, 400, 280);
									panelMain.add(lblAdvertImage);

									JLabel advertPrice = new JLabel(Integer.toString(advert.getPrice()) + "TL");
									advertPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
									advertPrice.setForeground(Color.red);
									advertPrice.setHorizontalAlignment(SwingConstants.CENTER);
									advertPrice.setBounds(685, 410, 130, 24);
									panelMain.add(advertPrice);

									JLabel advertTitle = new JLabel(advert.getAdvertTitle());
									advertTitle.setFont(new Font("Elephant", Font.PLAIN, 26));
									advertTitle.setHorizontalAlignment(SwingConstants.CENTER);
									advertTitle.setBounds(605, 450, 300, 30);
									panelMain.add(advertTitle);

									JLabel lblAdvertId = new JLabel("Ilan Id :");
									lblAdvertId.setBounds(230, 520, 90, 24);
									lblAdvertId.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									lblAdvertId.setHorizontalAlignment(SwingConstants.LEFT);
									panelMain.add(lblAdvertId);

									JLabel advertId = new JLabel(Integer.toString(advert.getId()));
									advertId.setBounds(400, 520, 150, 24);
									advertId.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									advertId.setHorizontalAlignment(SwingConstants.RIGHT);
									advertId.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
									panelMain.add(advertId);

									JLabel lblAdvertCategory = new JLabel("Kategori : ");
									lblAdvertCategory.setBounds(230, 610, 100, 24);
									lblAdvertCategory.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									lblAdvertCategory.setHorizontalAlignment(SwingConstants.LEFT);
									panelMain.add(lblAdvertCategory);

									JLabel advertCategory = new JLabel(advert.getCategory());
									advertCategory.setBounds(400, 610, 150, 24);
									advertCategory.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									advertCategory.setHorizontalAlignment(SwingConstants.RIGHT);
									advertCategory.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
									panelMain.add(advertCategory);

									JLabel lblAdvertVTable = new JLabel("Araç Plakası : ");
									lblAdvertVTable.setBounds(230, 690, 140, 24);
									lblAdvertVTable.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									lblAdvertVTable.setHorizontalAlignment(SwingConstants.LEFT);
									panelMain.add(lblAdvertVTable);

									JLabel advertVTable = new JLabel(advert.getVehicleTable());
									advertVTable.setBounds(400, 690, 150, 24);
									advertVTable.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									advertVTable.setHorizontalAlignment(SwingConstants.RIGHT);
									advertVTable.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
									panelMain.add(advertVTable);

									JLabel lblAdvertMotorPower = new JLabel("Motor Gücü : ");
									lblAdvertMotorPower.setBounds(230, 770, 140, 24);
									lblAdvertMotorPower.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									lblAdvertMotorPower.setHorizontalAlignment(SwingConstants.LEFT);
									panelMain.add(lblAdvertMotorPower);

									JLabel advertMotorPower = new JLabel(Integer.toString(advert.getMotorPower()));
									advertMotorPower.setBounds(400, 770, 150, 24);
									advertMotorPower.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									advertMotorPower.setHorizontalAlignment(SwingConstants.RIGHT);
									advertMotorPower.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
									panelMain.add(advertMotorPower);

									JLabel lblAdvertBrand = new JLabel("Marka :");
									lblAdvertBrand.setBounds(620, 520, 90, 24);
									lblAdvertBrand.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									lblAdvertBrand.setHorizontalAlignment(SwingConstants.LEFT);
									panelMain.add(lblAdvertBrand);

									JLabel advertBrand = new JLabel(advert.getBrandName());
									advertBrand.setBounds(780, 520, 130, 24);
									advertBrand.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									advertBrand.setHorizontalAlignment(SwingConstants.RIGHT);
									advertBrand.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
									panelMain.add(advertBrand);

									JLabel lblAdvertModel = new JLabel("Model : ");
									lblAdvertModel.setBounds(620, 610, 100, 24);
									lblAdvertModel.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									lblAdvertModel.setHorizontalAlignment(SwingConstants.LEFT);
									panelMain.add(lblAdvertModel);

									JLabel advertModel = new JLabel(advert.getModelName());
									advertModel.setBounds(780, 610, 130, 24);
									advertModel.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									advertModel.setHorizontalAlignment(SwingConstants.RIGHT);
									advertModel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
									panelMain.add(advertModel);

									JLabel lblAdvertModelYear = new JLabel("Model Yılı : ");
									lblAdvertModelYear.setBounds(620, 690, 120, 24);
									lblAdvertModelYear.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									lblAdvertModelYear.setHorizontalAlignment(SwingConstants.LEFT);
									panelMain.add(lblAdvertModelYear);

									JLabel advertModelYear = new JLabel(Integer.toString(advert.getModelYear()));
									advertModelYear.setBounds(780, 690, 130, 24);
									advertModelYear.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									advertModelYear.setHorizontalAlignment(SwingConstants.RIGHT);
									advertModelYear.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
									panelMain.add(advertModelYear);

									JLabel lblAdvertMileage = new JLabel("Kilometre :");
									lblAdvertMileage.setBounds(980, 520, 100, 24);
									lblAdvertMileage.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									lblAdvertMileage.setHorizontalAlignment(SwingConstants.LEFT);
									panelMain.add(lblAdvertMileage);

									JLabel advertMileage = new JLabel(Integer.toString(advert.getMileage()));
									advertMileage.setBounds(1100, 520, 130, 24);
									advertMileage.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									advertMileage.setHorizontalAlignment(SwingConstants.RIGHT);
									advertMileage.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
									panelMain.add(advertMileage);

									JLabel lblAdvertColor = new JLabel("Renk : ");
									lblAdvertColor.setBounds(980, 610, 70, 24);
									lblAdvertColor.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									lblAdvertColor.setHorizontalAlignment(SwingConstants.LEFT);
									panelMain.add(lblAdvertColor);

									JLabel advertColor = new JLabel(advert.getColor());
									advertColor.setBounds(1100, 610, 130, 24);
									advertColor.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									advertColor.setHorizontalAlignment(SwingConstants.RIGHT);
									advertColor.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
									panelMain.add(advertColor);

									JLabel lblAdvertGear = new JLabel("Vites : ");
									lblAdvertGear.setBounds(980, 690, 70, 24);
									lblAdvertGear.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									lblAdvertGear.setHorizontalAlignment(SwingConstants.LEFT);
									panelMain.add(lblAdvertGear);

									JLabel advertGear = new JLabel(advert.getGear());
									advertGear.setBounds(1100, 690, 130, 24);
									advertGear.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 20));
									advertGear.setHorizontalAlignment(SwingConstants.RIGHT);
									advertGear.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
									panelMain.add(advertGear);
									
									
									try {
										BufferedImage resizedImage = resizeImage(ImageIO.read(new File(imgAdvertPath)),
												380, 214);
										ImageIcon imageIcon = new ImageIcon(resizedImage);
										lblAdvertImage.setIcon(imageIcon);
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									
									
									panelMain.revalidate();
									panelMain.repaint();
									
									lblComeBackIcon.addMouseListener(new MouseAdapter() {
										@Override
										public void mouseClicked(MouseEvent e) {
											panelMain.removeAll();
											panelMain.add(lblECarCategoryView);
											panelMain.add(paneECarCategory);
											panelMain.revalidate();
											panelMain.repaint();
										}
									});
								}
							});
						}
					}
				} catch (Exception e2) {
					System.out.println("File reading unsuccessful");
				}finally {
					try {
						fr.close();
					} catch (Exception e3) {
						System.out.println("File closing unsuccessful");
					}
				}
				
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
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblElektrikliAraclar.setForeground(new Color(2, 40, 62));
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblElektrikliAraclar.setForeground(SystemColor.window);
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		lblNameSurname.addMouseListener(new MouseAdapter() {
			@Override 
			public void mouseEntered(MouseEvent e) {
				lblNameSurname.setText("<html><u>" + user.getName() + " " + user.getSurname() + "</u></html>");
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				lblNameSurname.setText(user.getName() + " " + user.getSurname());
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				UserAccountPage userAP = new UserAccountPage(user);
				setVisible(false);
			}
		});
	}
	public static BufferedImage resizeImage(BufferedImage originalImage, int width, int height) {
		return Scalr.resize(originalImage, Scalr.Method.QUALITY, Scalr.Mode.AUTOMATIC, width, height);
	}
}

