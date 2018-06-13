package www.person.manager.cantata;

import java.util.ArrayList;

public class MainClass {

	public static void main(String[] args) {
		
		Person p1 = new Person();
		p1.setName("james");
		p1.setNo(1);
		Person p2 = new Person();
		p2.setName("tom");
		p2.setNo(2);
		
		ArrayList<Person> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		
//		System.out.println("list.size()::" + list.size());
		for(int i=0; i<list.size() ; i++) {
			Person person = list.get(i);
			String personInfo = person.toString();
			
			System.out.println(personInfo);
		}
	}

}
