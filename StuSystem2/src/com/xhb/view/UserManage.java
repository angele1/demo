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
import com.xhb.entity.User;
import com.xhb.utils.IsEmpty;

import java.awt.Toolkit;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class UserManage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField idFindField;
	private JTextField nameFindField;
	private Object[][] data;
	private Object[][] data1;
	private String[] head= {"学工号","姓名","用户类型"};
	private DefaultTableModel tableModel;
	private String userType;
	private String searchId;
	private String searchName;
	private String permission;
	private int rowNum;
	static String id;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UserManage frame = new UserManage();
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
	public UserManage() {
		setTitle("\u7528\u6237\u7BA1\u7406");
		setIconImage(Toolkit.getDefaultToolkit().getImage(UserManage.class.getResource("/image/\u5B66\u751F.png")));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		data = queryData();
		tableModel = new DefaultTableModel(data, head);
		table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		
		JLabel label = new JLabel("\u8D26\u53F7");
		label.setFont(new Font("楷体", Font.PLAIN, 18));
		
		idFindField = new JTextField();
		idFindField.setFont(new Font("楷体", Font.PLAIN, 18));
		idFindField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u59D3\u540D");
		label_1.setFont(new Font("楷体", Font.PLAIN, 18));
		
		nameFindField = new JTextField();
		nameFindField.setFont(new Font("楷体", Font.PLAIN, 18));
		nameFindField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				userType = comboBox.getSelectedItem().toString();
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u5B66\u751F", "\u6559\u5E08", "\u7BA1\u7406\u5458"}));
		comboBox.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JButton button = new JButton("\u641C\u7D22");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchUserOp(e);
			}
		});
		button.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JButton button_1 = new JButton("\u6DFB\u52A0\u7528\u6237");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddUser();
				dispose();
			}
		});
		button_1.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JButton button_2 = new JButton("\u5220\u9664\u7528\u6237");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rowNum = table.getSelectedRow();
				deleteUserOp(e);
				tableModel.removeRow(rowNum);
				JOptionPane.showMessageDialog(contentPane, "删除成功");
			}
		});
		button_2.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JButton button_3 = new JButton("\u91CD\u7F6E");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data = queryData();
				tableModel = new DefaultTableModel(data, head);
				table.setModel(tableModel);
				idFindField.setText("");
				nameFindField.setText("");
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
		
		JButton button_5 = new JButton("\u67E5\u770B");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rowNum = table.getSelectedRow();
				id = tableModel.getValueAt(rowNum, 0).toString();
				new ViewUserInfo();
				dispose();
			}
		});
		button_5.setFont(new Font("楷体", Font.PLAIN, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 617, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(button_1)
									.addGap(26)
									.addComponent(button_2)
									.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
									.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
									.addGap(18))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(idFindField, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
									.addGap(21)
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(nameFindField, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
									.addGap(37)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(42)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 123, Short.MAX_VALUE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(idFindField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(nameFindField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button_2)
						.addComponent(button_3)
						.addComponent(button_5)
						.addComponent(button_4))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}
	
	protected void deleteUserOp(ActionEvent e) {
		UserService service = new UserServiceImpl();
		String id = (String) tableModel.getValueAt(rowNum, 0);
		service.deleteUser(id);
	}

	protected void searchUserOp(ActionEvent e) {
		searchId = idFindField.getText();
		searchName = nameFindField.getText();
		UserService service = new UserServiceImpl();
		if(IsEmpty.IsEmpty(searchId)&&IsEmpty.IsEmpty(searchName)) {
			if(userType.equals("学生")||IsEmpty.IsEmpty(userType)) {
				permission = "0";
			}else if(userType.equals("教师")) {
				permission = "1";
			}else if(userType.equals("管理员")) {
				permission = "2";
			}
			List<User> list = service.selectUserType(permission);
			data1 = new Object[list.size()][head.length];
			for(int i=0;i<list.size();i++)
				for(int j=0;j<head.length;j++) {
					data1[i][0]=list.get(i).getId();
					data1[i][1]=list.get(i).getReal_name();
					data1[i][2]=userType;
				}
			tableModel = new DefaultTableModel(data1, head);
			table.setModel(tableModel);
		}
		if(IsEmpty.notEmpty(searchId)||IsEmpty.notEmpty(searchName)) {
			//UserService service = new UserServiceImpl();
			List<User> list1 = null;
			if(IsEmpty.IsEmpty(searchName)&&IsEmpty.notEmpty(searchId)) {
				User user = new User();
				user.setId(searchId);
				if(userType.equals("学生")) {
					permission = "0";
				}else if(userType.equals("教师")) {
					permission = "1";
				}else if(userType.equals("管理员")) {
					permission = "2";
				}
				user.setPermission(permission);
				list1 = service.selectLikeP1(user);
				data1 = new Object[list1.size()][head.length];
				for(int i=0;i<list1.size();i++)
					for(int j=0;j<head.length;j++) {
						data1[i][0]=list1.get(i).getId();
						data1[i][1]=list1.get(i).getReal_name();
						String p = list1.get(i).getPermission();
						if(IsEmpty.notEmpty(p)&&p.equals("0")) {
							data1[i][2]="学生";
						}else if(IsEmpty.notEmpty(p)&&p.equals("1")) {
							data1[i][2]="教师";
						}else {
							data[i][2]="管理员";
						}
					}
				tableModel = new DefaultTableModel(data1, head);
				table.setModel(tableModel);
			}
			else if(IsEmpty.IsEmpty(searchId)&&IsEmpty.notEmpty(searchName)) {
				User user = new User();
				user.setReal_name(searchName);;
				if(userType.equals("学生")) {
					permission = "0";
				}else if(userType.equals("教师")) {
					permission = "1";
				}else if(userType.equals("管理员")) {
					permission = "2";
				}
				user.setPermission(permission);
				list1 = service.selectLikeP2(user);
				data1 = new Object[list1.size()][head.length];
				for(int i=0;i<list1.size();i++)
					for(int j=0;j<head.length;j++) {
						data1[i][0]=list1.get(i).getId();
						data1[i][1]=list1.get(i).getReal_name();
						String p = list1.get(i).getPermission();
						if(IsEmpty.notEmpty(p)&&p.equals("0")) {
							data1[i][2]="学生";
						}else if(IsEmpty.notEmpty(p)&&p.equals("1")) {
							data1[i][2]="教师";
						}else {
							data[i][2]="管理员";
						}
						
					}
				tableModel = new DefaultTableModel(data1, head);
				table.setModel(tableModel);
			}
		}
			
	}

	public Object[][] queryData() {
		UserService service = new UserServiceImpl();
		List<User> list = service.selectAllUser();

		data = new Object[list.size()][head.length]; 
		for(int i=0;i<list.size();i++)
			for(int j=0;j<head.length;j++) {
				data[i][0]=list.get(i).getId();
				data[i][1]=list.get(i).getReal_name();
				if(list.get(i).getPermission().equals("0")) {
					data[i][2]="学生";
				}else if(list.get(i).getPermission().equals("1")) {
					data[i][2]="教师";
				}else {
					data[i][2]="管理员";
				}
			}
		return data;
	}
}
