package cn.dorado.infrastructure.persistence;

import cn.dorado.cms.domain.DomainId;
import cn.dorado.cms.domain.model.article.Article;
import cn.dorado.cms.domain.model.page.Page;
import cn.dorado.cms.domain.model.page.PageRepository;
import org.hibernate.exception.ConstraintViolationException;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Eric on 14-5-4.
 */
public class PageHibernateRepository extends GenericHibernateRepository implements PageRepository {
    @Override
    public DomainId nextIdentity() {
        return new DomainId(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    @Override
    public void add(Page page) {
        try {
            this.getSession().saveOrUpdate(page);
        }catch (ConstraintViolationException e){
            throw new IllegalStateException("Page is not unique.",e);
        }
    }

    @Override
    public void addAll(Collection<Page> pageCollection) {
        try{
            for(Page page : pageCollection){
                this.getSession().saveOrUpdate(page);
            }
        }catch (ConstraintViolationException e){
            throw new IllegalStateException("Page is not unique.",e);
        }

    }

    @Override
    public void remove(Page page) {
      this.getSession().delete(page);
    }

    @Override
    public void removeAll(Collection<Page> pageCollection) {
        for(Page page:pageCollection){
            this.getSession().delete(page);
        }
    }

    @Override
    public Page pageOfId(DomainId pageId) {
        return (Page)this.getSession().get(Page.class, pageId);
    }

    @Override
    public Article createArticle(Article article) {
        return null;
    }
}
