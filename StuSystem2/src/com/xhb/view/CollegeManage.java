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
import com.xhb.entity.College;
import com.xhb.entity.Course;
import com.xhb.entity.User;
import com.xhb.utils.IsEmpty;

import java.awt.Toolkit;
import java.util.List;

import javax.naming.directory.SearchControls;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CollegeManage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Object[][] data;
	private Object[][] data1;
	private String[] head= {"学院编号","学院名称","专业","班级"};
	private DefaultTableModel tableModel;
	private JLabel label;
	private JTextField textField;
	private JLabel label_1;
	private JTextField textField_1;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_4;
	private JButton button_5;
	private String searchId;
	private String searchName;
	private int rowNum;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CollegeManage frame = new CollegeManage();
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
	public CollegeManage() {
		setTitle("\u5B66\u9662\u7BA1\u7406");
		setIconImage(Toolkit.getDefaultToolkit().getImage(CollegeManage.class.getResource("/image/\u5B66\u751F.png")));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		data = queryData();
		tableModel = new DefaultTableModel(data, head);
		table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		
		label = new JLabel("\u5B66\u9662\u7F16\u53F7");
		label.setFont(new Font("楷体", Font.PLAIN, 18));
		
		textField = new JTextField();
		textField.setFont(new Font("楷体", Font.PLAIN, 18));
		textField.setColumns(10);
		
		label_1 = new JLabel("\u5B66\u9662\u540D\u79F0");
		label_1.setFont(new Font("楷体", Font.PLAIN, 18));
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("楷体", Font.PLAIN, 18));
		textField_1.setColumns(10);
		
		button = new JButton("\u641C\u7D22");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchCollegeOp(e);
			}
		});
		button.setFont(new Font("楷体", Font.PLAIN, 18));
		
		button_1 = new JButton("\u6DFB\u52A0");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddCollege();
			}
		});
		button_1.setFont(new Font("楷体", Font.PLAIN, 18));
		
		button_2 = new JButton("\u5220\u9664");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rowNum = table.getSelectedRow();
				if(rowNum>0) {
					College college = new College();
					college.setCollege_id(tableModel.getValueAt(rowNum, 0).toString());
					college.setCollege_name(tableModel.getValueAt(rowNum, 1).toString());
					college.setMajor(tableModel.getValueAt(rowNum, 2).toString());
					college.setClasses(tableModel.getValueAt(rowNum, 3).toString());
					UserService service = new UserServiceImpl();
					service.deleteCollege(college);
					tableModel.removeRow(rowNum);
					JOptionPane.showMessageDialog(contentPane, "删除成功");
				}else {
					JOptionPane.showMessageDialog(contentPane, "请选择要删除的记录");
				}
			}
		});
		button_2.setFont(new Font("楷体", Font.PLAIN, 18));
		
		button_4 = new JButton("\u91CD\u7F6E");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data = queryData();
				tableModel = new DefaultTableModel(data, head);
				table.setModel(tableModel);
				textField.setText("");
				textField_1.setText("");
			}
		});
		button_4.setFont(new Font("楷体", Font.PLAIN, 18));
		
		button_5 = new JButton("\u8FD4\u56DE");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AdminOp();
			}
		});
		button_5.setFont(new Font("楷体", Font.PLAIN, 18));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addGap(37)
							.addComponent(button_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(label_1)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(51)
							.addComponent(button))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(26)
							.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(button_5)
							.addComponent(button_4))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(button_1)
							.addComponent(button_2)))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}
	
	protected void searchCollegeOp(ActionEvent e) {
		searchId = textField.getText();
		searchName = textField_1.getText();
		UserService service = new UserServiceImpl();
		if(IsEmpty.IsEmpty(searchId)&&IsEmpty.IsEmpty(searchName)) {
			JOptionPane.showMessageDialog(this,"请输入搜索内容");
		}else {
			if(IsEmpty.notEmpty(searchId)||IsEmpty.notEmpty(searchName)) {
				//UserService service = new UserServiceImpl();
				List<College> list1 = null;
				if(IsEmpty.IsEmpty(searchName)&&IsEmpty.notEmpty(searchId)) {
					list1 = service.selectLikeCo(searchId);
					data1 = new Object[list1.size()][head.length];
					for(int i=0;i<list1.size();i++)
						for(int j=0;j<head.length;j++) {
							data1[i][0]=list1.get(i).getCollege_id();
							data1[i][1]=list1.get(i).getCollege_name();
							data1[i][2] = list1.get(i).getMajor();
							data1[i][3] = list1.get(i).getClasses();
							
							
						}
					tableModel = new DefaultTableModel(data1, head);
					table.setModel(tableModel);
				}
				
				if(IsEmpty.IsEmpty(searchId)&&IsEmpty.notEmpty(searchName)) {
						list1 = service.selectLikeCo2(searchName);
						data1 = new Object[list1.size()][head.length];
						for(int i=0;i<list1.size();i++)
							for(int j=0;j<head.length;j++) {
								data1[i][0]=list1.get(i).getCollege_id();
								data1[i][1]=list1.get(i).getCollege_name();
								data1[i][2] = list1.get(i).getMajor();
								data1[i][3] = list1.get(i).getClasses();
								
							}
						tableModel = new DefaultTableModel(data1, head);
						table.setModel(tableModel);
				}
			}
		}
		
	}

	public Object[][] queryData() {
		UserService service = new UserServiceImpl();
		List<College> list = service.selectAllCollege();

		data = new Object[list.size()][head.length]; 
		for(int i=0;i<list.size();i++)
			for(int j=0;j<head.length;j++) {
				data[i][0]=list.get(i).getCollege_id();
				data[i][1]=list.get(i).getCollege_name();
				data[i][2]= list.get(i).getMajor();
				data[i][3]= list.get(i).getClasses();
			}
		return data;
	}
}
