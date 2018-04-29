package com.qjh.crud.utils;

public class Msg {

	private int code_;
	private String msg_;
	private Object data;
	private String detail_;

	public int getCode_() {
		return code_;
	}

	public void setCode_(int code_) {
		this.code_ = code_;
	}

	public String getMsg_() {
		return msg_;
	}

	public void setMsg_(String msg_) {
		this.msg_ = msg_;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getDetail_() {
		return detail_;
	}

	public void setDetail_(String detail_) {
		this.detail_ = detail_;
	}

	public Msg() {
	}

	public Msg(int code_, String msg_) {
		this.code_ = code_;
		this.msg_ = msg_;
	}

	public Msg(int code_, String msg_, Object data) {
		this(code_, msg_);
		this.data = data;
	}

	public Msg(int code_, String msg_, Object data, String detail_) {
		this(code_, msg_, data);
		this.detail_ = detail_;
	}
	
	public static Msg success() {
		return new Msg(200, "success");
	}
	
	public static Msg success(Object data) {
		return new Msg(200, "success", data);
	}

}
