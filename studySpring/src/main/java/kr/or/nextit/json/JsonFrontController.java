package kr.or.nextit.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.or.nextit.json.service.JsonVo;

@Controller
public class JsonFrontController {

	private final Logger log =  LoggerFactory.getLogger(this.getClass());
	@RequestMapping(value="/json/testFront.do")
	public String jsonTestFront(
			
			
			) throws Exception{
		
		
		
		return "json/testFront";
	}
	
	@RequestMapping(value="/json/testData.json")
	@ResponseBody //이건 바이너리 데이타야 json타입 데이터라구
	public HashMap<String, Object> jsonTestData() throws Exception{
		HashMap<String, Object> result = new HashMap<>();
			
		result.put("name", "말짜짜짜");
		result.put("age", 25);		
		result.put("title", "말짜 의 HOME");		
		
		List<HashMap<String, Object>> itemList = new ArrayList<>();
		
		HashMap<String, Object> mapItem = new HashMap<>();
		mapItem.put("tel1", "010-0100-0200");
		mapItem.put("email", "test1@nextit.or.kr");
		itemList.add(mapItem);
		
		result.put("info",itemList);
		
		return result;
		
	}
	@RequestMapping(value="/json/testList.json")
	@ResponseBody
	public List<HashMap<String, Object>> jsonTestList() throws Exception{
		List<HashMap<String, Object>> result = new ArrayList<>();
		
		HashMap<String, Object> item = new HashMap<>();
		
		item.put("name", "숙짜야");
		item.put("age", 25);
		item.put("title", "숙짜의 홈");
		
		result.add(item);
		
		return result;
	}
	
	@RequestMapping(value="/json/testJsonVo.json")
	@ResponseBody
	public JsonVo testJsonVo(
			) throws Exception{
			JsonVo jsonVo = new JsonVo();
		
			jsonVo.setId("master");
			jsonVo.setName("홍숙짜");
			jsonVo.setStatus(true);
			jsonVo.setMessage("정상 처리 되어버려씀!");
			
			List<HashMap<String, Object>> itemList = new ArrayList<>();
			
			HashMap<String, Object> mapItem = new HashMap<>();
			mapItem.put("tel1", "010-0100-0200");
			mapItem.put("email", "test1@nextit.or.kr");
			itemList.add(mapItem);
			
			jsonVo.setItem(itemList);
			
		return jsonVo; 
	}
	
	
	
	
	
	
}
