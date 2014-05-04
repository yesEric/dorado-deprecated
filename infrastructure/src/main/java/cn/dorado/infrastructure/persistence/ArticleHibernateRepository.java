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
    @Override
    public DomainId nextIdentity() {
        return null;
    }

    @Override
    public void add(Article article) {

    }

    @Override
    public void addAll(Collection<Article> articleCollection) {

    }

    @Override
    public void remove(Article article) {

    }

    @Override
    public void removeAll(Collection<Article> articleCollection) {

    }

    @Override
    public Article articleOfId(DomainId articleId) {
        return null;
    }

    @Override
    public Collection<Article> articlesOfColumn(DomainId columnId) {
        return null;
    }

    @Override
    public Collection<Article> publishedArticlesOfAuthor(Author author) {
        return null;
    }

    @Override
    public Collection<Article> publishedArticlesOfColumns(DomainId columnId) {
        return null;
    }
}
