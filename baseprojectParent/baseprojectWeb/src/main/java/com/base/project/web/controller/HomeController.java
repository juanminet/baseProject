package com.base.project.web.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.base.project.model.Base;
import com.base.project.service.IBaseService;
import com.base.project.web.controller.commands.BaseCommand;


@Controller
@RequestMapping("/home")
public class HomeController extends BaseController{
	
	private int count = 0;
	
	@Autowired
	IBaseService baseService;

	@RequestMapping(method=RequestMethod.GET)
	public String getHomePage(ModelMap model){	
		count++;
		BaseCommand baseCommand = new BaseCommand();
		model.put("baseCommand", baseCommand);		
		model.put("count", count);
		return super.HOME_PAGE;
	}
	
	
	@RequestMapping(value={"/save"}, method=RequestMethod.POST)
	public String addValue(@Valid BaseCommand baseCommand, BindingResult errors, Model model, HttpSession session){
		
		addBase(baseCommand);
		
		return super.HOME_PAGE;
	}
	
	private void addBase(BaseCommand baseCommand) {
		
		
		//create athlete data		
		Base base = new Base();
		base.setValue(baseCommand.getValue());
		base.setDescription(baseCommand.getDescription());
		
		baseService.setBase(base);
	}
	
}
