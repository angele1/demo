package com.xhb.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.xhb.dao.UserService;
import com.xhb.dao.UserServiceImpl;
import com.xhb.entity.Grade;
import com.xhb.entity.User;
import com.xhb.utils.IsEmpty;

import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterGrade extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	Grade grade2;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RegisterGrade frame = new RegisterGrade();
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
	public RegisterGrade() {
		setTitle("\u5B66\u751F\u6210\u7EE9");
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegisterGrade.class.getResource("/image/\u5B66\u751F.png")));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 403, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u5B66\u53F7");
		label.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_1 = new JLabel("\u59D3\u540D");
		label_1.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_2 = new JLabel("\u6210\u7EE9");
		label_2.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JButton button = new JButton("\u786E\u8BA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(IsEmpty.notEmpty(textField.getText())) {
					grade2.setGrade(textField.getText());
					UserService service = new UserServiceImpl();
					service.updateGrade(grade2);
					JOptionPane.showMessageDialog(contentPane, "登记成功");
				}else {
					JOptionPane.showMessageDialog(contentPane, "请输入学生成绩");
				}
			}
		});
		button.setFont(new Font("楷体", Font.PLAIN, 18));
		
		UserService service = new UserServiceImpl();
		Grade grade = new Grade();
		grade.setStu_id(CourseStuInfo.stuId);
		grade.setCourse_name(StuManage.courseName);
		grade2 = service.selectGrade(grade);
		
		JLabel lblId = new JLabel(grade2.getStu_id());
		lblId.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel lblName = new JLabel(grade2.getStu_name());
		lblName.setFont(new Font("楷体", Font.PLAIN, 18));
		
		textField = new JTextField();
		textField.setFont(new Font("楷体", Font.PLAIN, 18));
		textField.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(60)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2)
						.addComponent(label_1)
						.addComponent(label))
					.addGap(103)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblName)
						.addComponent(lblId)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
					.addGap(61))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(lblId))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(lblName))
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_2)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addComponent(button)
					.addGap(30))
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}

}
