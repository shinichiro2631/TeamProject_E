package dto;

public class Arrears {
	private String name;
	private int account_id;
	private int book_id;
	private String title;
	private String loan_date;
	private String due_date;
	public Arrears(String name, int account_id, int book_id, String title, String loan_date, String due_date) {
		super();
		this.name = name;
		this.account_id = account_id;
		this.book_id = book_id;
		this.title = title;
		this.loan_date = loan_date;
		this.due_date = due_date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLoan_date() {
		return loan_date;
	}
	public void setLoan_date(String loan_date) {
		this.loan_date = loan_date;
	}
	public String getDue_date() {
		return due_date;
	}
	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}
	
}
