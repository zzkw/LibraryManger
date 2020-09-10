package bigsubject.model;

/**
 * 图书类别实体
 * @author Administrator
 *
 */
public class Booktype {
	private int id;
	private String bookTypename;
	private String bookTypeDesc;
	
	public Booktype() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public Booktype(String bookTypename, String bookTypeDesc) {
		super();
		this.bookTypename = bookTypename;
		this.bookTypeDesc = bookTypeDesc;
	}

	
	
	public Booktype(int id, String bookTypename, String bookTypeDesc) {
		super();
		this.id = id;
		this.bookTypename = bookTypename;
		this.bookTypeDesc = bookTypeDesc;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBooktypename() {
		return bookTypename;
	}
	public void setBooktypename(String bookTypename) {
		this.bookTypename = bookTypename;
	}
	public String getBookTypeDesc() {
		return bookTypeDesc;
	}
	public void setBookTypeDesc(String bookTypeDesc) {
		this.bookTypeDesc = bookTypeDesc;
	}



	@Override
	public String toString() {
		return bookTypename;
	}
	
}
