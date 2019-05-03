package com.xhb.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.xhb.dao.UserService;
import com.xhb.dao.UserServiceImpl;
import com.xhb.entity.Course;
import com.xhb.entity.Grade;

import java.awt.Toolkit;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChooseCourse extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Object[][] data;
	private String[] head= {"课程编号","课程名","任课教师"};
	private DefaultTableModel tableModel;
	private int rowNum;
	private String coId;
	private String coName;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ChooseCourse frame = new ChooseCourse();
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
	public ChooseCourse() {
		setTitle("\u9009\u8BFE");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ChooseCourse.class.getResource("/image/\u5B66\u751F.png")));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u53EF\u9009\u8BFE\u7A0B");
		label.setFont(new Font("楷体", Font.PLAIN, 18));
		
		data = queryData();
		tableModel = new DefaultTableModel(data, head);
		table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		
		JButton button = new JButton("\u9009\u62E9\u8BFE\u7A0B");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rowNum = table.getSelectedRow();
				if(rowNum<0) {
					JOptionPane.showMessageDialog(contentPane, "请选择课程");
				}else {
					coName = tableModel.getValueAt(rowNum, 1).toString();
					coId = tableModel.getValueAt(rowNum, 0).toString();
					addCourseOp(e);
					tableModel.removeRow(rowNum);
					JOptionPane.showMessageDialog(contentPane, "选择课程成功");
				}
			}
		});
		button.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new MyCourseInfo();
			}
		});
		button_1.setFont(new Font("楷体", Font.PLAIN, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 442, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(75)
							.addComponent(button)
							.addGap(82)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(25))
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}
	
	protected void addCourseOp(ActionEvent e) {
		UserService service = new UserServiceImpl();
		Grade grade = new Grade();
		grade.setStu_id(LoginFrame.un);
		grade.setStu_name(LoginFrame.userN);
		grade.setCourse_name(coName);
		grade.setCourse_id(coId);
		//grade.setCourse_id();
		grade.setExam("否");
		service.insertGrade(grade);
		
	}

	public Object[][] queryData(){
		UserService service = new UserServiceImpl();
		Grade grade = new Grade();
		grade.setStu_id(LoginFrame.un);
		List<Course> list = service.selectOtherCourse(grade);
		
		data = new Object[list.size()][head.length]; 
		for(int i=0;i<list.size();i++)
			for(int j=0;j<head.length;j++) {
				data[i][0]=list.get(i).getCourse_id();
				data[i][1]=list.get(i).getCourse_name();
				data[i][2]= list.get(i).getCourse_te();
			}
		return data;
	}
}
