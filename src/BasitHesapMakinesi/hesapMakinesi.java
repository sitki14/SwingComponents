package BasitHesapMakinesi;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class hesapMakinesi extends JFrame {
	
	private int say=0;
	private JPanel contentPane;
	private JTextField birinciSayi;
	private JTextField ikinciSayi;
	private JTextField sonuc;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hesapMakinesi frame = new hesapMakinesi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public hesapMakinesi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 414, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("TOPLA");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				int birinci_sayi=Integer.valueOf(birinciSayi.getText());
				int ikinci_sayi=Integer.valueOf(ikinciSayi.getText());
				sonuc.setText(String.valueOf(birinci_sayi+ikinci_sayi));
				
			}
		});
		btnNewButton.setBounds(38, 128, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u00C7IKAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int birinci_sayi=Integer.valueOf(birinciSayi.getText());
				int ikinci_sayi=Integer.valueOf(ikinciSayi.getText());
				sonuc.setText(String.valueOf(birinci_sayi-ikinci_sayi));
			}
		});
		btnNewButton_1.setBounds(255, 128, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u00C7ARP");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int birinci_sayi=Integer.valueOf(birinciSayi.getText());
				int ikinci_sayi=Integer.valueOf(ikinciSayi.getText());
				sonuc.setText(String.valueOf(birinci_sayi*ikinci_sayi));
			}
		});
		btnNewButton_2.setBounds(38, 194, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("B\u00D6L");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int birinci_sayi=Integer.valueOf(birinciSayi.getText());
				int ikinci_sayi=Integer.valueOf(ikinciSayi.getText());
				sonuc.setText(String.valueOf((double)birinci_sayi/ikinci_sayi));
				
			}
		});
		btnNewButton_3.setBounds(255, 194, 89, 23);
		contentPane.add(btnNewButton_3);
		
		birinciSayi = new JTextField();
		birinciSayi.setBounds(86, 11, 86, 20);
		contentPane.add(birinciSayi);
		birinciSayi.setColumns(10);
		
		ikinciSayi = new JTextField();
		ikinciSayi.setBounds(222, 11, 86, 20);
		contentPane.add(ikinciSayi);
		ikinciSayi.setColumns(10);
		
		JLabel cevap = new JLabel("CEVAP");
		cevap.setBounds(159, 164, 72, 23);
		contentPane.add(cevap);
		
		sonuc = new JTextField();
		sonuc.setEditable(false);
		sonuc.setBounds(145, 84, 86, 20);
		contentPane.add(sonuc);
		sonuc.setColumns(10);
		
	}
}
