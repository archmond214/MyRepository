package kr.or.nextit.propertie;

import java.util.Properties;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PropertieController {

	private final Logger log =  LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="propertyService")
	private Properties propertiesService;
	
	
	
	@RequestMapping(value="/properties/propertiesFront.do")
	public String testPropertiesFront(
			Model model
			) throws Exception{
		
		log.debug("dev.driver={}", propertiesService.getProperty("dev.driver"));
		log.debug("dev.url={}", propertiesService.getProperty("dev.url"));
		log.debug("dev.user={}", propertiesService.getProperty("dev.user"));
		log.debug("dev.password={}", propertiesService.getProperty("dev.password"));
		
		
		log.debug("server.save.path={}", propertiesService.getProperty("server.save.path"));
		log.debug("server.save.url={}", propertiesService.getProperty("server.save.url"));
		
		log.debug("site.title={}", propertiesService.getProperty("site.title"));
		
		//프로퍼티스 정보를 jsp 에서 사용 하고자 할 경우.. Model Or Model Map OR ModelAndView
		model.addAttribute("siteTitle",propertiesService.getProperty("site.title"));
		
		return "/properties/propertiesFront";
	}
	
}











