package kr.or.nextit;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.nextit.test.service.HomeVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private final Logger log =  LoggerFactory.getLogger(this.getClass());
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request,HttpServletResponse response ) {
		logger.info("Welcome home! The client locale is {}.", locale);
		logger.info("request.getRemoteAddr(): {} ",request.getRemoteAddr());
		logger.info("request.getContextPath(): {} ",request.getContextPath());
		logger.info("request.getContentType(): {} ",request.getContentType());
		logger.info("request.getContentLength(): {} ",request.getContentLength());
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	//get post , put , delete 등의 모든 메소드를 받아서 처리 할 수 있음...뭐가?@RequestMapping얘가
	//@RequestMapping(value ="/test/getTest.do") // 요청을 매핑 시키겠다 매핑! 
	@GetMapping(value="/test/getTest.do") //이뇨속은 GET방식만..됨
	public String getTest(
			//@@RequestParam 버튼 또는 링크 이벤트 발생시 input tag 의 값을 객체에 담아 주는 기능..
			@RequestParam HashMap<String, Object> params,
			@RequestParam (name="title") String title ,
			//@@ModelAttribute 버튼 또는 링크 이벤트 발생시 input tag 의 값을 객체(Vo)에 담아주는기능.
			@ModelAttribute HomeVo homeVo) {
		//이건 파람	으로 보낸거구
		/*logger.info("Home 에서 보낸값 {}",params);
		logger.info("Home 에서 보낸값 {}",params);
		logger.info("Home 에서 보낸값 {}",params);
		logger.info("Home 에서 보낸값 {}",params);
		logger.info("Home 에서 보낸값 {}",params);
		*/
		//이건 이제 스트링으로 보낸거구 
		logger.info("Home title에서 보낸값 {}",title);
		logger.info("Home title에서 보낸값 {}",title);
		logger.info("Home title에서 보낸값 {}",title);
		logger.info("Home title에서 보낸값 {}",title);
		logger.info("Home title에서 보낸값 {}",title);
		 return "/test/getTest";
	}
	//post 방식!으로!
	//@PostMapping 의 value 값은 문자열 또는 문자열 배열로 지정이 가능함! 
	// postTest 메소드에 "/test/postTest.do","/test/postTest.daum"하나이상의
	//배열로 url 을 만들어 줄수 있음 ! 
	@PostMapping(value={"/test/postTest.do","/test/postTest.daum"})
	public String postTest(@ModelAttribute HomeVo homeVo) {
		
		log.info( "home post : {}",homeVo);
		log.error("home post : {}",homeVo);
		log.debug("home post : {}",homeVo);
		log.debug("home post : {}",homeVo);
		log.debug("home post : {}",homeVo);
		
		
		return "/test/postTest";
	}
	
	
}
