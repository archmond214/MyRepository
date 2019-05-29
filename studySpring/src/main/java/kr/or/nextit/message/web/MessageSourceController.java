package kr.or.nextit.message.web;

import java.util.Locale;
import java.util.Properties;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MessageSourceController {
	//필수
	private final Logger log =  LoggerFactory.getLogger(this.getClass());
	@Resource(name="propertyService")
	private Properties propertiesService;
	
	//다국어 사이트만 적용``
	@Resource(name="messageSource")
	private MessageSource messageSource;
	
	@RequestMapping(value="/message/messageSource.do")
	public String testMessageSource(
			//프레임 워크에 설정된 locale정보를 받아옴...
			Locale locale
			)throws Exception{
		
		//messageSource.getMessage("key", "param", "언어");
		log.debug("메시지 : {}", messageSource.getMessage("list.sample", null, locale));
		log.debug("메시지 : {}", messageSource.getMessage("button.search", null, locale));
		log.debug("메시지 : {}", messageSource.getMessage("search.keyword", null, locale));
		log.debug("메시지 : {}", messageSource.getMessage("search.name", null, locale));
		
		Object[] args = {"이름은" ,"3"};
		log.debug("메시지 : {}", messageSource.getMessage("errors.minlength", args, locale));
		log.debug("메시지 : {}", messageSource.getMessage("errors.maxlength", args, locale));
		
		log.debug("메시지 : {}", messageSource.getMessage("errors.test", args, locale));
		log.debug("메시지 : {}", messageSource.getMessage("errors.title", args, locale));
		
		
		
		
		
		
		
		
		
		return "message/messageSource";
	
		
		
	
	
	}
	
	
	
	
	
	
	
	
}
