package www.person.manager;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import www.person.manager.cantata.Index;

public class MainClass {
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				Index window = new Index();
				
			}
		});
		
	}

}
