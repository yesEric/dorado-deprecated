package cn.dorado.infrastructure.persistence;

import cn.dorado.cms.domain.DomainId;
import cn.dorado.cms.domain.model.article.Article;
import cn.dorado.cms.domain.model.channel.Channel;
import cn.dorado.cms.domain.model.channel.ChannelRepository;
import cn.dorado.cms.domain.model.common.Owner;
import cn.dorado.cms.domain.model.page.Page;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by Eric on 14-5-4.
 */
@Repository("channelRepository")
public class ChannelHibernateRepository extends GenericHibernateRepository implements ChannelRepository {
    
    public DomainId nextIdentity() {
        return new DomainId(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    
    public void add(Channel channel) {
        try {
            this.getSession().saveOrUpdate(channel);
        }catch (ConstraintViolationException e){
            throw new IllegalStateException("Channel is not unique.",e);
        }
    }

    
    public void addAll(Collection<Channel> channelCollection) {
        try{
            for(Channel channel : channelCollection){
                this.getSession().saveOrUpdate(channel);
            }
        }catch (ConstraintViolationException e){
            throw new IllegalStateException("Channel is not unique.",e);
        }
    }

    
    public void remove(Channel channel) {
          this.getSession().delete(channel);
    }

   
    public void removeAll(Collection<Channel> channelCollection) {
      for(Channel channel:channelCollection){
          this.getSession().delete(channel);
      }
    }

    
    public Channel ChannelOfId(DomainId channelId) {
        return (Channel)this.getSession().get(Channel.class,channelId);
    }

    
    public Page createPage(DomainId pageId, Owner owner, String title,String channelId) {
        Page page=new Page(pageId,title,owner,channelId);
        return page;
    }
}
