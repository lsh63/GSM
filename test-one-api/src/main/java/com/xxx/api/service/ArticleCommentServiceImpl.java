package com.xxx.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.api.dao.ArticleCommentRepository;
import com.xxx.dto.article.ArticleComment;

/*
 * 文章评论业务实现
 * */
@Service(value = "articleCommentServiceImpl")
public class ArticleCommentServiceImpl {
	
	@Autowired
	private ArticleCommentRepository articleCommentRepository;
	
	/*
	 * JPA查询所有文章评论
	 * */
	public List<ArticleComment> findALLArticleCommentService(Long articleid){
		List<ArticleComment> list = articleCommentRepository.findArticleCommentByArticleId(articleid);
		return list;
	}

}
