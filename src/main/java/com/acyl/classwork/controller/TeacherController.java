package com.acyl.classwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.acyl.classwork.service.TeacherService;

@Controller
public class TeacherController {
	
	private TeacherService teacherService;

	@Autowired(required = true)
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	
	@RequestMapping(value = "teachers", method = RequestMethod.GET)
	public String teachers(Model model) {
		model.addAttribute("teacherList", teacherService.getAllTeachers());
		
		return "teachers";
	}

}
