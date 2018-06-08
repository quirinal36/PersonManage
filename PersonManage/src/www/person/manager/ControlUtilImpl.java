package www.person.manager;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ControlUtilImpl implements ControllUtil {

	@Override
	public Person addItem(JFrame parentComponent) {
		Person person = new Person();
		person.setName(JOptionPane.showInputDialog(parentComponent, "이름"));
		person.setBirth(JOptionPane.showInputDialog(parentComponent, "생년월일"));
		return person;
	}

	@Override
	public void updateItem(Person person, ArrayList<Person> list) {
		Iterator<Person> iter = list.iterator();
		while(iter.hasNext()) {
			Person item = iter.next();
			if(item.getNo() == person.getNo()) {
				item = person;
			}
		}
	}

	@Override
	public void deleteItem(int id, final ArrayList<Person> list) {
		for(int i=0; i<list.size(); i++) {
			Person person = list.get(i);
			if(person.getNo() == id) {
				list.remove(person);
			}
		}
		
	}

	@Override
	public ArrayList<Person> getSearchName(String search, ArrayList<Person> list) {
		ArrayList<Person> result = new ArrayList<>();
		for(int i=0; i<list.size(); i++) {
			Person person = list.get(i);
			if(person.getName().contains(search)) {
				result.add(person);
			}
		}
		return result;
	}

	@Override
	public void showAll(ArrayList<Person> list) {
		Iterator<Person> iter = list.iterator();
		while(iter.hasNext()) {
			Person person = iter.next();
			System.out.println(person.toString());
		}
	}
}
