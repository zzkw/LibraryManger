package bigsubject.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import bigsubject.dao.Borrowdao;
import bigsubject.model.Borrow;
import bigsubject.util.Jdbcutil;
import bigsubject.util.Stringutil;

public class BorrowF extends JInternalFrame {
	private JTextField booknametxt;
	private JTextField lendmantxt;
	private JTextField phonetxt;

	private Jdbcutil jdbcutil=new Jdbcutil();
	private Borrowdao borrowdao=new Borrowdao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrowF frame = new BorrowF();
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
	public BorrowF() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u501F\u89C8\u7BA1\u7406");
		setBounds(100, 100, 450, 300);
		
		ImageIcon background = new ImageIcon("images\\背景2.jpg");
		JLabel beijing= new JLabel(background);
		beijing.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		getLayeredPane().add(beijing, new Integer(Integer.MIN_VALUE));
        JPanel jp = (JPanel) getContentPane();
        jp.setOpaque(false);
        JPanel jpanel = new JPanel();
        jpanel.setOpaque(true);
		setClosable(true);
		
		JLabel lblNewLabel = new JLabel("\u4E66\u540D\uFF1A");
		
		booknametxt = new JTextField();
		booknametxt.setColumns(10);
		
		JLabel label = new JLabel("\u501F\u9605\u4EBA\uFF1A");
		
		lendmantxt = new JTextField();
		lendmantxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u624B\u673A\u53F7\uFF1A");
		
		phonetxt = new JTextField();
		phonetxt.setColumns(10);
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrowAddActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(BorrowF.class.getResource("/images/\u6DFB\u52A0.png")));
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		button_1.setIcon(new ImageIcon(BorrowF.class.getResource("/images/\u91CD\u7F6E.png")));
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(booknametxt, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(phonetxt, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
								.addComponent(button, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))))
					.addGap(49)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(button_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lendmantxt, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
					.addGap(69))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lendmantxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addComponent(booknametxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(phonetxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(77))
		);
		getContentPane().setLayout(groupLayout);

	}
	/**
	 * 图书借览信息添加事件处理
	 * @param evt
	 */
	protected void borrowAddActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String bookname=this.booknametxt.getText();
		String lendman=this.lendmantxt.getText();
		String phone=this.phonetxt.getText();
		if(Stringutil.isEmpty(bookname)){
			JOptionPane.showMessageDialog(null, "图书名称不能为空！");
			return;
		}
		Borrow borrow=new Borrow(bookname,lendman,phone);
		Connection con=null;//
		try {
			con=jdbcutil.getCon();
			int n = Borrowdao.add(con, borrow);
			if(n==1){
				JOptionPane.showMessageDialog(null, "借览成功");
				resetValue();
			}else{
				JOptionPane.showMessageDialog(null, "借览失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "添加失败");
			// TODO: handle exception
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
	 * 重置事件处理
	 * @param evt
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		this.resetValue();
	}

	/**
	 * 重置表单
	 */
	private void resetValue(){
		this.booknametxt.setText("");
		this.lendmantxt.setText("");
		this.phonetxt.setText("");
	}
}
