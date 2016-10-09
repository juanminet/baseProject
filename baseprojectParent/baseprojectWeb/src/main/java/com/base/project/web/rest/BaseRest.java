package com.base.project.web.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.base.project.model.Base;
import com.base.project.service.IBaseService;
import com.base.project.web.controller.commands.BaseCommand;


@RestController
@RequestMapping("/rest/base")
public class BaseRest {

	@Autowired
	IBaseService baseService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody BaseCommand getBaseInJSON(@PathVariable String id) { 
	
		Base base = baseService.getBaseById(Long.valueOf(id));
		
		BaseCommand baseCommand = new BaseCommand();
		baseCommand.setIdBase(base.getId());
		baseCommand.setValue(base.getValue());
		baseCommand.setDescription(base.getDescription());
 
   	 return baseCommand;
 
    }
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<BaseCommand> getAllBaseInJSON() { 	
 
   	 return getAllBases();
 
    }
	
	private List<BaseCommand> getAllBases() {
		List<Base> listBases = baseService.getAllBases();
		
		List<BaseCommand> baseCommandList = new ArrayList<BaseCommand>();
 		for (Base b :  listBases){
			BaseCommand baseCommand = new BaseCommand();
			baseCommand.setIdBase(b.getId());
			baseCommand.setValue(b.getValue());
			baseCommand.setDescription(b.getDescription());
			
			baseCommandList.add(baseCommand);
		}
 		
 		return baseCommandList;
	}
}
