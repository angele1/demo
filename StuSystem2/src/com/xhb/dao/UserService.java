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
	//ģ����ѯ
	List<User> selectLikeP1(User user);
	//ģ����ѯ
	List<User> selectLikeP2(User user);
	//�����û�
	void insertUser(User user);
	//ɾ���û�
	void deleteUser(String id);
	//��ѯ���пγ�
	List<Course> selectCourse();
	//ģ����ѯ(�γ�id)
	List<Course> selectCourseI(String id);
	//ģ����ѯ(�γ���)
	List<Course> selectCourseN(String name);
	//���ݿγ�id���ҿγ�
	Course selectCourseById(String id);
	//���¿γ���Ϣ
	void updateCourse(Course course);
	//����¿γ�
	void insertCourse(Course course);
	//����idɾ���γ�
	void deleteCourse(String id);
	//��ѯ����ѧԺ��Ϣ
	List<College> selectAllCollege();
	//ģ����ѯ
	List<College> selectLikeCo(String id);
	//ģ����ѯ
	List<College> selectLikeCo2(String name);
	//���ѧԺ��Ϣ
	void insertCollege(College college);
	//ɾ��ѧԺ
	void deleteCollege(College college);
	//��ѯ����ѧ���ɼ�
	List<Grade> selectAllGrade();
	//��ѯѧԺ����רҵ
	List<College> selectMajor(String name);
	//����ѧ���ɼ�
	void insertGrade(Grade grade);
	//ɾ��ѧ���ɼ�1
	void deleteGrade(Grade grade);
	//����ѧ���ɼ�
	Grade selectGrade(Grade grade);
	//����ѧ���ɼ�
	void updateGrade(Grade grade);
	//ģ����ѯ(ѧ��id)
	List<Grade> selectGradeI(String id);
	//ģ����ѯ(ѧ������)
	List<Grade> selectGradeN(String name);
	//���ҽ�ʦ�γ�
	List<Course> selectTeCourse(String name);
	//���ҿγ�
	List<Grade> selectStuCourse(String course);
	//����ѧ��id���ҳɼ�
	List<Grade> selectGradeById(Grade grade);
	//����δѡ�γ�
	List<Course> selectOtherCourse(Grade grade);
	//���һ�δ���Ե�ѧ��
	List<Grade> selectNull(Grade grade);
	//���¿���
	void updateExam(Grade grade);
	//��������״̬
	void updateEvaluate(Grade grade);
	//��������״̬
	String selectEvaluate(Grade grade);
	//����������ʦ
	List<User> selectOtherTe(User user);
	//���������д״̬
	void updateCourseExam(Course course);
	//��ѯ�γ̿����д״̬
	String selectCoExam(String co_name);
	//���ҽ�ʦ
	User selectTeacher(User user);
}
