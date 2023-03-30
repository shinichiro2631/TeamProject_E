package dto;

public class Review {
	private int id;
	private int account_id;
	private String user_name;
	private String name;
	private String book_review;
	private String isbn;
	public Review(int id, int account_id, String user_name, String name, String book_review, String isbn) {
		super();
		this.id = id;
		this.account_id = account_id;
		this.user_name = user_name;
		this.name = name;
		this.book_review = book_review;
		this.isbn = isbn;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBook_review() {
		return book_review;
	}
	public void setBook_review(String book_review) {
		this.book_review = book_review;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
}