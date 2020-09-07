package com.qjh.crud.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qjh.crud.bean.Student;
import com.qjh.crud.service.StudentService;
import com.qjh.crud.utils.Msg;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService service;
	
	@RequiresPermissions({"student:_page"})
	@RequestMapping(value = "/_page", method = RequestMethod.POST)
	@ResponseBody
	public PageInfo<Student> page(@RequestBody Student student) {
		PageHelper.startPage(student.getPageNum(), student.getPageSize());
		List<Student> list = service.getAll();

		return new PageInfo<Student>(list);
	}

	@RequiresPermissions({"student:_list"})
	@RequestMapping(value = "/_list", method = RequestMethod.POST)
	@ResponseBody
	public Msg list() {
		HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
		System.out.println("The username in session: " + request.getSession().getAttribute("username"));

		return Msg.success(service.getAll());
	}
	
	@RequiresRoles({"admin"})
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Msg update(@PathVariable("id") int id, @RequestBody Student student) {
		student.setId(id);
		service.update(student);
		
		return Msg.success();
	}
	
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@ResponseBody
	public Msg delete(@PathVariable("ids") List<Integer> ids) {
		service.delete(ids);
		
		return Msg.success();
	}
}
