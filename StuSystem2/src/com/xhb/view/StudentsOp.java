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
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTable;

public class StudentsOp extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Object[][] data;
	private String[] head= {"通告内容"}; 
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					StudentsOp frame = new StudentsOp();
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
	public StudentsOp() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(StudentsOp.class.getResource("/image/\u5B66\u751F.png")));
		setTitle("\u5B66\u751F\u754C\u9762");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblXxx = new JLabel(LoginFrame.userN);
		lblXxx.setFont(new Font("楷体", Font.PLAIN, 20));
		
		JLabel label = new JLabel("\u540C\u5B66");
		label.setFont(new Font("楷体", Font.PLAIN, 20));
		
		JButton stuInfoBtn = new JButton("\u4E2A\u4EBA\u4FE1\u606F");
		stuInfoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new StuInfo();
			}
		});
		stuInfoBtn.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JButton changePsBtn = new JButton("\u4FEE\u6539\u5BC6\u7801");
		changePsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChangePass();
			}
		});
		changePsBtn.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JButton courseInfoBtn = new JButton("\u8BFE\u7A0B\u4FE1\u606F");
		courseInfoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MyCourseInfo();
				dispose();
			}
		});
		courseInfoBtn.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JButton classInfoBtn = new JButton("\u73ED\u7EA7\u4FE1\u606F");
		classInfoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ClassmateInfo();
			}
		});
		classInfoBtn.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JButton examBtn = new JButton("\u5728\u7EBF\u8003\u8BD5");
		examBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new OnlineEx();
			}
		});
		examBtn.setFont(new Font("楷体", Font.PLAIN, 18));
		
		
		data = queryAll();
		DefaultTableModel tableModel = new DefaultTableModel(data, head);
		table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		
		JLabel label_1 = new JLabel("\u901A\u544A");
		label_1.setFont(new Font("楷体", Font.PLAIN, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(32)
					.addComponent(lblXxx)
					.addGap(15)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(courseInfoBtn)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(stuInfoBtn)
							.addPreferredGap(ComponentPlacement.RELATED, 221, Short.MAX_VALUE)
							.addComponent(classInfoBtn))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label)
							.addGap(59)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label_1)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE)))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(changePsBtn)
							.addPreferredGap(ComponentPlacement.RELATED, 221, Short.MAX_VALUE)
							.addComponent(examBtn)))
					.addGap(93))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(14)
					.addComponent(label_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblXxx)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(label)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(stuInfoBtn)
						.addComponent(classInfoBtn))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(46)
							.addComponent(examBtn))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(32)
							.addComponent(changePsBtn)))
					.addGap(18)
					.addComponent(courseInfoBtn)
					.addGap(22))
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}
	
	public Object[][] queryAll() {
		int x=0;
		UserService service = new UserServiceImpl();
		List<Notice> list = service.selectNotice();
		data = new Object[list.size()][head.length];
		for(int i=0;i<list.size();i++)
			for(int j=0;j<head.length;j++) {
				if(list.get(i).getNotice_permission().equals("0")) {
					data[x][0]=list.get(i).getNotice_content();
					x++;
				}
			}
		return data;
		}
	}

