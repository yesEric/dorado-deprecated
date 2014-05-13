package cn.dorado.cms.application.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.dorado.cms.application.channel.ChannelApplication;
import cn.dorado.cms.application.channel.ChannelDto;
import cn.dorado.cms.domain.DomainId;
import cn.dorado.cms.domain.model.channel.Channel;
import cn.dorado.cms.domain.model.channel.ChannelRepository;
import cn.dorado.cms.domain.model.common.Approver;
import cn.dorado.cms.domain.model.common.DomainException;
import cn.dorado.cms.domain.model.common.Owner;
import cn.dorado.cms.domain.model.page.Page;
import cn.dorado.cms.domain.model.page.PageRepository;

@Service("channelApplication")
public class ChannelApplicationImpl implements ChannelApplication{
	protected final Log log = LogFactory.getLog(getClass());
	@Autowired
	ChannelRepository channelRepository;
	@Autowired
	PageRepository pageRepository;
	@Transactional
	public String save(String title, String description, Owner owner) {
		DomainId channelId=channelRepository.nextIdentity();
		Channel channel=new Channel(channelId,title,description,owner);
		channelRepository.add(channel);
		return channelId.getId();
		
		
	}
	@Transactional
	public void approved(String channelId, Approver approver) {
		this.notNullChannel(channelId).appoved(approver);
		
	}
	@Transactional
	public void reject(String channelId, Approver approver) {
		this.notNullChannel(channelId).reject(approver);
		
	}
	@Transactional
	public void commit(String channelId) {
		this.notNullChannel(channelId).commit();
		
	}
	@Transactional
	public void active(String channelId) {
		this.notNullChannel(channelId).active();
		
	}
	@Transactional
	public void deactive(String channelId) {
		this.notNullChannel(channelId).deactive();
		
	}
	@Transactional(readOnly=true)
	public Channel notNullChannel(String channelId){
		Channel channel=channelRepository.ChannelOfId(new DomainId(channelId));
		if(channel==null){
			throw new DomainException("domain.not.found",channelId);
		}		
		
		return channel;
	}
	public ChannelDto channelOfId(String channelId) {
		Channel channel=notNullChannel(channelId);
		ChannelDto channelDto=new ChannelDto();
		try {
			BeanUtils.copyProperties(channelDto, channel);
		} catch (IllegalAccessException e) {
			log.error(e);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			log.error(e);
			e.printStackTrace();
		}
		return channelDto;
	}
	public Collection<Page> pages(String channelId) {
		Channel channel=notNullChannel(channelId);
		return channelRepository.pagesOfChannel(channel);
	}
	public void createPage(String title, Owner owner, String channelId) {
		Channel channel=notNullChannel(channelId);
		
		pageRepository.add(channel.createPage(pageRepository.nextIdentity(), owner, title));
		
	}

}
