package FileChooserveColorChooser;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class FileChooserveColorChooser extends JFrame {

	private JPanel contentPane;
	private JTextArea yaziAlani;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileChooserveColorChooser frame = new FileChooserveColorChooser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public FileChooserveColorChooser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 440);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton dosyaAc = new JButton("dosya a\u00E7");
		dosyaAc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//bu butona bastýgýmýzda býr tane dosya secici ekrana gelmesini aðlayacagýz
				JFileChooser fc=new JFileChooser();
				int i=fc.showOpenDialog(FileChooserveColorChooser.this);
				//ok a basarsak i ye deger gidecek veya cancel e basarsak baska deger gýdecek
				//bu durumu kontrole alýcagýz
				if(i==JFileChooser.APPROVE_OPTION) {
					File file=fc.getSelectedFile();
					//hangi dosya secilmisse bu dosyanýn içine attýk.
					String icerik="";
					try(Scanner sc=new Scanner(new BufferedReader(new FileReader(file)))){
						while(sc.hasNextLine()) {
							icerik+=sc.nextLine()+"\n";
							//while döngüsü bittiðinde file ýn tüm içeriði okunmus oluyor.
						}
						yaziAlani.setText(icerik);
		} catch (FileNotFoundException e1) {
		}}}
		});
		dosyaAc.setBounds(64, 319, 108, 23);
		contentPane.add(dosyaAc);
		
		JButton renkDegistir = new JButton("renk de\u011Fi\u015Ftir");
		renkDegistir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color color=JColorChooser.showDialog(FileChooserveColorChooser.this, "Bir Renk Saçin", Color.red);
				yaziAlani.setForeground(color);
				
			}
		});
		renkDegistir.setBounds(378, 319, 108, 23);
		contentPane.add(renkDegistir);
		
		JTextArea yaziAlani = new JTextArea();
		yaziAlani.setBounds(64, 29, 422, 257);
		contentPane.add(yaziAlani);
	}
}
