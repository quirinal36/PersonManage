package www.person.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GuiWindow extends JFrame implements ActionListener{
	Logger logger = Logger.getLogger(this.getName());
	
	public static ArrayList<Person> list;
	
	ControllUtil util;
	
	JButton buttonAdd;
	JButton buttonDel;
	JButton buttonUpd;
	JButton buttonSearch;
	JButton buttonShowAll;
	
	/**
	 * 생성자
	 */
	public GuiWindow() {
		util = new ControlUtilImpl();
		list = new ArrayList<Person>();
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		
		addButtons(panel);
	}

	private void addButtons(JPanel panel) {
		buttonAdd = new JButton("추가");
		buttonDel = new JButton("삭제");
		buttonUpd = new JButton("수정");
		buttonSearch = new JButton("검색");
		buttonShowAll = new JButton("현재 상태 보기");
		
		panel.add(buttonShowAll);
		panel.add(buttonUpd);
		panel.add(buttonDel);
		panel.add(buttonAdd);
		panel.add(buttonSearch);
		
		buttonShowAll.addActionListener(this);
		buttonAdd.addActionListener(this);
		buttonDel.addActionListener(this);
		buttonUpd.addActionListener(this);
		buttonSearch.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttonAdd) {
			Person person = util.addItem(this);
			logger.info(person.toString());
			list.add(person);
			
		}else if(e.getSource() == buttonDel) {
//			util.deleteItem(id);
		}else if(e.getSource() == buttonUpd) {
//			util.updateItem(person);
		}else if(e.getSource() == buttonSearch) {
//			util.getSearchName(search);
		}else if(e.getSource() == buttonShowAll) {
			showAll();
		}
	}
	public void showAll() {
		Iterator<Person> iter = list.iterator();
		while(iter.hasNext()) {
			logger.info(iter.next().toString());
		}
	}
}
