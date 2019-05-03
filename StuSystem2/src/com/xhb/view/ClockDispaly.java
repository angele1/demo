package com.xhb.view;

import java.text.NumberFormat;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

 class ClockDispaly extends Thread{//����Thread���Ե���ʱģ��
	
	private JLabel lefttimer;
	private int testtime;
	
	public ClockDispaly(JLabel lt,int time) {
		lefttimer = lt;
		testtime = time * 60;
	}
	public void run(){
		NumberFormat numberFormat = NumberFormat.getInstance();//����ʱ�����ʾ��ʽ
		numberFormat.setMinimumIntegerDigits(2);//������ֵ�����������������Сλ��
		int h,m,s;//����ʱ����
		while (testtime >= 0) {
			h = testtime / 3600;
			m = testtime % 3600 / 60;
			s = testtime % 60;
			StringBuffer stringBuffer = new StringBuffer("");
			//���ӵ�lefttimer��ǩ
			stringBuffer.append("����ʣ��ʱ��Ϊ��"+numberFormat.format(h)+":"+numberFormat.format(m)+":"+numberFormat.format(s));
			lefttimer.setText(stringBuffer.toString());
			try {
				Thread.sleep(1000);//��ʱһ��
			} catch (Exception e) {
				//ignore error
			}
			testtime = testtime - 1; 
		}
		if (testtime <= 0) {
			JOptionPane.showMessageDialog(null, "���Խ���");
			System.exit(0);
		}
	}
 }
