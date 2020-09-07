package com.qjh.crud.controller;

import com.qjh.crud.bean.Student;
import com.qjh.crud.service.StudentService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qjh.crud.utils.Msg;

import java.util.List;

@Controller
@RequestMapping("/shiro")
public class LoginController {

	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Msg login(@RequestParam("userName") String userName, @RequestParam("password") String password) {

		Subject subject = SecurityUtils.getSubject();
		
		if (!subject.isAuthenticated()) {
			UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
			token.setRememberMe(true);
			
			try {
				subject.login(token);
			} catch (AuthenticationException e) {
				return Msg.fail(e.getMessage());
			}
		}

		List<Student> students = studentService.getAll();
		System.out.println(students);

		return Msg.success();
	}

}
