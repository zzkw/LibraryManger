package bigsubject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bigsubject.model.User;
import bigsubject.util.Jdbcutil;

/**
  * 用户dao类
  * @author Administrator
  *
  */
public class Userdao {
	/**
	 * 登录验证
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User login(Connection con,User user)throws Exception{
		User reUser =null;
		String sql="select* from l_user where users=? and passwd=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, user.getUser());
		ps.setString(2, user.getPasswd());
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			reUser=new User();
			reUser.setId(rs.getInt("id"));
			reUser.setUser(rs.getString("users"));
			reUser.setPasswd(rs.getString("passwd"));
		}
		return reUser;
		
	}

	public User login(Class<? extends Jdbcutil> con, User user1) {
		// TODO Auto-generated method stub
		return null;
	}
}
