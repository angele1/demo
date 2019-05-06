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
import com.xhb.entity.Grade;
import com.xhb.utils.IsEmpty;

import java.awt.Toolkit;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GradeManage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private Object[][] data;
	private Object[][] data1;
	private String[] head= {"学号","姓名","课程","成绩"};
	private JTextField idField;
	private JTextField nameField;
	private int rowNum;
	static String stuId;
	static String stuName;
	static String courseId;
	static String gra;
	private String searchId;
	private String searchName;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GradeManage frame = new GradeManage();
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
	public GradeManage() {
		setTitle("\u6210\u7EE9\u7BA1\u7406");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GradeManage.class.getResource("/image/\u5B66\u751F.png")));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		data = queryData();
		tableModel = new DefaultTableModel(data, head);
		table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		
		JLabel label = new JLabel("\u5B66\u53F7");
		label.setFont(new Font("楷体", Font.PLAIN, 18));
		
		idField = new JTextField();
		idField.setFont(new Font("楷体", Font.PLAIN, 18));
		idField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u59D3\u540D");
		label_1.setFont(new Font("楷体", Font.PLAIN, 18));
		
		nameField = new JTextField();
		nameField.setFont(new Font("楷体", Font.PLAIN, 18));
		nameField.setColumns(10);
		
//		UserService service = new UserServiceImpl();
//		List<College> listCo = service.selectAllCollege();
//		for(int i=0;i<listCo.size();i++) {
//			if(comboBox.getItemCount()==0) {
//				comboBox.addItem(listCo.get(i).getCollege_name());
//			}
//			else {
//				for(int j=0;j<comboBox.getItemCount();j++) {
//					
//					if(!(comboBox.getItemAt(j).toString().equals(listCo.get(i).getCollege_name()))){
//						comboBox.addItem(listCo.get(i).getCollege_name());
//					}
//				}
//			}
//		}
		//String name = comboBox.getSelectedItem().toString();
		JButton button = new JButton("\u641C\u7D22");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchGradeOp(e);
			}
		});
		button.setFont(new Font("楷体", Font.PLAIN, 18));
//		for(int i=0;i<gList.size();i++) {
//			
//			comboBox_1.addItem(gList.get(i).getMajor());
//		}
		
		
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AdminOp();
				dispose();
				
			}
		});
		button_1.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JButton button_2 = new JButton("\u91CD\u7F6E");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data = queryData();
				tableModel = new DefaultTableModel(data, head);
				table.setModel(tableModel);
			}
		});
		button_2.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JButton button_3 = new JButton("\u6DFB\u52A0");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddGrade();
			}
		});
		button_3.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JButton button_4 = new JButton("\u5220\u9664");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rowNum = table.getSelectedRow();
				if(rowNum>0) {
					String s_id = tableModel.getValueAt(rowNum, 0).toString();
					String c_name = tableModel.getValueAt(rowNum, 2).toString();
					Grade grade = new Grade();
					grade.setStu_id(s_id);
					grade.setCourse_name(c_name);
					UserService service = new UserServiceImpl();
					service.deleteGrade(grade);
					tableModel.removeRow(rowNum);
					JOptionPane.showMessageDialog(contentPane, "删除成功");
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "请选择要删除行");
				}
			}
		});
		button_4.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JButton button_5 = new JButton("\u4FEE\u6539");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rowNum = table.getSelectedRow();
				if(rowNum>0) {
					stuId = tableModel.getValueAt(rowNum, 0).toString();
					stuName = tableModel.getValueAt(rowNum, 1).toString();
					courseId = tableModel.getValueAt(rowNum, 2).toString();
					gra = tableModel.getValueAt(rowNum, 3).toString();
					new ChangeGradeInfo();
				}else {
					JOptionPane.showMessageDialog(contentPane, "请选择要修改的学生成绩");
				}
			}
		});
		button_5.setFont(new Font("楷体", Font.PLAIN, 18));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(idField))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)))
							.addGap(27)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
									.addGap(32)
									.addComponent(button_2))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_1)
									.addGap(26)
									.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(button_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(button, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(label)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(idField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(button)
							.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_1)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button_3)
						.addComponent(button_4)
						.addComponent(button_5)
						.addComponent(button_2))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}
	
	protected void searchGradeOp(ActionEvent e) {
		searchId = idField.getText();
		searchName = nameField.getText();
		UserService service = new UserServiceImpl();
		if(IsEmpty.IsEmpty(searchId)&&IsEmpty.IsEmpty(searchName)) {
			JOptionPane.showMessageDialog(this,"请输入搜索内容");
		}else {
			if(IsEmpty.notEmpty(searchId)||IsEmpty.notEmpty(searchName)) {
				//UserService service = new UserServiceImpl();
				List<Grade> list1 = null;
				if(IsEmpty.IsEmpty(searchName)&&IsEmpty.notEmpty(searchId)) {
					//Course course = new Course();
					list1 = service.selectGradeI(searchId);
					data1 = new Object[list1.size()][head.length];
					for(int i=0;i<list1.size();i++)
						for(int j=0;j<head.length;j++) {
							data1[i][0]=list1.get(i).getStu_id();
							data1[i][1]=list1.get(i).getStu_name();
							data1[i][2]=list1.get(i).getCourse_name();
							data1[i][3]=list1.get(i).getGrade();
							
							
						}
					tableModel = new DefaultTableModel(data1, head);
					table.setModel(tableModel);
				}
				
				if(IsEmpty.IsEmpty(searchId)&&IsEmpty.notEmpty(searchName)) {
						//Course course = new Course();
						list1 = service.selectGradeN(searchName);
						data1 = new Object[list1.size()][head.length];
						for(int i=0;i<list1.size();i++)
							for(int j=0;j<head.length;j++) {
								data1[i][0]=list1.get(i).getStu_id();
								data1[i][1]=list1.get(i).getStu_name();
								data1[i][2]=list1.get(i).getCourse_name();
								data1[i][3]=list1.get(i).getGrade();
								
							}
						tableModel = new DefaultTableModel(data1, head);
						table.setModel(tableModel);
				}
			}
		}
	}

	public Object[][] queryData(){
		UserService service = new UserServiceImpl();
		List<Grade> list = service.selectAllGrade();
		data = new Object[list.size()][head.length];
		for(int i=0;i<list.size();i++)
			for(int j=0;j<head.length;j++) {
				data[i][0] = list.get(i).getStu_id();
				data[i][1] = list.get(i).getStu_name();
				data[i][2] = list.get(i).getCourse_name();
				data[i][3] = list.get(i).getGrade();
				
			}
		
		return data;
	}
}
