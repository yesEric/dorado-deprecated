package cn.dorado.cms.domain;

import org.springframework.beans.factory.annotation.Autowired;

import cn.dorado.cms.domain.model.channel.ChannelRepository;


/**
 * Created by Eric on 14-4-30.
 */
public abstract class DomainRepository {

	@Autowired
    private static ChannelRepository channelRepository;

	public static ChannelRepository getChannelRepository() {
		return channelRepository;
	}
    
	
    
}
