package com.wangting.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.wangting.cms.entity.Link;

public interface LinkMapper {

	@Select("select * from cms_link")
	List<Link> linklist();

}
