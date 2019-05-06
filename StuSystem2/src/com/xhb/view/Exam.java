package com.xhb.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.xhb.dao.UserService;
import com.xhb.dao.UserServiceImpl;
import com.xhb.entity.Grade;
import com.xhb.entity.TestQuestion;

import junit.framework.Test;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.NumberFormat;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Exam extends JFrame implements ActionListener{

	private JPanel contentPane;
	int examtime;
	int p=0;//设置题目数指针           
	int topicNum=0;
	int right,error;                                                     //答对和答错
	ClockDispaly mt;
	private ButtonGroup buttonGroup;
	private int score;

	TestQuestion t1;
	TestQuestion[] questions;
	JRadioButton rdbtnA;
	JRadioButton rdbtnB;
	JRadioButton rdbtnC;
	JRadioButton rdbtnD	;
	JTextArea textArea;
	JLabel label;
	JButton commit;
	JButton back;
	JButton next;
	JButton start;
	private JLabel clock;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Exam frame = new Exam();
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
	public Exam() {
		setTitle(OnlineEx.courseName+"在线考试");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Exam.class.getResource("/image/\u5B66\u751F.png")));
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		rdbtnA = new JRadioButton("A");
		
		rdbtnB = new JRadioButton("B");
		
		rdbtnC = new JRadioButton("C");
		
		rdbtnD = new JRadioButton("D");
		
		buttonGroup = new ButtonGroup();
		
		back = new JButton("\u4E0A\u4E00\u9898");
		back.setFont(new Font("楷体", Font.PLAIN, 18));
		
		next = new JButton("\u4E0B\u4E00\u9898");
		next.setFont(new Font("楷体", Font.PLAIN, 18));
		
		commit = new JButton("\u63D0\u4EA4\u8BD5\u5377");
		commit.setFont(new Font("楷体", Font.PLAIN, 18));
		
		label = new JLabel("\u603B\u8003\u8BD5\u65F6\u95F4\uFF1A100\u5206\u949F");
		label.setFont(new Font("楷体", Font.PLAIN, 15));
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		
		start = new JButton("\u5F00\u59CB\u8003\u8BD5");
		start.setFont(new Font("楷体", Font.PLAIN, 15));
		start.addActionListener(this);
		back.addActionListener(this);
		next.addActionListener(this);
		commit.addActionListener(this);
		rdbtnA.addActionListener(this);
		rdbtnB.addActionListener(this);
		rdbtnC.addActionListener(this);
		rdbtnD.addActionListener(this);
		
		clock = new JLabel();
		//clock.setText("1");
		mt = new ClockDispaly(clock, 100); 
		//mt.start();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 464, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(16)
						.addComponent(label)
						.addGap(75)
						.addComponent(clock)
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(start))
					.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
						.addGap(15)
						.addComponent(rdbtnA)
						.addGap(17)
						.addComponent(rdbtnB)
						.addGap(12)
						.addComponent(rdbtnC)
						.addGap(11)
						.addComponent(rdbtnD)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(back)
						.addGap(14)
						.addComponent(next)
						.addGap(10)
						.addComponent(commit)))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(13)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(label)
								.addComponent(clock)))
						.addComponent(start))
					.addGap(14)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(rdbtnA)
							.addGap(24))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(rdbtnB)
							.addGap(25))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(rdbtnC)
							.addGap(25))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(rdbtnD)
							.addGap(25))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(back)
							.addGap(25))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(next)
							.addGap(26))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(commit)
							.addGap(27))))
		);
		
		buttonGroup.add(rdbtnA);
		buttonGroup.add(rdbtnB);
		buttonGroup.add(rdbtnC);
		buttonGroup.add(rdbtnD);
		contentPane.setLayout(gl_contentPane);
		
		setVisible(true);
		
	}
	
	public void createQuestion() {
		Vector<TestQuestion> qList = null;
		String questionText="";
		String standardKey;
		String s;
		TestQuestion t;
		try {
			FileReader fr = new FileReader("D:\\在线考试\\"+OnlineEx.courseName+".txt");
			BufferedReader br = new BufferedReader(fr);
			qList = new Vector<TestQuestion>();
			while((s=br.readLine())!=null) {
				if(s.equals("*****")) {
					questionText = "";
					s=br.readLine();
				}
				else if(s.equals("$$$$$")) {
					s  = br.readLine();
					standardKey = s;
					t = new TestQuestion(questionText,standardKey);
					qList.add(t);
				}
				questionText = questionText+s+'\n';
			}
			br.close();
			fr.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		topicNum = qList.size();
		questions = new TestQuestion[topicNum];
		for(int i=0;i<qList.size();i++) {
			questions[i] = qList.get(i);
		}
	}
	
	public void setSelected(String s) {//设置单选按钮不重复模块
		if (s.equals("A")) buttonGroup.setSelected(rdbtnA.getModel(), true);
		if (s.equals("B")) buttonGroup.setSelected(rdbtnB.getModel(), true);
		if (s.equals("C")) buttonGroup.setSelected(rdbtnC.getModel(), true);
		if (s.equals("D")) buttonGroup.setSelected(rdbtnD.getModel(), true);
		if (s.equals("")) buttonGroup.clearSelection();
	}
	
	public void showQuestion() {
		textArea.setText("");
		textArea.append(questions[p].getQuestionText());
		setSelected(questions[p].getSelectKey());
	}
	
	public void showScore() {
		right=0;
		error=0;
		for(int i=0;i<topicNum;i++) {
			if(questions[i].check()) {
				right++;
			}else {
				error++;
			}
			
		}
		score = (int)(right*100/topicNum);
		//JOptionPane.showMessageDialog(null, "答对"+right+"题，答错"+error+"题，分数为"+score);
		JOptionPane.showMessageDialog(this, "提交成功");
	}

	@Override
	public void actionPerformed(ActionEvent e) {//动作监听事件
		
		if (e.getSource()==start) {//开始开始按键实现
			createQuestion();          //调用createExam模块
			mt.start();
			p=0;                   //题目序号
			showQuestion();        //调用showQuestion模块
			start.setEnabled(false);//设置按钮不可点击
			             //考试时间倒计时启动
		}
		if (e.getSource()==back) {//上一题的按键实现
			p--;
			if (p==-1) {
				JOptionPane.showMessageDialog(null, "已经是第一题");
				p++;
			}
			showQuestion();
		}
		if (e.getSource()==next) {//下一题的按键实现
			p++;
			if (p==topicNum) {
				JOptionPane.showMessageDialog(null, "已经是最后一题");
				p--;
			}
			showQuestion();
		}
		if (e.getSource()==commit) {//提交试卷的按键实现
			showScore();
		
			AddGrade();
			commit.setEnabled(false);
			//System.exit(0);          //退出
			dispose();
			
		}
		
		if(e.getSource()==rdbtnA) questions[p].setSelectKey("A");
		if(e.getSource()==rdbtnB) questions[p].setSelectKey("B");
		if(e.getSource()==rdbtnC) questions[p].setSelectKey("C");
		if(e.getSource()==rdbtnD) questions[p].setSelectKey("D");
		
	}
	
	private void AddGrade() {
		UserService service = new UserServiceImpl();
		Grade grade = new Grade();
		grade.setStu_id(LoginFrame.un);
	//	grade.setStu_name(LoginFrame.userN);
		grade.setCourse_name(OnlineEx.courseName);
	//	grade.setCourse_id(OnlineEx.courseId);
		String scorev = String.valueOf(score);
		System.out.println(score);
		grade.setGrade(scorev);
		service.updateGrade(grade);
		
	}

//	public static void main(String[] args) {
//		new Exam();
//	}

	
}





