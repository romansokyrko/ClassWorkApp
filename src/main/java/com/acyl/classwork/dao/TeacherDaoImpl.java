package com.acyl.classwork.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.acyl.classwork.model.Teacher;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class TeacherDaoImpl implements TeacherDao {
	private static final Logger logger = LoggerFactory.getLogger(TeacherDaoImpl.class);
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addTeacher(Teacher teacher) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(teacher);
		logger.info("Teacher succesfully saved. Teacher details: " + teacher);
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		Session session = sessionFactory.getCurrentSession();
		session.update(teacher);
		logger.info("Teacher succesfully updated. Teacher details: " + teacher);
	}

	@Override
	public void removeTeacher(int id) {
		Session session = sessionFactory.getCurrentSession();
		Teacher teacher = (Teacher) session.load(Teacher.class, new Integer(id));
		if (teacher!=null) {
			session.delete(teacher);
		}
		logger.info("Teacher succesfully removed. Tacher details: " + teacher);
	}

	@Override
	public Teacher getTeacherById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Teacher teacher = (Teacher) session.load(Teacher.class, new Integer(id));
		logger.info("Teacher succesfully loaded. Tacher details: " + teacher);
		return teacher;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> getAllTeachers() {
		Session session = sessionFactory.getCurrentSession();
		List<Teacher> teacherList = session.createQuery("from Teacher").list();
		for(Teacher teacher: teacherList) {
			logger.info("Teacher list" + teacher);
		}
		return teacherList;
	}

}
