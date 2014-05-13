package cn.dorado.cms.application;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collection;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.dorado.cms.application.channel.ChannelApplication;
import cn.dorado.cms.application.channel.ChannelDto;
import cn.dorado.cms.domain.model.common.Approver;
import cn.dorado.cms.domain.model.common.Owner;
import cn.dorado.cms.domain.model.page.Page;
import cn.dorado.cms.domain.model.page.PageRepository;

public class ChannelApplicationTestCase extends BaseApplicationTestCase{
	
	@Autowired
	ChannelApplication channelApplication;
	@Autowired 
	PageRepository pageRepository;
	
	
	@Test
	public void testSave()throws Exception{
		String channelId=savedChannelId();
		ChannelDto dto=channelApplication.channelOfId(channelId);
		assertEquals("Eric",dto.getOwner().getOwnerName());
		
	}
	@Test
	public void testApproved() throws Exception{
		String channelId=savedChannelId();
		channelApplication.commit(channelId);
		channelApplication.approved(channelId, new Approver("Eric"));
		ChannelDto dto=channelApplication.channelOfId(channelId);
		
		assertEquals("Eric",dto.getApprover().getApproverName());
	}
	
	@Test public void testReject()throws Exception{
		String channelId=savedChannelId();
		channelApplication.commit(channelId);
		channelApplication.reject(channelId, new Approver("Eric"));
		ChannelDto dto=channelApplication.channelOfId(channelId);
		
		assertEquals("Eric",dto.getApprover().getApproverName());
	}
	
	@Test public void testActive()throws Exception{
		
		String channelId=savedChannelId();
		channelApplication.commit(channelId);
		channelApplication.approved(channelId, new Approver("Eric"));
		channelApplication.active(channelId);
		ChannelDto dto=channelApplication.channelOfId(channelId);
		
		assertEquals("PUBLISHED",dto.getChannelState().toString());
	}
	@Test public void testGetPagesOfChannel()throws Exception{
		String channelId=savedChannelId();
		channelApplication.commit(channelId);
		channelApplication.createPage("test",new Owner("Ercic"), channelId);
		Collection<Page> pages=channelApplication.pages(channelId);
		assertNotNull(pages);
		
	}
	private String savedChannelId(){
		String channelId=channelApplication.save("Test", "desc", new Owner("Eric"));
		return channelId;
	}
	
	

}
