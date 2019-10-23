package com.wangting.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangting.cms.entity.Commnent;
import com.wangting.cms.service.CommnentService;

@Controller
public class CommnentController {

	@Autowired
	CommnentService commnentService;
	
	@ResponseBody
	@RequestMapping("commnentinsert")
	public boolean commnentinsert(Commnent commnent ) {
		return commnentService.commnentinsert(commnent)>0;
		
	}
	
}
