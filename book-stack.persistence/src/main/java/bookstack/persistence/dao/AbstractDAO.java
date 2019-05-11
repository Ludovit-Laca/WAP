package bookstack.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class AbstractDAO<T> {
	
	private Class<T> entityClass;

	@PersistenceContext(unitName = "bookstackPU")
	protected EntityManager em;
	
	public AbstractDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public T create(T entity) {
        em.persist(entity);
        return entity;
    }

    public T edit(T entity) {
        em.merge(entity);
        return entity;
    }

    public T delete(T entity) {
    	T entity2 = em.merge(entity);
        em.remove(entity2);
        return entity;
    }

    public List<T> findAll() {
    	CriteriaBuilder cb = em.getCriteriaBuilder();
    	CriteriaQuery<T> query = cb.createQuery(entityClass);
    	Root<T> root = query.from(entityClass);
    	query.select(root);
    	TypedQuery<T> typedQuery = em.createQuery(query);
	    return typedQuery.getResultList();
    }

    public T find(Long id) {
        T entity = em.find(entityClass, id);
        return entity;
    }

}
