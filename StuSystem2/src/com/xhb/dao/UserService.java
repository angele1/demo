package com.xhb.dao;

import java.util.List;

import com.xhb.entity.College;
import com.xhb.entity.Course;
import com.xhb.entity.Grade;
import com.xhb.entity.Notice;
import com.xhb.entity.User;

public interface UserService {
	List<User> selectAllUser();
	User selectById(String id);
	//List<User> selectByName(String name);
	User selectByName(String name);
	//��������
	//void insert(User user);
	//���ݸ�������
	void updateById(User user);
	//��ʾͬ��ͬѧ
	List<User> selectClassmate(User user);
	//ģ����ѯ(id)�û�
	List<User> selectLikeId(User user);
	List<User> stuLikeId(User user);
	List<User> stuLikeName(User user);
	//ģ����ѯ(����)
	List<User> selectLikeName(User user);
	//����ͨ��
	void insertNotice(Notice notice);
	//��ѯͨ��
	List<Notice> selectNotice(String permission);
	List<Notice> selectAllNotice();
	//ɾ��ͨ��
	void deleteNotice(String content);
	//����ͨ��
	void updateNotice(Notice notice);
	//�����û����Ͳ�ѯ
	List<User> selectUserType(String permission);
	
	List<User> selectLikeP1(User user);
	List<User> selectLikeP2(User user);
	//�����û�
	void insertUser(User user);
	//ɾ���û�
	void deleteUser(String id);
	List<Course> selectCourse();
	//ģ����ѯ�γ�
	List<Course> selectCourseI(String id);
	List<Course> selectCourseN(String name);
	
	Course selectCourseById(String id);
	void updateCourse(Course course);
	void insertCourse(Course course);
	void deleteCourse(String id);
	
	List<College> selectAllCollege();
	List<College> selectLikeCo(String id);
	List<College> selectLikeCo2(String name);
	void insertCollege(College college);
	void deleteCollege(College college);
	
	List<Grade> selectAllGrade();
	List<College> selectMajor(String name);
	void insertGrade(Grade grade);
	void deleteGrade(Grade grade);
	Grade selectGrade(Grade grade);
	void updateGrade(Grade grade);
	
	List<Grade> selectGradeI(String id);
	List<Grade> selectGradeN(String name);
	
	List<Course> selectTeCourse(String name);
	List<Grade> selectStuCourse(String course);
	List<Grade> selectGradeById(Grade grade);
	
	List<Course> selectOtherCourse(Grade grade);
	List<Grade> selectNull(Grade grade);
	
	void updateExam(Grade grade);
	
	void updateEvaluate(Grade grade);
	String selectEvaluate(Grade grade);
	
	List<User> selectOtherTe(User user);
}
