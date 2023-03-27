package dto;

public class History {
	private int book_id;
	private int account_id;
	private String loan_date;
	private String return_date;
	private String due_date;

	public History(int book_id, int account_id, String loan_date, String return_date, String due_date) {
		super();
		this.book_id = book_id;
		this.account_id = account_id;
		this.loan_date = loan_date;
		this.return_date = return_date;
		this.due_date = due_date;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public String getLoan_date() {
		return loan_date;
	}

	public void setLoan_date(String loan_date) {
		this.loan_date = loan_date;
	}

	public String getReturn_date() {
		return return_date;
	}

	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}

	public String getDue_date() {
		return due_date;
	}

	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}
	
}

