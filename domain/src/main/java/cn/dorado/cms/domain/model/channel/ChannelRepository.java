package cn.dorado.cms.domain.model.channel;

import cn.dorado.cms.domain.DomainId;
import cn.dorado.cms.domain.model.article.Article;
import cn.dorado.cms.domain.model.common.Owner;
import cn.dorado.cms.domain.model.page.Page;

import java.util.Collection;

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
    public Page createPage(DomainId pageId,Owner owner,String title,Channel channel);
    public Collection<Page> pagesOfChannel(Channel channel);
}
