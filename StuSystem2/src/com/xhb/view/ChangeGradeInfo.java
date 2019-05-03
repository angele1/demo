package com.xhb.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.xhb.dao.UserService;
import com.xhb.dao.UserServiceImpl;
import com.xhb.entity.Grade;
import com.xhb.utils.IsEmpty;

import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangeGradeInfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	Grade grade;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ChangeGradeInfo frame = new ChangeGradeInfo();
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
	public ChangeGradeInfo() {
		setTitle("\u4FEE\u6539\u6210\u7EE9");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ChangeGradeInfo.class.getResource("/image/\u5B66\u751F.png")));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u5B66\u53F7");
		label.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_1 = new JLabel("\u59D3\u540D");
		label_1.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_2 = new JLabel("\u8BFE\u7A0B");
		label_2.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_3 = new JLabel("\u6210\u7EE9");
		label_3.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JButton button = new JButton("\u786E\u8BA4\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(IsEmpty.notEmpty(textField.getText())) {
					grade.setGrade(textField.getText());
					UserService service = new UserServiceImpl();
					service.updateGrade(grade);
					JOptionPane.showMessageDialog(contentPane, "修改成功");
				}else {
					JOptionPane.showMessageDialog(contentPane, "成绩不能为空");
				}
			}
		});
		button.setFont(new Font("楷体", Font.PLAIN, 18));
		
		UserService service = new UserServiceImpl();
		Grade grade2 = new Grade();
		grade2.setStu_id(GradeManage.stuId);
		grade2.setCourse_name(GradeManage.courseId);
		grade = service.selectGrade(grade2);
		
		textField = new JTextField(GradeManage.gra);
		textField.setFont(new Font("楷体", Font.PLAIN, 18));
		textField.setColumns(10);
		
		JLabel lblId = new JLabel(grade.getStu_id());
		lblId.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel lblName = new JLabel(grade.getStu_name());
		lblName.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel lblCourse = new JLabel(grade.getCourse_name());
		lblCourse.setFont(new Font("楷体", Font.PLAIN, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(100, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_2)
						.addComponent(label_3)
						.addComponent(label_1)
						.addComponent(label))
					.addGap(84)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(button)
						.addComponent(lblName)
						.addComponent(lblId)
						.addComponent(lblCourse)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(115))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(label))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(label_1))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCourse)
						.addComponent(label_2))
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3))
					.addGap(18)
					.addComponent(button)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}

}
