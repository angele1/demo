package com.xhb.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.xhb.dao.UserService;
import com.xhb.dao.UserServiceImpl;
import com.xhb.entity.User;
import com.xhb.utils.IsEmpty;

import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	public static String un;
	public static String userN;
	private String ps;
	private int result=0;
	private JPasswordField password;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setTitle("\u7528\u6237\u767B\u9646");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/image/\u5B66\u751F.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u7528\u6237\u540D");
		label.setFont(new Font("楷体", Font.PLAIN, 20));
		
		JLabel label_1 = new JLabel("\u5BC6\u7801");
		label_1.setFont(new Font("楷体", Font.PLAIN, 20));
		
		username = new JTextField();
		username.setColumns(10);
		
		JButton button = new JButton("\u767B\u9646");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginOp(e);
			}
		});
		button.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username.setText("");
				password.setText("");
			}
		});
		button_1.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_2 = new JLabel("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		label_2.setFont(new Font("楷体", Font.PLAIN, 24));
		
		password = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(104)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
							.addGap(50))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label)
								.addComponent(label_1))
							.addGap(64)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(username)
						.addComponent(password, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
						.addComponent(button_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(116))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(154)
					.addComponent(label_2)
					.addContainerGap(154, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_2)
					.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(82)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button))
					.addGap(55))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void loginOp(ActionEvent e) {
		UserService service = new UserServiceImpl();
		List<User> list =  service.selectAllUser();
		un = username.getText();
		char[] passf = password.getPassword();
		ps = String.valueOf(passf);
		if(IsEmpty.IsEmpty(un)||IsEmpty.IsEmpty(ps)) {
			JOptionPane.showMessageDialog(this, "账号不能为空");
		}
		else {
			for(User user : list) {
				
				if(un.equals(user.getId())&&ps.equals(user.getPassword())) {
					if(user.getPermission().equals("0")) {
						//学生登陆
						userN = user.getReal_name();
						new StudentsOp();
						result++;
						dispose();
					}
					else if(user.getPermission().equals("1")) {
						//教师登陆
						userN = user.getReal_name();
						new TeacherOp();
						result++;
						dispose();
					} else {
						//管理员登陆
						userN = user.getReal_name();
						new AdminOp();
						result++;
						dispose();
					}
				}
				
				
				
			}
			//登陆失败
			if(result == 0) {
				JOptionPane.showMessageDialog(this, "账号登陆错误");
			}
			
		}
//		for(User user:list)
//			System.out.println(user);
	}
}
