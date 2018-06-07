package www.person.manager;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ControlUtilImpl implements ControllUtil {

	@Override
	public Person addItem(JFrame parentComponent) {
		Person person = new Person();
		person.setName(JOptionPane.showInputDialog(parentComponent, "이름"));
		return person;
	}

	@Override
	public int updateItem(Person person) {
		return 0;
	}

	@Override
	public int deleteItem(int id) {
		return 0;
	}

	@Override
	public ArrayList<Person> getAllList() {
		return null;
	}

	@Override
	public ArrayList<Person> getSearchName(String search) {
		return null;
	}

}
