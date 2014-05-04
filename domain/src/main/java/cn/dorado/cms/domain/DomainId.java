package cn.dorado.cms.domain;

import java.io.Serializable;

/**
 * Created by Eric on 14-4-29.
 * 此值对象用于保存实体的ID
 */
public class DomainId  implements Serializable {
	
    public DomainId(String domainId){
        this.setId(domainId);
    }
    String id;

    public String getId() {
        return id;
    }

    protected void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DomainId{" +
                "id='" + id + '\'' +
                '}';
    }
}