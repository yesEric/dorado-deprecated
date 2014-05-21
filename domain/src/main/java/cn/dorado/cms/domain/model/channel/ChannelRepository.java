package cn.dorado.cms.domain.model.channel;

import java.util.Collection;
import java.util.List;

import cn.dorado.cms.domain.DomainId;
import cn.dorado.cms.domain.model.page.Page;

/**
 * Created by Eric on 14-5-4.
 */
public interface ChannelRepository {

    public DomainId nextIdentity();
    public void add(Channel channel);
    public void addAll(Collection<Channel> channelCollection);
    public void remove(Channel channel);
    public void removeAll(Collection<Channel> channelCollection);
    public Channel ChannelOfId(DomainId channelId);   
    public Collection<Page> pagesOfChannel(Channel channel);
    public List<Channel> allChannels();
}
