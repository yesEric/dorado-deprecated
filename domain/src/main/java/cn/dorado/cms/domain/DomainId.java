package cn.dorado.cms.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * Created by Eric on 14-4-29.
 * 此值对象用于保存实体的ID
 */
@Embeddable
public class DomainId  implements Serializable {
	
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DomainId other = (DomainId) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public DomainId(){}

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