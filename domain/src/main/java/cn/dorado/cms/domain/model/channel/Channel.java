package cn.dorado.cms.domain.model.channel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import cn.dorado.cms.domain.AbstractEntity;
import cn.dorado.cms.domain.DomainId;
import cn.dorado.cms.domain.model.common.ApprovalState;
import cn.dorado.cms.domain.model.common.PublishState;
import cn.dorado.util.DateUtil;

/**
 * Created by Eric on 14-4-29.
 */
@Entity(name="channel")
public class Channel extends AbstractEntity {
    @Id
    String channelId;
    @Column(length=255)
    String title;

    @Column
    int channelState;
    @Column
    int approvalState;
    @Column
    String ownerName;
    @Column
    String createDate;

    public Channel(){
        super();
    }
   public Channel(String channelId,String title,String ownerName){
       this.setChannelId(channelId);
       this.setTitle(title);
       this.setOwner(ownerName);
       this.setCreateDate(DateUtil.getToday().toString());
       this.setChannelState(PublishState.DRAFT);
       this.setApprovalState(ApprovalState.INIT);

   }
    public String getChannelId() {
        return channelId;
    }

    protected void setChannelId(String chancelId) {
        this.channelId = chancelId;
    }

    public String getTitle() {
        return title;
    }

    protected void setTitle(String title) {
        this.title = title;
    }


    public int getChannelState() {
        return channelState;
    }

    protected void setChannelState(int chancelState) {
        this.channelState = chancelState;
    }

    public int getApprovalState() {
        return approvalState;
    }

    protected void setApprovalState(int approvalState) {
        this.approvalState = approvalState;
    }

    public String getOwner() {
        return ownerName;
    }

    protected void setOwner(String ownerName) {
        this.ownerName = ownerName;
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
                ", owner=" + ownerName +
                ", createDate=" + createDate +
                '}';
    }
}