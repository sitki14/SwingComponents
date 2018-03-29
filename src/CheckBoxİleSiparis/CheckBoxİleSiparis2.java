package CheckBoxÝleSiparis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.awt.event.ActionEvent;

public class CheckBoxÝleSiparis2 extends CheckBoxÝleSiparis {
	Map<String, Integer> siparisler =new LinkedHashMap<String , Integer >(); 

	private JFrame frame;
	
	private final JComboBox comboBox = new JComboBox();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckBoxÝleSiparis2 window = new CheckBoxÝleSiparis2();
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
	public CheckBoxÝleSiparis2() {
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
		
		JCheckBox iskender = new JCheckBox("ISKENDER - 15");
		iskender.setBounds(35, 48, 145, 23);
		frame.getContentPane().add(iskender);
		
		JCheckBox beyti = new JCheckBox("BEYTI - 12");
		beyti.setBounds(35, 74, 145, 23);
		frame.getContentPane().add(beyti);
		
		JCheckBox salata = new JCheckBox("SALATA - 5");
		salata.setBounds(35, 100, 145, 23);
		frame.getContentPane().add(salata);
		
		JCheckBox ayran = new JCheckBox("AYRAN - 2");
		ayran.setBounds(35, 126, 145, 23);
		frame.getContentPane().add(ayran);
		
		JLabel lblMen = new JLabel("MENU");
		lblMen.setBounds(35, 22, 46, 14);
		frame.getContentPane().add(lblMen);
		
		JButton siparisGoster = new JButton("SiparisGoster");
		siparisGoster.addActionListener(new ActionListener() {
			public void siparisleriGoster(){
					String message ="";
					int tutar = 0;
					if(siparisler.isEmpty()) {
						message="siparisiniz bulunmamaktadýr. ";
						
					}else {
						 message = "Siparisler \n";
						for(Map.Entry<String,Integer> entry : siparisler.entrySet()) {
							message +=entry.getKey() +"\n";
							tutar +=entry.getValue();
						}
						message +="Toplam tutar:"+tutar;
						
					}
					//JOptionPane.showMessageDialog(siparisGoster, this, message, tutar);
					JOptionPane.showMessageDialog(siparisGoster, message);
				}
			public void actionPerformed(ActionEvent arg0) {
				
				if(iskender.isSelected()) {
					siparisler.put("iskender", 15); // map secilmesinin nedeni iskender 1 kere ye mahsus kullanýlýyo olmasýdýr
					
					
				}else siparisler.remove("iskender");
				
				if(beyti.isSelected()) {
					siparisler.put("beyti", 12); 
					
					
				}else siparisler.remove("beyti");
				
				if(salata.isSelected()) {
					siparisler.put("salata", 5); 
					
					
				}else siparisler.remove("salata");
				
				if(ayran.isSelected()) {
					siparisler.put("ayran", 2); 
					
					
				}else siparisler.remove("ayran");
				
				siparisleriGoster();
				
				
				
				
				
			}
		});
		siparisGoster.setBounds(35, 198, 124, 23);
		frame.getContentPane().add(siparisGoster);
	}
}
