package com.qjh.crud.bean;

public class Clazz {
	private Integer id;

	private String name;

	private String code;

	private String desc;

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc == null ? null : desc.trim();
	}

	public Clazz() {
		super();
	}

	public Clazz(Integer id, String name, String code, String desc) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.desc = desc;
	}

}