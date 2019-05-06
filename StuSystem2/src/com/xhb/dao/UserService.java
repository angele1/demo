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
	//模糊查询
	List<User> selectLikeP1(User user);
	//模糊查询
	List<User> selectLikeP2(User user);
	//插入用户
	void insertUser(User user);
	//删除用户
	void deleteUser(String id);
	//查询所有课程
	List<Course> selectCourse();
	//模糊查询(课程id)
	List<Course> selectCourseI(String id);
	//模糊查询(课程名)
	List<Course> selectCourseN(String name);
	//根据课程id查找课程
	Course selectCourseById(String id);
	//更新课程信息
	void updateCourse(Course course);
	//添加新课程
	void insertCourse(Course course);
	//根据id删除课程
	void deleteCourse(String id);
	//查询所有学院信息
	List<College> selectAllCollege();
	//模糊查询
	List<College> selectLikeCo(String id);
	//模糊查询
	List<College> selectLikeCo2(String name);
	//添加学院信息
	void insertCollege(College college);
	//删除学院
	void deleteCollege(College college);
	//查询所有学生成绩
	List<Grade> selectAllGrade();
	//查询学院所有专业
	List<College> selectMajor(String name);
	//插入学生成绩
	void insertGrade(Grade grade);
	//删除学生成绩1
	void deleteGrade(Grade grade);
	//查找学生成绩
	Grade selectGrade(Grade grade);
	//更新学生成绩
	void updateGrade(Grade grade);
	//模糊查询(学生id)
	List<Grade> selectGradeI(String id);
	//模糊查询(学生姓名)
	List<Grade> selectGradeN(String name);
	//查找教师课程
	List<Course> selectTeCourse(String name);
	//查找课程
	List<Grade> selectStuCourse(String course);
	//根据学生id查找成绩
	List<Grade> selectGradeById(Grade grade);
	//查找未选课程
	List<Course> selectOtherCourse(Grade grade);
	//查找还未考试的学生
	List<Grade> selectNull(Grade grade);
	//更新考试
	void updateExam(Grade grade);
	//更新评价状态
	void updateEvaluate(Grade grade);
	//查找评价状态
	String selectEvaluate(Grade grade);
	//查找其他教师
	List<User> selectOtherTe(User user);
	//更新试题编写状态
	void updateCourseExam(Course course);
	//查询课程考题编写状态
	String selectCoExam(String co_name);
	//查找教师
	User selectTeacher(User user);
}
