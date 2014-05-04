package cn.dorado.domain.model;

import cn.dorado.cms.domain.DomainId;
import cn.dorado.cms.domain.model.article.ArticleRepository;
import cn.dorado.domain.BaseRepositoryTestCase;
import cn.dorado.infrastructure.persistence.ArticleHibernateRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Eric on 14-5-4.
 */
public class ArticleHibernateRepositoryTestCase extends BaseRepositoryTestCase {
    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void testAddAndRemoveArticle() throws Exception{
        DomainId articleId=articleRepository.nextIdentity();

    }

}
