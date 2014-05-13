package cn.dorado.cms.domain.model.common;

import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class Approver implements User {
    String approverName;
    
    public Approver(){}

	public Approver(String approverName) {
		this.setApproverName(approverName);
	}

	public String getApproverName() {
		return approverName;
	}

	protected void setApproverName(String approverName) {
		this.approverName = approverName;
	}


}
