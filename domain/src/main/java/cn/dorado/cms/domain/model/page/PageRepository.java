package cn.dorado.cms.domain.model.page;

import cn.dorado.cms.domain.DomainId;
import cn.dorado.cms.domain.model.article.Article;

import java.util.Collection;

/**
 * Created by Eric on 14-5-4.
 */
public interface PageRepository {
    public DomainId nextIdentity();
    public void add(Page page);
    public void addAll(Collection<Page> pageCollection);
    public void remove(Page page);
    public void removeAll(Collection<Page> pageCollection);
    public Page pageOfId(DomainId pageId);
    public Article createArticle(Article article);

}
