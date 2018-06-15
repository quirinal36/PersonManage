package www.person.manager.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import www.person.manager.Person;

public class DButil {
	public int insertPerson(Person person) {
		int result = 0;
		DBconn db = new DBconn();
		Connection conn = null;
		try {
			String query = "INSERT INTO Person (name, birth, NUM) VALUES (?,?,?)";
			
			conn = db.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, person.getName());
			stmt.setString(2, person.getBirth());
			stmt.setInt(3, person.getNo());
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public int updatePerson(Person person) {
		int result = 0;
		DBconn db = new DBconn();
		Connection conn = null;
		StringBuilder query = new StringBuilder();
		query.append("UPDATE Person");
		query.append(" 	SET"); 
		query.append("	NUM=?,");
		query.append("	name=?,");
		query.append("	address=?,");
		query.append("	postCode=?,");
		query.append("	birth=?");
		query.append("	WHERE NUM = ?");
		try {
			conn = db.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query.toString());
			stmt.setInt(1, person.getNo());
			stmt.setString(2, person.getName());
			stmt.setString(3, person.getAddress());
			stmt.setString(4, person.getPostCode());
			stmt.setString(5, person.getBirth());
			stmt.setInt(6, person.getNo());
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public int deleteByNum(int num) {
		int result = 0;
		
		DBconn db = new DBconn();
		Connection conn = null;
		
		try {
			conn = db.getConnection();
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM Person WHERE NUM = ?");
			stmt.setInt(1, num);
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	public Person searchByNum(int no) {
		Person person = new Person();
		DBconn db = new DBconn();
		Connection conn = null;
		
		try {
			conn = db.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM new_schema.Person WHERE Num = ?");
			stmt.setInt(1, no);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				System.out.println("NUM:" + rs.getInt("NUM"));
				
				person.setNo(rs.getInt("NUM"));
				person.setName(rs.getString("name"));
				person.setBirth(rs.getString("birth"));
				person.setAddress(rs.getString("address"));
				person.setPostCode(rs.getString("postcode"));
				person.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return person;
	}
	public List<Person> searchByName(String name){
		List<Person> list = new ArrayList<>();
		DBconn db = new DBconn();
		Connection conn = null;
		try {
			conn = db.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Person WHERE name = ?");
			stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Person person = new Person();
				person.setNo(rs.getInt("NUM"));
				person.setName(rs.getString("name"));
				person.setBirth(rs.getString("birth"));
				
				list.add(person);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public List<Person> getPeople(){
		List<Person> list = new ArrayList<>();
		DBconn db = new DBconn();
		Connection conn = null;
		try {
			conn = db.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery("SELECT * FROM Person");
			while(rs.next()) {
				Person person = new Person();
				person.setNo(rs.getInt("NUM"));
				person.setName(rs.getString("name"));
				person.setBirth(rs.getString("birth"));
				person.setAddress(rs.getString("address"));
				person.setPostCode(rs.getString("postcode"));
				person.setPhone(rs.getString("phone"));
				
				list.add(person);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
