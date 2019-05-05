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
	//插入数据
	//void insert(User user);
	//根据更新数据
	void updateById(User user);
	//显示同班同学
	List<User> selectClassmate(User user);
	//模糊查询(id)用户
	List<User> selectLikeId(User user);
	List<User> stuLikeId(User user);
	List<User> stuLikeName(User user);
	//模糊查询(姓名)
	List<User> selectLikeName(User user);
	//插入通告
	void insertNotice(Notice notice);
	//查询通告
	List<Notice> selectNotice(String permission);
	List<Notice> selectAllNotice();
	//删除通告
	void deleteNotice(String content);
	//更新通告
	void updateNotice(Notice notice);
	//根据用户类型查询
	List<User> selectUserType(String permission);
	
	List<User> selectLikeP1(User user);
	List<User> selectLikeP2(User user);
	//插入用户
	void insertUser(User user);
	//删除用户
	void deleteUser(String id);
	List<Course> selectCourse();
	//模糊查询课程
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
