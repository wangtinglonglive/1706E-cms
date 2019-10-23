package com.wangting.cms.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangting.cms.dao.ChannelMapper;
import com.wangting.cms.entity.Article;
import com.wangting.cms.entity.Channel;
import com.wangting.cms.service.ChannelService;

@Service
public class ChannelServiceImpl  implements ChannelService{

	@Autowired
	ChannelMapper channelMapper;
	
	/**
	 *  获取所有的频道（栏目）
	 * @return
	 */
	@Override
	public List<Channel> getAllChnls() {
		// TODO Auto-generated method stub
		return channelMapper.listAll();
	}

	@Override
	public List<Article> getSreach(String title) {
		// TODO Auto-generated method stub
		return channelMapper.sreach(title);
	}



	

}
