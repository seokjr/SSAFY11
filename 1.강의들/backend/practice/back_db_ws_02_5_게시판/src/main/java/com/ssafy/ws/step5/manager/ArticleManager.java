package com.ssafy.ws.step5.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.ws.step5.dto.Article;
import com.ssafy.ws.step5.dto.Comment;

public class ArticleManager {
	private List<Article> articles = new ArrayList<>();
	private static ArticleManager instance = new ArticleManager();
	private Map<Integer, List<Comment>> comments = new HashMap<>();

	private ArticleManager() {
	}

	public static ArticleManager getInstance() {
		return instance;
	}
	public List<Article> selectAll(){
		return articles;
	}
	public Article selectOne(int articleId) {
		for (int i = 0; i<articles.size(); i++) {
			if (articleId == articles.get(i).getArticleId()) {
				return articles.get(i);
			}
		}
		// null을 넘겨줬을 때 처리할 수 있는게 존재해야 할 듯하다.
		System.out.println("해당 기사가 없습니다.");
		return null;
	}
	public void insert(Article a) {
		articles.add(a);
	}
	public void removeArticle(int articleId) {
		for (int i = 0; i <articles.size();i++) {
			if(articleId == articles.get(i).getArticleId()) {
				articles.remove(i);
			}
		}
	}
	public void insert(Comment comment) {
		if (comments.get(comment.getArticleId()) == null) {
			comments.put(comment.getArticleId(),new ArrayList<>()); 
			comments.get(comment.getArticleId()).add(comment);
		} else {
			comments.get(comment.getArticleId()).add(comment);
		}
	}
	public void removeComment(int articleId, int commentId) {
		// 일단 없으면 그냥 리턴
		if (comments.get(articleId) == null){
			return;
		}
		// 하나밖에 없을 때 article 번호까지 지우면서 그냥 없앤다.
		else if (comments.get(articleId).size()==1) {
			comments.remove(articleId);
		}
		// 여러 개 있을 때이다.
		else {
			for (int i = 0; i<comments.get(articleId).size();i++) {
				// 포문돌면서 commentId가 같으면 삭제
				if (commentId == comments.get(articleId).get(i).getCommentId()) {
					comments.get(articleId).remove(i);
				}
			}
		}
	}
	public List<Comment> selectArticleComment(int articleId) {
		if (comments.get(articleId) == null) {
			return null;
		} else {
			return comments.get(articleId);
		}
	}
}
