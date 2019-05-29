package kr.or.nextit.member.web;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import kr.or.nextit.member.service.MemberSearchVo;
import kr.or.nextit.member.service.MemberService;
import kr.or.nextit.member.service.MemberVo;

@Controller
@RequestMapping(value="/json")
public class jsonMemberController {

	private final Logger log =  LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="propertyService")
	private Properties propertiesService;
	
	@Resource(name="MemberService")
	private MemberService memberService;
	
	
	
	@RequestMapping(value="/memberListFront.do")
	public String getMemberListFront() throws Exception{
		
		
		return "json/memberList";
		
	}
	@RequestMapping(value="/memberListProc.json")
	@ResponseBody
	public List<MemberVo> getMemberListProc(
			@ModelAttribute(name="searchVo")MemberSearchVo searchVo
			) throws Exception{
		int totalCount = memberService.selectMemberTotalCnt(searchVo);
		
		searchVo.setTotalCount(totalCount);
		searchVo.setScreenSize(10);
		searchVo.setPageBlockSize(4);
		searchVo.pageSetting();
	
		//업무 로직을 수행하고. resultList 변수에 결과 값을 반환....
		List<MemberVo> resultList = memberService.selectMemberList(searchVo);

		return resultList;
	}
	
	
	
	@RequestMapping(value= {"/memberInsertFront.do"})
	public ModelAndView getMemberInsert(
			ModelAndView modelAndView
			) throws Exception {
		
		//page를 setViewName 페이징 포워딩
		modelAndView.setViewName("json/memberInsert");
		
		return modelAndView;
	
	}
	@RequestMapping(value="/findIdCheckProc.json")
	@ResponseBody
	public HashMap<String, Object> findIdCheck(
			@RequestParam HashMap<String, Object> params
			) throws Exception{
		log.debug("params: {}",params);
		
		HashMap<String, Object> result = new HashMap<>();
	
		try {
			String userId =  (String)params.get("usrId");
	
			if(userId == null || "".equals(userId)) {
				throw new Exception("회원 아이디를 입력 하셔야 합니다");
			}
			MemberVo memberInfo = memberService.findIdCheck(userId);
			
			if(memberInfo != null) {
				throw new Exception("사용 중인 아이디 입니다. 다른 아이디를 입력하세요");
			}
			
			result.put("status", true);
			result.put("message", "사용 가능한 아이디 입니다. 사용 강추!!!!");
			result.put("checkId", userId);
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("status", false);
			result.put("message", e.getMessage());
		}
		
		return result;
	}
	@RequestMapping(value="/insertMemberInfo.json")
	@ResponseBody
	public HashMap<String, Object> setInsertMemberInfo(
			@ModelAttribute MemberVo memberVo,
			HttpServletRequest request,
			ModelAndView model
			) throws Exception{
		
		
		
		memberVo.setUsrIp(request.getRemoteAddr());
		
		log.debug("insert Data : {}",memberVo);
		log.debug("insert Data : {}",memberVo);
		log.debug("insert Data : {}",memberVo);
		
		HashMap<String, Object> result = new HashMap<>();
		
		try {
			memberService.insertMemberInfo(memberVo);
			
			result.put("status", true);
			result.put("message", "회원 가입 축하 드립니당");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("status", false);
			result.put("message", e.getMessage());
		}
		
		
		return result;
	}
}
