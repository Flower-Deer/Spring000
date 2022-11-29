package com.multi.www000;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //스프링에 컨트롤로 역할을 하는 클래스라고 등록!!
public class MemberController2 {
	
	@Autowired //이미 만들어서 준비된 MemberDAO객체의 주소를 찾아서, 자동으로 그 주소를 아래의 변수인 dao에 넣어주세요@@
	MemberDAO dao; // ex) dao ="뒷베란다"에있음 : 주소 자동으로 찾아줌
	
	//회원가입처리
	@RequestMapping("insert.multi")   //MemberDAO dao=프로토타입
	public void insert(MemberDTO bag, MemberDAO dao) {
		//메서드입력파라메터로 bag변수만 선언해주면
		//아래의 1-1, 1-2, 1-3을 스프링이 해줌.
		//   1-1) 데이터를 받아라!
		//   1-2) bag을 만들어서!
	    //   1-3) bag에 집어 넣어라.!
		//        set~()메서드가 자동호출
		System.out.println("클라이언트 회원가입 처리 요청됨.");
		System.out.println(bag);
		System.out.println(dao);
		
		//MemberDAO dao = new MemberDAO(); //프로토타입
		//insert 메서드의 변수로 선언!! > spring이 프로토타입으로 만들어서 준다.!
		dao.insert(bag); //끝!
	
	}

	//로그인처리
	//@RequestMapping("login.multi")
	public String login(MemberDTO bag, MemberDAO dao) {
		//login(String id, String pw)
		//login.multi요청이 왔을때
		//서버에서 받아서 가방에 넣어서, 프린트!
		System.out.println("클라이언트 로그인 처리 요청됨.");
		System.out.println(bag);
		//String id2 = "root";
		//String pw2 = "1234";
		//if (id2.equals(bag.getId()) && pw2.equals(bag.getPw())) {
			//로그인 성공--> ok.jsp
		//	return "ok";
		//} else {
			//로그인 실패--> no.jsp
			//return "no";
			//실패했을때, webapp아래 member.jsp를 다시 호출하게 하고 싶음.(webapp아래 jsp는 브라우저(클라이언트)가 호출하는 페이지)
			//서버가 브라우저에게 member.jsp를 호출하라고 하게 함.
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
		System.out.println("클라이언트 로그인 처리 요청됨.");
		System.out.println(bag);
		int result = dao.login(bag); //0 or 1 
		System.out.println(dao); //dao 주소찍기!
		if(result ==1) {
			return "ok";
		}else { //result == 0
			return "redirect:member.jsp";
		}
	}

	//회원수정처리

	//회원탈퇴처리
	@RequestMapping("delete.multi")
	public void delete(String id) {
	//delete(@RequestParam("id"a) String writer)
		System.out.println("받은 아이디는  " + id);
		dao.delete(id);
		//결과를 담는 페이지로 넘어가게 되어있음.
		// /WEB-INF/views/delete.jsp를 자동호출하게 되어있음 
	}
	
	//전체회원정보처리
	//회원정보처리
}




















