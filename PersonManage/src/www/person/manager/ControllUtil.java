package www.person.manager;

import java.util.ArrayList;

public interface ControllUtil {

	// 생성
	public int addItem(Person person);
	// 수정
	public int updateItem(Person person);
	// 삭제
	public int deleteItem(int id);
	// 전체조회
	public ArrayList<Person> getAllList();
	// 검색
	public ArrayList<Person> getSearchName(String search);
}
