package www.person.manager;

import java.util.ArrayList;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Person {
	int no;
	String name;
	String phone;
	String address;
	String postCode;
	String birth;
	String img;
	ArrayList<Person> family;
	
	public Person() {
		super();
	}

	public Person(int no, String name, String phone, String address, String postCode, String birth, String img,
			ArrayList<Person> family) {
		super();
		this.no = no;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.postCode = postCode;
		this.birth = birth;
		this.img = img;
		this.family = family;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public ArrayList<Person> getFamily() {
		return family;
	}

	public void setFamily(ArrayList<Person> family) {
		this.family = family;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}
