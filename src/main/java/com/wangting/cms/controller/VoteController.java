package com.wangting.cms.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.wangting.cms.entity.Article4Vote;
import com.wangting.cms.entity.VoteStatic;
import com.wangting.cms.service.Article4VoteService;

@RequestMapping("vote")
@Controller
public class VoteController {
	/*
	 * 
	 * 投票
	 */
	@Autowired
	Article4VoteService avService;
	
	@RequestMapping("list")
	public String list(HttpServletRequest request) {
		List<Article4Vote> list = avService.list();
		request.setAttribute("list", list);
		return "my/vote/list";
		
	}
	
	@GetMapping("push")
	public String push(HttpServletRequest request) {
		return "my/vote/add";
		
	}
	
	@PostMapping("push")
	@ResponseBody
	public boolean  push(HttpServletRequest request,Article4Vote av) {
		return avService.publish(av)>0;
		
	}
	
	/**
	 * 
	 * @param request
	 * @param arId  投票的id
	 * @return
	 */
	@GetMapping("getVote")
	public String getVote(HttpServletRequest request,int arId) {
		Article4Vote av = avService.findById(arId);
		request.setAttribute("voteArticle", av);
		Gson gson = new Gson();
		
		LinkedHashMap<String,String> map = gson.fromJson(av.getContent(), LinkedHashMap.class);
		
		
		LinkedHashMap<String,VoteStatic> lmap = new LinkedHashMap<String,VoteStatic>();
		Set<Entry<String, String>> entrySet = map.entrySet();
		
		List<VoteStatic> voteStatics = avService.getVoteStatics(arId);
		// 计算共有多少人投票
		int totalNum = 0;
		for (VoteStatic voteStatic : voteStatics) {
			totalNum+=voteStatic.getVoteNum();
		}
		
		// 生成新的map集合存放统计数量
		for (Entry<String, String> entry : entrySet) {
			VoteStatic voteStatic = new VoteStatic();
			voteStatic.setOptionKey(entry.getKey());
			voteStatic.setOptionTitle(entry.getValue());
			voteStatic.setVoteNumTotal(totalNum);
			lmap.put(entry.getKey(), voteStatic);
			
		}
		
		
		
		//获取统计的每一项的结果
		for (VoteStatic voteStatic : voteStatics) {
			VoteStatic showStatic = lmap.get(voteStatic.getOptionKey());
			showStatic.setVoteNum(voteStatic.getVoteNum());
		}
		
		request.setAttribute("lmap", lmap);
		
		return "my/vote/detail";
	}
	
	@PostMapping("vote")
	@ResponseBody
	public Boolean push(HttpServletRequest request,Integer articleId,Character option) {	
		return avService.vote( articleId, option)>0;
		
	}

}
