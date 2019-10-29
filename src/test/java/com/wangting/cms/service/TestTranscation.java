package com.wangting.cms.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wangting.cms.entity.Article;

/**
 * 测试事务
 * @author wangting
 *
 */
public class TestTranscation extends BaseTest {
	
	@Autowired
	ArticleService articleService;

	/**
	 * 
	 */
	@Test
	public void testAddArticle() {
		Article article = new Article();
		article.setContent("测试内容22");
		article.setTags(" zhSANG1222,LISI22");
		articleService.add(article);
		
		
	}
}
