package bigsubject.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import bigsubject.dao.BookTypedao;
import bigsubject.dao.Bookdao;
import bigsubject.model.Book;
import bigsubject.model.Booktype;
import bigsubject.util.Jdbcutil;
import bigsubject.util.Stringutil;

public class BookAIF extends JInternalFrame {
	private JTextField booknametxt;
	private JTextField authortxt;
	private JTextField presstxt;
	private JTextField versiontxt;
	private JTextField pricetxt;
	private JComboBox booktypejcb; 
	private JTextArea bookdesctxt;
	private Jdbcutil jdbcutil=new Jdbcutil();
	private BookTypedao booktypedao=new BookTypedao();
	private Bookdao bookdao = new Bookdao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAIF frame = new BookAIF();
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
	public BookAIF() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u56FE\u4E66\u6DFB\u52A0");
		setBounds(100, 100, 450, 377);
		
		ImageIcon background = new ImageIcon("images\\����2.jpg");
		JLabel beijing= new JLabel(background);
		beijing.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		getLayeredPane().add(beijing, new Integer(Integer.MIN_VALUE));
        JPanel jp = (JPanel) getContentPane();
        jp.setOpaque(false);
        JPanel jpanel = new JPanel();
        jpanel.setOpaque(true);
		setClosable(true);
		
		JLabel label = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		
		booknametxt = new JTextField();
		booknametxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		
		authortxt = new JTextField();
		authortxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u51FA\u7248\u793E\uFF1A");
		
		presstxt = new JTextField();
		presstxt.setColumns(10);
		
		JLabel label_3 = new JLabel("\u7248\u672C\uFF1A");
		
		versiontxt = new JTextField();
		versiontxt.setColumns(10);
		
		JLabel label_4 = new JLabel("\u56FE\u4E66\u4EF7\u683C\uFF1A");
		
		pricetxt = new JTextField();
		pricetxt.setColumns(10);
		
		JLabel label_5 = new JLabel("\u56FE\u4E66\u63CF\u8FF0\uFF1A");
		
		bookdesctxt = new JTextArea();
		
		JLabel label_6 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		
		booktypejcb = new JComboBox();
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookAddActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(BookAIF.class.getResource("/images/\u6DFB\u52A0.png")));
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		button_1.setIcon(new ImageIcon(BookAIF.class.getResource("/images/\u91CD\u7F6E.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(booknametxt, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(label_6)
										.addComponent(label_2))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(presstxt, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
										.addComponent(booktypejcb, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
							.addGap(35)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_4)
								.addComponent(label_3)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_1)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(pricetxt, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
								.addComponent(versiontxt, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
								.addComponent(authortxt, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_5)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(button)
									.addPreferredGap(ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
									.addComponent(button_1))
								.addComponent(bookdesctxt, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE))))
					.addGap(40))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(label_1)
						.addComponent(booknametxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(authortxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(label_3)
						.addComponent(versiontxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(presstxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(label_6)
						.addComponent(booktypejcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(pricetxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(bookdesctxt, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(77, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

		//�����ı���߿�
		bookdesctxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
		fillBooktype();
	}
	/**
	 * �����¼�����
	 * @param e
	 */
	private void resetValueActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.resetvalue();
	}

	/**
	 * ͼ������¼�����
	 * @param e
	 */
	private void bookAddActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String bookName=this.booknametxt.getText();
		String author=this.authortxt.getText();
		String press=this.presstxt.getText();
		String version=this.versiontxt.getText();
		String price=this.pricetxt.getText();
		String bookDesc=this.bookdesctxt.getText();
		if(Stringutil.isEmpty(bookName)){
			JOptionPane.showMessageDialog(null, "ͼ�����Ʋ���Ϊ�գ�");
			return;
		}
		if(Stringutil.isEmpty(author)){
			JOptionPane.showMessageDialog(null, "ͼ�����߲���Ϊ�գ�");
			return;
		}
		if(Stringutil.isEmpty(press)){
			JOptionPane.showMessageDialog(null, "ͼ������粻��Ϊ�գ�");
			return;
		}
		if(Stringutil.isEmpty(version)){
			JOptionPane.showMessageDialog(null, "ͼ��汾����Ϊ�գ�");
			return;
		}
		if(Stringutil.isEmpty(price)){
			JOptionPane.showMessageDialog(null, "ͼ��۸���Ϊ�գ�");
			return;
		}
		Booktype booktype=(Booktype) booktypejcb.getSelectedItem();
		int booktypeId=booktype.getId();
		
		Book book=new Book(bookName, author, press, version, Float.parseFloat(price), booktypeId,
				bookDesc);
		Connection con=null;
		try {
			con=jdbcutil.getCon();
			int a=bookdao.add(con, book);
			if(a==1){
				JOptionPane.showMessageDialog(null, "ͼ����ӳɹ���");
				resetvalue();
			}else{
				JOptionPane.showMessageDialog(null, "ͼ�����ʧ��o(�i�n�i)o");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "ͼ�����ʧ��o(�i�n�i)o");
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
 * ���ñ�
 */
	private void resetvalue(){
		this.booknametxt.setText("");
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
	 * ��ʼ��ͼ�����������ʾ����
	 */
	private void fillBooktype(){
		Connection con=null;
		Booktype booktype=null;
		try {
			con=jdbcutil.getCon();
			ResultSet rs=booktypedao.list(con, new Booktype());
			while(rs.next()){
				booktype=new Booktype();
				booktype.setId(rs.getInt("id"));
				booktype.setBooktypename(rs.getString("bookTypename"));
				this.booktypejcb.addItem(booktype);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			
		}
	}
}
