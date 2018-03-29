package RadioveCombobox;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RadioveCombobox2 {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RadioveCombobox2 window = new RadioveCombobox2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public RadioveCombobox2() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBoxDiller = new JComboBox();
		comboBoxDiller.setModel(new DefaultComboBoxModel(new String[] {"Python", "Java", "Cplusplus", "Php"}));
		comboBoxDiller.setBounds(120, 67, 154, 22);
		frame.getContentPane().add(comboBoxDiller);
		
		JButton Goster = new JButton("G\u00D6STER");
		Goster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String message ="Þu Diller Seçidi : "+comboBoxDiller.getSelectedItem();
				JOptionPane.showMessageDialog(Goster, message);
				
				
				
				
			}
		});
		Goster.setBounds(160, 163, 89, 23);
		frame.getContentPane().add(Goster);
	}

}
