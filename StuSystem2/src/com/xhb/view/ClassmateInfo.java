package com.xhb.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.logging.log4j.spi.CleanableThreadContextMap;

import com.xhb.dao.UserService;
import com.xhb.dao.UserServiceImpl;
import com.xhb.entity.User;
import com.xhb.utils.IsEmpty;

import ognl.ObjectPropertyAccessor;

import java.awt.Toolkit;
import java.util.List;

import javax.print.attribute.standard.RequestingUserName;
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

public class ClassmateInfo extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String[] head= {"学号","姓名","电话","QQ"};
	private Object[][] data;
	private Object[][] data1;
	private JTextField stuIdField;
	private JTextField nameField;
	private String searchId;
	private String searchName;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane; 
	private JButton button_1;
	private List<User> list;
	private List<User> list1;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ClassmateInfo frame = new ClassmateInfo();
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
	public ClassmateInfo() {
		setTitle("\u73ED\u7EA7\u4FE1\u606F");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ClassmateInfo.class.getResource("/image/\u5B66\u751F.png")));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		data = queryData();
		tableModel = new DefaultTableModel(data, head);
		table = new JTable(tableModel);
		scrollPane = new JScrollPane(table);
		
		JLabel label = new JLabel("\u5B66\u53F7");
		label.setFont(new Font("楷体", Font.PLAIN, 18));
		
		stuIdField = new JTextField();
		stuIdField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u59D3\u540D");
		label_1.setFont(new Font("楷体", Font.PLAIN, 18));
		
		nameField = new JTextField();
		nameField.setColumns(10);
		
		JButton button = new JButton("\u641C\u7D22");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchStu(e);
			}
		});
		button.setFont(new Font("楷体", Font.PLAIN, 18));
		
		button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clean(e);
				
			}
		});
		button_1.setFont(new Font("楷体", Font.PLAIN, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(stuIdField, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addGap(57)
					.addComponent(label_1)
					.addGap(18)
					.addComponent(nameField, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(button)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(stuIdField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}
	
	protected void clean(ActionEvent e) {
		//重置数据
		tableModel = new DefaultTableModel(data, head);
		table.setModel(tableModel);
		stuIdField.setText("");
		nameField.setText("");
	}

	protected void searchStu(ActionEvent e) {
		searchId = stuIdField.getText();
		searchName = nameField.getText();
		User user = new User();
		UserService service2 = new UserServiceImpl();
		user = service2.selectById(LoginFrame.un);
		if(IsEmpty.IsEmpty(searchId)&&IsEmpty.IsEmpty(searchName)) {
			JOptionPane.showMessageDialog(this, "请输入搜索内容");
		}
		if(IsEmpty.notEmpty(searchId)||IsEmpty.notEmpty(searchName)) {
			UserService service = new UserServiceImpl();
			if(IsEmpty.IsEmpty(searchName)&&IsEmpty.notEmpty(searchId)) {
				list1 = service.selectLikeId(user);
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
			else if(IsEmpty.IsEmpty(searchId)&&IsEmpty.notEmpty(searchName)) {
				list1 = service.selectLikeName(user);
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

	public Object[][] queryData() {
		//Object[][] data1=null;
		UserService service = new UserServiceImpl();
		User user = service.selectByName(LoginFrame.userN);
		//System.out.println(user);
		UserService service2 = new UserServiceImpl();
		list = service2.selectClassmate(user);
//		for(User user2:list) {
//			System.out.println(user2);
//		}
		data = new Object[list.size()][head.length]; 
		for(int i=0;i<list.size();i++)
			for(int j=0;j<head.length;j++) {
				data[i][0]=list.get(i).getId();
				data[i][1]=list.get(i).getReal_name();
				data[i][2]=list.get(i).getPhone();
				data[i][3]=list.get(i).getContact();
			}
		return data;
	}
}
