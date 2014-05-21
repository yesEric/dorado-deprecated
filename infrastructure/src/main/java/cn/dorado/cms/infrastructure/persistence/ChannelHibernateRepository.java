package cn.dorado.cms.infrastructure.persistence;

import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Repository;

import cn.dorado.cms.domain.DomainId;
import cn.dorado.cms.domain.model.channel.Channel;
import cn.dorado.cms.domain.model.channel.ChannelRepository;
import cn.dorado.cms.domain.model.common.Owner;
import cn.dorado.cms.domain.model.page.Page;

/**
 * Created by Eric on 14-5-4.
 */
@SuppressWarnings("rawtypes")
@Repository("channelRepository")
public class ChannelHibernateRepository extends GenericHibernateRepository
implements ChannelRepository {
    
    @SuppressWarnings("unchecked")
	public ChannelHibernateRepository() {
		super(Channel.class);
		
	}


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

    
    public Page createPage(DomainId pageId, Owner owner, String title,Channel channel) {
        Page page=new Page(pageId,title,owner,channel);
        return page;
    }


	@SuppressWarnings("unchecked")
	public Collection<Page> pagesOfChannel(Channel channel) {
	 return	this.getSession().createCriteria(Page.class).add(Restrictions.eq("channel", channel)).list();
		
	}


	@SuppressWarnings("unchecked")
	public List<Channel> allChannels() {
		
		return this.getAll();
	}

}
