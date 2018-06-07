package www.person.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GuiWindow extends JFrame implements ActionListener{
	ControllUtil util;
	
	JButton buttonAdd;
	JButton buttonDel;
	JButton buttonUpd;
	JButton buttonSearch;
	
	/**
	 * 생성자
	 */
	public GuiWindow() {
		util = new ControlUtilImpl();
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		
		addButtons(panel);
	}

	private void addButtons(JPanel panel) {
		buttonAdd = new JButton("추가");
		buttonDel = new JButton("삭제");
		buttonUpd = new JButton("수정");
		buttonSearch = new JButton("검색");
		
		panel.add(buttonUpd);
		panel.add(buttonDel);
		panel.add(buttonAdd);
		panel.add(buttonSearch);
		
		buttonAdd.addActionListener(this);
		buttonDel.addActionListener(this);
		buttonUpd.addActionListener(this);
		buttonSearch.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttonAdd) {
			util.addItem(person);
		}else if(e.getSource() == buttonDel) {
			util.deleteItem(id);
		}else if(e.getSource() == buttonUpd) {
			util.updateItem(person);
		}else if(e.getSource() == buttonSearch) {
			util.getSearchName(search);
		}
	}
}