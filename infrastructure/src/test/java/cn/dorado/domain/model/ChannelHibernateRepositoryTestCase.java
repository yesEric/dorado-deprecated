package cn.dorado.domain.model;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.dorado.cms.domain.DomainId;
import cn.dorado.cms.domain.model.channel.Channel;
import cn.dorado.cms.domain.model.channel.ChannelRepository;
import cn.dorado.cms.domain.model.common.ApprovalState;
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
    

//    @BeforeClass
//    public static void setUp() {
//       ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//       validator = factory.getValidator();
//    }

    @Test
    public void testAddAndRemoveChannel() throws Exception{
        DomainId channelId=channelRepository.nextIdentity();
        Owner owner=new Owner();
        owner.setOwnerName("Eric");

        Channel channel=new Channel(channelId,"New Test Channel",owner);
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
        Owner owner=new Owner();
        owner.setOwnerName("Eric");

        Channel channel=new Channel(channelId,"New Test Channel",owner);
        channelRepository.add(channel);
        
        DomainId pageId=pageRepository.nextIdentity();
        Page page=channelRepository.createPage(pageId, owner, "Test Page", channelId.getId());
        assertNotNull(page);
    }
    @Test
    public void testCommitTo()throws Exception{
    	DomainId channelId=channelRepository.nextIdentity();
        Owner owner=new Owner();
        owner.setOwnerName("Eric");

        Channel channel=new Channel(channelId,"New Test Channel",owner);
        channel.commitTo();
        channelRepository.add(channel);
       
        channel=channelRepository.ChannelOfId(channelId);
        assertEquals(channel.getApprovalState(), ApprovalState.WAITING);
    }
    @Test
    public void testApproved()throws Exception{
     	DomainId channelId=channelRepository.nextIdentity();
        Owner owner=new Owner();
        owner.setOwnerName("Eric");

        Channel channel=new Channel(channelId,"New Test Channel",owner);
        channel.appoved();
        channelRepository.add(channel);
        
        channel=channelRepository.ChannelOfId(channelId);
        assertEquals(channel.getApprovalState(),ApprovalState.APPROVED);
    }
    @Test
    public void testReject()throws Exception{
     	DomainId channelId=channelRepository.nextIdentity();
        Owner owner=new Owner();
        owner.setOwnerName("Eric");

        Channel channel=new Channel(channelId,"New Test Channel",owner);
        channel.reject();
        channelRepository.add(channel);
        
        channel=channelRepository.ChannelOfId(channelId);
        assertEquals(channel.getApprovalState(),ApprovalState.REJECTED);
    }
    
    @Test
    public void testActive()throws Exception{
     	DomainId channelId=channelRepository.nextIdentity();
        Owner owner=new Owner();
        owner.setOwnerName("Eric");

        Channel channel=new Channel(channelId,"New Test Channel",owner);
        channel.active();
        channelRepository.add(channel);
        
        channel=channelRepository.ChannelOfId(channelId);
        assertEquals(channel.getChannelState(),PublishState.PUBLISHED);
    }
    @Test
    public void testDeactive()throws Exception{
     	DomainId channelId=channelRepository.nextIdentity();
        Owner owner=new Owner();
        owner.setOwnerName("Eric");

        Channel channel=new Channel(channelId,"New Test Channel",owner);
        channelRepository.add(channel);
        channel.deactive();
        channel=channelRepository.ChannelOfId(channelId);
        assertEquals(channel.getChannelState(),PublishState.CLOSED);
    }
    @Test
    public void testNullOwnerValidator()throws Exception{
    	DomainId channelId=channelRepository.nextIdentity();
        Owner owner=new Owner();
       // owner.setOwnerName("Eric");
        

        Channel channel=new Channel(channelId,"New Test Channel",null);
        Set<ConstraintViolation<Channel>> constraintViolations =
      	      validator.validate( channel );
        assertEquals( 2, constraintViolations.size() );
        assertEquals(
                "The owner is not allow null value",
                constraintViolations.iterator().next().getMessage()
                );
        //channelRepository.add(channel);
    	
    	
    }
}
