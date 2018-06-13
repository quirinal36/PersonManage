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
			String query = "INSERT INTO Person (name, birth, Num) VALUES (?,?,?)";
			
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
