package com.qjh.crud.service.impl;

import com.qjh.crud.bean.Student;
import com.qjh.crud.bean.StudentExample;
import com.qjh.crud.bean.StudentExample.Criteria;
import com.qjh.crud.dao.StudentMapper;
import com.qjh.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentMapper mapper;

	public List<Student> getAll() {
		return mapper.selectByExampleWithClazz(null);
	}

	public Student getById(int id) {
		return mapper.selectByPrimaryKeyWithClazz(id);
	}

	public int update(Student student) {
		return mapper.updateByPrimaryKeySelective(student);
	}

	public void delete(List<Integer> ids) {
		StudentExample example = new StudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdIn(ids);

		mapper.deleteByExample(example);
	}

}
