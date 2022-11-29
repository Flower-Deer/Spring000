package com.multi.www000;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.protobuf.Method;

//이 클래스를 컨트롤러로 스프링 프로그램에 등록해 주세요 + 싱글톤으로 만들어 준비해주세요.
@Controller
public class AchievementController {
	
	@Autowired
	AchievementDAO dao;
	
	@RequestMapping("insert4.multi")
	public void insert(AchievementDTO bag) throws Exception {
		//1. bag을 만들어서 클라이언트로부터 전달되는 데이터를 받아, 가방에 넣으세요.
		System.out.println(bag);
		//2. dao를 이용하여 insert(bag) 요청.
		dao.insert(bag);
		//스프링 프로그램이 컨트롤러에 있는 메서드의 마지막은 무조건!! insert3.jsp를 호출!!!!
	}
	
	@RequestMapping("list")
	public void list(Model model){
		ArrayList<AchievementDTO> list = dao.list();
		model.addAttribute("list", list);
	}
	
	@RequestMapping("delete2")
	public void delete(String id) throws Exception {
		dao.delete(id);
	}
	
	
}
