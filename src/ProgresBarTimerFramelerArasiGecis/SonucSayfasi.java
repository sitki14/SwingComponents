package ProgresBarTimerFramelerArasiGecis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SonucSayfasi {

	private JFrame sonucSayfasi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SonucSayfasi window = new SonucSayfasi();
					window.sonucSayfasi.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public SonucSayfasi() {
		initialize();
	}

	private void initialize() {
		sonucSayfasi = new JFrame();
		sonucSayfasi.setTitle("Sonu\u00E7 Sayfas\u0131");
		sonucSayfasi.setBounds(100, 100, 397, 149);
		sonucSayfasi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sonucSayfasi.getContentPane().setLayout(null);
		
		JLabel lblDosyaIndirmeTamamland = new JLabel("Dosya \u0130ndirme Tamamland\u0131");
		lblDosyaIndirmeTamamland.setBounds(42, 22, 179, 22);
		sonucSayfasi.getContentPane().add(lblDosyaIndirmeTamamland);
		
		JButton btnk = new JButton("\u00C7\u0131k\u0131\u015F");
		btnk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnk.setBounds(247, 62, 89, 23);
		sonucSayfasi.getContentPane().add(btnk);
	}


}
