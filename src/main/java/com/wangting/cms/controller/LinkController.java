package com.wangting.cms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangting.cms.entity.Link;
import com.wangting.cms.entity.User;
import com.wangting.cms.service.LinkService;

@Controller
@RequestMapping("link")
public class LinkController {

	@Autowired
	private LinkService linkService;
	
	/*//@ResponseBody
	@RequestMapping("linkinsert")
	public String linklist(Link link) {
		return "index";
	}*/
/*
	@RequestMapping("linkselect")
	public String getList(HttpServletRequest request) {
		List<User> list = linkService.listinsert();
		request.setAttribute("list", list);
		return "admin/article/userlist";
	}
	*/
}
