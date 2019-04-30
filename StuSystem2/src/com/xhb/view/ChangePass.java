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

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePass extends JFrame {

	private JPanel contentPane;
	private JTextField originPsField;
	private JTextField newPsField;
	private String originPs;
	private String newPs;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ChangePass frame = new ChangePass();
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
	public ChangePass() {
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ChangePass.class.getResource("/image/\u5B66\u751F.png")));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u539F\u5BC6\u7801");
		label.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_1 = new JLabel("\u65B0\u5BC6\u7801");
		label_1.setFont(new Font("楷体", Font.PLAIN, 18));
		
		originPsField = new JTextField();
		originPsField.setColumns(10);
		
		newPsField = new JTextField();
		newPsField.setColumns(10);
		
		JButton button = new JButton("\u786E\u8BA4\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePsOp(e);
			}
		});
		button.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				originPsField.setText("");
				newPsField.setText("");
			}
		});
		button_1.setFont(new Font("楷体", Font.PLAIN, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(76)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(button)
							.addGap(70)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label)
								.addComponent(label_1))
							.addGap(31)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(newPsField)
								.addComponent(originPsField, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))))
					.addContainerGap(72, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(50)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(originPsField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(newPsField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(29))
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}

	protected void changePsOp(ActionEvent e) {
		originPs = originPsField.getText();
		newPs = newPsField.getText();
		UserService service = new UserServiceImpl();
		User user = service.selectByName(LoginFrame.userN);
		if(IsEmpty.IsEmpty(originPs)||IsEmpty.IsEmpty(newPs)) {
			JOptionPane.showMessageDialog(this, "密码不能为空");
		}
		else {
			if(originPs.equals(user.getPassword())) {
				UserService service2 = new UserServiceImpl();
				user.setPassword(newPs);
				service2.updateById(user);
				JOptionPane.showMessageDialog(this, "修改成功");
				dispose();
			}
			else {
				JOptionPane.showMessageDialog(this, "原密码错误，修改失败");
				
			}
		}
		
	}

}
