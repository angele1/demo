package com.xhb.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.xhb.dao.UserService;
import com.xhb.dao.UserServiceImpl;
import com.xhb.entity.User;

import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StuInfo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					StuInfo frame = new StuInfo();
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
	public StuInfo() {
		setTitle("\u4E2A\u4EBA\u4FE1\u606F");
		setIconImage(Toolkit.getDefaultToolkit().getImage(StuInfo.class.getResource("/image/\u5B66\u751F.png")));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u5B66\u53F7");
		label.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_1 = new JLabel("\u59D3\u540D");
		label_1.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_2 = new JLabel("\u6027\u522B");
		label_2.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_3 = new JLabel("\u73ED\u7EA7");
		label_3.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_4 = new JLabel("\u4E13\u4E1A");
		label_4.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_5 = new JLabel("\u51FA\u751F\u65E5\u671F");
		label_5.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_6 = new JLabel("\u624B\u673A");
		label_6.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel lblQq = new JLabel("QQ");
		lblQq.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JButton button = new JButton("\u7F16\u8F91");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChangeStuInfo();
				dispose();
			}
		});
		button.setFont(new Font("楷体", Font.PLAIN, 18));
		
		User user = myInfo(LoginFrame.userN);
		
		JLabel label_7 = new JLabel(user.getId());
		
		JLabel label_8 = new JLabel(user.getReal_name());
		
		JLabel label_9 = new JLabel(user.getSex());
		
		JLabel label_10 = new JLabel(user.getClasses());
		
		JLabel label_11 = new JLabel(user.getMajor());
		
		JLabel label_12 = new JLabel(user.getBirthday());
		
		JLabel label_13 = new JLabel(user.getPhone());
		
		JLabel label_14 = new JLabel(user.getContact());
		
		JLabel label_15 = new JLabel("\u5B66\u9662");
		label_15.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel lblXueyuan = new JLabel(user.getCollege());
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(button))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(60)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
									.addComponent(label_7))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_4)
									.addPreferredGap(ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
									.addComponent(label_11))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_3)
									.addPreferredGap(ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
									.addComponent(label_10))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
									.addComponent(label_9))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
									.addComponent(label_8))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_5)
									.addPreferredGap(ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
									.addComponent(label_12))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_15)
									.addPreferredGap(ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
									.addComponent(lblXueyuan))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(lblQq)
									.addPreferredGap(ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
									.addComponent(label_14))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_6)
									.addPreferredGap(ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
									.addComponent(label_13)))))
					.addGap(101))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(label_7))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(label_8))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(label_9))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(label_10))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(label_11))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_5)
						.addComponent(label_12))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(label_15))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(lblXueyuan)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_6)
						.addComponent(label_13))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_14)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblQq)
							.addGap(25)
							.addComponent(button)))
					.addGap(32))
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}
	
	public User myInfo(String name) {
		UserService service = new UserServiceImpl();
		User user = service.selectByName(name);
		return user;
	}
}
