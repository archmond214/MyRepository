package kr.or.nextit.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TestInterceptor extends HandlerInterceptorAdapter {

	// 필수라고했지...클래스만들면...
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub

		log.debug("TestInterceptor preHandle() 실행");
		log.debug("전처리 : Url 요청시 컨트롤러가 실행되기 전 실행....");

		Enumeration<String> keyNames = request.getParameterNames();

		while (keyNames.hasMoreElements()) {
			String str = (String) keyNames.nextElement();
			log.debug("key Name : {} , key Value : {}", keyNames, request.getParameter(str));
		}

		return true;

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		log.debug("TestInterceptor postHandle() 실행");
		log.debug("후처리 : Url 요청시 컨트롤러가 실행 된 후 실행....");

		// Controller 에서 return ? String / ModelAndView

		// 메소드에서 String 으로 반환 하는 경우..
		// 스프링에서 내부적으로 String 값을 modelAndView.setViewName("경로/파일명"); set기능을 자동수행
		// modelAndView.setViewName("경로/파일명");

		Enumeration<String> keyNames = request.getParameterNames();

		while (keyNames.hasMoreElements()) {
			String keyName = (String) keyNames.nextElement();
			log.debug("key Name : {}, key Value : {} ", keyName, request.getParameter(keyName));

		}
		
		if(modelAndView!=null) {
		
		log.debug("model : {}", modelAndView.getModel());
		log.debug("modelMap : {} ", modelAndView.getModelMap());
	
		modelAndView.addObject("userTitle","숙짜~와 함께 하는 인터 쎄에에엡터!");
		
		}
		
	}

}
