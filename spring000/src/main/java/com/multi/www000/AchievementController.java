package com.multi.www000;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.protobuf.Method;

//�� Ŭ������ ��Ʈ�ѷ��� ������ ���α׷��� ����� �ּ��� + �̱������� ����� �غ����ּ���.
@Controller
public class AchievementController {
	
	@Autowired
	AchievementDAO dao;
	
	@RequestMapping("insert4.multi")
	public void insert(AchievementDTO bag) throws Exception {
		//1. bag�� ���� Ŭ���̾�Ʈ�κ��� ���޵Ǵ� �����͸� �޾�, ���濡 ��������.
		System.out.println(bag);
		//2. dao�� �̿��Ͽ� insert(bag) ��û.
		dao.insert(bag);
		//������ ���α׷��� ��Ʈ�ѷ��� �ִ� �޼����� �������� ������!! insert3.jsp�� ȣ��!!!!
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
