package bookstack.persistence.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

//dvojica meno+priezvisko musi byt jedinecna
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "name", "surname" }))
@Entity
@NamedQueries({
		@NamedQuery(name = "findBooksByNames", query = "SELECT a FROM Author a WHERE a.name LIKE :name AND a.surname LIKE :surname") })
public class Author {

	@Id
	@GeneratedValue
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@OneToMany(mappedBy = "autor", cascade={CascadeType.ALL}) // zmena mena
	private List<Book> books;

	public Author() {
	}

	public Author(String name, String surname) {
		this.name = name;
		this.surname = surname;
		this.books = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Transient
	public String getFullName() {
		return this.name + " " + this.surname;
	}

}
