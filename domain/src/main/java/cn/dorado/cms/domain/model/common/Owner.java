package cn.dorado.cms.domain.model.common;

import javax.persistence.Embeddable;

/**
 * Created by Eric on 14-4-29.
 */
@SuppressWarnings("serial")
@Embeddable
public class Owner implements User{
    String ownerName;
    public Owner(){};

    public Owner(String ownerName){
    	this.setOwnerName(ownerName);
    }

	public String getOwnerName() {
		return ownerName;
	}

	protected void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
   
    
}
