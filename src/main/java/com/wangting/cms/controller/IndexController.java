package com.wangting.cms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.wangting.cms.entity.Article;
import com.wangting.cms.entity.Cat;
import com.wangting.cms.entity.Channel;
import com.wangting.cms.entity.Link;
import com.wangting.cms.service.ArticleService;
import com.wangting.cms.service.CatService;
import com.wangting.cms.service.ChannelService;
import com.wangting.cms.service.LinkService;
import com.wangting.cms.web.PageUtils;

@Controller
public class IndexController {
	@Autowired
	ChannelService chnlService;
	
	@Autowired
	CatService catService;
	
	@Autowired
	ArticleService articleService;
	
	@Autowired
	private LinkService linkService;

	/**
	 * 
	 * @param request
	 * @param chnId  栏目id
	 * @param catId  分类id
	 * @param page  文章的页码
	 * @return
	 */
	@RequestMapping({"index","/"})
	public String index(HttpServletRequest request,
			@RequestParam(defaultValue="0") Integer chnId,
			@RequestParam(defaultValue="0")  Integer catId,
			@RequestParam(defaultValue="1")  Integer page
			/*@Param("title")String title*/
			) {
		
		//获取友情连接
		List<Link> linklist =linkService.linklist();
		request.setAttribute("linklist", linklist);

		// 获取所有的频道
		List<Channel> channels = chnlService.getAllChnls();

			if(chnId!=0) {	
				/*List<Article> sreach = chnlService.getSreach(title);
				System.out.println("---------------------"+sreach);
				if(sreach!=null) {
					request.setAttribute("sreach", sreach);
					return "my/sreach";
				}
				*/
				
				//获取该栏目下的所有分类
				List<Cat> catygories = catService.getListByChnlId(chnId); 
				request.setAttribute("catygories", catygories);
				//获取该栏目下的文章
				PageInfo<Article>  articleList = articleService.list(chnId,catId,page);
				request.setAttribute("articles", articleList);
				PageUtils.page(request, "/index?chnId="+chnId+"&catId=" + catId, 10, articleList.getList(),
						(long)articleList.getTotal(), articleList.getPageNum());
				//request.setAttribute("pageStr", pageStr);
				
				
				
			}else {
				// 首页热门
				// 获取热门文章
				PageInfo<Article>  articleList = articleService.hostList(page);
				request.setAttribute("articles", articleList);
				PageUtils.page(request, "/index", 10, articleList.getList(),
						(long)articleList.getTotal(), articleList.getPageNum());	
			}
			//获取最新文章
			List<Article>  lastList = articleService.last(5);
			request.setAttribute("lastList", lastList);
			request.setAttribute("chnls", channels);
			request.setAttribute("chnId", chnId);
			request.setAttribute("catId", catId);	
			return "index";	
	}
}
