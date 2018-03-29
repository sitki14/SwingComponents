package JListKullanimi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JListKullanimi extends JFrame {
	DefaultListModel model=new DefaultListModel();
	private JPanel contentPane;






	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JListKullanimi frame = new JListKullanimi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public JListKullanimi() {
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(314, 186, -216, -117);
		contentPane.add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(201, 198, 85, -58);
		contentPane.add(list_1);
		
		JList kullaniciListesi = new JList();
		kullaniciListesi.setBounds(51, 151, 488, 206);
		contentPane.add(kullaniciListesi);
		
		JLabel lblKullanclar = new JLabel("Kullan\u0131c\u0131lar");
		lblKullanclar.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblKullanclar.setBounds(84, 135, 85, 14);
		contentPane.add(lblKullanclar);
		
		JLabel mesajYazisi = new JLabel("");
		mesajYazisi.setForeground(Color.RED);
		mesajYazisi.setBounds(84, 82, 368, 14);
		contentPane.add(mesajYazisi);
		
		JButton ekle = new JButton("Kullan\u0131c\u0131 Ekle");
		
		ekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mesajYazisi.setText("");
				String cevap= JOptionPane.showInputDialog("Kullanýcý Ýsmi"); //býr tane deger girecegiz bu deger tam girilmiþ ise null dönmeyecek.
				//herhangi bir deger girilmemiþse yani iptal e basýlmýssa null doner .
				
				if(cevap!=null) {
					//eger cevap null degilse býz dönen degeri jlist e eklememýz gerekýr .
					if(cevap.trim().equals("")) {
						mesajYazisi.setText("Bos bir kullanýcý ismi girdniz");
					}// else durumunda kullanýcý normal býr ýsým gýrmýs demektýr.
					else {
						
						model.addElement(cevap.trim());// burada model referansýuzerinden lýste ye kullanýcý adýný ekledýk.
						mesajYazisi.setText("kullanýcý basarýlý býr sekýlde eklendý.");
					}
				}else mesajYazisi.setText("iþlem iptal edildi");
					
			}
		});
		ekle.setBounds(116, 11, 138, 28);
		contentPane.add(ekle);
		
		JButton sil = new JButton("Kullan\u0131c\u0131 Sil");
		sil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mesajYazisi.setText("");
				int selectedIndex=kullaniciListesi.getSelectedIndex(); //sectiðimiz degeri döndürür.
				if(selectedIndex==-1) {
					//listemiz bos ise veya bir yere týklamadýysak -1 doner 
					if(model.getSize()==0) { 
						mesajYazisi.setText("Liste Þu Anda Boþ.");
					}else {
						mesajYazisi.setText("Lütfen Silinecek Bir Satýr Seçiniz.");
					}
					
				}else {
					Object silinecekSatir=model.getElementAt(selectedIndex);
					model.removeElement(silinecekSatir);
				}
			}
		});
		sil.setBounds(341, 12, 138, 26);
		contentPane.add(sil);
		//model =(DefaultListModel) kullaniciListesi.getModel();
		kullaniciListesi.setModel(model);
	}
}
