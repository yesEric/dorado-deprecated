package cn.dorado.cms.domain.model.article;

import cn.dorado.cms.domain.DomainId;
import cn.dorado.cms.domain.model.common.Author;

import java.util.Collection;

/**
 * Created by Eric on 14-4-30.
 */
public interface ArticleRepository {
    public DomainId nextIdentity();
    public void add(Article article);
    public void addAll(Collection<Article> articleCollection);
    public void remove(Article article);
    public void removeAll(Collection<Article> articleCollection);
    public Article articleOfId(DomainId articleId);
    public Collection<Article> articlesOfColumn(DomainId columnId);
    public Collection<Article> publishedArticlesOfAuthor(Author author);
    public Collection<Article> publishedArticlesOfColumns(DomainId columnId);

}
