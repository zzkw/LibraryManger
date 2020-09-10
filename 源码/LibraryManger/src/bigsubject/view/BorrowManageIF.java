package bigsubject.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bigsubject.dao.Borrowdao;
import bigsubject.model.Booktype;
import bigsubject.model.Borrow;
import bigsubject.util.Jdbcutil;
import bigsubject.util.Stringutil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BorrowManageIF extends JInternalFrame {
	private JTable borrowtable;
	
	private Jdbcutil jdbcutil=new Jdbcutil();
	private Borrowdao borrowdao=new Borrowdao();
	private JTextField idtxt;
	private JTextField booknametxt;
	private JTextField borrowmantxt;
	private JTextField phonetxt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrowManageIF frame = new BorrowManageIF();
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
	public BorrowManageIF() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u56FE\u4E66\u501F\u9605\u7EF4\u62A4");
		setBounds(100, 100, 494, 380);
		
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
		
		JLabel label = new JLabel("\u7F16\u53F7\uFF1A");
		
		idtxt = new JTextField();
		idtxt.setEditable(false);
		idtxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		
		booknametxt = new JTextField();
		booknametxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u501F\u9605\u4EBA\uFF1A");
		
		borrowmantxt = new JTextField();
		borrowmantxt.setColumns(10);
		
		JLabel label_3 = new JLabel("\u624B\u673A\u53F7\uFF1A");
		
		phonetxt = new JTextField();
		phonetxt.setColumns(10);
		
		JButton button = new JButton("\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrowUpdateActionEvent(e);
			}
		});
		button.setIcon(new ImageIcon(BorrowManageIF.class.getResource("/images/\u4FEE\u6539.png")));
		
		JButton button_1 = new JButton("\u5220\u9664");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrowDeleteActionEvent(e);
			}
		});
		button_1.setIcon(new ImageIcon(BorrowManageIF.class.getResource("/images/\u5220\u9664.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(idtxt, 0, 0, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(borrowmantxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(46)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(booknametxt, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_3)
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(phonetxt, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
										.addComponent(button_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))))
							.addGap(49))
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
					.addGap(62))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addGap(54)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(booknametxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(idtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(borrowmantxt, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3)
						.addComponent(phonetxt, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(30))
		);
		
		borrowtable = new JTable();
		borrowtable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				borrowtableMousePressed(e);
			}
		});
		borrowtable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u501F\u9605\u4EBA", "\u624B\u673A\u53F7"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(borrowtable);
		getContentPane().setLayout(groupLayout);
		
		this.filltable(new Borrow());

	}
	protected void borrowDeleteActionEvent(ActionEvent evt) {
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
				int d=borrowdao.delete(con, id);
				if(d==1){
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetValue();
					this.filltable(new Borrow());
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

	protected void borrowUpdateActionEvent(ActionEvent evt) {
		// TODO Auto-generated method stub
		String id=idtxt.getText();
		String bookname=booknametxt.getText();
		String borrowname=borrowmantxt.getText();
		String phonenumber=phonetxt.getText();
		if(Stringutil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		if(Stringutil.isEmpty(bookname)){
			JOptionPane.showMessageDialog(null, "请输入图书类别名称");
			return;
		}
		Borrow borrow=new Borrow(Integer.parseInt(id),bookname,borrowname,phonenumber);
		Connection con=null;
		try {
			con=jdbcutil.getCon();
			int m=borrowdao.update(con, borrow);
			if(m==1){
				JOptionPane.showMessageDialog(null, "修改成功！");
				this.resetValue();
				this.filltable(new Borrow());
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

	protected void borrowtableMousePressed(MouseEvent evt) {
		// TODO Auto-generated method stub
		int row=borrowtable.getSelectedRow();
		idtxt.setText((String)borrowtable.getValueAt(row, 0));
		booknametxt.setText((String)borrowtable.getValueAt(row, 1));
		borrowmantxt.setText((String)borrowtable.getValueAt(row, 2));
		phonetxt.setText((String)borrowtable.getValueAt(row, 3));
	}

	private void filltable(Borrow borrow){
		DefaultTableModel dtm=(DefaultTableModel) borrowtable.getModel();
		//设置成0行表格清空
		dtm.setRowCount(0);
		Connection con=null;
		try {
			con=jdbcutil.getCon();
			ResultSet rs=Borrowdao.list(con, borrow);
			while(rs.next()){
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("bookname"));
				v.add(rs.getString("borrowname"));
				v.add(rs.getString("phonenumber"));
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
		this.booknametxt.setText("");
		this.borrowmantxt.setText("");
		this.phonetxt.setText("");
	}
}
