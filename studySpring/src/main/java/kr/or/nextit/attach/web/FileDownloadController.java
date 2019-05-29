package kr.or.nextit.attach.web;

import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.nextit.attach.service.AttachService;
import kr.or.nextit.attach.service.AttachVo;

@Controller
public class FileDownloadController {
	
	private final Logger log =  LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="propertyService")
	private Properties propertiesService;
	
	@Autowired
	private AttachService attachService;
	
	@RequestMapping(value="/attach/testDownload.do")
	public String testDownloadFront(
			Model model,
			@RequestParam HashMap<String, Object> params
			) throws Exception{
		String groupSeqNo = "85";
		
		if((String)params.get("groupSeqNo")!=null) {
			groupSeqNo = (String)params.get("groupSeqNo");
		}
		
		
		List<AttachVo> attachList = attachService.selectFileList(groupSeqNo);
		model.addAttribute("attachList",attachList);
		return "attach/testDownload";
	}
	
	/**
	 * 첨부 파일 다운로드 구현시 return void 설정해 주어야함....
	 * 서버에 저장된 파일을 바이너리 읽어서 response 객체로 처리..
	 * /attach/fileDownload.do?seqNo=정수
	 * @throws Exception
	 */
	@RequestMapping(value="/attach/fileDownload.do")
	public void getFileDownload(
			@RequestParam(name="seqNo") int seqNo,
			HttpServletResponse response
			
			) throws Exception{
		
		String serverRootPath = propertiesService.getProperty("server.save.path");
		
		AttachVo attachVo = attachService.selectFileInfo(seqNo);
		
		//다운로드 경로.
		//  /NOTICE/ 파일명DB 저장된 정보...
		///home/pc13/workspace/upload/   + /NOTICE/파일명 DB저장된 정보 
	
		StringBuilder fileSavePath = new StringBuilder();
		fileSavePath.append(serverRootPath);
		fileSavePath.append(attachVo.getSavePath());
		fileSavePath.append(attachVo.getSaveName());
		
		log.debug("서버에 저장된 파일 위치 :{}",fileSavePath);
		log.debug("서버에 저장된 파일 위치 :{}",fileSavePath);
		log.debug("서버에 저장된 파일 위치 :{}",fileSavePath);
		
		//서버에 저장된 파일 정보를 읽어옴...
		File serverFile = new File(fileSavePath.toString());
		//파일을 byte 배열로 변환해서 읽어옴 
		byte fileByte[] = FileUtils.readFileToByteArray(serverFile);
		
		log.debug("file Name: {}",attachVo.getFileName());
		
		//context 정보를 바이너리 데이터로 브라우저에서 해석하지 않도록 설정
		response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
		response.setContentLength(fileByte.length);
		response.setHeader("Content-Transfer-Encoding","binary");

		//첨부 파일 다운로드 버튼 클릭시 DB에 저장된 이름으로 보이도록 설정
		//URLEncoder.encode 한글 이름 처리시 필수 
//		response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
//				"attachment; fileName=\""+ URLEncoder.encode(attachVo.getFileName(), "UTF-8")+"\";");
		
		response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
				String.format("attachment; fileName=\"%s\";",  URLEncoder.encode(attachVo.getFileName(),
				 "UTF-8")));
		
		
		//서버에서 읽어온 파일 정보를 response 응답 객체에 바이트로 덮어씀..
		response.getOutputStream().write(fileByte);
		// response 객체를 적용..
		response.getOutputStream().flush();
		//response 객체에 파일정보를 적용후 다른 페이지 정보가 보이지 않도록 닫아줌.
		response.getOutputStream().close();
	}
	
	
	
	
	
	
	
}
