package cn.dorado.infrastructure.persistence;

import cn.dorado.cms.domain.DomainId;
import cn.dorado.cms.domain.model.article.Article;
import cn.dorado.cms.domain.model.article.ArticleRepository;
import cn.dorado.cms.domain.model.common.Author;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by Eric on 14-4-30.
 */
@Repository("articleRepository")
public class ArticleHibernateRepository implements ArticleRepository {

	public DomainId nextIdentity() {
		// TODO Auto-generated method stub
		return null;
	}

	public void add(Article article) {
		// TODO Auto-generated method stub
		
	}

	public void addAll(Collection<Article> articleCollection) {
		// TODO Auto-generated method stub
		
	}

	public void remove(Article article) {
		// TODO Auto-generated method stub
		
	}

	public void removeAll(Collection<Article> articleCollection) {
		// TODO Auto-generated method stub
		
	}

	public Article articleOfId(DomainId articleId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<Article> articlesOfColumn(DomainId columnId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<Article> publishedArticlesOfAuthor(Author author) {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<Article> publishedArticlesOfColumns(DomainId columnId) {
		// TODO Auto-generated method stub
		return null;
	}
    
    
}
