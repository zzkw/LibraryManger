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
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import bigsubject.dao.BookTypedao;
import bigsubject.dao.Bookdao;
import bigsubject.model.Booktype;
import bigsubject.util.Jdbcutil;
import bigsubject.util.Stringutil;

public class BooktypeManageIF extends JInternalFrame {
	private JTable booktypetable;

	private Jdbcutil jdbcutil=new Jdbcutil();
	private BookTypedao booktypedao=new BookTypedao();
	private Bookdao bookdao=new Bookdao();
	private JTextField l_booktypenametxt;
	private JTextField idtxt;
	private JTextField booktypenametxt;
	private JTextArea booktypedesctxt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BooktypeManageIF frame = new BooktypeManageIF();
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
	public BooktypeManageIF() {
		ImageIcon background = new ImageIcon("images\\背景2.jpg");
		JLabel beijing= new JLabel(background);
		beijing.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		getLayeredPane().add(beijing, new Integer(Integer.MIN_VALUE));
        JPanel jp = (JPanel) getContentPane();
        jp.setOpaque(false);
        JPanel jpanel = new JPanel();
        jpanel.setOpaque(true);
		setClosable(true);
		
		setIconifiable(true);
		setTitle("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		setBounds(100, 100, 489, 484);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");
		
		l_booktypenametxt = new JTextField();
		l_booktypenametxt.setBackground(UIManager.getColor("Button.background"));
		l_booktypenametxt.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				booktypeSearchActionPerFormed(e);
			}
		});
		button.setIcon(new ImageIcon(BooktypeManageIF.class.getResource("/images/\u67E5\u8BE2.png")));
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.background"));
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(65)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(l_booktypenametxt, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(button))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(52)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE))))
					.addContainerGap(57, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(l_booktypenametxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGap(45)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		
		JLabel label_1 = new JLabel("\u7F16\u53F7\uFF1A");
		
		idtxt = new JTextField();
		idtxt.setEditable(false);
		idtxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");
		
		booktypenametxt = new JTextField();
		booktypenametxt.setColumns(10);
		
		JLabel label_3 = new JLabel("\u63CF\u8FF0\uFF1A");
		
		 booktypedesctxt = new JTextArea();
		
		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				booktypeUpdateActionEvent( e );
			}
		});
		button_1.setIcon(new ImageIcon(BooktypeManageIF.class.getResource("/images/\u4FEE\u6539.png")));
		
		JButton button_2 = new JButton("\u5220\u9664");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				booktypeDeleteActionEvent(e);
			}
		});
		button_2.setIcon(new ImageIcon(BooktypeManageIF.class.getResource("/images/\u5220\u9664.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(idtxt, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(booktypenametxt, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(button_1)
									.addPreferredGap(ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
									.addComponent(button_2)
									.addGap(10))
								.addComponent(booktypedesctxt, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(idtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(booktypenametxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(booktypedesctxt, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button_2))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		booktypetable = new JTable();
		booktypetable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				booktypeTableMousePressed(e);
			}
		});
		booktypetable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u7C7B\u522B\u540D\u79F0", "\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(booktypetable);
		getContentPane().setLayout(groupLayout);

		this.filltable(new Booktype());
		//设置文本域边框
		booktypedesctxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
	}
	/*
	 * 类别删除事件处理
	 * 
	 */
	private void booktypeDeleteActionEvent(ActionEvent evt) {
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
				boolean flag=bookdao.Exist(con, id);
				if(flag){
					JOptionPane.showMessageDialog(null, "当前图书类别存在书籍，不能删除该类别");
					return;
				}
				int d=booktypedao.delete(con, id);
				if(d==1){
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetValue();
					this.filltable(new Booktype());
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
	 * 类别修改事件处理
	 * @param e
	 */
	private void booktypeUpdateActionEvent(ActionEvent evt) {
		// TODO Auto-generated method stub
		String id=idtxt.getText();
		String bookTypename=booktypenametxt.getText();
		String bookTypeDesc=booktypedesctxt.getText();
		if(Stringutil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		if(Stringutil.isEmpty(bookTypename)){
			JOptionPane.showMessageDialog(null, "请输入图书类别名称");
			return;
		}
		Booktype booktype=new Booktype(Integer.parseInt(id),bookTypename,bookTypeDesc);
		Connection con=null;
		try {
			con=jdbcutil.getCon();
			int m=booktypedao.update(con, booktype);
			if(m==1){
				JOptionPane.showMessageDialog(null, "修改成功！");
				this.resetValue();
				this.filltable(new Booktype());
			}else{
				JOptionPane.showMessageDialog(null, "修改失败！");
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
	 * 表格行点击事件处理
	 * @param e
	 */
	private void booktypeTableMousePressed(MouseEvent evt) {
		// TODO Auto-generated method stub
		int row=booktypetable.getSelectedRow();
		idtxt.setText((String)booktypetable.getValueAt(row, 0));
		booktypenametxt.setText((String)booktypetable.getValueAt(row, 1));
		booktypedesctxt.setText((String)booktypetable.getValueAt(row, 2));
	}

	/**
	 * 图书类别搜索 事件处理
	 * @param evt
	 */
	private void booktypeSearchActionPerFormed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String l_booktypename=this.l_booktypenametxt.getText();
		Booktype booktype=new Booktype();
		booktype.setBooktypename(l_booktypename);
		this.filltable(booktype);
	}

	private void filltable(Booktype booktype){
		DefaultTableModel dtm=(DefaultTableModel) booktypetable.getModel();
		//设置成0行表格清空
		dtm.setRowCount(0);
		Connection con=null;
		try {
			con=jdbcutil.getCon();
			ResultSet rs=booktypedao.list(con, booktype);
			while(rs.next()){
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("bookTypename"));
				v.add(rs.getString("bookTypeDesc"));
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
	
	/**
	 * 重置表单
	 */
	private void resetValue(){
		this.idtxt.setText("");
		this.booktypenametxt.setText("");
		this.booktypedesctxt.setText("");
	}
}