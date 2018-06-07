package www.person.manager;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainClass {
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				GuiWindow window = new GuiWindow();
				window.setTitle("학생관리 프로그램");
				window.setSize(500, 300);
				window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				window.setVisible(true);
			}
		});
		
	}

}
