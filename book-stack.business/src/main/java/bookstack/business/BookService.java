package bookstack.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import bookstack.persistence.dao.AuthorDAO;
import bookstack.persistence.dao.BookDAO;
import bookstack.persistence.dao.CategoryDAO;
import bookstack.persistence.entities.Author;
import bookstack.persistence.entities.Book;
import bookstack.persistence.entities.Category;

@Stateless
public class BookService {
	
	@Inject
	private BookDAO bookDao;
	
	@Inject
	private AuthorDAO authorDao;
	
	@Inject
	private CategoryDAO categoryDao;
	
	public List<Book> getBooksByTitle(String title) {
		return bookDao.getBooksByTitle(title);
	}
	
	public List<Book> getAllBooks() {
		return bookDao.findAll();
	}
	
	public Book create(Book book,Author author, Category category){
		Author authorFromDb = authorDao.getAuthorByName(author.getName(),author.getSurname());
		Category categoryFromDb = categoryDao.getCategoryByName(category.getCategory_name());
		if(authorFromDb != null){
			book.setAutor(authorFromDb);
		}else{
			//neexistuje vytvorime noveho
			book.setAutor(author);
		}
		if(categoryFromDb != null){
			book.setCategory(categoryFromDb);
		}else{
			//neexistuje vytvorime noveho
			book.setCategory(category);
		}
		return this.bookDao.create(book);
	}
	
	public Book deleteBook(Book book) {
		return this.bookDao.delete(book);
	}

}
