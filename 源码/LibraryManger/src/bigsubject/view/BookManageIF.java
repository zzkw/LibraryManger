package bigsubject.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import bigsubject.dao.BookTypedao;
import bigsubject.dao.Bookdao;
import bigsubject.model.Book;
import bigsubject.model.Booktype;
import bigsubject.util.Jdbcutil;
import bigsubject.util.Stringutil;

public class BookManageIF extends JInternalFrame {
	private JTable booktable;
	private JTextField s_booknametxt;
	private JTextField s_authortxt;
	private JComboBox s_booktypejcb;
	
	private Jdbcutil jdbcutil=new Jdbcutil();
	private BookTypedao booktypedao=new BookTypedao();
	private Bookdao bookdao = new Bookdao();
	private JTextField idtxt;
	private JTextField versiontxt;
	private JTextField pricetxt;
	private JComboBox booktypejcb;
	private JTextField authortxt;
	private JTextField bookname;
	private JTextField presstxt;
	private JTextArea bookdesctxt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookManageIF frame = new BookManageIF();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookManageIF() {
		setTitle("\u56FE\u4E66\u7BA1\u7406");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 637, 488);
		
		ImageIcon background = new ImageIcon("images\\背景2.jpg");
		JLabel beijing= new JLabel(background);
		beijing.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		getLayeredPane().add(beijing, new Integer(Integer.MIN_VALUE));
        JPanel jp = (JPanel) getContentPane();
        jp.setOpaque(false);
        JPanel jpanel = new JPanel();
        jpanel.setOpaque(true);
		setClosable(true);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 593, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel label_3 = new JLabel("\u7F16\u53F7\uFF1A");
		
		idtxt = new JTextField();
		idtxt.setEditable(false);
		idtxt.setColumns(10);
		
		JLabel label_4 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		
		JLabel lblNewLabel = new JLabel("\u51FA\u7248\u793E\uFF1A");
		
		JLabel label_5 = new JLabel("\u7248\u672C\uFF1A");
		
		versiontxt = new JTextField();
		versiontxt.setColumns(10);
		
		JLabel label_6 = new JLabel("\u4EF7\u683C\uFF1A");
		
		pricetxt = new JTextField();
		pricetxt.setColumns(10);
		
		JLabel label_7 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		
		JLabel label_8 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		
		booktypejcb = new JComboBox();
		
		JLabel label_9 = new JLabel("\u56FE\u4E66\u63CF\u8FF0\uFF1A");
		
		bookdesctxt = new JTextArea();
		
		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bookUpdateActionPerformed(evt);
			}
		});
		button_1.setIcon(new ImageIcon(BookManageIF.class.getResource("/images/\u4FEE\u6539.png")));
		
		JButton button_2 = new JButton("\u5220\u9664");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bookDeleteActionPerformed(evt);
			}
		});
		button_2.setIcon(new ImageIcon(BookManageIF.class.getResource("/images/\u5220\u9664.png")));
		
		authortxt = new JTextField();
		authortxt.setColumns(10);
		
		bookname = new JTextField();
		bookname.setColumns(10);
		
		presstxt = new JTextField();
		presstxt.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(label_9)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(button_1)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(button_2))
								.addComponent(bookdesctxt, GroupLayout.PREFERRED_SIZE, 507, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(idtxt, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_6)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(pricetxt, 0, 0, Short.MAX_VALUE)))
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(label_4)
								.addComponent(label_7))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(authortxt, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
								.addComponent(bookname, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
							.addGap(27)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(presstxt, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
									.addGap(5)
									.addComponent(label_5)
									.addGap(4)
									.addComponent(versiontxt, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
									.addGap(78))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_8)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(booktypejcb, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 112, Short.MAX_VALUE)))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(idtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(lblNewLabel)
						.addComponent(label_5)
						.addComponent(versiontxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(bookname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(presstxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_6)
						.addComponent(pricetxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_7)
						.addComponent(label_8)
						.addComponent(booktypejcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(authortxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_9)
						.addComponent(bookdesctxt, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button_2)))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel label = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		
		s_booknametxt = new JTextField();
		s_booknametxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		
		s_authortxt = new JTextField();
		s_authortxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		
		s_booktypejcb = new JComboBox();
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookSearchActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(BookManageIF.class.getResource("/images/\u67E5\u8BE2.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(4)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_booknametxt, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_authortxt, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_booktypejcb, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(44, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(s_booknametxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(s_authortxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(s_booktypejcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addContainerGap(11, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		booktable = new JTable();
		booktable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent ev) {
				booktableMousePressed(ev);
			}
		});
		scrollPane.setViewportView(booktable);
		booktable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u4F5C\u8005", "\u51FA\u7248\u793E", "\u7248\u672C", "\u56FE\u4E66\u4EF7\u683C", "\u56FE\u4E66\u63CF\u8FF0", "\u56FE\u4E66\u7C7B\u522B"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		getContentPane().setLayout(groupLayout);

		this.fillBooktype("search");
		this.fillBooktype("modify");
		this.fillTable(new Book());
		//设置文本域边框
		bookdesctxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
	}
	/**
	 * 图书删除事件处理
	 * @param evt
	 */
	private void bookDeleteActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String id =idtxt.getText();
		if(Stringutil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;
		}
		//确认删除
		int s=JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
		if(s==0){
			Connection con=null;
			try {
				con=jdbcutil.getCon();
				int d=bookdao.delete(con, id);
				if(d==1){
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetvalue();
					this.fillTable(new Book());
				}else{
					JOptionPane.showMessageDialog(null, "删除失败");
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "修改失败");
			}finally{
				try {
					jdbcutil.closeCon(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 图书修改事件处理
	 * @param evt
	 */
	private void bookUpdateActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String id=this.idtxt.getText();
		if(Stringutil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		String bookName=this.bookname.getText();
		String author=this.authortxt.getText();
		String press=this.presstxt.getText();
		String version=this.versiontxt.getText();
		String price=this.pricetxt.getText();
		String bookDesc=this.bookdesctxt.getText();
		if(Stringutil.isEmpty(bookName)){
			JOptionPane.showMessageDialog(null, "图书名称不能为空！");
			return;
		}
		if(Stringutil.isEmpty(author)){
			JOptionPane.showMessageDialog(null, "图书作者不能为空！");
			return;
		}
		if(Stringutil.isEmpty(press)){
			JOptionPane.showMessageDialog(null, "出版社不能为空！");
			return;
		}
		Booktype booktype=(Booktype)booktypejcb.getSelectedItem();
		int booktypeId=booktype.getId();
		Book book=new Book(Integer.parseInt(id), bookName, author, press, version, Float.parseFloat(price), booktypeId,
				bookDesc);
		Connection con=null;
		try {
			con=jdbcutil.getCon();
			int a=bookdao.update(con, book);
			if(a==1){
				JOptionPane.showMessageDialog(null, "图书修改成功！");
				resetvalue();
				this.fillTable(new Book());
			}else{
				JOptionPane.showMessageDialog(null, "图书修改失败o(╥﹏╥)o");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "图书修改失败o(╥﹏╥)o");
		}finally{
			try {
				jdbcutil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 表单重置
	 */
	private void resetvalue(){
		this.idtxt.setText("");
		this.bookname.setText("");
		this.authortxt.setText("");
		this.presstxt.setText("");
		this.versiontxt.setText("");
		this.pricetxt.setText("");
		this.bookdesctxt.setText("");
		if(this.booktypejcb.getItemCount()>0){
			this.booktypejcb.setSelectedIndex(0);
		}
	}
	/**
	 * 表格行点击事件处理
	 * @param ev
	 */
	private void booktableMousePressed(MouseEvent ev) {
		// TODO Auto-generated method stub
		int row=this.booktable.getSelectedRow();
		this.idtxt.setText((String)booktable.getValueAt(row, 0));
		this.bookname.setText((String)booktable.getValueAt(row, 1));
		this.authortxt.setText((String)booktable.getValueAt(row, 2));
		this.presstxt.setText((String)booktable.getValueAt(row, 3));
		this.versiontxt.setText((String)booktable.getValueAt(row, 4));
		this.pricetxt.setText((Float)booktable.getValueAt(row, 5)+"");
		this.bookdesctxt.setText((String)booktable.getValueAt(row, 6));
		String bookTypename=(String)this.booktable.getValueAt(row, 7);
		int n=this.booktypejcb.getItemCount();
		for(int i=0;i<n;i++){
			Booktype item=(Booktype)this.booktypejcb.getItemAt(i);
			if(item.getBooktypename().equals(bookTypename)){
				this.booktypejcb.setSelectedIndex(i);
			}
		}
	}

	private void bookSearchActionPerformed(ActionEvent evt) {
		String bookName=this.s_booknametxt.getText();
		String author=this.s_authortxt.getText();
		Booktype booktype=(Booktype)this.s_booktypejcb.getSelectedItem();
		int booktypeId=booktype.getId();
		
		Book book=new Book(bookName,author,booktypeId);
		this.fillTable(book);
		// TODO Auto-generated method stub
		
	}

	/**
	 * 下拉框的初始化
	 * @param type
	 */
	private void fillBooktype(String type){  //下拉框类型
		Connection con=null;
		Booktype booktype=null;
		try {
			con=jdbcutil.getCon();
			ResultSet rs=booktypedao.list(con, new Booktype());
			if("search".equals(type)){
				booktype=new Booktype();
				booktype.setBooktypename("请选择...");
				booktype.setId(-1);
				this.s_booktypejcb.addItem(booktype);
			}while(rs.next()){
				booktype=new Booktype();
				booktype.setBooktypename(rs.getString("bookTypename"));
				booktype.setId(rs.getInt("id"));
				if("search".equals(type)){
					this.s_booktypejcb.addItem(booktype);
				}else if("modify".equals(type)){
					this.booktypejcb.addItem(booktype);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				jdbcutil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 表格数据初始化
	 * @param book
	 */
	private void fillTable(Book book){
		DefaultTableModel dtm=(DefaultTableModel) booktable.getModel();
		//设置成0行表格清空
		dtm.setRowCount(0);
		Connection con=null;
		try {
			con=jdbcutil.getCon();
			ResultSet rs=bookdao.list(con, book);
			while(rs.next()){
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("bookName"));
				v.add(rs.getString("author"));
				v.add(rs.getString("press"));
				v.add(rs.getString("version"));
				v.add(rs.getFloat("price"));
				v.add(rs.getString("bookDesc"));
				v.add(rs.getString("bookTypename"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				jdbcutil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
