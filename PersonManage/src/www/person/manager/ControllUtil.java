package www.person.manager;

import java.util.ArrayList;

import javax.swing.JFrame;

public interface ControllUtil {

	// 생성
	public Person addItem(JFrame frame);
	// 수정
	public void updateItem(Person person, ArrayList<Person> list);
	// 삭제
	public void deleteItem(int id, ArrayList<Person> list);
	// 특정 이름 검색
	public ArrayList<Person> getSearchName(String search, ArrayList<Person> list);
	// 전체 출력
	public void showAll(ArrayList<Person> list);
}
