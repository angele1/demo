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
import com.xhb.entity.Notice;
import com.xhb.utils.IsEmpty;

import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class AllNotice extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Object[][] data;
	private String[] head = {"通告编号","通告内容","类型"};
	private DefaultTableModel tableModel;
//	static int rowNum;
	static Integer id;
	static String content;
	static String permission;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AllNotice frame = new AllNotice();
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
	public AllNotice() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AllNotice.class.getResource("/image/\u5B66\u751F.png")));
		setTitle("\u901A\u544A");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		data = queryAll();
		tableModel = new DefaultTableModel(data, head);
		table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		
		JButton button = new JButton("\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//modifyNotice(e);
				int rowNum = table.getSelectedRow();
				id = (Integer) tableModel.getValueAt(rowNum, 0);
				content = tableModel.getValueAt(rowNum, 1).toString();
				String type = tableModel.getValueAt(rowNum, 2).toString();
				//String permission = null;
				if(IsEmpty.notEmpty(type)&&type.equals("学生")) {
					permission = "0";
				}
				else {
					permission = "1";
				}
				new ChangeNotice();
			}
		});
		button.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JButton button_2 = new JButton("\u5220\u9664");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteNotice(e);
			}
		});
		button_2.setFont(new Font("楷体", Font.PLAIN, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 551, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(64)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(82)
					.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(59))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1)
						.addComponent(button_2))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}



	protected void deleteNotice(ActionEvent e) {
		int rowNum = table.getSelectedRow();
		String content = table.getValueAt(rowNum, 0).toString();
		UserService service = new UserServiceImpl();
		service.deleteNotice(content);
		tableModel.removeRow(rowNum);
		JOptionPane.showMessageDialog(this, "删除成功");
		
	}

	public Object[][] queryAll() {
		
		UserService service = new UserServiceImpl();
		List<Notice> list = service.selectNotice();
		data = new Object[list.size()][head.length];
		for(int i=0;i<list.size();i++)
			for(int j=0;j<head.length;j++) {
					data[i][0]=list.get(i).getNotice_id();
					data[i][1]=list.get(i).getNotice_content();
					if(list.get(i).getNotice_permission().equals("0")) {
						data[i][2]="学生";
					}
					else {
						data[i][2]="教师";
					}
				
			}
		return data;
		}
}
