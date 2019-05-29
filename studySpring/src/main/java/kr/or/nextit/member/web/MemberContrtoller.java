package kr.or.nextit.member.web;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import kr.or.nextit.member.service.MemberSearchVo;
import kr.or.nextit.member.service.MemberService;
import kr.or.nextit.member.service.MemberVo;

@Controller
//컨트롤러 생성시 default url 경로는 "/member"부터 시작..
@RequestMapping(value="/member")
public class MemberContrtoller {
	
	private final Logger log =  LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MemberService memberService;
	
	/**
	 * @Controller 에 @RequestMapping(value="/member")컨트롤러에 기본 url 경로 설정되어있음.
	 * 메소드의 	@RequestMapping(value="/memberList.do")경로 앞에  @RequestMapping(value="/member")작동함
	 * ex)/member/memberList.do
	 * /member/memberList.do
	 * /member/memberView.do
	 * /member/memberDelete.do
	 * @param model
	 * @param searchVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/memberList.do")
	public String getMemberList(
				Model model,
				@ModelAttribute(name="searchVo") MemberSearchVo searchVo
				)throws Exception{
		int totalCount = memberService.selectMemberTotalCnt(searchVo);
		
			searchVo.setTotalCount(totalCount);
			searchVo.setScreenSize(3);
			searchVo.setPageBlockSize(4);
			searchVo.pageSetting();
			//?왜 없지???
		
		//업무 로직을 수행하고. resultList 변수에 결과 값을 반환....
		List<MemberVo> resultList = memberService.selectMemberList(searchVo);
		// jsp (view) 데이터 전달: 	addAttribute : key , value 
		model.addAttribute("memberList", resultList);
		return "member/memberList";
	}
	// 		/member/memberInsertFront.do
	@RequestMapping(value= {"/memberInsertFront.do"})
	public ModelAndView getMemberInsert(
			ModelAndView modelAndView
			) throws Exception {
		
		//page를 setViewName 페이징 포워딩
		modelAndView.setViewName("member/memberInsert");
		
		
		
		return modelAndView;
	}
	
	
	@RequestMapping(value= "/memberInsertProc.do")
	public ModelAndView setMemberInsertProc(
			ModelAndView modelAndView,
			//클라이언트에서 보낸 데이터를 Vo객체에 자동으로 담아서 보내줌!
			//jsp 파일에서 <input name="useName"> 으로 보낸 값을 Vo로 받아서 처리 할 경우
			//사용한당!
			@ModelAttribute(name="memberVo") MemberVo memberVo,
			HttpServletRequest request 
			) throws Exception{
		
		log.debug("memberVo: {}",memberVo);
		log.debug("memberVo: {}",memberVo);
		log.debug("memberVo: {}",memberVo);
		memberVo.setUsrIp(request.getRemoteAddr());
	
		try {
			memberService.insertMemberInfo(memberVo);
			//회원가입 성공시 회원 목록으로 화면 전환!
			RedirectView redirectView = new RedirectView();
			redirectView.setUrl("/member/memberList.do");
			modelAndView.setView(redirectView);
		} catch (Exception e) {
			// 에러가 나면 에러 난 페이지 띄움
			modelAndView.setViewName("member/memberInsert");
			e.printStackTrace();
			throw new Exception ("회원가입시 에러가 발생 하였습니다.",e);
		}
		return modelAndView;
	}
	@RequestMapping(value="/memberView.do")
	public String getMemberInfoView(
				Model model,
				@ModelAttribute(name="searchVo") MemberSearchVo searchVo
			) throws Exception{
		
		log.debug("searchVo : {}",searchVo);
		log.debug("searchVo : {}",searchVo);
		log.debug("searchVo : {}",searchVo);

		MemberVo memberVo = memberService.selectMemberInfo(searchVo.getSeqNo());
		model.addAttribute("memberInfo",memberVo);
		
		return "member/memberView";
	}
	@RequestMapping(value="/memberUpdateFront.do")
	public String getMemberUpdateFront(
			ModelMap model,
			@RequestParam HashMap<String, Object> params
			) throws Exception {
	
		log.debug("params : {} ",params);
		String seqNo = (String)params.get("seqNo"); 
		MemberVo memberInfo = memberService.selectMemberInfo(seqNo);
		model.addAttribute("memberInfo",memberInfo);
		return "member/memberUpdate";
	
	}
	@RequestMapping(value="/memberUpdateProc.do")
	public String setMemberUpdateProc(
			ModelMap model,
			@RequestParam HashMap<String, Object> params,
			HttpServletRequest request
			) throws Exception {
		log.debug("params : {}",params);
		
		params.put("usrIp", request.getRemoteAddr());
		params.put("updUser", "master");
		
		//RedirectView
		try {
			memberService.updateMemberInfo(params);
			//수정 성공시 view page이동...
			return String.format("redirect:/member/memberView.do?seqNo=%s", params.get("seqNo"));
		} catch (Exception e) {
			// TODO 수정 페이지 로 이동 (실패시)
			e.printStackTrace();
			return String.format("redirect:/member/memberUpdateFront.do?seqNo=%s", params.get("seqNo"));
			
		}
	}

	@RequestMapping(value="/memberDeleteProc.do")
	public String setDeleteMemberInfo(
			Model model,
			@ModelAttribute MemberSearchVo searchVo,
			@RequestParam(name="seqNo",required=true) String seqNo
			) throws Exception{
		
		memberService.deleteMemberInfo(seqNo, searchVo);
		return "redirect:/member/memberList.do";
	}
	
	
}
