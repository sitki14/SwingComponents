package ProgresBarTimerFramelerArasiGecis;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.ProgressMonitor;
import javax.swing.Timer;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {
	private int say=0;
	
	private JFrame frmDosyaIndirmeSimlasyonu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmDosyaIndirmeSimlasyonu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDosyaIndirmeSimlasyonu = new JFrame();
		frmDosyaIndirmeSimlasyonu.setTitle("Dosya \u0130ndirme Sim\u00FClasyonu");
		frmDosyaIndirmeSimlasyonu.setBounds(100, 100, 719, 456);
		frmDosyaIndirmeSimlasyonu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDosyaIndirmeSimlasyonu.getContentPane().setLayout(null);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(129, 181, 418, 35);
		frmDosyaIndirmeSimlasyonu.getContentPane().add(progressBar);
		
		JButton dosyaindir = new JButton("Dosya \u0130ndirmeyi Ba\u015Flat");
		dosyaindir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Timer timer=new Timer(50,null); 
				
				
				timer.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						say++;
						SonucSayfasi sonucSayfasi=new SonucSayfasi();
						//	setVisible(true);
						progressBar.setValue(say);
						if(progressBar.getValue()==100) {
							//JOptionPane.showMessageDialog(progressBar, "Dosya indirme iþlemi tamamlandi");
							
							//progressBar.setVisible(false);
							timer.stop();
							
							
							
						//	System.exit(0);
						}
						
					}

					

					
					
				});
		timer.start();
				
				
				
				
				
				
				
				
			}
		});
		dosyaindir.setBounds(245, 281, 182, 23);
		frmDosyaIndirmeSimlasyonu.getContentPane().add(dosyaindir);
	}
}
