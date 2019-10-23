package com.wangting.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangting.cms.entity.Commnent;
import com.wangting.cms.service.CommnentService;

@Controller
@RequestMapping("commnent")
public class CommentController {

	/*@Autowired
	private CommnentService commnentService;
	
	@ResponseBody
	@PostMapping("getlist")
	public boolean getlist( Commnent commnent,String a) {
		return commnentService.insert(commnent)>0;
	}*/
	
}
