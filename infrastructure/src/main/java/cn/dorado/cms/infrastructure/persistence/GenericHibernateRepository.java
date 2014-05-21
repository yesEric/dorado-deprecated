package cn.dorado.cms.infrastructure.persistence;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

/**
 * Created by Eric on 14-4-30.
 * @param <T>
 */
@SuppressWarnings("restriction")
public  class GenericHibernateRepository<T,PK extends Serializable> {
	private Class<T> persistentClass;
	 public GenericHibernateRepository(final Class<T> persistentClass) {
	        this.persistentClass = persistentClass;
	        
	    }
	
    @SuppressWarnings("restriction")
	@Resource
    private SessionFactory sessionFactory;
    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    public final ThreadLocal<T> session=new ThreadLocal<T>();
    /**
     * 简单的工厂方法，用于获取Session对象.
     *
     * @return 获取的Session对象
     * @throws org.hibernate.HibernateException
     */
    public Session getSession() throws HibernateException {
        Session sess =(Session)session.get();
        
        if (sess == null) {
            sess = getSessionFactory().openSession();
            session.set((T)sess);
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
    
    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        Session sess = getSession();
        return sess.createCriteria(persistentClass).list();
    }

}
