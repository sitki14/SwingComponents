package Menuler;
import java.util.Scanner;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.Font;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.event.InputEvent;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuKullanimi extends JFrame {
	
	private JPanel contentPane;
	private JTextArea yaziAlani_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuKullanimi frame = new MenuKullanimi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MenuKullanimi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 454);
		contentPane = new JPanel();
		contentPane.setToolTipText("dosya2");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 11, 630, 46);
		contentPane.add(menuBar);
		
		JMenu mnDosya = new JMenu("Dosya");
		menuBar.add(mnDosya);
		
		JMenuItem mnýtmDosyaA = new JMenuItem("Dosya A\u00E7");
		mnýtmDosyaA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fc=new JFileChooser(); // dosya ya bastýgýzýzda bir tane file chooser acýlacak
				int i=fc.showOpenDialog(MenuKullanimi.this);//ok a basýlmýssa yazýl alanýna basýlacak 
				//kýsaca bastýgý butonu döndürür cancel ok gibi
				if(i==JFileChooser.APPROVE_OPTION){ //kullanýcý ok  a basmýssa demek
					File file=fc.getSelectedFile();
					try(Scanner sc=new Scanner(new BufferedReader(new FileReader(file)))){
						String icerik=""; // okunan içeril buna eklenir
						while(sc.hasNextLine()) {
							icerik +=sc.nextLine() +"\n";
							
						}
						yaziAlani_1.setText(icerik);
					} catch (FileNotFoundException e1) {
						System.out.println("dosya ac da hata var");
					}
				}
		
			}
		});
		mnýtmDosyaA.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnDosya.add(mnýtmDosyaA);
		
		JMenuItem mnýtmDosyaKaydet = new JMenuItem("Dosya Kaydet");
		mnýtmDosyaKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				JFileChooser fc=new JFileChooser();
				int cevap=fc.showSaveDialog(MenuKullanimi.this);
				if(cevap==JFileChooser.APPROVE_OPTION) {// yine ok a mi yoksa cancel a mý basýldý diye kontrol sagladýk
					String dosyaYolu=fc.getSelectedFile().getPath(); // secilen dosyanýn yolunu alýr 
					try(FileWriter writer=new FileWriter(dosyaYolu)) {
						writer.write(yaziAlani_1.getText());
						
					} catch (Exception e2) {
						System.out.println("hataa");
					}
					 
					
				}
			}
		});
		mnýtmDosyaKaydet.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnDosya.add(mnýtmDosyaKaydet);
		
		JMenuItem mnýtmNewDosya = new JMenuItem("\u00C7\u0131k\u0131\u015F");
		mnýtmNewDosya.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnýtmNewDosya.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		mnDosya.add(mnýtmNewDosya);
		
		JMenu mnDzenle = new JMenu("D\u00FCzenle");
		menuBar.add(mnDzenle);
		
		JMenu mnRenk = new JMenu("Renk");
		mnDzenle.add(mnRenk);
		
		JMenuItem mnýtmRengiDeitir = new JMenuItem("Rengi De\u011Fi\u015Ftir");
		mnýtmRengiDeitir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//RENK DEÐÝÞTÝR
				Color color=JColorChooser.showDialog(yaziAlani_1, "renk sec", Color.black);
				yaziAlani_1.setForeground(color);
				
				
			}
		});
		mnRenk.add(mnýtmRengiDeitir);
		
		JMenu mnYazTipi = new JMenu("Yaz\u0131 Tipi");
		mnDzenle.add(mnYazTipi);
		
		JMenuItem mnýtmArial = new JMenuItem("Arial");
		mnýtmArial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//YAZI TÝPÝ ARÝAL
				Font font=new Font("Arial", Font.PLAIN, 20);
				yaziAlani_1.setFont(font);
				
				
				
				
			}
		});
		mnYazTipi.add(mnýtmArial);
		
		JMenuItem mnýtmTimesNewRoman = new JMenuItem("Times New Roman");
		mnýtmTimesNewRoman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Font font=new Font("Times New Roman",Font.ITALIC, 30);
				yaziAlani_1.setFont(font);
			}
		});
		mnYazTipi.add(mnýtmTimesNewRoman);
		
		JMenu mnDeneme = new JMenu("Deneme");
		menuBar.add(mnDeneme);
		
		JMenu mnDeneme_1 = new JMenu("deneme1");
		mnDeneme.add(mnDeneme_1);
		
		JMenu mnDeneme_4 = new JMenu("deneme1.1");
		mnDeneme_1.add(mnDeneme_4);
		
		JMenu mnDeneme_6 = new JMenu("deneme1.1.1");
		mnDeneme_4.add(mnDeneme_6);
		
		JMenuItem mnýtmDeneme = new JMenuItem("deneme1.1.1_1");
		mnDeneme_6.add(mnýtmDeneme);
		
		JMenuItem mnýtmDeneme_1 = new JMenuItem("deneme1.1.1_2");
		mnDeneme_6.add(mnýtmDeneme_1);
		
		JMenu mnDeneme_7 = new JMenu("deneme1.1.2");
		mnDeneme_4.add(mnDeneme_7);
		
		JMenuItem mnýtmDeneme_2 = new JMenuItem("deneme1.1.2_1");
		mnDeneme_7.add(mnýtmDeneme_2);
		
		JMenuItem mnýtmDeneme_3 = new JMenuItem("deneme1.1.2_2");
		mnDeneme_7.add(mnýtmDeneme_3);
		
		JMenu mnDeneme_5 = new JMenu("deneme1.2");
		mnDeneme_1.add(mnDeneme_5);
		
		JMenu mnDeneme_2 = new JMenu("deneme2");
		mnDeneme.add(mnDeneme_2);
		
		JMenu mnDeneme_3 = new JMenu("deneme3");
		mnDeneme.add(mnDeneme_3);
		
		yaziAlani_1 = new JTextArea();
		yaziAlani_1.setBounds(10, 68, 630, 336);
		contentPane.add(yaziAlani_1);
	}
}
