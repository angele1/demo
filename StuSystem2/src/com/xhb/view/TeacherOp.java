package com.xhb.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeacherOp extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 486, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton button = new JButton("\u4E2A\u4EBA\u4FE1\u606F");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TecherInfo();
				//dispose();
			}
		});
		button.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JButton button_1 = new JButton("\u5B66\u751F\u7BA1\u7406");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StuManage();
				//dispose();
			}
		});
		button_1.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JButton button_2 = new JButton("\u5176\u4ED6\u6559\u5E08");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OtherTeacher();
			}
		});
		button_2.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JButton button_3 = new JButton("\u4FEE\u6539\u5BC6\u7801");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChangeTePass();
			}
		});
		button_3.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JButton button_4 = new JButton("\u8003\u8BD5\u7BA1\u7406");
		button_4.setFont(new Font("楷体", Font.PLAIN, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(49)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(button_4)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(button_3)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(button_2))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(button)
								.addGap(88)
								.addComponent(button_1))))
					.addContainerGap(111, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(button_1)
						.addComponent(button))
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(button_2)
						.addComponent(button_3))
					.addGap(48)
					.addComponent(button_4)
					.addContainerGap(84, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}

}
