package cn.dorado.infrastructure.persistence;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

import javax.annotation.Resource;

/**
 * Created by Eric on 14-4-30.
 */
public class GenericHibernateRepository {
    @Resource
    private SessionFactory sessionFactory;
    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    /**
     * 简单的工厂方法，用于获取Session对象.
     *
     * @return 获取的Session对象
     * @throws org.hibernate.HibernateException
     */
    public Session getSession() throws HibernateException {
        Session sess = getSessionFactory().getCurrentSession();
        if (sess == null) {
            sess = getSessionFactory().openSession();
        }
        return sess;
    }

    /**
     *
     *
     * @param sessionFactory Hibernate SessionFactory
     */
    @Autowired
    @Required
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
