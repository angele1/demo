package com.xhb.dao;

import java.util.List;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import org.apache.ibatis.session.SqlSession;

import com.mysql.jdbc.Statement;
import com.xhb.entity.College;
import com.xhb.entity.Course;
import com.xhb.entity.Grade;
import com.xhb.entity.Notice;
import com.xhb.entity.User;
import com.xhb.utils.DbUtil;

public class UserServiceImpl implements UserService {
	private SqlSession sqlSession = DbUtil.getSqlSession();
	
	//String statement = "selectAll";
	//查找所有用户
	@Override
	public List<User> selectAllUser() {
		
		List<User> list = sqlSession.selectList("selectAll");
		//sqlSession.close();
		return list;
		
	}
	//根据id查找
	@Override
	public User selectById(String id) {
		//sqlSession = DbUtil.getSqlSession();
		User user = sqlSession.selectOne("selectById",id);
		sqlSession.close();
		return user;
	}
	//根据姓名查找
	@Override
	public User selectByName(String name) {
		//sqlSession = DbUtil.getSqlSession();
		//List<User> list= sqlSession.selectList("selectByName");
		User list = sqlSession.selectOne("selectByName", name);
		sqlSession.close();
		return list;
	}
	//插入
//	@Override
//	public void insert(User user) {
//		sqlSession.insert("insert",user);
//		sqlSession.commit();
//		sqlSession.close();
//		
//	}
	@Override
	public void updateById(User user) {
		sqlSession.update("updateById", user);
		sqlSession.commit();
		sqlSession.close();
		
	}
	//查找班级同学
	@Override
	public List<User> selectClassmate(User user) {
		List<User> list = sqlSession.selectList("selectClassmate",user);
		sqlSession.close();
		return list;
	}
	@Override
	public List<User> selectLikeId(User user) {
		List<User> list = sqlSession.selectList("selectLikeId", user);
		sqlSession.close();
		return list;
	}
	@Override
	public List<User> selectLikeName(User user) {
		List<User> list = sqlSession.selectList("selectLikeName", user);
		sqlSession.close();
		return list;
	}
	@Override
	public void insertNotice(Notice notice) {
		sqlSession.insert("insertNotice", notice);
		sqlSession.commit();
		sqlSession.close();
		
	}
	@Override
	public List<Notice> selectNotice(String permission) {
		List<Notice> list = sqlSession.selectList("selectNotice",permission);
		return list;
	}
	@Override
	public void deleteNotice(String content) {
		sqlSession.delete("deleteNotice", content);
		sqlSession.commit();
		sqlSession.close();
		
	}
	@Override
	public void updateNotice(Notice notice) {
		sqlSession.update("updateNotice", notice);
		sqlSession.commit();
		sqlSession.close();
		
	}
	@Override
	public List<User> selectUserType(String permission) {
		List<User> list = sqlSession.selectList("selectUserType",permission);
		return list;
	}
	@Override
	public List<User> selectLikeP1(User user) {
		List<User> list = sqlSession.selectList("selectLikeP1",user);
		return list;
	}
	@Override
	public List<User> selectLikeP2(User user) {
		List<User> list = sqlSession.selectList("selectLikeP2",user);
		return list;
	}
	@Override
	public void insertUser(User user) {
		sqlSession.insert("insertUser", user);
		sqlSession.commit();
		sqlSession.close();
		
	}
	@Override
	public void deleteUser(String id) {
		sqlSession.delete("deleteUser", id);
		sqlSession.commit();
		sqlSession.close();
		
	}
	@Override
	public List<Course> selectCourse() {
		List<Course> list = sqlSession.selectList("selectCourse");
		sqlSession.close();
		return list;
	}
	@Override
	public List<Course> selectCourseI(String id) {
		List<Course> list = sqlSession.selectList("selectCourseI", id);
		sqlSession.close();
		return list;
	}
	@Override
	public List<Course> selectCourseN(String name) {
		List<Course> list = sqlSession.selectList("selectCourseN", name);
		sqlSession.close();
		return list;
	}
	@Override
	public Course selectCourseById(String id) {
		Course course = sqlSession.selectOne("selectCourseById", id);
		sqlSession.close();
		return course;
	}
	@Override
	public void updateCourse(Course course) {
		sqlSession.update("updateCourse", course);
		sqlSession.commit();
		sqlSession.close();
		
	}
	@Override
	public void insertCourse(Course course) {
		sqlSession.insert("insertCourse", course);
		sqlSession.commit();
		sqlSession.close();
		
	}
	@Override
	public void deleteCourse(String id) {
		sqlSession.delete("deleteCourse", id);
		sqlSession.commit();
		sqlSession.close();
		
	}
	@Override
	public List<College> selectAllCollege() {
		List<College> list = sqlSession.selectList("selectAllCollege");
		sqlSession.close();
		return list;
	}
	@Override
	public List<College> selectLikeCo(String id) {
		List<College> list = sqlSession.selectList("selectCollegeI", id);
		sqlSession.close();
		return list;
	}
	@Override
	public List<College> selectLikeCo2(String name) {
		List<College> list = sqlSession.selectList("selectCollegeN", name);
		sqlSession.close();
		return list;
	}
	@Override
	public void insertCollege(College college) {
		sqlSession.insert("insertCollege", college);
		sqlSession.commit();
		sqlSession.close();
		
	}
	@Override
	public void deleteCollege(College college) {
		sqlSession.delete("deleteCollege", college);
		sqlSession.commit();
		sqlSession.close();
		
	}
	@Override
	public List<Grade> selectAllGrade() {
		List<Grade> list = sqlSession.selectList("selectAllGrade");
		sqlSession.close();
		return list;
	}
	@Override
	public List<College> selectMajor(String name) {
		List<College> list = sqlSession.selectList("selectMajor", name);
		sqlSession.close();
		return list;
	}
	@Override
	public void insertGrade(Grade grade) {
		sqlSession.insert("insertGrade", grade);
		sqlSession.commit();
		sqlSession.close();
		
	}
	@Override
	public void deleteGrade(Grade grade) {
		sqlSession.delete("deleteGrade", grade);
		sqlSession.commit();
		sqlSession.close();
		
	}
	@Override
	public Grade selectGrade(Grade grade) {
		Grade grade2 = sqlSession.selectOne("selectGrade", grade);
		sqlSession.close();
		return grade2;
	}
	@Override
	public void updateGrade(Grade grade) {
		sqlSession.update("updateGrade",grade);
		sqlSession.commit();
		sqlSession.close();
		
	}
	@Override
	public List<Grade> selectGradeI(String id) {
		List<Grade> list = sqlSession.selectList("selectGradeI", id);
		sqlSession.close();
		return list;
	}
	@Override
	public List<Grade> selectGradeN(String name) {
		List<Grade> list = sqlSession.selectList("selectGradeN", name);
		sqlSession.close();
		return list;
	}
	@Override
	public List<Course> selectTeCourse(String name) {
		List<Course> list = sqlSession.selectList("selectTeCourse", name);
		sqlSession.close();
		return list;
	}
	@Override
	public List<Grade> selectStuCourse(String course) {
		List<Grade> list = sqlSession.selectList("selectStuCourse", course);
		sqlSession.close();
		return list;
	}
	@Override
	public List<Grade> selectGradeById(Grade grade) {
		List<Grade> list = sqlSession.selectList("selectGradeById", grade);
		sqlSession.close();
		return list;
	}
	@Override
	public List<Course> selectOtherCourse(Grade grade) {
		List<Course> list = sqlSession.selectList("selectOtherCourse", grade);
		sqlSession.close();
		return list;
	}
	@Override
	public List<Grade> selectNull(Grade grade) {
		List<Grade> list = sqlSession.selectList("selectNull", grade);
		sqlSession.close();
		return list;
	}
	@Override
	public void updateExam(Grade grade) {
		sqlSession.update("updateExam", grade);
		sqlSession.commit();
		sqlSession.close();
		
	}
	@Override
	public List<User> stuLikeId(User user) {
		List<User> list = sqlSession.selectList("stuLikeId", user);
		sqlSession.close();
		return list;
	}
	@Override
	public List<User> stuLikeName(User user) {
		List<User> list = sqlSession.selectList("stuLikeName", user);
		sqlSession.close();
		return list;
	}
	@Override
	public void updateEvaluate(Grade grade) {
		sqlSession.update("updateEvaluate", grade);
		sqlSession.commit();
		sqlSession.close();
	
		
	}
	@Override
	public String selectEvaluate(Grade grade) {
		String evaluate = sqlSession.selectOne("selectEvaluate", grade);
		sqlSession.close();
		return evaluate;
	}
	@Override
	public List<Notice> selectAllNotice() {
		List<Notice> list = sqlSession.selectList("selectAllNotice");
		sqlSession.close();
		return list;
	}
	@Override
	public List<User> selectOtherTe(User user) {
		List<User> list = sqlSession.selectList("selectOtherTe", user);
		sqlSession.close();
		return list;
	}
	
	

}
