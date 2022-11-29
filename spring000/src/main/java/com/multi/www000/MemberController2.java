package com.multi.www000;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //�������� ��Ʈ�ѷ� ������ �ϴ� Ŭ������� ���!!
public class MemberController2 {
	
	@Autowired //�̹� ���� �غ�� MemberDAO��ü�� �ּҸ� ã�Ƽ�, �ڵ����� �� �ּҸ� �Ʒ��� ������ dao�� �־��ּ���@@
	MemberDAO dao; // ex) dao ="�޺�����"������ : �ּ� �ڵ����� ã����
	
	//ȸ������ó��
	@RequestMapping("insert.multi")   //MemberDAO dao=������Ÿ��
	public void insert(MemberDTO bag, MemberDAO dao) {
		//�޼����Է��Ķ���ͷ� bag������ �������ָ�
		//�Ʒ��� 1-1, 1-2, 1-3�� �������� ����.
		//   1-1) �����͸� �޾ƶ�!
		//   1-2) bag�� ����!
	    //   1-3) bag�� ���� �־��.!
		//        set~()�޼��尡 �ڵ�ȣ��
		System.out.println("Ŭ���̾�Ʈ ȸ������ ó�� ��û��.");
		System.out.println(bag);
		System.out.println(dao);
		
		//MemberDAO dao = new MemberDAO(); //������Ÿ��
		//insert �޼����� ������ ����!! > spring�� ������Ÿ������ ���� �ش�.!
		dao.insert(bag); //��!
	
	}

	//�α���ó��
	//@RequestMapping("login.multi")
	public String login(MemberDTO bag, MemberDAO dao) {
		//login(String id, String pw)
		//login.multi��û�� ������
		//�������� �޾Ƽ� ���濡 �־, ����Ʈ!
		System.out.println("Ŭ���̾�Ʈ �α��� ó�� ��û��.");
		System.out.println(bag);
		//String id2 = "root";
		//String pw2 = "1234";
		//if (id2.equals(bag.getId()) && pw2.equals(bag.getPw())) {
			//�α��� ����--> ok.jsp
		//	return "ok";
		//} else {
			//�α��� ����--> no.jsp
			//return "no";
			//����������, webapp�Ʒ� member.jsp�� �ٽ� ȣ���ϰ� �ϰ� ����.(webapp�Ʒ� jsp�� ������(Ŭ���̾�Ʈ)�� ȣ���ϴ� ������)
			//������ ���������� member.jsp�� ȣ���϶�� �ϰ� ��.
			//resonse.sendRedirect("member.jsp")
		//	return "redirect:member.jsp";
		//}
		int result = dao.login(bag); //0 or 1
		if(result ==1) {
			return "ok";
		}else { //result == 0
			return "redirect:member.jsp";
		}
	}
	
	@RequestMapping("login.multi")
	public String loginOld2(MemberDTO bag) {
		System.out.println("Ŭ���̾�Ʈ �α��� ó�� ��û��.");
		System.out.println(bag);
		int result = dao.login(bag); //0 or 1 
		System.out.println(dao); //dao �ּ����!
		if(result ==1) {
			return "ok";
		}else { //result == 0
			return "redirect:member.jsp";
		}
	}

	//ȸ������ó��

	//ȸ��Ż��ó��
	@RequestMapping("delete.multi")
	public void delete(String id) {
	//delete(@RequestParam("id"a) String writer)
		System.out.println("���� ���̵��  " + id);
		dao.delete(id);
		//����� ��� �������� �Ѿ�� �Ǿ�����.
		// /WEB-INF/views/delete.jsp�� �ڵ�ȣ���ϰ� �Ǿ����� 
	}
	
	//��üȸ������ó��
	//ȸ������ó��
}




















