package JPasswordFieldKullaniciGirisi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;


import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class JPasswordFieldKullaniciGirisi {

	private JFrame frame;
	private JTextField kullaniciAdi;
	private JPasswordField parola;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPasswordFieldKullaniciGirisi window = new JPasswordFieldKullaniciGirisi();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JPasswordFieldKullaniciGirisi() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton giris = new JButton("G\u0130R\u0130\u015E YAP");
		giris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String kullanici_Adi=kullaniciAdi.getText();
				String parola_=new String(parola.getPassword());//cahr array dönüyo bunu string e dönüþtürürüz 
				String message;
				if(kullanici_Adi.equals("sitki_")&&parola_.equals("12345")) {
					message="HOÞGELDÝZNÝZ. " + kullanici_Adi;
					JOptionPane.showMessageDialog(  giris, this, message, 0);
					System.exit(1000);
				}
				else if(!kullanici_Adi.equals("sitki_")&&parola_.equals("12345")) {
					message="Kullanýcý Adý Hatalý";
					
				}else if(kullanici_Adi.equals("sitki_")&&!parola_.equals("12345")) {
					message="Parola Hatalý";
					
				}else {
					message ="Kullanýcý Adý ve Parola Hatalý";
					}
			
				
				JOptionPane.showMessageDialog(  giris, this, message, 0); //this --> ben bu obje üzerinde bir tane mesaj diyalog olusturmak istiyorum
				parola.setText("");  // message diyalog tan sontra ok a basýlýnca alanlarý temýzler 
				kullaniciAdi.setText("");
				
			}
			
		});
		giris.setBounds(245, 191, 89, 23);
		frame.getContentPane().add(giris);
		
		kullaniciAdi = new JTextField();
		kullaniciAdi.setBounds(174, 88, 160, 20);
		frame.getContentPane().add(kullaniciAdi);
		kullaniciAdi.setColumns(10);
		
		parola = new JPasswordField();
		parola.setBounds(174, 35, 160, 20);
		frame.getContentPane().add(parola);
		
		JLabel lblParola = new JLabel("PAROLA");
		lblParola.setBounds(72, 38, 46, 14);
		frame.getContentPane().add(lblParola);
		
		JLabel lblKullancAd = new JLabel("KULLANICI ADI");
		lblKullancAd.setBounds(72, 91, 114, 14);
		frame.getContentPane().add(lblKullancAd);
	}
}
