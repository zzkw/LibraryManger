package bigsubject.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;

public class MainJF extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainJF frame = new MainJF();
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
	public MainJF() {
		setTitle("图书管理系统-大作业v2.1版");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("图书基本数据维护");
		mnNewMenu.setIcon(new ImageIcon(MainJF.class.getResource("/images/\u56FE\u4E66\u9986\u4FE1\u606F\u7EF4\u62A4.png")));
		menuBar.add(mnNewMenu);
		
		JMenu menu_1 = new JMenu("图书类别管理");
		menu_1.setIcon(new ImageIcon(MainJF.class.getResource("/images/\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406.png")));
		mnNewMenu.add(menu_1);
		
		JMenuItem menuItem_1 = new JMenuItem("添加图书类别");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				BooktypeAIF booktypeAIF=new BooktypeAIF();
				booktypeAIF.setVisible(true);
				table.add(booktypeAIF);
			}
		});
		menuItem_1.setIcon(new ImageIcon(MainJF.class.getResource("/images/\u6DFB\u52A0\u56FE\u4E66\u7C7B\u522B.png")));
		menu_1.add(menuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("修改图书类别");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BooktypeManageIF booktypeManageIF=new BooktypeManageIF();
				booktypeManageIF.setVisible(true);
				table.add(booktypeManageIF);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(MainJF.class.getResource("/images/\u4FEE\u6539\u56FE\u4E66\u7C7B\u522B.png")));
		menu_1.add(mntmNewMenuItem);
		
		JMenu menu_2 = new JMenu("图书信息管理");
		menu_2.setIcon(new ImageIcon(MainJF.class.getResource("/images/\u56FE\u4E66\u4FE1\u606F\u7BA1\u7406.png")));
		mnNewMenu.add(menu_2);
		
		JMenuItem menuItem_2 = new JMenuItem("添加图书");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAIF bookAIF=new BookAIF();
				bookAIF.setVisible(true);
				table.add(bookAIF);
			}
		});
		menuItem_2.setIcon(new ImageIcon(MainJF.class.getResource("/images/\u6DFB\u52A0\u56FE\u4E66.png")));
		menu_2.add(menuItem_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("图书信息维护");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookManageIF bookManageIF=new BookManageIF();
				bookManageIF.setVisible(true);
				table.add(bookManageIF);
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(MainJF.class.getResource("/images/\u56FE\u4E66\u4FE1\u606F\u7EF4\u62A4.png")));
		menu_2.add(mntmNewMenuItem_1);
		
		JMenuItem menuItem = new JMenuItem("退出系统");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				int result = JOptionPane.showConfirmDialog(null, "是否退出系统");
				if(result==0){
					dispose();
				}	
			}
		});
		
		JMenu mnNewMenu_1 = new JMenu("\u501F\u89C8\u4FE1\u606F\u7BA1\u7406");
		mnNewMenu_1.setIcon(new ImageIcon(MainJF.class.getResource("/images/\u501F\u89C8.png")));
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem menuItem_3 = new JMenuItem("\u6DFB\u52A0\u56FE\u4E66\u501F\u89C8");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BorrowF borrowF=new BorrowF();
				borrowF.setVisible(true);
				table.add(borrowF);
			}
		});
		menuItem_3.setIcon(new ImageIcon(MainJF.class.getResource("/images/\u6DFB\u52A0\u56FE\u4E66\u501F\u89C8.png")));
		mnNewMenu_1.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("\u501F\u89C8\u4FE1\u606F\u7EF4\u62A4");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BorrowManageIF borrowmanageIF=new BorrowManageIF();
				borrowmanageIF.setVisible(true);
				table.add(borrowmanageIF);
			}
		});
		menuItem_4.setIcon(new ImageIcon(MainJF.class.getResource("/images/\u501F\u89C8\u7EF4\u62A4.png")));
		mnNewMenu_1.add(menuItem_4);
		menuItem.setIcon(new ImageIcon(MainJF.class.getResource("/images/\u9000\u51FA\u7CFB\u7EDF.png")));
		mnNewMenu.add(menuItem);
		
		JMenu menu = new JMenu("关于");
		menu.setIcon(new ImageIcon(MainJF.class.getResource("/images/\u5173\u4E8E.png")));
		menuBar.add(menu);
		
		JMenuItem mntmjava = new JMenuItem("关于JAVA大作业");
		mntmjava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				AboutIF aboutIF=new AboutIF();
				aboutIF.setVisible(true);
				table.add(aboutIF);
			}
		});
		mntmjava.setIcon(new ImageIcon(MainJF.class.getResource("/images/\u5173\u4E8Ejava.png")));
		menu.add(mntmjava);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setForeground(UIManager.getColor("MenuBar.background"));
		desktopPane.setBorder(UIManager.getBorder("MenuBar.border"));
		desktopPane.setBackground(UIManager.getColor("MenuBar.background"));
		
		table = new JDesktopPane();
		table.setBackground(SystemColor.activeCaptionBorder);
		contentPane.add(desktopPane);
		GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
		gl_desktopPane.setHorizontalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 1915, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_desktopPane.setVerticalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 977, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel label = new JLabel("          \u4E00\u5207\u4E3A\u4E86\u4EBA\u6C11\uFF01");
		label.setFont(new Font("华文行楷", Font.BOLD | Font.ITALIC, 31));
		label.setBounds(0, 36, 424, 127);
		table.add(label);
		desktopPane.setLayout(gl_desktopPane);


		/*String path = "images//图书馆登录界面.jpg";
		// 背景图片
		ImageIcon background = new ImageIcon(path);
		// 把背景图片显示在一个标签里面
		JLabel label = new JLabel(background);
		JPanel imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));*/

		setVisible(true);
		//设置JFrame最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
