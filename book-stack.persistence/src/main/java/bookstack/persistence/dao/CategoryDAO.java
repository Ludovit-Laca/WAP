package bookstack.persistence.dao;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import bookstack.persistence.entities.Category;

@Stateless
public class CategoryDAO extends AbstractDAO<Category> {

	public CategoryDAO() {
		super(Category.class);
	}

	/**
	 * @param name
	 * @return category identified by name, otherwise NULL
	 */
	public Category getCategoryByName(String name) {
		TypedQuery<Category> query = em.createNamedQuery("findBooksByCategory", Category.class);
		query.setParameter("category_name", name);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			// in case of no result return null
			return null;
		}
	}
}
