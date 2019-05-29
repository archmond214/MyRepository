package kr.or.nextit.attach.web;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.or.nextit.attach.service.AttachService;
import kr.or.nextit.session.service.LoginInfoVo;

@Controller
public class FileUploadController {

	private final Logger log =  LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="propertyService")
	private Properties propertiesService;
	@Autowired
	private AttachService attachService;
	
	/**
	 * 비동기 업로드 화면...
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/attach/ajaxFileUploadFront.do")
	public String getAjaxFileUploadFront(
			
			) throws Exception{
		
		
		
		
		return "attach/ajaxFileUploadFront";
	}
	@RequestMapping(value="/attach/ajaxFileUploadProc.json")
	@ResponseBody
	public HashMap<String, Object> ajaxFileUploadProc(
			@RequestParam HashMap<String, Object> params,
			@RequestParam(name="attachFiles") List<MultipartFile> attachFiles,
			HttpServletRequest request
			) throws Exception{
		
		//=========================================================================================
		String savePath = propertiesService.getProperty("server.save.path");
		
		String groupSeqNo = UUID.randomUUID().toString();
		String serviceType = (String)params.get("serviceType");
		
		LoginInfoVo loginInfo = (LoginInfoVo) request.getSession().getAttribute("loginInfo");
		
		String userId = "guest";
		if(loginInfo != null) {
			userId = loginInfo.getUsrId();
		}
		
		String userIp = request.getRemoteAddr();
		//첨부 파일 업로드
		HashMap<String, Object> result = attachService.insertFileUploads(groupSeqNo, serviceType, savePath,
				userId, userIp, attachFiles);
		
		//attachService.insertFileUploads(groupSeqNo, serviceType, savePath, userId, userIp, attachFiles);
		
		//=========================================================================================

		return result;
		
	}
	
	
	/**
	 * 동기화 방식 파일 업로드...
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/attach/fileUploadFront.do")
	public String getFileUploadFront(
			
			) throws Exception{
		
		return "attach/fileUploadFront";
		
	}
	
	@RequestMapping(value="/attach/fileUploadProc.do")
	public String setFileUploadFront(
			Model model,
			@RequestParam HashMap<String, Object> params,
			//Point!! : 스프링 프레임워크에서 첨부 파일을 넘겼을 경우 받아옴! 
			@RequestParam(name="attachFiles") List<MultipartFile> attachFiles,
			HttpServletRequest request
			
			// 첨부 파일이 1개만 받아서 처리할때! 
			//@RequestParam(name="attachFiles") ListMultipartFile attachFiles
			
			) throws Exception{
		
		log.debug("param : {}",params);
		log.debug("MultipartFilegetName : {}",attachFiles);
		//=========================================================================================
		String savePath = propertiesService.getProperty("server.save.path");
		
		String groupSeqNo = UUID.randomUUID().toString();
		String serviceType = "test";
		
		LoginInfoVo loginInfo = (LoginInfoVo) request.getSession().getAttribute("loginInfo");
		
		String userId = "guest";
		if(loginInfo != null) {
			userId = loginInfo.getUsrId();
		}
		
		String userIp = request.getRemoteAddr();
		//첨부 파일 업로드
		HashMap<String, Object> result = attachService.insertFileUploads(groupSeqNo, serviceType, savePath, userId, userIp, attachFiles);
		
		//처리 결과를 jsp 전달!
		model.addAttribute("fileInfo",result);
		
		//attachService.insertFileUploads(groupSeqNo, serviceType, savePath, userId, userIp, attachFiles);
		
		//=========================================================================================
		//다중 첨부 파일 1개
//		for (MultipartFile multipartFile : attachFiles) {
//			log.debug("getName : {}",multipartFile.getName());
//			log.debug("getOriginalFilename : {}",multipartFile.getOriginalFilename());
//			log.debug("getContentType : {}",multipartFile.getContentType());
//			log.debug("getSize : {}",multipartFile.getSize());
//		
//			// 첨부 파일이 1개 이상 등록 해야 하는데 1개만 등록 하였을경우..
//			//에러가 발생함! 파일 명이 넘어 오지 않으면 파일 생성을 하지 않음...
//			if(!"".equalsIgnoreCase(multipartFile.getOriginalFilename())) {
//				
//			
//			
//			//File.separator 구분자를 윈도우 \가 리눅스,유닉스 /냐 맞춰 주겠당
//			 File saveFile = new File(String.format("%s%s%s", savePath ,File.separator , multipartFile.getOriginalFilename()));
//			 
//			 FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), saveFile);
//			}
//		}
		
		
		
		//밑에 껏 들은 첨부 파일이 오직 1건일 경우
//		log.debug("param : {}",params);
//		log.debug("MultipartFilegetName : {}",attachFiles.getName());
//		log.debug("MultipartFilegetOriginalFilename : {}",attachFiles.getOriginalFilename());
//		log.debug("MultipartFilegetContentType : {}",attachFiles.getContentType());
//		log.debug("MultipartFilegetSize : {}",attachFiles.getSize());
//		///여기가 포인트!!!!!!!!!!!!!!!!!!!
//		//저장할 파일 경로와 파일명을 file 객체로 인스턴스 생성....
//		File saveFile = new File("/home/pc13/workspace/upload/" + attachFiles.getOriginalFilename());
//		// 클라이언트에서 올라온 파일 inputStream 객체를 saveFile 경로 + 파일 명으로 생성...
//		FileUtils.copyToFile(attachFiles.getInputStream(), saveFile);
		
		return "attach/fileUploadFront";
	}
	@RequestMapping(value="/attach/fileUploadPartProc.do")
	public String setFileUploadPartProc(
			@RequestParam HashMap<String, Object> params,
			@RequestPart List<Part> attachFiles
			) throws Exception{
	
		log.debug("part : {}",attachFiles);
		
		for (Part part : attachFiles) {
			log.debug("getName : {}",part.getName());
			log.debug("getSubmittedFileName : {}",part.getSubmittedFileName());
			log.debug("getContentType : {}",part.getContentType());
			log.debug("getSize : {}",part.getSize());
	
			Collection<String> headers = part.getHeaderNames();
			for (String string : headers) {
				log.debug("{},{}",headers,part.getHeader(string));
			}
			
			
			String savePath = propertiesService.getProperty("server.save.path");
			
			if(!"".equalsIgnoreCase(part.getSubmittedFileName())) {
				
				
				
				//File.separator 구분자를 윈도우 \가 리눅스,유닉스 /냐 맞춰 주겠당
				 File saveFile = new File(String.format("%s%s%s", savePath ,File.separator , part.getSubmittedFileName()));
				 
				 FileUtils.copyInputStreamToFile(part.getInputStream(), saveFile);
				}
		
		}
	
		return "attach/fileUploadFront";
	}
	
	
	
	
}
