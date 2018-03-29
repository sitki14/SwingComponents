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
		
		JMenuItem mn�tmDosyaA = new JMenuItem("Dosya A\u00E7");
		mn�tmDosyaA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fc=new JFileChooser(); // dosya ya bast�g�z�zda bir tane file chooser ac�lacak
				int i=fc.showOpenDialog(MenuKullanimi.this);//ok a bas�lm�ssa yaz�l alan�na bas�lacak 
				//k�saca bast�g� butonu d�nd�r�r cancel ok gibi
				if(i==JFileChooser.APPROVE_OPTION){ //kullan�c� ok  a basm�ssa demek
					File file=fc.getSelectedFile();
					try(Scanner sc=new Scanner(new BufferedReader(new FileReader(file)))){
						String icerik=""; // okunan i�eril buna eklenir
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
		mn�tmDosyaA.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnDosya.add(mn�tmDosyaA);
		
		JMenuItem mn�tmDosyaKaydet = new JMenuItem("Dosya Kaydet");
		mn�tmDosyaKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				JFileChooser fc=new JFileChooser();
				int cevap=fc.showSaveDialog(MenuKullanimi.this);
				if(cevap==JFileChooser.APPROVE_OPTION) {// yine ok a mi yoksa cancel a m� bas�ld� diye kontrol saglad�k
					String dosyaYolu=fc.getSelectedFile().getPath(); // secilen dosyan�n yolunu al�r 
					try(FileWriter writer=new FileWriter(dosyaYolu)) {
						writer.write(yaziAlani_1.getText());
						
					} catch (Exception e2) {
						System.out.println("hataa");
					}
					 
					
				}
			}
		});
		mn�tmDosyaKaydet.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnDosya.add(mn�tmDosyaKaydet);
		
		JMenuItem mn�tmNewDosya = new JMenuItem("\u00C7\u0131k\u0131\u015F");
		mn�tmNewDosya.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mn�tmNewDosya.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		mnDosya.add(mn�tmNewDosya);
		
		JMenu mnDzenle = new JMenu("D\u00FCzenle");
		menuBar.add(mnDzenle);
		
		JMenu mnRenk = new JMenu("Renk");
		mnDzenle.add(mnRenk);
		
		JMenuItem mn�tmRengiDeitir = new JMenuItem("Rengi De\u011Fi\u015Ftir");
		mn�tmRengiDeitir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//RENK DE���T�R
				Color color=JColorChooser.showDialog(yaziAlani_1, "renk sec", Color.black);
				yaziAlani_1.setForeground(color);
				
				
			}
		});
		mnRenk.add(mn�tmRengiDeitir);
		
		JMenu mnYazTipi = new JMenu("Yaz\u0131 Tipi");
		mnDzenle.add(mnYazTipi);
		
		JMenuItem mn�tmArial = new JMenuItem("Arial");
		mn�tmArial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//YAZI T�P� AR�AL
				Font font=new Font("Arial", Font.PLAIN, 20);
				yaziAlani_1.setFont(font);
				
				
				
				
			}
		});
		mnYazTipi.add(mn�tmArial);
		
		JMenuItem mn�tmTimesNewRoman = new JMenuItem("Times New Roman");
		mn�tmTimesNewRoman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Font font=new Font("Times New Roman",Font.ITALIC, 30);
				yaziAlani_1.setFont(font);
			}
		});
		mnYazTipi.add(mn�tmTimesNewRoman);
		
		JMenu mnDeneme = new JMenu("Deneme");
		menuBar.add(mnDeneme);
		
		JMenu mnDeneme_1 = new JMenu("deneme1");
		mnDeneme.add(mnDeneme_1);
		
		JMenu mnDeneme_4 = new JMenu("deneme1.1");
		mnDeneme_1.add(mnDeneme_4);
		
		JMenu mnDeneme_6 = new JMenu("deneme1.1.1");
		mnDeneme_4.add(mnDeneme_6);
		
		JMenuItem mn�tmDeneme = new JMenuItem("deneme1.1.1_1");
		mnDeneme_6.add(mn�tmDeneme);
		
		JMenuItem mn�tmDeneme_1 = new JMenuItem("deneme1.1.1_2");
		mnDeneme_6.add(mn�tmDeneme_1);
		
		JMenu mnDeneme_7 = new JMenu("deneme1.1.2");
		mnDeneme_4.add(mnDeneme_7);
		
		JMenuItem mn�tmDeneme_2 = new JMenuItem("deneme1.1.2_1");
		mnDeneme_7.add(mn�tmDeneme_2);
		
		JMenuItem mn�tmDeneme_3 = new JMenuItem("deneme1.1.2_2");
		mnDeneme_7.add(mn�tmDeneme_3);
		
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
