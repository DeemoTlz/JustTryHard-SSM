package com.qjh.crud.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qjh.crud.bean.Student;
import com.qjh.crud.service.StudentService;
import com.qjh.crud.utils.Msg;

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
