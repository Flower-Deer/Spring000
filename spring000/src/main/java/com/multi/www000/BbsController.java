package com.multi.www000;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BbsController {
	
	@RequestMapping("insert2.bbs")
	public void insert(MemberDTO bag) {
		System.out.println("클라이언트 회원가입 처리 요청됨.");
		System.out.println(bag);
	}
}
