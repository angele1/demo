package com.xhb.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.xhb.dao.UserService;
import com.xhb.dao.UserServiceImpl;
import com.xhb.entity.User;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangeStuInfo extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField sexField;
	private JTextField classField;
	private JTextField majorField;
	private JTextField birField;
	private JTextField phoneField;
	private JTextField qqField;
//	private String real_name;
//	private String sex;
//	private String birthday;
//	private String college;
//	private String major;
//	private String classes;
//	private String phone;
//	//private String permission;
//	private String contact;
	private JTextField collegeField;
	private User user;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ChangeStuInfo frame = new ChangeStuInfo();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ChangeStuInfo() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u5B66\u53F7");
		
		JLabel label_1 = new JLabel("\u59D3\u540D");
		
		JLabel label_2 = new JLabel("\u6027\u522B");
		
		JLabel label_3 = new JLabel("\u73ED\u7EA7");
		
		JLabel label_4 = new JLabel("\u4E13\u4E1A");
		
		JLabel label_5 = new JLabel("\u51FA\u751F\u65E5\u671F");
		
		JLabel label_6 = new JLabel("\u624B\u673A");
		
		JLabel lblQq = new JLabel("QQ");
		
		user = myInfo(LoginFrame.userN);
		
		JLabel lblId = new JLabel(user.getId());
		
		nameField = new JTextField(user.getReal_name());
		nameField.setColumns(10);
		
		sexField = new JTextField(user.getSex());
		sexField.setColumns(10);
		
		classField = new JTextField(user.getClasses());
		classField.setColumns(10);
		
		majorField = new JTextField(user.getMajor());
		majorField.setColumns(10);
		
		birField = new JTextField(user.getBirthday());
		birField.setColumns(10);
		

		collegeField = new JTextField(user.getCollege());
		collegeField.setColumns(10);
		
		phoneField = new JTextField(user.getPhone());
		phoneField.setColumns(10);
		
		qqField = new JTextField(user.getContact());
		qqField.setColumns(10);
		
		JButton button = new JButton("\u786E\u8BA4\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeStuOp(e);
			}
		});
		button.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_7 = new JLabel("\u5B66\u9662");
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new StuInfo();
			}
		});
		button_1.setFont(new Font("楷体", Font.PLAIN, 18));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(label_5)
						.addComponent(label_4)
						.addComponent(label_3)
						.addComponent(label_2)
						.addComponent(label_1)
						.addComponent(label_6)
						.addComponent(lblQq)
						.addComponent(label_7))
					.addPreferredGap(ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(collegeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(qqField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblId)
						.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(sexField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(classField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(majorField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(birField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(phoneField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(71, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(58)
					.addComponent(button)
					.addGap(64)
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(87, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(lblId))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_1)
						.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_2)
						.addComponent(sexField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(classField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(majorField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(birField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_7)
						.addComponent(collegeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_6)
							.addGap(19)
							.addComponent(lblQq))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(phoneField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(qqField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}
	
	protected void changeStuOp(ActionEvent e) {
		//User newUser = new User();
		//newUser.setId(LoginFrame.un);
		user.setReal_name(nameField.getText()); 
		user.setSex(sexField.getText());
		user.setClasses(classField.getText()); 
		user.setMajor(majorField.getText()); 
		user.setBirthday(birField.getText()); 
		user.setCollege(collegeField.getText()); 
		user.setPhone(phoneField.getText()); 
		user.setContact(qqField.getText()); 
		UserService service = new UserServiceImpl();
		service.updateById(user);
		JOptionPane.showMessageDialog(this, "修改成功");
	}

	public User myInfo(String name) {
		UserService service = new UserServiceImpl();
		User user = service.selectByName(name);
		return user;
	}
}
