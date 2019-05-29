package kr.or.nextit.test.web;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.hello.service.HelloService;


@Controller //어노테이션안붙이면 그냥 클래스임! 그닌까 이게 서블릿탈려면 어노테이션 붙여야겠찡!?
public class TestController {
	//로거는 필수! 필쑤! 피일쑤! 칼퇴! 칼퇴!!!칼퇴!!!!!!!!!
	private final Logger log =  LoggerFactory.getLogger(this.getClass());
		
		
	//@Autowired  //내부적으로 의존관계있는놈을 찾아서 자동으로 주입!
//	@Autowired
//	public HelloService helloService;
	
	
	@RequestMapping(value ="/test/modelAndViewTest.do") // 경로!
	public ModelAndView modelAndViewTest(
			ModelAndView modelAndView,
			@RequestParam HashMap<String, Object> params
			) throws Exception  {

		log.debug(" params: {}",params);
		log.debug(" params: {} ,{}",params,"ModelAndView");
		
		
		//모델엔뷰를 객체로 만들던지 스프링 프레임워크에 있는 모델엔 뷰를 파라미터로받든지
		//ModelAndView 는 스프링프레임워크의 최상위 클래스
		//ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/test/testFront");
		modelAndView.addObject("title", "ModelAndView modelAndView 테스트..");
		
//		List<HashMap<String, Object>> result = helloService.getHelloList("test");
//		modelAndView.addObject("helloList",result);
		
		return modelAndView;
	}
	
	
	// url 경로 / 매핑된 파일명(testMain).확장자(.do)
	@RequestMapping(value ="/test/testMain.do") // 경로! 
	public String testFront(
			Model model,
			@RequestParam(name="dan",defaultValue="1",required=false) int dan
			) throws Exception {
		log.debug(" request.getParam~~~{}",dan);
		log.debug(" request.getParam~~~{},{}",dan,"구구구단 구구구....");
		
		model.addAttribute("title","Model.addAttribute 테스트...화면...");
	//파일 경로(test/) / 파일명(testFront)
	return "test/testFront";

	}
	@RequestMapping(value="/test/modelMap.do")
	public String modelMapTestFront (
			ModelMap modelMap,
			@RequestParam HashMap<String,Object> params
			
			) throws Exception {
		log.debug("params : {}" ,params);
		log.debug("params : {}" ,params);
		log.debug("params : {}" ,params);
		log.debug("params : {}" ,params);
		log.debug("params : {}" ,params);
		
		modelMap.addAttribute("title","ModelMap modelMap.addAttribute 테스트...");
		
		//파일 경로(test/) / 파일명(testFront)
		return "/test/testFront";
	}
	
	
	
	
	
	
	
	
}
