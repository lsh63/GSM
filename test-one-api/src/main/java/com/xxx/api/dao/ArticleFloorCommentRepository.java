package com.xxx.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.xxx.dto.article.ArticleFloorComment;

public interface ArticleFloorCommentRepository extends 
JpaRepository<ArticleFloorComment, Long>,JpaSpecificationExecutor<ArticleFloorComment> {

	//根据ARTICLEID获取文章评论
	@Query(value = "select * from articlefloorcomment where commentid=?1 ", nativeQuery = true)
	public List<ArticleFloorComment> findArticleFloorCommentByCommentId(Long commentid);

}
