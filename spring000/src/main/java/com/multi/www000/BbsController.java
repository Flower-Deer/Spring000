package com.multi.www000;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BbsController {
	
	@RequestMapping("insert2.bbs")
	public void insert(MemberDTO bag) {
		System.out.println("Ŭ���̾�Ʈ ȸ������ ó�� ��û��.");
		System.out.println(bag);
	}
}
