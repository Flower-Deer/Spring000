package com.multi.www000;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
	
	//�̹� ram�� ���� �����س��� �ּҸ� ã�Ƽ�(wired) �ڵ����� �Ʒ� ������ �� �ּҸ� �־���!
	@Autowired 
	BookDAO dao; //dao = 200�ּ�
	
	@RequestMapping("one3.multi")
	public void one(int id, Model model) {
		BookDTO dto = dao.one(id); //orm�� ���� dto���� return!
		//model�� �Ӽ����� �����ϸ�, views�Ʒ����� �����̵ȴ�.!!
		model.addAttribute("dto", dto);
	}
	
	@RequestMapping("delete3.multi")
	public void delete(int id) {
		dao.delete(id);
		//����� views�Ʒ� delete3.jsp�� ȣ���ؼ� Ŭ���̾�Ʈ�� ����!
	}
	
	@RequestMapping("insert3.multi")
	public void insert(BookDTO bag) {
			//1. bag�� ���� Ŭ���̾�Ʈ�κ��� ���޵Ǵ� ������ �޾�, ���濡 ��������.
		System.out.println(bag);
		
			//2. dao�� �̿��ؼ� insert(bag)��û
		dao.insert(bag);
	}
	
	@RequestMapping("list2")
	public void list(Model model){
		ArrayList<BookDTO> list = dao.list();
		model.addAttribute("list", list);
	}

}
