package dto;

public class Account {
	private int id;
	private String name;
	private String user_name;
	private int tel;
	private String mail;
	private String pw;
	private String salt;
	private String hashedPassword;
	
	public Account(int id, String name, String user_name, int tel, String mail, String pw, String salt,
			String hashedPassword) {
		super();
		this.id = id;
		this.name = name;
		this.user_name = user_name;
		this.tel = tel;
		this.mail = mail;
		this.pw = pw;
		this.salt = salt;
		this.hashedPassword = hashedPassword;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}
}
