package swingDersleriProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.TextField;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Rectangle;

public class ders1 {
	private javax.swing.JTextField textField;
	private javax.swing.JButton týklaButonu;
	private JFrame frame;
	private int say=0;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ders1 window = new ders1();
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
	public ders1() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton týklaButonu = new JButton("TIKLA");
		týklaButonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				say++;
				System.out.println("butona "+say+"kere týklandý");
		     	textField.setBackground(Color.BLUE);
		     	textField.getBackground();
			/*	String internetAdresi=textField.getText();
				Desktop d=Desktop.getDesktop();
				try {
					d.browse(new URI(internetAdresi));
					
					
				} catch (IOException e1) {
				} catch (URISyntaxException e1) {
				}
				*/
				
			}
		});
		frame.getContentPane().add(týklaButonu, BorderLayout.NORTH);
		
		TextField textField = new TextField();
		textField.setBounds(new Rectangle(10, 10, 15, 5));
		textField.setSize(new Dimension(12, 10));
		textField.setSelectionStart(3);
		textField.setFont(new Font("Algerian", Font.PLAIN, 12));
		textField.setBackground(Color.RED);
		frame.getContentPane().add(textField, BorderLayout.CENTER);
	}

}
