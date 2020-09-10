package bigsubject.model;

/**
 * 用户实体
 * @author Administrator
 *
 */
public class User {
	private int id;
	private String user;
	private String passwd;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public User(String user, String passwd) {
		super();
		this.user = user;
		this.passwd = passwd;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	
}
