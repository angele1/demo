package com.xhb.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OnlineEx extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Object[][] data;
	private String[] head= {"课程编号","课程名","是否可以考试"};
	DefaultTableModel tableModel;
	private int rowNum;
	static String courseName;
	static String courseId;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					OnlineEx frame = new OnlineEx();
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
	public OnlineEx() {
		setTitle("\u5728\u7EBF\u8003\u8BD5");
		setIconImage(Toolkit.getDefaultToolkit().getImage(OnlineEx.class.getResource("/image/\u5B66\u751F.png")));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		data = queryData();
		tableModel = new DefaultTableModel(data, head);
		table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JButton button = new JButton("\u9009\u62E9\u8003\u8BD5");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rowNum = table.getSelectedRow();
				if(rowNum<0) {
					JOptionPane.showMessageDialog(contentPane, "请选择课程");
				}else {
					courseName = tableModel.getValueAt(rowNum, 1).toString();
					courseId = tableModel.getValueAt(rowNum, 0).toString();
					if(tableModel.getValueAt(rowNum, 2).toString().equals("是")) {
						new Exam();
						dispose();
					}else {
						JOptionPane.showMessageDialog(contentPane, "考试尚未开始");
					}
				}
			}
		});
		button.setFont(new Font("楷体", Font.PLAIN, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(200)
							.addComponent(button)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
					.addComponent(button)
					.addGap(49))
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}
	
	public Object[][] queryData(){
		UserService service = new UserServiceImpl();
		Grade grade = new Grade();
		grade.setStu_id(LoginFrame.un);
		List<Grade> list = service.selectNull(grade);
		
		data = new Object[list.size()][head.length]; 
		for(int i=0;i<list.size();i++)
			for(int j=0;j<head.length;j++) {
				data[i][0]=list.get(i).getCourse_id();
				data[i][1]=list.get(i).getCourse_name();
				data[i][2]="否";
			}
		return data;
	}
}
