package cn.dorado.domain.model;

import cn.dorado.cms.domain.DomainId;
import cn.dorado.cms.domain.model.channel.Channel;
import cn.dorado.cms.domain.model.channel.ChannelRepository;
import cn.dorado.cms.domain.model.common.Owner;
import cn.dorado.domain.BaseRepositoryTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

/**
 * Created by Eric on 14-5-4.
 */
public class ChannelHibernateRepositoryTestCase extends BaseRepositoryTestCase {

    @Autowired
    private   ChannelRepository channelRepository;

    @Test
    public void testAddAndRemoveChannel() throws Exception{
        String channelId=channelRepository.nextIdentity();
        Owner owner=new Owner();
        owner.setOwnerName("Eric");

        Channel channel=new Channel(channelId,"New Test Channel","Eric");
        channelRepository.add(channel);
        assertEquals(channel,channelRepository.ChannelOfId(channelId));

        channelRepository.remove(channel);
        assertNull(channelRepository.ChannelOfId(channelId));
    }
}
