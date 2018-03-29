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
				String cevap= JOptionPane.showInputDialog("Kullan�c� �smi"); //b�r tane deger girecegiz bu deger tam girilmi� ise null d�nmeyecek.
				//herhangi bir deger girilmemi�se yani iptal e bas�lm�ssa null doner .
				
				if(cevap!=null) {
					//eger cevap null degilse b�z d�nen degeri jlist e eklemem�z gerek�r .
					if(cevap.trim().equals("")) {
						mesajYazisi.setText("Bos bir kullan�c� ismi girdniz");
					}// else durumunda kullan�c� normal b�r �s�m g�rm�s demekt�r.
					else {
						
						model.addElement(cevap.trim());// burada model referans�uzerinden l�ste ye kullan�c� ad�n� ekled�k.
						mesajYazisi.setText("kullan�c� basar�l� b�r sek�lde eklend�.");
					}
				}else mesajYazisi.setText("i�lem iptal edildi");
					
			}
		});
		ekle.setBounds(116, 11, 138, 28);
		contentPane.add(ekle);
		
		JButton sil = new JButton("Kullan\u0131c\u0131 Sil");
		sil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mesajYazisi.setText("");
				int selectedIndex=kullaniciListesi.getSelectedIndex(); //secti�imiz degeri d�nd�r�r.
				if(selectedIndex==-1) {
					//listemiz bos ise veya bir yere t�klamad�ysak -1 doner 
					if(model.getSize()==0) { 
						mesajYazisi.setText("Liste �u Anda Bo�.");
					}else {
						mesajYazisi.setText("L�tfen Silinecek Bir Sat�r Se�iniz.");
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
