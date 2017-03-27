package com.auctionspace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;

import com.auctionspace.model.UserModel;
import com.auctionspace.model.LoginModel;
import com.auctionspace.dao.ManageUsersDao;

@RestController
@RequestMapping("/Users")
public class ManageUsersController {
	private static Logger logger = Logger.getLogger(ManageUsersController.class);

	@RequestMapping(value = "/getUserRole", method = RequestMethod.GET)
	public String getDummyEmployee(ModelAndView model) {
		logger.debug("In get User log");
		model.addObject("user", new UserModel());
		return "index";
	}
	
	  @Autowired
	  public ManageUsersDao userService;
	  
	  @RequestMapping(value = "/registerSeller", method = RequestMethod.GET)
	  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("SellerRegister");
	    mav.addObject("user", new UserModel());
	    return mav;
	  }
	  
	  @RequestMapping(value = "/registerProcessSeller", method = RequestMethod.POST)
	  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("user") @Valid UserModel user) {
	  userService.registerUser(user);
	  return new ModelAndView("Welcome", "firstname", user.getFname());
	  }
	  
	  @RequestMapping(value = "/registerBuyer", method = RequestMethod.GET)
	  public ModelAndView showRegisterBuyer(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("BuyerRegister");
	    mav.addObject("user", new UserModel());
	    return mav;
	  }
	  
	  @RequestMapping(value = "/registerProcessBuyer", method = RequestMethod.POST)
	  public ModelAndView addBuyer(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("user") @Valid UserModel user) {
	  userService.registerUser(user);
	  return new ModelAndView("Welcome", "firstname", user.getFname());
	  }
	  
	  @RequestMapping(value = "/login", method = RequestMethod.GET)
	  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("login");
	    mav.addObject("login", new LoginModel());
	    return mav;
	  }
	  
	  @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("login") LoginModel login) {
	    ModelAndView mav = null;
	    UserModel user = userService.validateUser(login);
	    if (null != user) {
	    mav = new ModelAndView("Users/Welcome");
	    mav.addObject("firstname", user.getFname());
	    } else {
	    mav = new ModelAndView("login");
	    mav.addObject("message", "Username or Password is wrong!!");
	    }
	    return mav;
	  }
	  
}
