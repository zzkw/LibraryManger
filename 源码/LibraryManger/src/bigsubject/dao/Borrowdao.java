package bigsubject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bigsubject.model.Borrow;
import bigsubject.util.Stringutil;

public class Borrowdao {
	public static int add(Connection con,Borrow borrow)throws Exception{
		String sql="insert into l_borrow values(?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, borrow.getBookname());
		ps.setString(2, borrow.getBorrowname());
		ps.setString(3, borrow.getPhonenumber());
		return ps.executeUpdate();
	}
	public static ResultSet list(Connection con,Borrow borrow)throws Exception{
		StringBuffer stb=new StringBuffer("select* from l_borrow");
		if(Stringutil.isNotEmpty(borrow.getBookname())){
			stb.append(" and bookname like '%"+borrow.getBookname()+"%'");
		}
		PreparedStatement ps=con.prepareStatement(stb.toString().replaceFirst("and", "where"));
		return ps.executeQuery();
	}
	public int delete(Connection con,String id)throws Exception{
		String sql="delete from l_borrow where id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, id);
		return ps.executeUpdate();
	}
	public int update(Connection con,Borrow borrow)throws Exception{
		String sql = "update l_borrow set bookname=?,borrowname=?,phonenumber=? where id = ?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, borrow.getBookname());
		ps.setString(2, borrow.getBorrowname());
		ps.setString(3, borrow.getPhonenumber());
		ps.setInt(4, borrow.getId());
		return ps.executeUpdate();
	}
}
