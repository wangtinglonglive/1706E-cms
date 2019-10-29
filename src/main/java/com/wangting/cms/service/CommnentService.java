package com.wangting.cms.service;

import java.util.List;

import com.wangting.cms.entity.Commnent;

public interface CommnentService {


	List<Commnent> commnentlist(Integer articleId);

	/**
	 * 发布评论
	 * @param id
	 * @param articleId
	 * @param content
	 */
	void comment(Integer id, Integer articleId, String content);

}
