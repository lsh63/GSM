package com.xxx.dto.article;

import org.springframework.data.annotation.Id;

public class Article {
	@Id
	private Long id;
	
	private String articlename;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArticlename() {
		return articlename;
	}

	public void setArticlename(String articlename) {
		this.articlename = articlename;
	}
	
	public Article(Long id, String articlename) {
		this.id = id;
		this.articlename = articlename;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", articlename=" + articlename + "]";
	}

}
