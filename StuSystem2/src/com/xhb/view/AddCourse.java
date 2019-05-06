package com.xhb.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.xhb.dao.UserService;
import com.xhb.dao.UserServiceImpl;
import com.xhb.entity.Course;
import com.xhb.entity.User;

import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCourse extends JFrame {

	private JPanel contentPane;
	private JTextField idField;
	private JTextField nameField;
	private JTextField teField;
	private String teacherId;
	private JTextField teacherIdField;
	private String teacherName;
	private String courseId;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddCourse frame = new AddCourse();
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
	public AddCourse() {
		setTitle("\u6DFB\u52A0\u8BFE\u7A0B");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddCourse.class.getResource("/image/\u5B66\u751F.png")));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u8BFE\u7A0B\u7F16\u53F7");
		label.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_1 = new JLabel("\u8BFE\u7A0B\u540D");
		label_1.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_2 = new JLabel("\u4EFB\u8BFE\u6559\u5E08");
		label_2.setFont(new Font("楷体", Font.PLAIN, 18));
		
		idField = new JTextField();
		idField.setFont(new Font("楷体", Font.PLAIN, 18));
		idField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setFont(new Font("楷体", Font.PLAIN, 18));
		nameField.setColumns(10);
		
		teField = new JTextField();
		teField.setFont(new Font("楷体", Font.PLAIN, 18));
		teField.setColumns(10);
		
		JButton button = new JButton("\u786E\u8BA4\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teacherId = teacherIdField.getText();
				teacherName = teField.getText();
				courseId = idField.getText();
				User user = new User();
				user.setId(teacherId);
				user.setReal_name(teacherName);
				if(hasUser(user)&&!hasCourse(courseId)) {
					addCourseOp();
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "添加失败");
				}
			}
		});
		button.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idField.setText("");
				nameField.setText("");
				teField.setText("");
				teacherIdField.setText("");
			}
		});
		button_1.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_3 = new JLabel("\u6559\u5E08\u5DE5\u53F7");
		label_3.setFont(new Font("楷体", Font.PLAIN, 18));
		
		teacherIdField = new JTextField();
		teacherIdField.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(68)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label)
								.addComponent(label_1)
								.addComponent(label_2)
								.addComponent(label_3))
							.addGap(73)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(teField)
								.addComponent(nameField)
								.addComponent(idField)
								.addComponent(teacherIdField)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(82)
							.addComponent(button)
							.addGap(40)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(91, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(47)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(idField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_1)
						.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_3)
						.addComponent(teacherIdField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(teField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(56, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}

	protected void addCourseOp() {
		Course course = new Course();
		course.setCourse_id(idField.getText());
		course.setCourse_name(nameField.getText());
		course.setCourse_te(teField.getText());
		course.setTeacherId(teacherId);
		course.setExam("否");
		UserService service = new UserServiceImpl();
		service.insertCourse(course);
		JOptionPane.showMessageDialog(contentPane, "添加成功");
		
	}
	
	protected boolean hasUser(User user) {
		UserService service = new UserServiceImpl();
		User user2 = service.selectTeacher(user);
		if(user2!=null) {
			return true;
		}
		return false;
		
	}
	
	protected boolean hasCourse(String courseId) {
		UserService service = new UserServiceImpl();
		Course course = service.selectCourseById(courseId);
		if(course!=null) {
			return true;
		}
		return false;
	}
}
