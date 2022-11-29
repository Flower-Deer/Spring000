package com.multi.www000;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
	
	//이미 ram에 만들어서 저장해놓은 주소를 찾아서(wired) 자동으로 아래 변수에 그 주소를 넣어줘!
	@Autowired 
	BookDAO dao; //dao = 200주소
	
	@RequestMapping("one3.multi")
	public void one(int id, Model model) {
		BookDTO dto = dao.one(id); //orm에 의해 dto으로 return!
		//model의 속성으로 지정하면, views아래까지 전달이된다.!!
		model.addAttribute("dto", dto);
	}
	
	@RequestMapping("delete3.multi")
	public void delete(int id) {
		dao.delete(id);
		//결과는 views아래 delete3.jsp를 호출해서 클라이언트에 보냄!
	}
	
	@RequestMapping("insert3.multi")
	public void insert(BookDTO bag) {
			//1. bag을 만들어서 클라이언트로부터 전달되는 데이터 받아, 가방에 넣으세요.
		System.out.println(bag);
		
			//2. dao를 이용해서 insert(bag)요청
		dao.insert(bag);
	}
	
	@RequestMapping("list2")
	public void list(Model model){
		ArrayList<BookDTO> list = dao.list();
		model.addAttribute("list", list);
	}

}
