package cn.dorado.cms.domain.model.specification;

/**
 * 
 * @author Slawek
 *
 * @param <T>
 */
public class DisjunctionSpecification<T> extends CompositeSpecification<T>{
    private Specification<T>[] disjunction;

    public DisjunctionSpecification(Specification<T>... disjunction){
        this.disjunction = disjunction;
    }

    public boolean isSatisfiedBy(T candidate){
        for (Specification<T> spec : disjunction){
        	if (spec.isSatisfiedBy(candidate))
        		return true;
        }
    	
    	return false;
    }
}
