package HarfveKelimeSayisi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Dialog.ModalExclusionType;
import java.awt.Cursor;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class HarfveKelimeSayisi {
	
	
	private JFrame frmKelimeVeHarf;
	private JLabel kelimeSayisi_1;
	private JLabel harfSayisi;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HarfveKelimeSayisi window = new HarfveKelimeSayisi();
					window.frmKelimeVeHarf.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HarfveKelimeSayisi() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmKelimeVeHarf = new JFrame();
		frmKelimeVeHarf.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmKelimeVeHarf.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frmKelimeVeHarf.getContentPane().setLayout(null);
		
		JTextArea yaziAlani = new JTextArea();
		yaziAlani.setBounds(39, 65, 342, 112);
		frmKelimeVeHarf.getContentPane().add(yaziAlani);
		
		JButton islemYap = new JButton("\u0130\u015ELEM YAP");
		islemYap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String yazi=yaziAlani.getText();
				int karakterSayisi=0;
				int KelimeSayisi=0;
				
/*Harf*/				for(int i=0;i<yazi.length();i++) {
					if(yazi.charAt(i)!=' ') { // indinin üzerindeki bosluk deðilse karakter sayýsýný bir artýrýr. 
						karakterSayisi++;
					}
				}
				
/*Kelime*/		String []arr=yazi.split(" "); // split methodu ile yazý yý bosluk a göre ayýrdýk ve arr nýn içine attýk
				for(String kelime:arr) { 
					KelimeSayisi++;
				}
				
				kelimeSayisi_1.setText("Kelime Sayýsý : "+KelimeSayisi);
				harfSayisi.setText("Harf Sayýsý : "+karakterSayisi);
				
				
				
				
				
				
				
			}
		});
		islemYap.setBounds(174, 202, 89, 23);
		frmKelimeVeHarf.getContentPane().add(islemYap);
		
		kelimeSayisi_1 = new JLabel("Kelime Sayisi");
		kelimeSayisi_1.setBounds(77, 32, 141, 14);
		frmKelimeVeHarf.getContentPane().add(kelimeSayisi_1);
		
		harfSayisi = new JLabel("Harf Say\u0131s\u0131");
		harfSayisi.setBounds(283, 32, 111, 14);
		frmKelimeVeHarf.getContentPane().add(harfSayisi);
		frmKelimeVeHarf.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frmKelimeVeHarf.setTitle("Kelime ve Harf Say\u0131s\u0131");
		frmKelimeVeHarf.setBounds(100, 100, 450, 300);
		frmKelimeVeHarf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
