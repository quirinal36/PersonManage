package www.person.manager;

import java.util.ArrayList;

import javax.swing.JFrame;

public interface ControllUtil {

	// 생성
	public Person addItem(JFrame frame);
	// 수정
	public int updateItem(Person person);
	// 삭제
	public int deleteItem(int id);
	// 전체조회
	public ArrayList<Person> getAllList();
	// 검색
	public ArrayList<Person> getSearchName(String search);
}
