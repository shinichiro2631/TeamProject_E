package dto;

public class Book {
    private int id; // 図書ID
    private String title; // 図書名
    private String author; // 著者名
    private String isbn; // ISBN
    private String new_old; // 新書・旧書
    private String publisher; // 出版社
	public Book(int id, String title, String author, String isbn, String new_old, String publisher) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.new_old = new_old;
		this.publisher = publisher;
	}
	
	
	public Book(String title) {
		super();
		this.title = title;
	}


	public Book(int id2, String title2) {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getNew_old() {
		return new_old;
	}
	public void setNew_old(String new_old) {
		this.new_old = new_old;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
}