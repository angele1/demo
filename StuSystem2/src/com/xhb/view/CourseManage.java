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
import com.xhb.entity.User;
import com.xhb.utils.IsEmpty;

import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class CourseManage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField idField;
	private JTextField nameField;
	private DefaultTableModel tableModel;
	private Object[][] data;
	private String[] head= {"课程编号","课程名","教师工号","任课教师"};
	private Object[][] data1;
	private String searchId;
	private String searchName;
	static String c_id;
	private int rowNum;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CourseManage frame = new CourseManage();
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
	public CourseManage() {
		setTitle("\u8BFE\u7A0B\u7BA1\u7406");
		setIconImage(Toolkit.getDefaultToolkit().getImage(CourseManage.class.getResource("/image/\u5B66\u751F.png")));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		data = queryData();
		tableModel = new DefaultTableModel(data, head);
		table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		
		JLabel label = new JLabel("\u8BFE\u7A0B\u7F16\u53F7");
		label.setFont(new Font("楷体", Font.PLAIN, 18));
		
		idField = new JTextField();
		idField.setFont(new Font("楷体", Font.PLAIN, 18));
		idField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u8BFE\u7A0B\u540D");
		label_1.setFont(new Font("楷体", Font.PLAIN, 18));
		
		nameField = new JTextField();
		nameField.setFont(new Font("楷体", Font.PLAIN, 18));
		nameField.setColumns(10);
		
		JButton button = new JButton("\u641C\u7D22");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchCourseOp(e);
			}
		});
		button.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JButton button_1 = new JButton("\u6DFB\u52A0\u8BFE\u7A0B");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddCourse();
			}
		});
		button_1.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JButton button_2 = new JButton("\u5220\u9664\u8BFE\u7A0B");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rowNum = table.getSelectedRow();
				if(rowNum>0) {
					String id = tableModel.getValueAt(rowNum, 0).toString();
					UserService service = new UserServiceImpl();
					service.deleteCourse(id);
					tableModel.removeRow(rowNum);
					JOptionPane.showMessageDialog(contentPane, "删除成功");
					
				}else {
					JOptionPane.showMessageDialog(contentPane, "请选择要删除的记录");
				}
			}
		});
		button_2.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JButton button_3 = new JButton("\u67E5\u770B\u8BFE\u7A0B");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rowNum = table.getSelectedRow();
				if(rowNum>0) {
					c_id = tableModel.getValueAt(rowNum, 0).toString();
					new ViewCourse();
					dispose();
				}else {
					JOptionPane.showMessageDialog(contentPane, "请选择要查看的课程");
				}
			}
		});
		button_3.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JButton button_4 = new JButton("\u8FD4\u56DE");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AdminOp();
			}
		});
		button_4.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JButton button_5 = new JButton("\u91CD\u7F6E");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data = queryData();
				tableModel = new DefaultTableModel(data, head);
				table.setModel(tableModel);
				idField.setText("");
				nameField.setText("");
			}
		});
		button_5.setFont(new Font("楷体", Font.PLAIN, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 594, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(idField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(31)
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(button_1)
									.addGap(42)
									.addComponent(button_2)
									.addGap(33)
									.addComponent(button_3)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(27)
									.addComponent(button_5)
									.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
									.addComponent(button_4))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(button, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(idField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button_2)
						.addComponent(button_3)
						.addComponent(button_4)
						.addComponent(button_5))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}

	protected void searchCourseOp(ActionEvent e) {
		searchId = idField.getText();
		searchName = nameField.getText();
		UserService service = new UserServiceImpl();
		if(IsEmpty.IsEmpty(searchId)&&IsEmpty.IsEmpty(searchName)) {
			JOptionPane.showMessageDialog(this,"请输入搜索内容");
		}else {
			if(IsEmpty.notEmpty(searchId)||IsEmpty.notEmpty(searchName)) {
				//UserService service = new UserServiceImpl();
				List<Course> list1 = null;
				if(IsEmpty.IsEmpty(searchName)&&IsEmpty.notEmpty(searchId)) {
					Course course = new Course();
					list1 = service.selectCourseI(searchId);
					data1 = new Object[list1.size()][head.length];
					for(int i=0;i<list1.size();i++)
						for(int j=0;j<head.length;j++) {
							data1[i][0]=list1.get(i).getCourse_id();
							data1[i][1]=list1.get(i).getCourse_name();
							data1[i][2]= list1.get(i).getTeacherId();
							data1[i][3]=list1.get(i).getCourse_te();
							
						}
					tableModel = new DefaultTableModel(data1, head);
					table.setModel(tableModel);
				}
				
				if(IsEmpty.IsEmpty(searchId)&&IsEmpty.notEmpty(searchName)) {
						Course course = new Course();
						list1 = service.selectCourseN(searchName);
						data1 = new Object[list1.size()][head.length];
						for(int i=0;i<list1.size();i++)
							for(int j=0;j<head.length;j++) {
								data1[i][0]=list1.get(i).getCourse_id();
								data1[i][1]=list1.get(i).getCourse_name();
								data1[i][2] = list1.get(i).getTeacherId();
								data1[i][3]=list1.get(i).getCourse_te();
								
							}
						tableModel = new DefaultTableModel(data1, head);
						table.setModel(tableModel);
				}
			}
		}
		
	}

	public Object[][] queryData() {
		UserService service = new UserServiceImpl();
		List<Course> list = service.selectCourse();

		data = new Object[list.size()][head.length]; 
		for(int i=0;i<list.size();i++)
			for(int j=0;j<head.length;j++) {
				data[i][0]=list.get(i).getCourse_id();
				data[i][1]=list.get(i).getCourse_name();
				data[i][2]= list.get(i).getTeacherId();
				data[i][3]=list.get(i).getCourse_te();
			}
		return data;
	}
}
