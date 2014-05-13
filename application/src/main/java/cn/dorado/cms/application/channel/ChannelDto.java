package cn.dorado.cms.application.channel;

import java.io.Serializable;

import cn.dorado.cms.domain.model.common.ApprovalState;
import cn.dorado.cms.domain.model.common.Approver;
import cn.dorado.cms.domain.model.common.Owner;
import cn.dorado.cms.domain.model.common.PublishState;

@SuppressWarnings("serial")
public class ChannelDto implements Serializable {

	String id;
	String title;
	String description;
	PublishState channelState;
	ApprovalState approvalState;
	Owner owner;
	Approver approver;
	String createDate;
	String lastedModifyDate;
	String approvalDate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public PublishState getChannelState() {
		return channelState;
	}
	public void setChannelState(PublishState channelState) {
		this.channelState = channelState;
	}
	public ApprovalState getApprovalState() {
		return approvalState;
	}
	public void setApprovalState(ApprovalState approvalState) {
		this.approvalState = approvalState;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getLastedModifyDate() {
		return lastedModifyDate;
	}
	public void setLastedModifyDate(String lastedModifyDate) {
		this.lastedModifyDate = lastedModifyDate;
	}
	public String getApprovalDate() {
		return approvalDate;
	}
	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}
	public Approver getApprover() {
		return approver;
	}
	public void setApprover(Approver approver) {
		this.approver = approver;
	}
	
	
}
