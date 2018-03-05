package com.xxx.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.api.dao.ArticleCommentRepository;
import com.xxx.dto.article.ArticleComment;

/*
 * 用户文章评论业务实现
 * */
@Service
public class UserArticleCommentServiceImpl {
	
	@Autowired
	private ArticleCommentRepository articleCommentRepository;
	
	/*
	 * JPA添加文章评论
	 * */
	public ArticleComment addArticleCommentService(ArticleComment articleComment) {
		return articleCommentRepository.save(articleComment);
	}

}
