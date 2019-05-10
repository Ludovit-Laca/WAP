package bookstack.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import bookstack.persistence.dao.CategoryDAO;
import bookstack.persistence.entities.Author;
import bookstack.persistence.entities.Category;

@Stateless
public class CategoryService {

	@Inject
	private CategoryDAO categoryDAO;
	
	public Category findCategoryByName(String name){
		return this.categoryDAO.getCategoryByName(name);
	}
	
	public Category createCategory(Category category) {
		return this.categoryDAO.create(category);
	}
	
	public List<Category> getAllCategory() {
		return categoryDAO.findAll();
	}
	
	public Category deleteCategory(Category category) {
		return this.categoryDAO.delete(category);
	}
}