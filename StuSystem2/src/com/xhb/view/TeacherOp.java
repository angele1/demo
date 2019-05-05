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
import com.xhb.entity.Notice;

import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class TeacherOp extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel tableModel;
	private Object[][] data;
	private String[] head= {"ͨ��"};

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TeacherOp frame = new TeacherOp();
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
	public TeacherOp() {
		setTitle("\u6559\u5E08\u754C\u9762");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TeacherOp.class.getResource("/image/\u5B66\u751F.png")));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton button = new JButton("\u4E2A\u4EBA\u4FE1\u606F");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TecherInfo();
				dispose();
			}
		});
		button.setFont(new Font("����", Font.PLAIN, 18));
		
		JButton button_1 = new JButton("\u5B66\u751F\u7BA1\u7406");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StuManage();
				//dispose();
			}
		});
		button_1.setFont(new Font("����", Font.PLAIN, 18));
		
		JButton button_2 = new JButton("\u5176\u4ED6\u6559\u5E08");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OtherTeacher();
			}
		});
		button_2.setFont(new Font("����", Font.PLAIN, 18));
		
		JButton button_3 = new JButton("\u4FEE\u6539\u5BC6\u7801");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChangeTePass();
			}
		});
		button_3.setFont(new Font("����", Font.PLAIN, 18));
		
		JButton button_4 = new JButton("\u8003\u8BD5\u7BA1\u7406");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ExamManage();
				dispose();
			}
		});
		button_4.setFont(new Font("����", Font.PLAIN, 18));
		
		data=queryAll();
		tableModel = new DefaultTableModel(data, head);
		table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(98)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(button_4)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(button_3)
								.addComponent(button))
							.addPreferredGap(ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(button_1)
								.addComponent(button_2))
							.addGap(113))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 466, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(150, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_3)
						.addComponent(button_2))
					.addGap(47)
					.addComponent(button_4)
					.addGap(19))
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}
	
	public Object[][] queryAll() {
		int x=0;
		UserService service = new UserServiceImpl();
		List<Notice> list = service.selectNotice("1");
		data = new Object[list.size()][head.length];
		for(int i=0;i<list.size();i++)
			for(int j=0;j<head.length;j++) {
				//if(list.get(i).getNotice_permission().equals("0")) {
					data[x][0]=list.get(i).getNotice_content();
					x++;
				//}
			}
		return data;
		}
}
