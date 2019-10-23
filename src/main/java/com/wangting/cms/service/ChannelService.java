package com.wangting.cms.service;

import java.util.List;

import com.wangting.cms.entity.Article;
import com.wangting.cms.entity.Channel;

public interface ChannelService {


	/**
	 *  获取所有的频道（栏目）
	 * @return
	 */
	List<Channel> getAllChnls();

	List<Article> getSreach(String title);


	
}
