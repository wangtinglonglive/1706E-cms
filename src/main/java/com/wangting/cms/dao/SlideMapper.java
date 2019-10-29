package com.wangting.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.wangting.cms.entity.Slide;

public interface SlideMapper {
	/**
	 * 轮播图查询
	 * @return
	 */
	@Select("select * from cms_slide")
	List<Slide> selectSlide();

	
	/**
	 * 轮播图添加
	 * @return
	 */
	@Insert("insert into cms_slide set title=#{title}, picture=#{picture},url=#{url}")
	int insertSlide(Slide slide);


	/**
	 * 轮播图删除
	 * @return
	 */
	@Delete("delete from cms_slide where id = #{id}")
	int deleteSlide(Integer id);
	
}
