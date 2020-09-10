package bigsubject.model;

public class Borrow {
	private int id;
	private String bookname;
	private String borrowname;
	private String phonenumber;
	public Borrow() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Borrow(int id, String bookname, String borrowname, String phonenumber) {
		super();
		this.id = id;
		this.bookname = bookname;
		this.borrowname = borrowname;
		this.phonenumber = phonenumber;
	}
	
	public Borrow(String bookname, String borrowname, String phonenumber) {
		super();
		this.bookname = bookname;
		this.borrowname = borrowname;
		this.phonenumber = phonenumber;
	}
	public void Borrow1(String bookname2, String lendman, String phone) {
		// TODO Auto-generated constructor stub
		this.bookname = bookname2;
		this.borrowname = lendman;
		this.phonenumber = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBorrowname() {
		return borrowname;
	}
	public void setBorrowname(String borrowname) {
		this.borrowname = borrowname;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
}
