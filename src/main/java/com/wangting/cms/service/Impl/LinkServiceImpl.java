package com.wangting.cms.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangting.cms.dao.LinkMapper;
import com.wangting.cms.entity.Link;
import com.wangting.cms.service.LinkService;

@Service
public class LinkServiceImpl implements LinkService{

	@Autowired
	private LinkMapper linkMapper;

	@Override
	public List<Link> linklist() {
		// TODO Auto-generated method stub
		return linkMapper.linklist();
	}
	
}
