package cn.dorado.cms.domain.model.channel;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

import cn.dorado.cms.domain.AbstractEntity;
import cn.dorado.cms.domain.DomainId;
import cn.dorado.cms.domain.model.common.Approvable;
import cn.dorado.cms.domain.model.common.ApprovalState;
import cn.dorado.cms.domain.model.common.Approver;
import cn.dorado.cms.domain.model.common.Owner;
import cn.dorado.cms.domain.model.common.PublishState;
import cn.dorado.cms.domain.model.page.Page;
import cn.dorado.util.DateUtil;

/**
 * Created by Eric on 14-4-29.
 */
@Entity(name = "channel")
@Validated
@SuppressWarnings("serial")
public class Channel extends AbstractEntity implements Approvable {
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
	@NotNull(message = "{channel.owner.null}")
	@NotBlank(message = "{channel.owner.null}")
	Owner owner;
	@Column
	@NotNull
	@NotBlank
	String createDate;
	@Column
	@NotBlank
	String lastedModifyDate;
	@Column
	@NotBlank
	String approvalDate;
	
	@OneToMany(targetEntity=Page.class,cascade=CascadeType.ALL)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="channelId",updatable=false)
	Set<Page> pages=new HashSet<Page>();
	

	protected Set<Page> getPages() {
		return pages;
	}

	protected void setPages(Set<Page> pages) {
		this.pages = pages;
	}

	public Channel() {
		super();
	}

	public Channel(DomainId channelId, String title, Owner owner) {
		this.setChannelId(channelId);
		this.setTitle(title);
		this.setOwner(owner);
		this.setCreateDate(DateUtil.getToday().toString());
		this.setChannelState(PublishState.DRAFT);
		this.setApprovalState(ApprovalState.INIT);

	}

	public String getLastedModifyDate() {
		return lastedModifyDate;
	}

	protected void setLastedModifyDate(String lastedModifyDate) {
		this.lastedModifyDate = lastedModifyDate;
	}

	public String getApprovalDate() {
		return approvalDate;
	}

	protected void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
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
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Channel channel = (Channel) o;

		if (channelId != null ? !channelId.equals(channel.channelId)
				: channel.channelId != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return channelId != null ? channelId.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Channel{" + "chancelId=" + channelId + ", title='" + title
				+ '\'' + ", chancelState=" + channelState + ", approvalState="
				+ approvalState + ", owner=" + owner + ", createDate="
				+ createDate + '}';
	}

	/**
	 * 保存并提交审核,提交后需要指定是哪些栏目的
	 */
	public void commit() {
		
		/*只有DRAFT状态才允许提交*/
		if(this.getChannelState()!=PublishState.DRAFT || this.getApprovalState()!=ApprovalState.INIT){
			throw new ChannelException("channel.commitTo.error",this.getChannelId().toString());
		}
		
		this.setLastedModifyDate(DateUtil.getToday().toString());
		
		this.setApprovalState(ApprovalState.WAITING);
	}

	/**
	 * 设置为审核通过. 审核时要有审核人，同时设置默认审核时间为系统时间
	 */
	public void appoved(Approver appvoer) {
		if(this.getApprovalState()!=ApprovalState.WAITING){
			throw new ChannelException("channel.appoved.error",this.getChannelId().toString());
		}
		this.setApprovalDate(DateUtil.getToday().toString());
		this.setApprovalState(ApprovalState.APPROVED);

	}

	/**
	 * 设置为打回
	 */
	public void reject(Approver appvoer) {
		if(this.getApprovalState()!=ApprovalState.WAITING){
			throw new ChannelException("channel.reject.error",this.getChannelId().toString());
		}
		this.setApprovalDate(DateUtil.getToday().toString());
		this.setApprovalState(ApprovalState.REJECTED);
	}

	/**
	 * 激活频道
	 */
	public void active() {
		if(this.getApprovalState()!=ApprovalState.APPROVED ){
			throw new ChannelException("channel.active.error",this.getChannelId().toString());
		}
		this.setLastedModifyDate(DateUtil.getToday().toString());
		this.setChannelState(PublishState.PUBLISHED);
	}

	/**
	 * 关闭频道
	 */
	public void deactive() {
		if(this.getChannelState()!=PublishState.PUBLISHED ){
			throw new ChannelException("channel.deactive.error",this.getChannelId().toString());
		}
		this.setLastedModifyDate(DateUtil.getToday().toString());
		this.setChannelState(PublishState.CLOSED);
	}

	public Collection<Page> pages(){
		return this.getPages();
	}

}
