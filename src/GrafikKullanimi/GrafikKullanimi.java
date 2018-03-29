package GrafikKullanimi;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GrafikKullanimi extends JPanel{

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.red);
		g.drawRect(100, 10, 30, 40); //içi bos dikdörtgen
		g.fillRect(200, 100, 30, 40); // içi dolu dikdörtgen
		g.setColor(Color.blue);
		g.drawOval(200, 200, 350, 300);
		g.fillOval(300, 300, 40 ,200);
		g.setColor(Color.YELLOW);
		g.drawLine(100, 100, 300,300);
		g.setColor(Color.MAGENTA);
	
	}

	public GrafikKullanimi() {
		super();
		setBackground(Color.BLACK);
	}
	

}
