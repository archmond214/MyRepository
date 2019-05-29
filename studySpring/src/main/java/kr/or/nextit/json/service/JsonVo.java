package kr.or.nextit.json.service;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class JsonVo {

	private String  name    ;
	private String  id      ;
	
	private List<HashMap<String , Object>> item;
	
	private boolean status  ;
	private String  message ;
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ToStringBuilder.reflectionToString(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<HashMap<String, Object>> getItem() {
		return item;
	}

	public void setItem(List<HashMap<String, Object>> item) {
		this.item = item;
	}

	
	
	
	
}
