package com.xhb.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.xhb.dao.UserService;
import com.xhb.dao.UserServiceImpl;
import com.xhb.entity.Notice;
import com.xhb.utils.IsEmpty;

import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NoticeManage extends JFrame {

	private JPanel contentPane;
	private static String permission;
	private String content;
	private JTextArea noticeCo;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NoticeManage frame = new NoticeManage();
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
	public NoticeManage() {
		setTitle("\u901A\u544A");
		setIconImage(Toolkit.getDefaultToolkit().getImage(NoticeManage.class.getResource("/image/\u5B66\u751F.png")));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u901A\u544A\u5185\u5BB9\uFF1A");
		label.setFont(new Font("楷体", Font.PLAIN, 18));
		
		noticeCo = new JTextArea();
		
		JButton button = new JButton("\u786E\u5B9A\u53D1\u5E03");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(IsEmpty.IsEmpty(noticeCo.getText())) {
					JOptionPane.showMessageDialog(contentPane, "请输入通告内容");
				}
				else {
					addNotice(e);
				}
			}
		});
		button.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JButton button_1 = new JButton("\u4EE5\u5F80\u901A\u544A");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AllNotice();
			}
		});
		button_1.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JButton button_2 = new JButton("\u91CD\u7F6E");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				noticeCo.setText("");
			}
		});
		button_2.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(comboBox.getSelectedItem().toString().equals("学生")) {
					permission = "0";
				}else {
					permission = "1";
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u5B66\u751F", "\u6559\u5E08"}));
		comboBox.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_1 = new JLabel("\u901A\u544A\u5BF9\u8C61");
		label_1.setFont(new Font("楷体", Font.PLAIN, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addComponent(label)
					.addGap(10)
					.addComponent(noticeCo, GroupLayout.PREFERRED_SIZE, 353, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(57, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(64)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1, Alignment.TRAILING)
						.addComponent(button_1, Alignment.TRAILING))
					.addGap(39)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(button, Alignment.LEADING)
						.addComponent(button_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
					.addGap(151))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(37)
							.addComponent(label))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(38)
							.addComponent(noticeCo, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button)
						.addComponent(label_1))
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button_2))
					.addGap(28))
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}
	protected void addNotice(ActionEvent e) {
		content = noticeCo.getText().toString();
		Notice notice = new Notice();
		notice.setNotice_content(content);
		notice.setNotice_permission(permission);
		UserService service = new UserServiceImpl();
		service.insertNotice(notice);
		JOptionPane.showMessageDialog(this, "发布成功");
		noticeCo.setText("");
		
	}
}
