package bookstack.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import bookstack.persistence.dao.AuthorDAO;
import bookstack.persistence.entities.Author;

@Stateless
public class AuthorService {

	@Inject
	private AuthorDAO authorDAO;
	
	public Author findAuthorByName(String name,String surname){
		return this.authorDAO.getAuthorByName(name, surname);
	}
	
	public Author createAuthor(Author author) {
		return this.authorDAO.create(author);
	}
	
	public Author deleteAuthor(Author author) {
		return this.authorDAO.delete(author);
	}
	
	public List<Author> getAllAuthors() {
		return authorDAO.findAll();
	}
}