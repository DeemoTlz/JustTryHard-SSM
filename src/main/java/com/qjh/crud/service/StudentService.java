package com.qjh.crud.service;

import com.qjh.crud.bean.Student;

import java.util.List;

public interface StudentService {

	public List<Student> getAll();
	
	public Student getById(int id);

	public int update(Student student);

	public void delete(List<Integer> ids);
}
