package kr.or.hello.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kr.or.hello.service.HelloService;

public class HelloServiceImpl implements HelloService {

	@Override
	public List<HashMap<String, Object>> getHelloList(String searchText) throws Exception {
		
		List<HashMap<String, Object>> result = new ArrayList<>();
		HashMap<String, Object> item = new HashMap<>();
		
		item.put("id", "master");
		item.put("name", "고라니");
		item.put("age", 25);
		result.add(item);

		item = new HashMap<>();
		item.put("id", "admin");
		item.put("name", "오린이");
		item.put("age", 18);
		result.add(item);
		
		item = new HashMap<>();
		item.put("id", "admin");
		item.put("name", "우주하마");
		item.put("age", 91);
		result.add(item);

		return result;
	}

}
