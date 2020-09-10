package bigsubject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bigsubject.model.Booktype;
import bigsubject.util.Stringutil;

/**
 * ͼ�����dao��
 * @author Administrator
 *
 */
public class BookTypedao {
	/**
	 * ͼ��������
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,Booktype booktype)throws Exception{
		String sql="insert into l_booktype values(null,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, booktype.getBooktypename());
		ps.setString(2, booktype.getBookTypeDesc());
		return ps.executeUpdate();
	}
	
	/**
	 * ��ѯͼ����𼯺�
	 * @param con
	 * @param booktype
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con,Booktype booktype)throws Exception{
		StringBuffer stb=new StringBuffer("select* from l_booktype");
		if(Stringutil.isNotEmpty(booktype.getBooktypename())){
			stb.append(" and booktypename like '%"+booktype.getBooktypename()+"%'");
		}
		PreparedStatement ps=con.prepareStatement(stb.toString().replaceFirst("and", "where"));
		return ps.executeQuery();
	}
	/**
	 * ɾ��ͼ�����
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con,String id)throws Exception{
		String sql="delete from l_booktype where id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, id);
		return ps.executeUpdate();
	}
	/**
	 * ����ͼ�����
	 * @param con
	 * @param booktype
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con,Booktype booktype)throws Exception{
		String sql = "update l_booktype set bookTypename=?,bookTypeDesc=? where id = ?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, booktype.getBooktypename());
		ps.setString(2, booktype.getBookTypeDesc());
		ps.setInt(3, booktype.getId());
		return ps.executeUpdate();
	}
}
