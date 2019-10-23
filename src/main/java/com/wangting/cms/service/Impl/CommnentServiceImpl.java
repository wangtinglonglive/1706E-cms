package com.wangting.cms.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangting.cms.dao.CommnentMapper;
import com.wangting.cms.entity.Article;
import com.wangting.cms.entity.Commnent;
import com.wangting.cms.service.CommnentService;

@Service
public class CommnentServiceImpl implements CommnentService {

	@Autowired
	CommnentMapper commnentMapper;
	
	@Override
	public int commnentinsert(Commnent commnent) {
		// TODO Auto-generated method stub
	Article article = new Article();
	
	article.setId(commnent.getArticleId());
	
	int i = commnentMapper.updateCommnents(article);
		return commnentMapper.insert(commnent) ;
	}

}
