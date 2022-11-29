package com.multi.www000;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class AchievementDAO {
	
	public void insert(AchievementDTO bag) throws Exception { // String id
		System.out.println(bag); // toString()ȣ��, ���濡 ����ִ� ������ ����Ʈ
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Ư���� ��ġ�� �ִ� ����̹� ������ ���� �о�鿩 ����
			System.out.println("1. ����̹� ���� ����.@@@@");
			// 2. db���� mySQL: winter, oracle: xe
			String url = "jdbc:mysql://localhost:3306/winter";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			System.out.println("2. db���� ����.@@@@@@");
			// 3. sql���� �����.
			String sql = "insert into achievement values (null, ?, ?, ?)";
			// �غ�� ����(Preparedstatement)
			PreparedStatement ps = con.prepareStatement(sql);
			//ps.setInt(1, bag.getId()); // 1�� ����ǥ�� id�� �����س��� ���� ��Ʈ������ �־���!
			ps.setString(1, bag.getClasses()); // 2�� ����ǥ�� pw�� �����س��� ���� ��Ʈ������ �־���!
			ps.setString(2, bag.getName()); // 3�� ����ǥ�� name�� �����س��� ���� ��Ʈ������ �־���!
			ps.setString(3, bag.getGrade()); // 4�� ����ǥ�� tel�� �����س��� ���� ��Ʈ������ �־���!
			System.out.println("3. sql�� ���� ����.@@@@@");
			// String site = "http://www.naver.com";
			// Url url = new Url(site); //��üȭ!!
			// 4. sql���� db������ ������. --> ����� ��� �Ǿ����� �ڹ����α׷� �˷���.
			String result2 = "����";
			try {
				int result = ps.executeUpdate(); // r�� ����� table, cud�� ����(�����row��) //1
				System.out.println("4. sql�� db������ ���� ����. @@@@@ �ݿ��� row�� >>" + result);
				if (result == 1) {
					result2 = "����";
				}
			} catch (Exception e) {
				System.out.println("ȸ�����Խ� �����߻�");
			}
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // insert
	
	public int delete(String id) {
		int result = 0; //delete�� �ȵǾ�����.!

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. ����̹� ���� ����.@@@@");
			String url = "jdbc:mysql://localhost:3306/winter";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			System.out.println("2. db���� ����.@@@@@@");

			String sql = "delete from achievement where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id); // 1�� ����ǥ�� id�� �����س��� ���� ��Ʈ������ �־���!
			System.out.println("3. sql�� ���� ����.@@@@@");
			
			result = ps.executeUpdate(); // r�� ����� table, cud�� ����(�����row��) //1
			System.out.println("4. sql�� db������ ���� ����. @@@@@ �ݿ��� row�� >>" + result);
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	} // delete
	
	public ArrayList<AchievementDTO> list() {
		// vo�� �־��� Ŀ�ٶ� �ڽ������� �� �� ��ǰ�� ��� ����
		// ���������� ��� arraylist
		// MemberDTO�� ���� �� arraylist�ڽ��� �ϳ� �������.
		ArrayList<AchievementDTO> list = new ArrayList<AchievementDTO>();
		// 1. ����̹� ����- ����̹�(Ŀ����) �ε�
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Ư���� ��ġ�� �ִ� ����̹� ������ ���� �о�鿩 ����
			System.out.println("1. ����̹� ���� ����.@@@@");
			// 2. db���� mySQL: winter, oracle: xe
			String url = "jdbc:mysql://localhost:3306/winter";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			System.out.println("2. db���� ����.@@@@@@");
			// 3. sql���� �����.
			String sql = "select * from achievement";
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("3. sql�� ���� ����.@@@@@");
			// 4. sql���� db������ ������. --> ����� ��� �Ǿ����� �ڹ����α׷� �˷���.
			ResultSet rs = ps.executeQuery(); // r�� ����� table, cud�� ����(�����row��) //1
			// rs.next() true�� ����� ����. false�� ����� ����.
			// System.out.println("4. sql�� db������ ���� ����. @@@@@ �ݿ��� row�� >>" + rs.next());
			while (rs.next()) { // ������� true�̸�!!
				System.out.println("�˻������ ����.");
				// ������
				// 1. �� ���� ������ ����
				// 2. vo�� ������ش�.
				// 3. vo�� ������ ������ �־��ش�.
				// 4. vo�� list�� �־��ش�.
				int id = rs.getInt(1); // �÷��� ���� 1�� id�� ����
				String classes = rs.getString(2);
				String name = rs.getString(3);
				String grade = rs.getString(4);
				System.out.println("�˻��� ���>>" + id + " " + classes + " " + name + " " + grade);
				// UI���� ����ڰ� �˻��� ����� �� �� �־�� �Ѵ�.
				// 4���� �����͸� UI���� return!!������.
				// 1) ������ ����,
				AchievementDTO bag = new AchievementDTO();
				// 2) �����͸� �ְ�,
				bag.setId(id);
				bag.setClasses(classes);
				bag.setName(name);
				bag.setGrade(grade);
				list.add(bag);
				// 3) return����.(����)
			} // while
			System.out.println("box(list)�� �� ������ ����>> " + list.size());
			// dbó���� ���õ� �޸� �Ҵ�� �� ������������.
			ps.close();
			con.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// �޼����� ó���� �� ������, ����� �������� ����. �� ���� �����.
		return list;
	} // list
	
}