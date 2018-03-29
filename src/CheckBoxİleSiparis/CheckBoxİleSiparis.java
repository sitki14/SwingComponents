package CheckBox›leSiparis;

import java.awt.EventQueue;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckBox›leSiparis {
	Set<String> set=new LinkedHashSet<String>();

	private JFrame frmSipariUygulamas;
	/**
	 * @wbp.nonvisual location=551,379
	 */
	private final JLabel label = new JLabel("New label");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckBox›leSiparis window = new CheckBox›leSiparis();
					window.frmSipariUygulamas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CheckBox›leSiparis() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSipariUygulamas = new JFrame();
		frmSipariUygulamas.setTitle("Sipari\u015F Uygulamas\u0131");
		frmSipariUygulamas.setBounds(100, 100, 450, 300);
		frmSipariUygulamas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSipariUygulamas.getContentPane().setLayout(null);
		
		JCheckBox javaCheckBox = new JCheckBox("JAVA");
		javaCheckBox.setBounds(21, 22, 97, 23);
		frmSipariUygulamas.getContentPane().add(javaCheckBox);
		
		JCheckBox pythonChechBox = new JCheckBox("PYTHON");
		pythonChechBox.setBounds(157, 22, 97, 23);
		frmSipariUygulamas.getContentPane().add(pythonChechBox);
		
		JCheckBox cplusplusCheckBox = new JCheckBox("C++");
		cplusplusCheckBox.setBounds(302, 22, 97, 23);
		frmSipariUygulamas.getContentPane().add(cplusplusCheckBox);
		
		JLabel diller = new JLabel("\u015Eu Diller Se\u00E7ildi:");
		diller.setBounds(21, 149, 347, 14);
		frmSipariUygulamas.getContentPane().add(diller);
		
		JButton goster = new JButton("G\u00F6ster");
		
		
		
		
		
		goster.addActionListener(new ActionListener() {
			public void labelDegistir(){
				String yazi="ﬁu diller seÁildi : ";
				for(String dil:set) {
					yazi +=dil +"  ";
					
				}
				diller.setText(yazi);
			
		}
			public void actionPerformed(ActionEvent arg0) {
				if(javaCheckBox.isSelected()) {
					set.add("java");
					
				}else set.remove("java");
				
				if(pythonChechBox.isSelected()) {
					set.add("python");
					
				}else set.remove("python");
				
				if(cplusplusCheckBox.isSelected()) {
					set.add("C++");
					
				}else set.remove("C++");
				
				labelDegistir();
				
				
				
			}
		});
		goster.setBounds(165, 81, 89, 23);
		frmSipariUygulamas.getContentPane().add(goster);
	}
}
