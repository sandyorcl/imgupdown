package com.iud.model;

import java.util.List;

public class ResponseObject<T> {

	public ResponseObject() {
	}
	
	public ResponseObject(boolean success) {
	super();
		this.success = success;
	}

	private boolean success;
	private String msg;
	private List<T> data;
	private String header;
	private String passedOnDateTime;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}

	@Override
	public String toString() {
		return "Response Object [success=" + success + ", msg=" + msg + ", data=" + data + ", header=" + header + "]";
	}
	public String getPassedOnDateTime() {
		return passedOnDateTime;
	}
	public void setPassedOnDateTime(String passedOnDateTime) {
		this.passedOnDateTime = passedOnDateTime;
	}
}
