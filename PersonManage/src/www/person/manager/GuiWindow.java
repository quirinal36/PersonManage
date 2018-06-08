package www.person.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GuiWindow extends JFrame implements ActionListener{
	Logger logger = Logger.getLogger(this.getName());
	
	public ArrayList<Person> list;
	
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
		addSomeInfo();
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		
		addButtons(panel);
	}
	private void addSomeInfo() {
		list.add(new Person(1, "nick", "01012345678", "nick 네 집", "5610", "921230"));
		list.add(new Person(2, "james", "01076456423", "james 네 집", "5611", "901229"));
		list.add(new Person(3, "kate", "01076512560", "kate 네 집", "5612", "911220"));
		list.add(new Person(4, "ronaldo", "01036751298", "ronaldo 네 집", "5613", "981210"));
		list.add(new Person(5, "mesi", "01001245786", "mesi 네 집", "5614", "991202"));
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
			list.add(person);
		}else if(e.getSource() == buttonDel) {
			int deleteItemId = Integer.parseInt(JOptionPane.showInputDialog("학생번호 입력"));
			util.deleteItem(deleteItemId, list);
		}else if(e.getSource() == buttonUpd) {
//			util.updateItem(person);
		}else if(e.getSource() == buttonSearch) {
			final String search = JOptionPane.showInputDialog(this, "검색할이름");
			ArrayList<Person> searchResult = util.getSearchName(search, list);
			if(searchResult != null) {
				util.showAll(searchResult);
			}
		}else if(e.getSource() == buttonShowAll) {
//			showAll();
			util.showAll(list);
		}
	}
	public void showAll() {
		Iterator<Person> iter = list.iterator();
		while(iter.hasNext()) {
			Person person = iter.next();
			logger.info(person.toString());
		}
	}
}
