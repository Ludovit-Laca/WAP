package bookstack.persistence.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@NamedQueries({
	@NamedQuery(name = "findBooksByCategory", query = "SELECT c FROM Category c WHERE c.category_name = :category_name")
})
public class Category  {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "category_name")
	private String category_name;
	
	// namapovanie OneToMany
	@OneToMany(mappedBy = "category", cascade={CascadeType.ALL})
	private List<Book> books;
	
	// konštruktory 
	public Category(){
	}
	
	public Category(String category_name ) {
		this.category_name = category_name;
		this.books = new ArrayList<>();
	}
	
	// getters a setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}