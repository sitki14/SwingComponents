package GrafikKullanimi;

import java.awt.HeadlessException;

import javax.swing.JFrame;

public class AnaEkran extends JFrame {
	
	public AnaEkran(String arg0) throws HeadlessException {
		super(arg0);
	}
	
	public static void main(String[] args) {
		GrafikKullanimi grafik=new GrafikKullanimi(); 
		AnaEkran ekran=new AnaEkran("Grafik Kullanýmý");
		ekran.setVisible(true);
		ekran.setResizable(true); //kenarýndan tutludugunda genýsletme ýsýne yarar.
		ekran.setSize(800,600);
		ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // carpý ya basýldýgýnda kapanma ozellýgý
		
		ekran.add(grafik);
		
		
		
	}

	

}
