package com.xxx.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.api.dao.ArticleFloorCommentRepository;
import com.xxx.dto.article.ArticleFloorComment;

/*
 * 文章楼层内评论业务实现
 * */
@Service
public class ArticleFloorCommentServiceImpl {
	
	@Autowired
	private ArticleFloorCommentRepository articleFloorCommentRepository;
	
	/*
	 * JPA查询所有文章楼层内评论
	 * */
	public List<ArticleFloorComment> findALLArticleFloorCommentService(Long commentid){
		List<ArticleFloorComment> list = articleFloorCommentRepository.findArticleFloorCommentByCommentId(commentid);
		return list;
	}

}
