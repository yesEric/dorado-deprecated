package cn.dorado.cms.application.channel;

import java.util.Collection;

import cn.dorado.cms.domain.DomainId;
import cn.dorado.cms.domain.model.channel.Channel;
import cn.dorado.cms.domain.model.common.Approver;
import cn.dorado.cms.domain.model.common.Owner;
import cn.dorado.cms.domain.model.page.Page;

public interface ChannelApplication {

	public String save(String title,String description, Owner owner);
	public void approved(String channelId,Approver approver);
	public void reject(String channelId,Approver approver);
	public void commit(String channelId);
	public void active(String channelId);
	public void deactive(String channelId);
	public ChannelDto channelOfId(String channelId);
	public Collection<Page> pages(String channelId);
	public void createPage(String title,Owner owner,String channelId);
	
}
