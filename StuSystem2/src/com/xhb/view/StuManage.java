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

public class StuManage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Object[][] data;
	DefaultTableModel tableModel;
	private String[] head = {"课程编号","课程名"};
	static String courseName;
	private int rowNum;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					StuManage frame = new StuManage();
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
	public StuManage() {
		setTitle("\u5B66\u751F\u7BA1\u7406");
		setIconImage(Toolkit.getDefaultToolkit().getImage(StuManage.class.getResource("/image/\u5B66\u751F.png")));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u6211\u7684\u8BFE\u7A0B");
		label.setFont(new Font("楷体", Font.PLAIN, 18));
		
		data =queryData();
		tableModel = new DefaultTableModel(data, head);
		table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JButton button = new JButton("\u67E5\u770B");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rowNum = table.getSelectedRow();
				if(rowNum>=0) {
					courseName = tableModel.getValueAt(rowNum, 1).toString();
					new CourseStuInfo();
					dispose();
				}else {
					JOptionPane.showMessageDialog(contentPane, "请选择要查看的课程");
				}
			}
		});
		button.setFont(new Font("楷体", Font.PLAIN, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(30)
							.addComponent(label))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(button)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 481, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(67, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(button)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}
	
	public Object[][] queryData(){
		UserService service = new UserServiceImpl();
		List<Course> list = service.selectTeCourse(LoginFrame.userN);
		data = new Object[list.size()][head.length];
		for(int i=0;i<list.size();i++)
			for(int j=0;j<head.length;j++) {
				data[i][0] = list.get(i).getCourse_id();
				data[i][1] = list.get(i).getCourse_name();
				
			}
		return data;
	}
}
