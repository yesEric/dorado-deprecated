package cn.dorado.cms.domain.model.common;

import javax.persistence.Embeddable;

/**
 * Created by Eric on 14-4-29.
 */
@Embeddable
public class Owner implements User{
    String ownerName;

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
