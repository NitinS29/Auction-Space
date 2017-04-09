package com.auctionspace.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/SignOut")
public class SignOutController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String signOut(HttpSession session){
		session.invalidate();
		return "/index";
	}
}
