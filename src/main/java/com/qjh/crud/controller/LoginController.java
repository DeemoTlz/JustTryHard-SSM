package com.qjh.crud.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qjh.crud.utils.Msg;

@Controller
@RequestMapping("/shiro")
public class LoginController {

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
		
		return Msg.success();
	}

}
