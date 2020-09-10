package bigsubject.model;
/**
 * 图书实体
 * @author Administrator
 *
 */
public class Book {
	private int id;
	private String bookName;
	private String author;
	private String press;//出版社
	private String version;//版本
	private float price;
	private Integer booktypeId;
	private String bookTypename;
	private String bookDesc;
	
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	



	public Book(String bookName, String author, String press, String version, float price, Integer booktypeId,
			String bookDesc) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.press = press;
		this.version = version;
		this.price = price;
		this.booktypeId = booktypeId;
		this.bookDesc = bookDesc;
	}

	



	public Book(int id, String bookName, String author, String press, String version, float price, Integer booktypeId,
			String bookDesc) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.press = press;
		this.version = version;
		this.price = price;
		this.booktypeId = booktypeId;
		this.bookDesc = bookDesc;
	}





	public Book(String bookName, String author, Integer booktypeId) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.booktypeId = booktypeId;
	}





	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Integer getBooktypeId() {
		return booktypeId;
	}
	public void setBooktypeId(Integer booktypeId) {
		this.booktypeId = booktypeId;
	}
	public String getBookTypename() {
		return bookTypename;
	}
	public void setBookTypename(String bookTypename) {
		this.bookTypename = bookTypename;
	}
	public String getBookDesc() {
		return bookDesc;
	}
	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}
	
}

