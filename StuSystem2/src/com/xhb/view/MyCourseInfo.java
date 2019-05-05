
package com.xhb.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.ibatis.jdbc.Null;

import com.xhb.dao.UserService;
import com.xhb.dao.UserServiceImpl;
import com.xhb.entity.Grade;
import com.xhb.utils.IsEmpty;

import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class MyCourseInfo extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Object[][] data;
	private String[] head= {"课程编号","课程","成绩"};
	private DefaultTableModel tableModel;
	private JButton button;
	private JButton button_1;
	static String c_id;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MyCourseInfo frame = new MyCourseInfo();
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
	public MyCourseInfo() {
		setTitle("\u5B66\u751F\u8BFE\u7A0B\u4FE1\u606F");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MyCourseInfo.class.getResource("/image/\u5B66\u751F.png")));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		data = queryData();
		tableModel = new DefaultTableModel(data, head);
		table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		
		button = new JButton("\u5176\u4ED6\u8BFE\u7A0B");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new ChooseCourse();
			}
		});
		button.setFont(new Font("楷体", Font.PLAIN, 18));
		
		button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new StudentsOp();
			}
		});
		button_1.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JButton button_2 = new JButton("\u8BFE\u7A0B\u8BC4\u4EF7");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int rowNum = table.getSelectedRow();
				//String grade = tableModel.getValueAt(rowNum, 2).toString();
				if(rowNum<0) {
					JOptionPane.showMessageDialog(contentPane,"请选择课程");
				}else {
					if(tableModel.getValueAt(rowNum, 2)==null) {
						JOptionPane.showMessageDialog(contentPane, "该课程还未结束");
						
					}else {
						UserService service = new UserServiceImpl();
						c_id = tableModel.getValueAt(rowNum, 0).toString();
						Grade grade = new Grade();
						grade.setCourse_id(c_id);
						grade.setStu_id(LoginFrame.un);
						String evaluate = service.selectEvaluate(grade);
						if(evaluate.equals("是")) {
							JOptionPane.showMessageDialog(contentPane, "这门课程你已经评价过");
							//dispose();
						}else {
							new Evaluate();
						}
					}
				}
			}
		});
		button_2.setFont(new Font("楷体", Font.PLAIN, 18));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(34)
					.addComponent(button)
					.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
					.addComponent(button_2)
					.addGap(41)
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addGap(53))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1)
						.addComponent(button_2))
					.addGap(40))
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}

	public Object[][] queryData(){
		UserService service = new UserServiceImpl();
		Grade grade = new Grade();
		grade.setStu_id(LoginFrame.un);
		List<Grade> list = service.selectGradeById(grade);
		data = new Object[list.size()][head.length]; 
		for(int i=0;i<list.size();i++)
			for(int j=0;j<head.length;j++) {
				data[i][0]=list.get(i).getCourse_id();
				data[i][1]=list.get(i).getCourse_name();
				data[i][2]=list.get(i).getGrade();
				
			}
		return data;
	}
}
