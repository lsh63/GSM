package com.xxx.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.api.dao.ArticleFloorCommentRepository;
import com.xxx.dto.article.ArticleFloorComment;

/*
 * 用户文章楼层内评论业务实现
 * */
@Service
public class UserArticleFloorCommentServiceImpl {
	
	@Autowired
	private ArticleFloorCommentRepository articleFloorCommentRepository;
	
	/*
	 * JPA添加文章楼层内评论
	 * */
	public ArticleFloorComment addArticleFloorCommentService(ArticleFloorComment articleFloorComment) {
		return articleFloorCommentRepository.save(articleFloorComment);
	}

}
