package com.multi.www000;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieController {
	
	@RequestMapping("movie")
	public String genre(String movie) {
//		String comedy = "코미디";
//		String drama = "드라마";
//		String action = "액션";
		if (movie.equals("코미디")) {
			return "comic";
		} else if(movie.equals("드라마")) {
			return "drama";
		} else if(movie.equals("액션")) {
			return "action";
		} else {
			return "no";
		}
	}
}
