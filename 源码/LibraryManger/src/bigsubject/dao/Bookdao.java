package bigsubject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bigsubject.model.Book;
import bigsubject.model.Booktype;
import bigsubject.util.Stringutil;

/**
 * 图书dao类
 * @author Administrator
 *
 */
public class Bookdao {
	/**
	 * 图书添加
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,Book book)throws Exception{
		String sql="insert into l_book values(null,?,?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, book.getBookName());
		ps.setString(2, book.getAuthor());
		ps.setString(3, book.getPress());
		ps.setString(4, book.getVersion());
		ps.setFloat(5, book.getPrice());
		ps.setInt(6, book.getBooktypeId());
		ps.setString(7, book.getBookDesc());
		return ps.executeUpdate();
	}
	/**
	 * 图书信息查询
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con,Book book)throws Exception{
		StringBuffer stb=new StringBuffer("select* from l_book b,l_booktype bt where b.booktypeId=bt.id");
		if(Stringutil.isNotEmpty(book.getBookName())){
			stb.append(" and b.bookName like '%"+book.getBookName()+"%'");
		}
		if(Stringutil.isNotEmpty(book.getAuthor())){
			stb.append(" and b.author like '%"+book.getAuthor()+"%'");
		}
		if(Stringutil.isNotEmpty(book.getPress())){
			stb.append(" and b.press like '%"+book.getPress()+"%'");
		}
		if(Stringutil.isNotEmpty(book.getVersion())){
			stb.append(" and b.version like '%"+book.getVersion()+"%'");
		}
		if(book.getBooktypeId()!=null && book.getBooktypeId()!=-1){
			stb.append(" and b.bookTypeId="+book.getBooktypeId());
		}
		PreparedStatement ps=con.prepareStatement(stb.toString());
		return ps.executeQuery();
	}
	/**
	 * 图书信息修改
	 * @param con
	 * @param booktype
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con,Book book)throws Exception{
		String sql = "update l_book set bookName=?,author=?,press=?,version=?,price=?,bookDesc=?,booktypeId=? where id = ?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, book.getBookName());
		ps.setString(2, book.getAuthor());
		ps.setString(3, book.getPress());
		ps.setString(4, book.getVersion());
		ps.setFloat(5, book.getPrice());
		ps.setString(6, book.getBookDesc());
		ps.setInt(7, book.getBooktypeId());
		ps.setInt(8, book.getId());
		return ps.executeUpdate();
	}
	/**
	 * 图书信息删除
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con,String id)throws Exception{
		String sql="delete from l_book where id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, id);
		return ps.executeUpdate();
	}
	/**
	 * 判断图书类别下有无书籍
	 */
	public boolean Exist(Connection con,String booktypeId)throws Exception{
		String sql="select * from l_book where booktypeId=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, booktypeId);
		ResultSet rs=ps.executeQuery();
		return rs.next();
	}
}
	
