package com.multi.www000;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

//��Ű��(Compinent�ձ���).Ŭ����(Compinent)
import org.springframework.stereotype.Component;

//MemberDAO dao = MemberDAO.getInstance(); ==> dao�� �ּҰ� ������� ����!
@Component //�������� MemberDAO�� �̱������� ���� �غ�����~!!
public class MemberDAO {
	
	public ArrayList<MemberDTO> list() {
		// vo�� �־��� Ŀ�ٶ� �ڽ������� �� �� ��ǰ�� ��� ����
		// ���������� ��� arraylist
		// MemberDTO�� ���� �� arraylist�ڽ��� �ϳ� �������.
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
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
			String sql = "select * from member";
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
				String id2 = rs.getString(1); // �÷��� ���� 1�� id�� ����
				String pw = rs.getString("pw");
				String name = rs.getString(3);
				String tel = rs.getString(4);
				System.out.println("�˻��� ���>>" + id2 + " " + pw + " " + name + " " + tel);
				// UI���� ����ڰ� �˻��� ����� �� �� �־�� �Ѵ�.
				// 4���� �����͸� UI���� return!!������.
				// 1) ������ ����,
				MemberDTO bag = new MemberDTO();
				// 2) �����͸� �ְ�,
				bag.setId(id2);
				bag.setPw(pw);
				bag.setName(name);
				bag.setTel(tel);
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
	// ����ϳ��� �޼��� �ϳ� ����(�˻� 1�� ���-row 1��)
	public int login(MemberDTO bag) {
		// ���޵� �� ����� ���޵Ǿ����� Ȯ���ϴ� ������ ����.
		System.out.println(bag);
		// 1. ����̹� ����- ����̹�(Ŀ����) �ε�
		// db�� ����, ������ ���� �ſ� ����.
		// �ʿ��� �� �ٿ�ε� �޾� ��� ��.
		int result = 0; // 0�� ���, ���ж�� ����.!
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
			String sql = "select * from member where id = ? and pw = ?"; // 1, 2�� 2���� ����ǥ ��ȣ
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getId()); // 1�� ����ǥ�� id�� �����س��� ���� ��Ʈ������ �־���!
			ps.setString(2, bag.getPw());
			System.out.println("3. sql�� ���� ����.@@@@@");
			// 4. sql���� db������ ������. --> ����� ��� �Ǿ����� �ڹ����α׷� �˷���.
			ResultSet rs = ps.executeQuery(); // r�� ����� table, cud�� ����(�����row��) //1
			// rs.next() true�� ����� ����. false�� ����� ����.
			// System.out.println("4. sql�� db������ ���� ����. @@@@@ �ݿ��� row�� >>" + rs.next());
			if (rs.next()) { // ������� true�̸�!!
				System.out.println("�˻������ ����.");
				result = 1;
				// 3) return����.(����)
			}
			// dbó���� ���õ� �޸� �Ҵ�� �� ������������.
			ps.close();
			con.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// �޼����� ó���� �� ������, ����� �������� ����. �� ���� �����.
		return result;
	} // login
	// ����ϳ��� �޼��� �ϳ� ����(�˻� 1�� ���-row 1��)
	public MemberDTO one(String id) {
		// ���޵� �� ����� ���޵Ǿ����� Ȯ���ϴ� ������ ����.
		System.out.println(id);
		// 1. ����̹� ����- ����̹�(Ŀ����) �ε�
		// db�� ����, ������ ���� �ſ� ����.
		// �ʿ��� �� �ٿ�ε� �޾� ��� ��.
		MemberDTO bag = null; // �����Ⱚ!!--> ���� �ʱ�ȭ�����־����.!
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
			String sql = "select * from member where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id); // 1�� ����ǥ�� id�� �����س��� ���� ��Ʈ������ �־���!
			System.out.println("3. sql�� ���� ����.@@@@@");
			// String site = "http://www.naver.com";
			// Url url = new Url(site); //��üȭ!!
			// 4. sql���� db������ ������. --> ����� ��� �Ǿ����� �ڹ����α׷� �˷���.
			ResultSet rs = ps.executeQuery(); // r�� ����� table, cud�� ����(�����row��) //1
			// rs.next() true�� ����� ����. false�� ����� ����.
			// System.out.println("4. sql�� db������ ���� ����. @@@@@ �ݿ��� row�� >>" + rs.next());
			if (rs.next()) { // ������� true�̸�!!
				System.out.println("�˻������ ����.");
				String id2 = rs.getString(1); // �÷��� ���� 1�� id�� ����
				String pw = rs.getString("pw");
				String name = rs.getString(3);
				String tel = rs.getString(4);
				System.out.println("�˻��� ���>>" + id2 + " " + pw + " " + name + " " + tel);
				// UI���� ����ڰ� �˻��� ����� �� �� �־�� �Ѵ�.
				// 4���� �����͸� UI���� return!!������.
				// 1) ������ ����,
				bag = new MemberDTO();
				// 2) �����͸� �ְ�,
				bag.setId(id2);
				bag.setPw(pw);
				bag.setName(name);
				bag.setTel(tel);
				// 3) return����.(����)
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
	// ����ϳ��� �޼��� �ϳ� ����(��ϱ��)
	public void insert(MemberDTO bag) { // String id
		System.out.println(bag); // toString()ȣ��, ���濡 ����ִ� ������ ����Ʈ
		// �ڹٿ��� DBMS�� �����Ϸ��� ��.
		// JDBC ���α׷��� ����
		// 4�ܰ� ����
		// 1. ����̹� ����- ����̹�(Ŀ����) �ε�
		// db�� ����, ������ ���� �ſ� ����.
		// �ʿ��� �� �ٿ�ε� �޾� ��� ��.
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
			String sql = "insert into member values (?, ?, ?, ?)";
			// �غ�� ����(Preparedstatement)
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getId()); // 1�� ����ǥ�� id�� �����س��� ���� ��Ʈ������ �־���!
			ps.setString(2, bag.getPw()); // 2�� ����ǥ�� pw�� �����س��� ���� ��Ʈ������ �־���!
			ps.setString(3, bag.getName()); // 3�� ����ǥ�� name�� �����س��� ���� ��Ʈ������ �־���!
			ps.setString(4, bag.getTel()); // 4�� ����ǥ�� tel�� �����س��� ���� ��Ʈ������ �־���!
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
			//JOptionPane.showMessageDialog(null, result2);  //������ ����
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // insert
	// ����ϳ��� �޼��� �ϳ� ����(Ż����)
	public int delete(String id) {
		int result = 0; //delete�� �ȵǾ�����.!
		// �ڹٿ��� DBMS�� �����Ϸ��� ��.
		// JDBC ���α׷��� ����
		// 4�ܰ� ����
		// 1. ����̹� ����- ����̹�(Ŀ����) �ε�
		// db�� ����, ������ ���� �ſ� ����.
		// �ʿ��� �� �ٿ�ε� �޾� ��� ��.
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Ư���� ��ġ�� �ִ� ����̹� ������ ���� �о�鿩 ����
			System.out.println("1. ����̹� ���� ����.@@@@");
			// 2. db���� mySQL: school, oracle: xe
			String url = "jdbc:mysql://localhost:3306/winter";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			System.out.println("2. db���� ����.@@@@@@");
			// 3. sql���� �����.
			String sql = "delete from member where id = ?";
			// �غ�� ����(Preparedstatement)
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id); // 1�� ����ǥ�� id�� �����س��� ���� ��Ʈ������ �־���!
			System.out.println("3. sql�� ���� ����.@@@@@");
			// String site = "http://www.naver.com";
			// Url url = new Url(site); //��üȭ!!
			// 4. sql���� db������ ������. --> ����� ��� �Ǿ����� �ڹ����α׷� �˷���.
			result = ps.executeUpdate(); // r�� ����� table, cud�� ����(�����row��) //1
			System.out.println("4. sql�� db������ ���� ����. @@@@@ �ݿ��� row�� >>" + result);
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	} // delete
} // class