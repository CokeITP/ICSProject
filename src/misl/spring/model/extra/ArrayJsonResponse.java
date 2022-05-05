package misl.spring.model.extra;

import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ArrayJsonResponse extends ArrayList<HashMap<String, Object>> {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	public ArrayJsonResponse(ArrayList<HashMap<String, Object>> listMap) {
		this.addAll(listMap);
	}
	
	public ArrayJsonResponse() {
		
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
