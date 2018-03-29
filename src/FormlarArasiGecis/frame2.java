package FormlarArasiGecis;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frame2 extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame2 frame = new frame2();
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
	public frame2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblFrameYe = new JLabel("frame 2 ye gecildi");
		lblFrameYe.setBounds(156, 130, 221, 14);
		getContentPane().add(lblFrameYe);
		
		JButton btnForm = new JButton("form2 ");
		btnForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame1 f1=new frame1();
				f1.setVisible(true);
			}
		});
		btnForm.setBounds(176, 208, 89, 23);
		getContentPane().add(btnForm);
	}

}
