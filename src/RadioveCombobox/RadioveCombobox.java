package RadioveCombobox;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedHashSet;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class RadioveCombobox {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	
	Set<String> diller=new LinkedHashSet<String>();
	private JRadioButton pythonRadio;
	private  JRadioButton javaRadio;
	private JRadioButton phpRadio;
	private ButtonGroup bg=new ButtonGroup(); 
	/* radio button lara sadece 1 tane sýný secmesýný saglamak ýcýn 
	once 1 tane radýo button group olusturduk sonra bu buttonlarý 
	bu gruba dahýl ettýk ve iþlem tamamlandý.:D*/
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RadioveCombobox window = new RadioveCombobox();
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
	public RadioveCombobox() {
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
		
		JRadioButton javaRadio = new JRadioButton("JAVA");
		javaRadio.setBounds(56, 28, 109, 23);
		frame.getContentPane().add(javaRadio);
		
		pythonRadio = new JRadioButton("PYTHON");
		pythonRadio.setBounds(56, 79, 109, 23);
		frame.getContentPane().add(pythonRadio);
		
		JRadioButton phpRadio = new JRadioButton("PHP");
		phpRadio.setBounds(56, 129, 109, 23);
		frame.getContentPane().add(phpRadio);
		
		bg.add(javaRadio);
		bg.add(pythonRadio);
		bg.add(phpRadio);
		
		
		JButton goster = new JButton("G\u00D6STER");
		
		goster.addActionListener(new ActionListener() {
			private void goster() {
				String message="Þu Diller Seçildi : ";
				for(String dil:diller) {
					message +=dil + " ";
				}
				//JOptionPane.showMessageDialog(goster,this,"BÝLGÝ KUTUSU", 0);
				//JOptionPane.showConfirmDialog(goster, message);
				//JOptionPane.showInputDialog(message);
				JOptionPane.showMessageDialog(goster, message);
				
				
				
				
				for(int i=0;i<diller.size();i++) {
					System.out.println("merhaba");
				
			}}
			public void actionPerformed(ActionEvent e) {
				if(javaRadio.isSelected()) {
					diller.add("JAVA");
				}else diller.remove("JAVA");
				if(pythonRadio.isSelected()) {
					diller.add("PYTHON");
				}else diller.remove("PYTHON");
				if(phpRadio.isSelected()) {
					diller.add("PHP");
				}else diller.remove("PHP");
				
				goster();
				
			}

			
				
			
		});
		goster.setBounds(118, 212, 89, 23);
		frame.getContentPane().add(goster);
	}
}
