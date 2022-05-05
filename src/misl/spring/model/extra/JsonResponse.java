package misl.spring.model.extra;


import java.util.HashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonResponse extends HashMap<String, Object> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void setResult(Object value) {
		this.put("result", value);
	}
	
	public void setStatus(String value) {
		this.put("status", value);
	}
	
	public void setMessage(String value) {
		this.put("message", value);
	}
	
	public void set(String key, Object value) {
		this.put(key, value);
	}
	
	public String getJson() {
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;	
	}

}
