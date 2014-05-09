package cn.dorado.cms.domain.model.channel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

import cn.dorado.cms.domain.AbstractEntity;
import cn.dorado.cms.domain.DomainId;
import cn.dorado.cms.domain.model.common.ApprovalState;
import cn.dorado.cms.domain.model.common.Owner;
import cn.dorado.cms.domain.model.common.PublishState;
import cn.dorado.util.DateUtil;

/**
 * Created by Eric on 14-4-29.
 */
@Entity(name="channel")
@Validated
public class Channel extends AbstractEntity {
    @Id
    DomainId channelId;
    @Column
    String title;

    @Column
    @Enumerated(EnumType.STRING)
    @NotNull
    PublishState channelState;
    @Column
    @Enumerated(EnumType.STRING)
    @NotNull
    ApprovalState approvalState;
    @Column    
    @NotNull(message="{channel.owner.null}")
    @NotBlank(message = "{channel.owner.null}") 
    Owner owner;
    @Column
    @NotNull 
    @NotBlank
    String createDate;

    public Channel(){
        super();
    }
   public Channel(DomainId channelId,String title,Owner owner){
       this.setChannelId(channelId);
       this.setTitle(title);
       this.setOwner(owner);
       this.setCreateDate(DateUtil.getToday().toString());
       this.setChannelState(PublishState.DRAFT);
       this.setApprovalState(ApprovalState.INIT);

   }
    public DomainId getChannelId() {
        return channelId;
    }

    protected void setChannelId(DomainId chancelId) {
        this.channelId = chancelId;
    }

    public String getTitle() {
        return title;
    }

    protected void setTitle(String title) {
        this.title = title;
    }


    public PublishState getChannelState() {
        return channelState;
    }

    protected void setChannelState(PublishState chancelState) {
        this.channelState = chancelState;
    }

    public ApprovalState getApprovalState() {
        return approvalState;
    }

    protected void setApprovalState(ApprovalState approvalState) {
        this.approvalState = approvalState;
    }

    public Owner getOwner() {
        return owner;
    }
    
    protected void setOwner(Owner Owner) {
        this.owner = owner;
    }

    public String getCreateDate() {
        return createDate;
    }

    protected void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Channel channel = (Channel) o;

        if (channelId != null ? !channelId.equals(channel.channelId) : channel.channelId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return channelId != null ? channelId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "chancelId=" + channelId +
                ", title='" + title + '\'' +
                ", chancelState=" + channelState +
                ", approvalState=" + approvalState +
                ", owner=" + owner +
                ", createDate=" + createDate +
                '}';
    }
    /**
     * 保存并提交审核
     */
    public void commitTo(){
    	
    	this.setApprovalState(ApprovalState.WAITING);
    }
    /**
     * 设置为审核通过
     */
    public void appoved(){
    	this.setApprovalState(ApprovalState.APPROVED);
    }
    /**
     * 设置为打回
     */
    public void reject(){
    	this.setApprovalState(ApprovalState.REJECTED);
    }
    /**
     * 激活频道
     */
    public void active(){
    	this.setChannelState(PublishState.PUBLISHED);
    }
    /**
     * 关闭频道
     */
    public void deactive(){
    	this.setChannelState(PublishState.CLOSED);
    }
}
