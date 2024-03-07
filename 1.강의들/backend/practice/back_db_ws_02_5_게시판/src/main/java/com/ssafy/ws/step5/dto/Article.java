package com.ssafy.ws.step5.dto;

import java.util.Date;

/**
 * 게시글 정보를 나타내는 클래스
 */
public class Article {
	private int articleId;
	private String title;
	private String content;
	private int userSeq;
	private int viewCnt;
	private Date regDate;

	public Article() {
	}

	public Article(int articleId, String title, String content, int userSeq) {
		super();
		this.articleId = articleId;
		this.title = title;
		this.content = content;
		this.userSeq = userSeq;
		this.regDate = new Date();
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", title=" + title + ", content=" + content + ", userSeq=" + userSeq
				+ ", viewCnt=" + viewCnt + ", regDate=" + regDate + "]";
	}
}
