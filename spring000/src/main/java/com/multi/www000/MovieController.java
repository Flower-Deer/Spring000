package com.multi.www000;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieController {
	
	@RequestMapping("movie")
	public String genre(String movie) {
//		String comedy = "�ڹ̵�";
//		String drama = "���";
//		String action = "�׼�";
		if (movie.equals("�ڹ̵�")) {
			return "comic";
		} else if(movie.equals("���")) {
			return "drama";
		} else if(movie.equals("�׼�")) {
			return "action";
		} else {
			return "no";
		}
	}
}
