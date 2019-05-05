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

import javassist.compiler.ast.NewExpr;

import java.awt.Toolkit;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OtherTeacher extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField idField;
	private JTextField nameField;
	private Object[][] data;
	private Object[][] data1;
	private String[] head= {"工号","教师名","手机","QQ"};
	private DefaultTableModel tableModel;
	private String searchId;
	private String searchName;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					OtherTeacher frame = new OtherTeacher();
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
	public OtherTeacher() {
		setTitle("\u6559\u5E08\u4FE1\u606F");
		setIconImage(Toolkit.getDefaultToolkit().getImage(OtherTeacher.class.getResource("/image/\u5B66\u751F.png")));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		data = queryData();
		tableModel = new DefaultTableModel(data, head);
		table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		
		JLabel label = new JLabel("\u6559\u5E08\u5DE5\u53F7");
		label.setFont(new Font("楷体", Font.PLAIN, 18));
		
		idField = new JTextField();
		idField.setFont(new Font("楷体", Font.PLAIN, 18));
		idField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6559\u5E08\u540D");
		label_1.setFont(new Font("楷体", Font.PLAIN, 18));
		
		nameField = new JTextField();
		nameField.setFont(new Font("楷体", Font.PLAIN, 18));
		nameField.setColumns(10);
		
		JButton button = new JButton("\u641C\u7D22");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchTeOp(e);
			}
		});
		button.setFont(new Font("楷体", Font.PLAIN, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 590, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(idField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(button)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(idField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}
	
	protected void searchTeOp(ActionEvent e) {
		searchId = idField.getText();
		searchName = nameField.getText();
		UserService service = new UserServiceImpl();
		UserService service2 = new UserServiceImpl();
		User user = new User();
		user = service.selectById(LoginFrame.un);
		if(IsEmpty.IsEmpty(searchId)&&IsEmpty.IsEmpty(searchName)) {
			JOptionPane.showMessageDialog(this,"请输入搜索内容");
		}else {
			if(IsEmpty.notEmpty(searchId)||IsEmpty.notEmpty(searchName)) {
				//UserService service = new UserServiceImpl();
				List<User> list1 = null;
				if(IsEmpty.IsEmpty(searchName)&&IsEmpty.notEmpty(searchId)) {
					list1 = service2.selectLikeId(user);
					data1 = new Object[list1.size()][head.length];
					for(int i=0;i<list1.size();i++)
						for(int j=0;j<head.length;j++) {
							data1[i][0]=list1.get(i).getId();
							data1[i][1]=list1.get(i).getReal_name();
							data1[i][2]=list1.get(i).getPhone();
							data1[i][3]=list1.get(i).getContact();
							
							
						}
					tableModel = new DefaultTableModel(data1, head);
					table.setModel(tableModel);
				}
				
				if(IsEmpty.IsEmpty(searchId)&&IsEmpty.notEmpty(searchName)) {
						list1 = service2.selectLikeName(user);
						data1 = new Object[list1.size()][head.length];
						for(int i=0;i<list1.size();i++)
							for(int j=0;j<head.length;j++) {
								data1[i][0]=list1.get(i).getId();
								data1[i][1]=list1.get(i).getReal_name();
								data1[i][2]=list1.get(i).getPhone();
								data1[i][3]=list1.get(i).getContact();
								
							}
						tableModel = new DefaultTableModel(data1, head);
						table.setModel(tableModel);
				}
			}
		}
		
	}

	public Object[][] queryData() {
		UserService service = new UserServiceImpl();
		UserService service2 = new UserServiceImpl();
		User user = new User();
		user = service.selectById(LoginFrame.un);
		
		List<User> list = service2.selectOtherTe(user);

		data = new Object[list.size()][head.length]; 
		for(int i=0;i<list.size();i++)
			for(int j=0;j<head.length;j++) {
				//if(!list.get(i).getId().equals(user.getId())) {
					data[i][0]=list.get(i).getId();
					data[i][1]=list.get(i).getReal_name();
					data[i][2]= list.get(i).getPhone();
					data[i][3]=list.get(i).getContact();
				//}
			}
		return data;
	}
}
