package com.acyl.classwork.service;

import java.util.List;

import com.acyl.classwork.model.Teacher;

public interface TeacherService {
	
	public void addTeacher(Teacher teacher);

	public void updateTeacher(Teacher teacher);

	public void removeTeacher(int id);

	public Teacher getTeacherById(int id);

	public List<Teacher> getAllTeachers();

}
