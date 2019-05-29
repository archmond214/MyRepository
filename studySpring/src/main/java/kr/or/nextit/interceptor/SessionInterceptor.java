package kr.or.nextit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.view.RedirectView;

import kr.or.nextit.session.service.LoginInfoVo;

public class SessionInterceptor extends HandlerInterceptorAdapter {
	
	private final Logger log =  LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		
		log.debug("SessionInterceptor.preHandle() 실행!!!!!!!");
		//logincontroller 에서 등록한 session.setAttribute("loginInfo") 등록 되어 있는 값을
		//request.getSession().getAttribute ("loginInfo") 에서 loginInfoVo 값으로 가지고 옴...
		//setAttribute("loginInfo",Object) 등록된 value 값은 object 등록이 되어 있어서 형변환 시켜야함
		LoginInfoVo loginInfoVo = (LoginInfoVo) request.getSession().getAttribute("loginInfo");
		
		if(loginInfoVo != null ) {
			
			log.debug("로그인 되어 있으면 컨트롤러 메소드 실행! ");
			log.debug("user LoginOnfoVo : {} " , loginInfoVo);
			
		}else {
			
		log.debug("로그인 정보가 없으면 로그인 페이지로 이동! ");
		//로그인이 되어 있지 않으면 로그인 화면으로 이동
		RedirectView redirectView = new RedirectView();
		//로그인 화면 URL 등록
		redirectView.setUrl("/session/loginFront.do");
		//스프링 프레임워크에서 처리가 되는 ModelAndView 객체 생성.
		ModelAndView modelAndView = new ModelAndView();
		//ModelAndView 뷰 단을 영역을 redirectView 객체로 설정...
		//modelAndView.setView(redirectView);
		modelAndView.setViewName("redirect:/session/loginFront.do");
		//modelAndViewDefiningException 에러를 발생..
		//에러 발생 이유는 단순한 redirect 일경우에는 무한 루프에 빠져서
		//에러가 발생 하기 때문에 뷰 단을 에러 영역으로 넘겨서 무한루프에 빠지지 않도록 처리...
		
		throw new ModelAndViewDefiningException(modelAndView);
		
		}
		return true;
		
	}
	
}
