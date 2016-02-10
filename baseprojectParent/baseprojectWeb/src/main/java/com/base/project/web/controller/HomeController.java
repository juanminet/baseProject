package com.base.project.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/home")
public class HomeController extends BaseController{

	@RequestMapping(method=RequestMethod.GET)
	public String getHomePage(ModelAndView modelAndView){		
		return super.HOME_PAGE;
	}
}