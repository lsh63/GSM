package com.xxx.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.xxx.dto.article.ArticleComment;

public interface ArticleCommentRepository extends 
JpaRepository<ArticleComment, Long>,JpaSpecificationExecutor<ArticleComment> {

	//根据ARTICLEID获取文章评论
	@Query(value = "select * from articlecomment where articleid=?1 ", nativeQuery = true)
	public List<ArticleComment> findArticleCommentByArticleId(Long articleid);
	
	

}
