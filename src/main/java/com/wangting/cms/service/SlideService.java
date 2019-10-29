package com.wangting.cms.service;

import java.util.List;


import com.wangting.cms.entity.Slide;

public interface SlideService {

	
	/**
	 * 轮播图查询
	 * @return
	 */
	List<Slide> selectSlide();

	
	/**
	 * 轮播图添加
	 * @return
	 */
	int insertSlide(Slide slide);


	/**
	 * 轮播图删除
	 * @return
	 */
	int deleteSlide(Integer id);
	
}
