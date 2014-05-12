package cn.dorado.cms.domain.model.specification;

/**
 * 
 * @author Slawek
 *
 * @param <T>
 */
public interface Specification<T> {
	boolean isSatisfiedBy(T candidate);

	Specification<T> and(Specification<T> other);

	Specification<T> or(Specification<T> other);

	Specification<T> not();
}
