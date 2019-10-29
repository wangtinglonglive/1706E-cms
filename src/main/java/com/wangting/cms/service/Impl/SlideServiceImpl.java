package com.wangting.cms.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangting.cms.dao.SlideMapper;
import com.wangting.cms.entity.Slide;
import com.wangting.cms.service.SlideService;

@Service
public class SlideServiceImpl  implements SlideService{

	@Autowired
	SlideMapper slideMapper;
	
	@Override
	public List<Slide> selectSlide() {
		// TODO Auto-generated method stub
		return slideMapper.selectSlide();
	}

	@Override
	public int insertSlide(Slide slide) {
		// TODO Auto-generated method stub
		return slideMapper.insertSlide(slide);
	}

	@Override
	public int deleteSlide(Integer id) {
		// TODO Auto-generated method stub
		return slideMapper.deleteSlide(id);
	}

}
