package com.acyl.classwork.service;

import java.util.List;

import com.acyl.classwork.dao.TeacherDao;
import com.acyl.classwork.model.Teacher;
import org.springframework.transaction.annotation.Transactional;

public class TeacherServiceImpl implements TeacherService {
	
	TeacherDao teacherDao;

	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	@Override
	@Transactional
	public void addTeacher(Teacher teacher) {
		teacherDao.addTeacher(teacher);

	}

	@Override
	@Transactional
	public void updateTeacher(Teacher teacher) {
		teacherDao.updateTeacher(teacher);

	}

	@Override
	@Transactional
	public void removeTeacher(int id) {
		teacherDao.removeTeacher(id);

	}

	@Override
	@Transactional
	public Teacher getTeacherById(int id) {
		return teacherDao.getTeacherById(id);
	}

	@Override
	@Transactional
	public List<Teacher> getAllTeachers() {
		return teacherDao.getAllTeachers();
	}

}
