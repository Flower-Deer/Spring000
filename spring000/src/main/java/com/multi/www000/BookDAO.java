package com.multi.www000;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class BookDAO {
	
	public ArrayList<BookDTO> list() {
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/winter";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password); // Connection

			String sql = "select * from book";
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery(); // r�� ����� table, cud�� ����(�����row��) //1
			while (rs.next()) { // ������� true�̸�!!
				BookDTO bag = new BookDTO();
				bag.setId(rs.getInt(1));
				bag.setName(rs.getString(2));
				bag.setUrl(rs.getString(3));
				bag.setImg(rs.getString(4));

				list.add(bag);
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

	// ����ϳ��� �޼��� �ϳ� ����(�˻� 1�� ���-row 1��)
	public BookDTO one(int id) {
		BookDTO bag = null; // �����Ⱚ!!--> ���� �ʱ�ȭ�����־����.!

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/winter";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password); // Connection

			String sql = "select * from book where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id); // 1�� ����ǥ�� id�� �����س��� ���� ��Ʈ������ �־���!

			ResultSet rs = ps.executeQuery(); // r�� ����� table, cud�� ����(�����row��) //1
			if (rs.next()) { // ������� true�̸�!!
				System.out.println("�˻������ ����.");
				bag = new BookDTO();
				bag.setId(rs.getInt(1));
				bag.setName(rs.getString(2));
				bag.setUrl(rs.getString(3));
				bag.setImg(rs.getString(4));
			}
			// dbó���� ���õ� �޸� �Ҵ�� �� ������������.
			ps.close();
			con.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// �޼����� ó���� �� ������, ����� �������� ����. �� ���� �����.
		return bag;
	} // one
	
	public void delete(int id) { // String id
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
			String sql = "delete from book where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id); 
			System.out.println("3. sql�� ���� ����.@@@@@");

			// 4. sql���� db������ ������. --> ����� ��� �Ǿ����� �ڹ����α׷� �˷���.
			String result2 = "����";
			try {
				int result = ps.executeUpdate(); // r�� ����� table, cud�� ����(�����row��) //1
				System.out.println("4. sql�� db������ ���� ����. @@@@@ �ݿ��� row�� >>" + result);
				if (result == 1) {
					result2 = "����";
				}
			} catch (Exception e) {
			}
			// JOptionPane.showMessageDialog(null, result2); //������ ����
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // delete
	
	public void insert(BookDTO bag) { // String id
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
			String sql = "insert into book values (null, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getName()); 
			ps.setString(2, bag.getUrl()); 
			ps.setString(3, bag.getImg()); 
			System.out.println("3. sql�� ���� ����.@@@@@");

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
			// JOptionPane.showMessageDialog(null, result2); //������ ����
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // insert
} // class
