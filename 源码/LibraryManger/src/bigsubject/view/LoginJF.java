package bigsubject.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import bigsubject.dao.Userdao;
import bigsubject.model.User;
import bigsubject.util.Jdbcutil;
import bigsubject.util.Stringutil;

public class LoginJF extends JFrame {

	private JPanel contentPane;
	private JTextField usertxt;
	private JPasswordField passwdtxt;

	private Jdbcutil jdbcutil=new Jdbcutil();
	private Userdao userdao=new Userdao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginJF frame = new LoginJF();
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
	public LoginJF() {
		//改变系统默认字体
		Font font = new Font("Dialog", Font.PLAIN, 12);
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource) {
				UIManager.put(key, font);
			}
		}	
		setTitle("\u7BA1\u7406\u5458\u767B\u5F55");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setBounds(167, 34, 120, 22);
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 19));
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setBounds(124, 76, 68, 16);
		lblNewLabel_1.setIcon(new ImageIcon(LoginJF.class.getResource("/images/\u767B\u5F55\u7528\u6237.png")));
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6    \u7801\uFF1A");
		lblNewLabel_2.setBounds(124, 115, 80, 16);
		lblNewLabel_2.setIcon(new ImageIcon(LoginJF.class.getResource("/images/\u767B\u5F55\u5BC6\u7801.png")));
		
		usertxt = new JTextField();
		usertxt.setBounds(210, 74, 116, 21);
		usertxt.setColumns(10);
		
		passwdtxt = new JPasswordField();
		passwdtxt.setBounds(210, 113, 116, 21);
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.setBounds(124, 175, 80, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(LoginJF.class.getResource("/images/\u767B\u5F55.png")));
		
		JButton button = new JButton("\u91CD\u7F6E");
		button.setBounds(252, 175, 86, 25);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reset(e);
			}
		});
		button.setIcon(new ImageIcon(LoginJF.class.getResource("/images/\u91CD\u7F6E.png")));
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);
		contentPane.add(btnNewButton);
		contentPane.add(lblNewLabel_2);
		contentPane.add(button);
		contentPane.add(usertxt);
		contentPane.add(passwdtxt);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(LoginJF.class.getResource("/images/\u56FE\u4E66\u9986\u767B\u5F55\u754C\u9762.jpg")));
		label.setBackground(UIManager.getColor("Button.background"));
		label.setBounds(0, 0, 446, 278);
		contentPane.add(label);
		//设置JFram居中显示
		this.setLocationRelativeTo(null);
	}
	/**
	 * 登录事件处理
	 * @param e
	 */
private void login(ActionEvent ev) {
		// TODO Auto-generated method stub
		String user=this.usertxt.getText();
		String passwd=new String(this.passwdtxt.getPassword());
		if(Stringutil.isEmpty(user)){
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		}
		if(Stringutil.isEmpty(passwd)){
			JOptionPane.showMessageDialog(null, "密码不能为空！！");
			return;
		}
		User user1=new User(user,passwd);
		Connection con = null;
		try {
			con = jdbcutil.getCon();
			User currentUser = userdao.login(con, user1);
			if (currentUser != null) {
				this.dispose();
				new MainJF().setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "用户名或密码错误");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "登录失败");
		} finally {
			try {
				jdbcutil.closeCon(con);
			} catch (Exception e) {
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

/**
 * 重置事件处理
 * @param e
 */
	private void Reset(ActionEvent ev) {
		// TODO Auto-generated method stub
		this.usertxt.setText("");
		this.passwdtxt.setText("");
	}
}
