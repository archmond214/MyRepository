package kr.or.nextit.board.web;

import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.or.nextit.attach.service.AttachService;
import kr.or.nextit.attach.service.AttachVo;
import kr.or.nextit.board.service.BoardSearchVo;
import kr.or.nextit.board.service.BoardService;
import kr.or.nextit.board.service.BoardVo;
import kr.or.nextit.session.service.LoginInfoVo;

@Controller
@RequestMapping(value="/board")
public class BoardController {

	private final Logger log =  LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="propertyService")
	private Properties propertiesService;
	
	@Autowired
	private AttachService attachService;
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value= {"/boardListFront.do"})
	public String getBoardList(
			Model model,
			@ModelAttribute BoardSearchVo searchVo

			
			) throws Exception{
		
		
		List<BoardVo> resultBoardList = boardService.selectBoardList(searchVo);
		model.addAttribute("boardList",resultBoardList);
		

		return "board/boardList";
	}
	
	@RequestMapping(value="/boardInsertForm.do")
	public String getBoardInsertForm(
			Model model,
			@ModelAttribute BoardSearchVo searchVo
			) throws Exception{
		
		
		 return "board/boardForm";
	}
	/**boardInserForm.do 에서 넘어온 데이터를 DB에 적재 
	 * @param model
	 * @param boardVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/boardInsertProc.do")
	public String setBoardInsertProc(
			Model model,
			@ModelAttribute(name="boardVo") BoardVo boardVo,
			//첨부파일..
			@RequestParam(name="attachFiles") List<MultipartFile> attachFiles,
			HttpServletRequest request
			) throws Exception{
		
		try {
			LoginInfoVo loginInfoVo = (LoginInfoVo)request.getSession().getAttribute("loginInfo");
			//작성자의 IP가져오기
			boardVo.setUsrIp(request.getRemoteAddr());
			boardVo.setRegUser(loginInfoVo.getUsrId());
			
			
			boardService.insertBoardInfo(boardVo);
		
			log.debug("insert 실행 후 seqNo값 : {}",boardVo.getSeqNo());
			//첨부파일 추가...
			attachService.insertFileUploads(boardVo.getSeqNo(), boardVo.getServiceType(), propertiesService.getProperty("server.save.path"), boardVo.getRegUser()
					, boardVo.getUsrIp(), attachFiles);
			
			
			
			//RedirectView
			//정상 등록시 List 이동
			return "redirect:/board/boardListFront.do";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("message",e.getMessage());
		}
		//등록시 에러가 발생하면 등록 폼을 보여줌
		return "board/boardForm";
	
	}
	@RequestMapping(value="/boardViewFront.do")
	public String getBoardViewFront(
			ModelMap modelMap,
			@ModelAttribute(name="searchVo") BoardSearchVo searchVo
			) throws Exception {
		
		BoardVo boardVo = boardService.selectBoardInfo(searchVo.getSeqNo());
		modelMap.addAttribute("boardInfo",boardVo);
		
		//seqNo 값에 해당하는 첨부파일 목록 조회...
		List<AttachVo> attachList = attachService.selectFileList(boardVo.getSeqNo());
		modelMap.addAttribute("attachList",attachList);
		
		
		
		
		
		return "board/boardView";
	}
	@RequestMapping(value="/boardDeleteProc.do")
	public String  setBoardInfoProc(
			Model model,
			@RequestParam HashMap<String, Object> params
			) throws Exception{
		
		 try {
			boardService.deleteBoardInfo(params);
			
			//정상 삭제시 list이동
			return "redirect:/board/boardListFront.do";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return String.format("redirect:/board/boardViewFront.do?seqNo=%s", params.get("seqNo")); 
		}
	}
	//이거는 회원 상세 보기를 하는 녀석 수정을위해...
	@RequestMapping(value="/boardUpdateFront.do")
	public String getBoardUpdateFront(
			Model model,
			@RequestParam HashMap<String, Object> params
			) throws Exception{
		
		BoardVo boardVo = boardService.selectBoardInfo((String)params.get("seqNo"));
		
		model.addAttribute("boardInfo",boardVo);
		
		return "board/boardUpdate";
	}
	//이녀석은 실제 수정한 값들을 넘겨서 처리해 주는 뇨석
	@RequestMapping(value="/boardUpdateProc.do")
	public String getBoardUpdateProc(
			ModelMap model,
			@RequestParam HashMap<String, Object> params,
			HttpSession session
			) throws Exception {
		log.debug("params : {}",params);
		//세션에서 로그인 사용자 정보를 가지고 와서 map 객체에 값을 넣어줌! 
		LoginInfoVo loginInfo = (LoginInfoVo) session.getAttribute("loginInfo");
		//put에서 넘겨준 키값updUser는 쿼리에 있는키값과 동일해야함! 
		params.put("updUser", loginInfo.getUsrId());
		
		boolean isResult = boardService.updateBoardInfo(params);
		
		if(isResult) {
			boardService.updateBoardInfo(params);
			//수정 성공시 view page이동...
			return String.format("redirect:/board/boardViewFront.do?seqNo=%s", params.get("seqNo"));
		}else {
			//수정 에러시 수정 폼을 보여줌
			return String.format("redirect:/board/boardUpdateFront.do?seqNo=%s", params.get("seqNo"));
		}
		
	}
	
}
