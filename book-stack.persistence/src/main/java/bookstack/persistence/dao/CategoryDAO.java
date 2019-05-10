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
	 * Method retrieves the category which is identified by category_name
	 * (unique), in case of no category_name found it returns NULL OBJECT.
	 * 
	 * @param category_name
	 * @return category identified by category_name, otherwise NULL
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
