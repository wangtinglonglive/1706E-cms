package com.wangting.cms.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import com.wangting.cms.entity.Article;
import com.wangting.cms.entity.Commnent;

public interface CommnentMapper {

	@Update("UPDATE cms_article SET commentCnt=commentCnt+1 WHERE id =#{id}")
	int updateCommnents(Article article);

	@Insert("INSERT INTO `cms_comment` (articleId,userId,content,created) VALUES(#{articleId},#{userId},#{content},#{created})")
	int insert(Commnent commnent);

}
