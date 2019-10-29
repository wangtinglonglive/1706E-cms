package com.wangting.cms.service;

import java.util.List;

import com.wangting.cms.entity.Article4Vote;
import com.wangting.cms.entity.VoteStatic;

/**
 * 
 * @author wangting
 *
 */
public interface Article4VoteService {
	
	int publish(Article4Vote av);
	
	List<Article4Vote>  list();
	
	Article4Vote  findById(Integer id);
	
	int vote(Integer articleId,Character option);
	//int vote(Integer userId, Integer articleId,Character option);
	
	List<VoteStatic> getVoteStatics(Integer articleId);
	
	
	

}
