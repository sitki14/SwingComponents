package ProgresBarTimerFramelerArasiGecis2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DosyaIndirmeSimulasyonu extends JFrame {
	private int say=0;

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DosyaIndirmeSimulasyonu frame = new DosyaIndirmeSimulasyonu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	
	public DosyaIndirmeSimulasyonu() {
		setTitle("Dosya \u0130ndirme Sim\u00FClasyonu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setBounds(47, 76, 472, 35);
		contentPane.add(progressBar);
		
		JButton btnNewButton = new JButton("\u0130ndirmeye Ba\u015Flat");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Timer timer=new Timer(1, null);
				timer.addActionListener(new ActionListener() { // time her çalýþtýðýnda bir akiyon yapmak istiyoruz
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						say++;
						progressBar.setValue(say);
						if(progressBar.getValue()==50) {
							//burada this dersek buradaki timer ý görüyo classý göremiyor
							//mesaj diyalog ta ok a basýp frame i kaybetmek için 
								JOptionPane.showMessageDialog(DosyaIndirmeSimulasyonu.this, "Ýndirme nin %50 si tamamlandý devam etmek için ok a basýnýz.");
						}
						if(progressBar.getValue()==100) {
						
						
							
							SonucSayfasi ss=new SonucSayfasi();
							ss.setVisible(true);
							setVisible(false);
							timer.stop();
							
							
						}
						
					}
				});
				timer.start();
				
				
				
			}
		});
		btnNewButton.setBounds(148, 183, 273, 23);
		contentPane.add(btnNewButton);
	}

}
