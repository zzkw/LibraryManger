package bigsubject.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接操作
 * @author Administrator
 *
 */
public class Jdbcutil {
	private String url="jdbc:sqlserver://localhost:1433;DatabaseName=lib_book";
	private String username="sa";
	private String password="";
	private String jdbcName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public Connection getCon() throws Exception{
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(url,username,password);
		return con;
	}
	public void closeCon(Connection con)throws Exception{
		if(con!=null)
			con.close();
	}
	
	public static void main(String[] args) {
		Jdbcutil jdbcutil = new Jdbcutil();
		try {
			jdbcutil.getCon();
			System.out.println("数据库连接成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
	}
}

