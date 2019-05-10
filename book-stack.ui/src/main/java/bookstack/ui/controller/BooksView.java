package bookstack.ui.controller;

import java.beans.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import bookstack.business.AuthorService;
import bookstack.business.BookService;
import bookstack.business.CategoryService;
import bookstack.persistence.entities.Author;
import bookstack.persistence.entities.Book;
import bookstack.persistence.entities.Category;

@ViewScoped
@Named
public class BooksView implements Serializable {
	
	private static final long serialVersionUID = 6559129950166292602L;
	
	private String input;
	
	private Author author;
	private Book book;
	private Category category;
	
	private String bookTitle;
	
	private List<Book> bookList;
	private List<Author> authorList;
	private List<Category> categoryList;
	
	private Author selectedAuthor;
	private Category selectedCategory;
	private Currency selectedCurrency;
	
	private float suma;
	private float kSuma;
	
	@Inject
	private BookService bookService;
	
	@Inject
	private AuthorService authorService;
	
	@Inject
	private CategoryService categoryService;
	
	@PostConstruct
	private void init() {
		System.out.println(this.getClass().getName() + " created.");
		bookList = bookService.getAllBooks();
		authorList = authorService.getAllAuthors();
		categoryList = categoryService.getAllCategory();
		
		input = "init hodnota";
		
		author = new Author();
		book = new Book();
		category = new Category();
		setSelectedCurrency(Currency.DOLAR);
	}
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public List<Author> getAuthorList() {
		return authorList;
	}

	public void setAuthorList(List<Author> authorList) {
		this.authorList = authorList;
	}

	@PreDestroy
	private void destroy(){
		System.out.println(this.getClass().getName() + " was destroyed.");
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public Currency getSelectedCurrency() {
		return selectedCurrency;
	}

	public void setSelectedCurrency(Currency selectedCurrency) {
		this.selectedCurrency = selectedCurrency;
	}
	
	public List<Currency> getCurrencies() {
		return Arrays.asList(Currency.values());
	}
	
	public float getkSuma() {
		return kSuma;
	}

	public void setkSuma(float kSuma) {
		this.kSuma = kSuma;
	}

	public float getSuma() {
		return suma;
	}

	public void setSuma(float suma) {
		this.suma = suma;
	}
	
	public String getCurrencyLabel(Currency currency) {
		return currency.name().toLowerCase() + " " + currency.getExchange();
	}
	
	@Transient
	public String getAuthorLabel(Author author) {
		return author.getFullName();
	}
	
	public String getCategoryLabel(Category category) {
		return category.getCategory_name();
	}
	
	public void processCurrency() {
		//System.out.println("processing currency | " + selectedCurrency + " | " + selectedCurrency.getExchange());
		this.kSuma = suma * getSelectedCurrency().getExchange();
		System.out.println("Suma:" + suma + ", mena:" + selectedCurrency + ", konvertovana suma: " + kSuma);
		
	}

	public Author getSelectedAuthor() {
		return selectedAuthor;
	}

	public void setSelectedAuthor(Author selectedAuthor) {
		this.selectedAuthor = selectedAuthor;
	}
	
	public Category getSelectedCategory() {
		return selectedCategory;
	}

	public void setSelectedCategory(Category selectedCategory) {
		this.selectedCategory = selectedCategory;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
}
