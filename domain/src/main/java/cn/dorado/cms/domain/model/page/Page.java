package cn.dorado.cms.domain.model.page;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import cn.dorado.cms.domain.AbstractEntity;
import cn.dorado.cms.domain.DomainId;
import cn.dorado.cms.domain.model.channel.Channel;
import cn.dorado.cms.domain.model.common.ApprovalState;
import cn.dorado.cms.domain.model.common.Owner;
import cn.dorado.cms.domain.model.common.PublishState;
import cn.dorado.util.DateUtil;

/**
 * Created by Eric on 14-4-29.
 */
@Entity
public class Page extends AbstractEntity {
    @Id
    DomainId pageId;
    @Column
    String title;
    @Column(name="ownerName")
    @Embedded
    Owner owner;
    @Column
    @Enumerated(EnumType.STRING)
    PublishState publishState;
    @Column
    @Enumerated(EnumType.STRING)
    ApprovalState approvalState;
    @Column
    String createDate;
   
    @ManyToOne(targetEntity =Channel.class,fetch=FetchType.EAGER)
    @JoinColumn(name="channelId",updatable=false)
    Channel channel;

 

    public Channel getChannel() {
		return channel;
	}

	protected void setChannel(Channel channel) {
		this.channel = channel;
	}

	public String getCreateDate() {
        return createDate;
    }

    protected void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Page(DomainId pageId,String title,Owner owner,Channel channel)  {

        this.setPageId(pageId);
        this.setTitle(title);
        this.setOwner(owner);
        this.setPublishState(PublishState.DRAFT);
        this.setApprovalState(ApprovalState.INIT);
        this.setCreateDate(DateUtil.getToday().toString());
        this.setChannel(channel);
    }
    public Page(){
        super();
    }
    @Override
    public String toString() {
        return "Page{" +
                "columnId=" + pageId +
                ", title='" + title + '\'' +
                ", owner=" + owner +
                ", publishState=" + publishState +
                ", approvalState=" + approvalState +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Page page = (Page) o;

        if (!pageId.equals(page.pageId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return pageId.hashCode();
    }

    public DomainId getPageId() {
        return pageId;
    }

    public void setPageId(DomainId pageId) {
        this.pageId = pageId;
    }

    public String getTitle() {
        return title;
    }

    protected void setTitle(String title) {
        this.title = title;
    }





    public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public PublishState getPublishState() {
        return publishState;
    }

    protected void setPublishState(PublishState publishState) {
        this.publishState = publishState;
    }

    public ApprovalState getApprovalState() {
        return approvalState;
    }

    protected void setApprovalState(ApprovalState approvalState) {
        this.approvalState = approvalState;
    }
}
