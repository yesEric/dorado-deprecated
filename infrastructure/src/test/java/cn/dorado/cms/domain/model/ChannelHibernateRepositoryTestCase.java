package cn.dorado.cms.domain.model;

import static  org.junit.Assert.assertEquals;
import static  org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.dorado.cms.domain.DomainId;
import cn.dorado.cms.domain.model.channel.Channel;
import cn.dorado.cms.domain.model.channel.ChannelRepository;
import cn.dorado.cms.domain.model.common.ApprovalState;
import cn.dorado.cms.domain.model.common.Approver;
import cn.dorado.cms.domain.model.common.Owner;
import cn.dorado.cms.domain.model.common.PublishState;
import cn.dorado.cms.domain.model.page.Page;
import cn.dorado.cms.domain.model.page.PageRepository;
import cn.dorado.domain.BaseRepositoryTestCase;

/**
 * Created by Eric on 14-5-4.
 */
public class ChannelHibernateRepositoryTestCase extends BaseRepositoryTestCase {

    @Autowired
    private   ChannelRepository channelRepository;
    @Autowired PageRepository pageRepository;
    



    @Test
    public void testAddAndRemoveChannel() throws Exception{
        DomainId channelId=channelRepository.nextIdentity();
        Owner owner=new Owner("Eric");
        

        Channel channel=new Channel(channelId,"New Test Channel","",owner);
        channelRepository.add(channel);
        assertEquals(channel,channelRepository.ChannelOfId(channelId));
        channel=channelRepository.ChannelOfId(channelId);
        assertEquals(channel.getChannelState(),PublishState.DRAFT);
        assertEquals(channel.getApprovalState(),ApprovalState.INIT);

        channelRepository.remove(channel);
        
        assertNull(channelRepository.ChannelOfId(channelId));
        
    }
    @Test
    public void testAddPage()throws Exception
    {
    	DomainId channelId=channelRepository.nextIdentity();
    	Owner owner=new Owner("Eric");

        Channel channel=new Channel(channelId,"New Test Channel","",owner);
        channelRepository.add(channel);
        
        DomainId pageId=pageRepository.nextIdentity();
        Page page=channel.createPage(pageId, owner, "page title");
        pageRepository.add(page);
        
        
//        channel=channelRepository.ChannelOfId(channelId);
//        Collection<Page> pages=channel.pages();
//        
//        assertEquals(pages.size(),1);
    }
    @Test
    public void testCommit()throws Exception{
    	DomainId channelId=channelRepository.nextIdentity();
    	Owner owner=new Owner("Eric");

        Channel channel=new Channel(channelId,"New Test Channel","",owner);
        channel.commit();
        channelRepository.add(channel);
       
        channel=channelRepository.ChannelOfId(channelId);
        assertEquals(channel.getApprovalState(), ApprovalState.WAITING);
    }
    @Test
    public void testApproved()throws Exception{
     	DomainId channelId=channelRepository.nextIdentity();
     	Owner owner=new Owner("Eric");
        Approver approver=new Approver("Super Man");
        

        Channel channel=new Channel(channelId,"New Test Channel","",owner);
        channel.commit();
        channel.appoved(approver);
        channelRepository.add(channel);

        
        channel=channelRepository.ChannelOfId(channelId);
        assertEquals(channel.getApprovalState(),ApprovalState.APPROVED);
    }
    @Test
    public void testReject()throws Exception{
     	DomainId channelId=channelRepository.nextIdentity();
     	Owner owner=new Owner("Eric");
        Approver approver=new Approver("Super Man");
        Channel channel=new Channel(channelId,"New Test Channel","",owner);
        channel.commit();
        channel.reject(approver);
        channelRepository.add(channel);
        
        channel=channelRepository.ChannelOfId(channelId);
        assertEquals(channel.getApprovalState(),ApprovalState.REJECTED);
    }
    
    @Test
    public void testActive()throws Exception{
     	DomainId channelId=channelRepository.nextIdentity();
     	Owner owner=new Owner("Eric");;

        Channel channel=new Channel(channelId,"New Test Channel","",owner);
        channel.commit();
        channel.appoved(new Approver("dd"));
        channel.active();
        channelRepository.add(channel);
        
        channel=channelRepository.ChannelOfId(channelId);
        assertEquals(channel.getChannelState(),PublishState.PUBLISHED);
    }
    @Test
    public void testDeactive()throws Exception{
     	DomainId channelId=channelRepository.nextIdentity();
     	Owner owner=new Owner("Eric");

        Channel channel=new Channel(channelId,"New Test Channel","",owner);
        channelRepository.add(channel);
        channel.commit();
        channel.appoved(new Approver("ddd"));
        channel.active();
        channel.deactive();
        channel=channelRepository.ChannelOfId(channelId);
        assertEquals(channel.getChannelState(),PublishState.CLOSED);
    }

   
//    @Test(expected = ComparisonFailure.class)
//    public void testNullOwnerValidator()throws Exception{
//    	DomainId channelId=channelRepository.nextIdentity();
//        Owner owner=new Owner();
//       // owner.setOwnerName("Eric");
//        
//
//        Channel channel=new Channel(channelId,"New Test Channel",owner);
//        Set<ConstraintViolation<Channel>> constraintViolations =
//      	      validator.validate( channel );
//        //assertEquals( 7, constraintViolations.size() );
//        assertEquals(
//                "The owner is not allow null value",
//                constraintViolations.iterator().next().getMessage()
//                );
//        //channelRepository.add(channel);
//    	
//    	
//    }
    

    
    
 
}
