package StokUygulamasi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StokUygulamasi {

	private JFrame frame;
	private JTextField textFieldUrunIsmi;
	private JTextField textFieldFiyat;
	private JTable tableUrunTablosu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StokUygulamasi window = new StokUygulamasi();
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
	public StokUygulamasi() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 486, 497);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblrnIsmi = new JLabel("\u00DCr\u00FCn \u0130smi:");
		lblrnIsmi.setBounds(53, 34, 76, 14);
		frame.getContentPane().add(lblrnIsmi);
		
		JLabel lblKategori = new JLabel("Kategori:");
		lblKategori.setBounds(53, 68, 76, 14);
		frame.getContentPane().add(lblKategori);
		
		JLabel lblFiyat = new JLabel("Fiyat:");
		lblFiyat.setBounds(53, 102, 76, 14);
		frame.getContentPane().add(lblFiyat);
		
		textFieldUrunIsmi = new JTextField();
		textFieldUrunIsmi.setBounds(128, 31, 154, 20);
		frame.getContentPane().add(textFieldUrunIsmi);
		textFieldUrunIsmi.setColumns(10);
		
		JComboBox comboBoxKategori = new JComboBox();
		comboBoxKategori.setBounds(128, 64, 154, 22);
		comboBoxKategori.setModel(new DefaultComboBoxModel(new String[] {"K\u00DCLT\u00DCR", "YEMEK", "ELEKTRON\u0130K"}));
		frame.getContentPane().add(comboBoxKategori);
		
		textFieldFiyat = new JTextField();
		textFieldFiyat.setBounds(128, 100, 154, 20);
		frame.getContentPane().add(textFieldFiyat);
		textFieldFiyat.setColumns(10);
		
		JLabel labelMesaj = new JLabel("");
		labelMesaj.setBounds(27, 157, 347, 27);
		labelMesaj.setForeground(Color.RED);
		frame.getContentPane().add(labelMesaj);
		
		tableUrunTablosu = new JTable();
		tableUrunTablosu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//burada tablonun uzerindeki sat�r i�imiz kolayla�s�n diye t�klann row daki degerler 
				//textbox ve combobox ta d�ner 
				//bu sayede g�ncelleme i�leri cok daha pratikle�ir.
				
				DefaultTableModel model=(DefaultTableModel) tableUrunTablosu.getModel();
				int seciliRow=tableUrunTablosu.getSelectedRow();
				textFieldUrunIsmi.setText(model.getValueAt(seciliRow, 0).toString());//obje d�nd��� i�in to String yap�ld�
				comboBoxKategori.setSelectedItem(model.getValueAt(seciliRow, 1).toString());
				textFieldFiyat.setText( model.getValueAt(seciliRow, 2).toString());
			}
		});
		tableUrunTablosu.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u00DCr\u00FCn \u0130smi", "Kategori", "Fiyat"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableUrunTablosu.getColumnModel().getColumn(0).setResizable(false);
		tableUrunTablosu.getColumnModel().getColumn(1).setPreferredWidth(76);
		tableUrunTablosu.getColumnModel().getColumn(2).setPreferredWidth(80);
		tableUrunTablosu.setBounds(27, 220, 347, 227);
		frame.getContentPane().add(tableUrunTablosu);
		
		JButton btnrnEkle = new JButton("\u00DCr\u00FCn Ekle");
		btnrnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				labelMesaj.setText(""); //labelin i�ini bosaltt�k
				DefaultTableModel model=(DefaultTableModel) tableUrunTablosu.getModel();
				if(textFieldUrunIsmi.getText().equals("")) { 
					/* bu sekilde �nce �r�nismi text field imizi ald�k 
					sonra i�indeki degeri d�nd�rduk sonra trim ile bas�nda
					ve sonunda bulunan bosluklar� s�ld�k ve en saon kalan
					deger bos ise diye if ile durumu kontrol alt�na ald�k.*/
					labelMesaj.setText("�r�n ismi bo� b�rak�lamaz...");
				}else {
					Object[] arr= {textFieldUrunIsmi.getText(),comboBoxKategori.getSelectedItem().toString(),textFieldFiyat.getText()};
					model.addRow(arr);
				}
				
				
				
				
				
				
			}
		});
		btnrnEkle.setBounds(344, 30, 99, 23);
		frame.getContentPane().add(btnrnEkle);
		
		JLabel lblrnIsmi_1 = new JLabel("\u00DCR\u00DCN \u0130SM\u0130");
		lblrnIsmi_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblrnIsmi_1.setForeground(new Color(64, 64, 64));
		lblrnIsmi_1.setBackground(new Color(0, 0, 0));
		lblrnIsmi_1.setBounds(53, 206, 76, 14);
		frame.getContentPane().add(lblrnIsmi_1);
		
		JLabel lblKategori_1 = new JLabel("KATEGOR\u0130");
		lblKategori_1.setForeground(Color.DARK_GRAY);
		lblKategori_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblKategori_1.setBounds(163, 206, 66, 14);
		frame.getContentPane().add(lblKategori_1);
		
		JLabel lblFiyat_1 = new JLabel("F\u0130YAT");
		lblFiyat_1.setForeground(Color.DARK_GRAY);
		lblFiyat_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblFiyat_1.setBounds(289, 206, 46, 14);
		frame.getContentPane().add(lblFiyat_1);
		
		JButton buttonUrunGuncelle = new JButton("\u00DCr\u00FCn G\u00FCncelle");
		buttonUrunGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelMesaj.setText(""); 
				DefaultTableModel model=(DefaultTableModel) tableUrunTablosu.getModel();
				int seciliRow=tableUrunTablosu.getSelectedRow(); // hangi row a t�klanm�ssa o row un de�erini bize s�yleyecek.
				if(seciliRow==-1) {
					//bu durumda 2 ihtimal var ya tabloda veri yok 
					// ya da tablodaki sat�rlar�n b�r�ne t�klanm�yo 
					//bu durumu da kontrol etmem�z gerek�r
					if(tableUrunTablosu.getRowCount()==0) { //TABLONUN SATIR AYISINI ALIR
						labelMesaj.setText("Tabloya �r�n ekleyiniz.");
					}else labelMesaj.setText("L�tfen tablodan 1 sat�r sa�iniz.");
				}else {
					model.setValueAt(textFieldUrunIsmi.getText(), seciliRow, 0);
					//burada secili row un -1 d�nmedi�indeki duruma bak�l�r
					// bu durumda hangi �e�n� g�ncelleyecegimizi belirtmemiz gerekir
					// �r�n ismini g�ncelleyece�i
					// secili row ne d�n�yosa o sat�r de�i�tirece�iz 
					// ve son olarak �r�n ismi 0. column da oldugundan 0 � seceriz
					model.setValueAt(comboBoxKategori.getSelectedItem(), seciliRow, 1);
					model.setValueAt(textFieldFiyat.getText(), seciliRow, 2);
					labelMesaj.setText("�r�n Ba�ar�yla G�ncellendi.");
				}
				
				
				
				
			}
		});
		buttonUrunGuncelle.setBounds(344, 78, 99, 23);
		frame.getContentPane().add(buttonUrunGuncelle);
		
		JButton btnNewButton = new JButton("�r�n Sil");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel) tableUrunTablosu.getModel();
				int seciliRow=tableUrunTablosu.getSelectedRow();
				if(seciliRow==-1) {
					if(tableUrunTablosu.getRowCount()==0) {
						labelMesaj.setText("�r�n Tablosu Bo�.");
					}else labelMesaj.setText("Silinecek bir �r�n se�iniz.");
					
				}else {
					model.removeRow(seciliRow);
				labelMesaj.setText("�r�n ba�ar�yla silindi");
				}
				
				
			}
		});
		btnNewButton.setBounds(344, 126, 99, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
