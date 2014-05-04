package cn.dorado.cms.domain;

import cn.dorado.cms.domain.AbstractEntity;
import cn.dorado.cms.domain.DomainId;


import java.util.Collection;

/**
 * Created by Eric on 14-4-30.
 */
public interface DomainRepository {

    public DomainId nextIdentity();
    public void add(AbstractEntity object);
    public void addAll(Collection<AbstractEntity> articleCollection);
    public void remove(AbstractEntity object);
    public void removeAll(Collection<AbstractEntity> articleCollection);
}
