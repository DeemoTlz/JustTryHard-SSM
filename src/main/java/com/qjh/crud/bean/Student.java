package com.qjh.crud.bean;

public class Student {
	private Integer id;

	private String name;

	private Integer age;

	private Boolean sex;

	private Integer classId;

	private Clazz clazz;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	public Student() {
		super();
	}

	public Student(Integer id, String name, Integer age, Boolean sex, Integer classId) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.classId = classId;
	}

}