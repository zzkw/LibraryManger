package bigsubject.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.server.SocketSecurityException;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import bigsubject.dao.BookTypedao;
import bigsubject.model.Booktype;
import bigsubject.util.Jdbcutil;
import bigsubject.util.Stringutil;
import javax.swing.UIManager;

public class BooktypeAIF extends JInternalFrame {
	private JTextField booktypenametxt;
	private JTextArea booktypedesctxt;
	
	private Jdbcutil jdbcutil=new Jdbcutil();
	private BookTypedao booktypedao=new BookTypedao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BooktypeAIF frame = new BooktypeAIF();
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
	public BooktypeAIF() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
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
		
		JLabel label = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0\uFF1A");
		
		booktypenametxt = new JTextField();
		booktypenametxt.setBackground(UIManager.getColor("EditorPane.background"));
		booktypenametxt.setColumns(10);
		
		booktypedesctxt = new JTextArea();
		booktypedesctxt.setBackground(UIManager.getColor("TextArea.background"));
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				booktypeAddActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(BooktypeAIF.class.getResource("/images/\u6DFB\u52A0.png")));
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		button_1.setIcon(new ImageIcon(BooktypeAIF.class.getResource("/images/\u91CD\u7F6E.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(58)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(booktypedesctxt, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(booktypenametxt)))
					.addContainerGap(98, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(138, Short.MAX_VALUE)
					.addComponent(button)
					.addGap(18)
					.addComponent(button_1)
					.addGap(124))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(booktypenametxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(booktypedesctxt, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

		//设置文本域边框
		booktypedesctxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
	}
	
	/**
	 * 图书类别添加事件处理
	 * @param e
	 */
	private void booktypeAddActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String bookTypename=this.booktypenametxt.getText();
		String bookTypeDesc=this.booktypedesctxt.getText();
		if(Stringutil.isEmpty(bookTypename)){
			JOptionPane.showMessageDialog(null, "图书类别名称不能为空！");
			return;
		}
		Booktype booktype=new Booktype(bookTypename,bookTypeDesc);
		Connection con=null;//
		try {
			con=jdbcutil.getCon();
			int n = booktypedao.add(con, booktype);
			if(n==1){
				JOptionPane.showMessageDialog(null, "图书类别添加成功");
				resetValue();
			}else{
				JOptionPane.showMessageDialog(null, "图书类别添加失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "图书类别添加失败");
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
		this.booktypenametxt.setText("");
		this.booktypedesctxt.setText("");
	}
}
