package com.qjh.crud.service;

import java.util.List;

import com.qjh.crud.bean.Student;

public interface StudentService {

	public List<Student> getAll();
	
	public Student getById(int id);

	public int update(Student student);

	public void delete(List<Integer> ids);
}
