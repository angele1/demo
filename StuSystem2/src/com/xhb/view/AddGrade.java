package com.xhb.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.tools.ant.types.resources.TarResource;

import com.xhb.dao.UserService;
import com.xhb.dao.UserServiceImpl;
import com.xhb.entity.Grade;
import com.xhb.entity.User;

import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class AddGrade extends JFrame {

	private JPanel contentPane;
	private JTextField idField;
	private JTextField nameField;
	private JTextField courseField;
	private JTextField gradeField;
	private boolean result;
	Grade grade;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddGrade frame = new AddGrade();
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
	public AddGrade() {
		setTitle("\u6DFB\u52A0\u6210\u7EE9");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddGrade.class.getResource("/image/\u5B66\u751F.png")));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 350);
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
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addGradeOp(e);
			}
		});
		button.setFont(new Font("楷体", Font.PLAIN, 18));
		
		idField = new JTextField();
		idField.setFont(new Font("楷体", Font.PLAIN, 18));
		idField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setFont(new Font("楷体", Font.PLAIN, 18));
		nameField.setColumns(10);
		
		courseField = new JTextField();
		courseField.setFont(new Font("楷体", Font.PLAIN, 18));
		courseField.setColumns(10);
		
		gradeField = new JTextField();
		gradeField.setFont(new Font("楷体", Font.PLAIN, 18));
		gradeField.setColumns(10);
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idField.setText("");
				nameField.setText("");
				courseField.setText("");
				gradeField.setText("");
			}
		});
		button_1.setFont(new Font("楷体", Font.PLAIN, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addGap(56)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label)
								.addComponent(label_1)
								.addComponent(label_2)
								.addComponent(label_3))
							.addGap(72)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(gradeField)
								.addComponent(courseField)
								.addComponent(nameField)
								.addComponent(idField, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))))
					.addContainerGap(111, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(idField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_1)
						.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_2)
						.addComponent(courseField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_3)
						.addComponent(gradeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(button_1)
						.addComponent(button))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}

	protected void addGradeOp(ActionEvent e) {
		grade = new Grade();
		grade.setStu_id(idField.getText());
		grade.setStu_name(nameField.getText());
		grade.setCourse_name(courseField.getText());
		grade.setGrade(gradeField.getText());
		UserService service = new UserServiceImpl();
		List<Grade> list = service.selectAllGrade();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getStu_id().equals(idField.getText())&&list.get(i).getCourse_name().equals(courseField.getText())) {
				result = true;
				JOptionPane.showMessageDialog(this, "添加失败，学生成绩已存在");
			}
		}
		if(!result) {
			UserService service2 = new UserServiceImpl();
			if(service2.selectById(idField.getText())==null) {
				JOptionPane.showMessageDialog(this, "该学生不存在");
			}else {
				UserService service3 = new UserServiceImpl();
				service3.insertGrade(grade);
				JOptionPane.showMessageDialog(this, "添加成功");
			}
		}
	}

}
