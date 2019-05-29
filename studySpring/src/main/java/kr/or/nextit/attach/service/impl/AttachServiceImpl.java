package kr.or.nextit.attach.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.or.nextit.attach.service.AttachService;
import kr.or.nextit.attach.service.AttachVo;

@Service("AttachService")
public class AttachServiceImpl implements AttachService {

	
	@Autowired
	private AttachMapper attachMapper;

	@Override
	public HashMap<String, Object> insertFileUploads(String groupSeqNo, String serviceType, String savePath,
			String userId, String userIp, List<MultipartFile> attachFiles) throws Exception {
	
		HashMap<String, Object> result = new  HashMap<String, Object>();
		try {
			
			for (MultipartFile attach : attachFiles) {
				
				if(attach.getOriginalFilename() != null && !"".equalsIgnoreCase(attach.getOriginalFilename())) {
				
				
				AttachVo fileInfo = new AttachVo();
				
				fileInfo.setGroupSeqNo(groupSeqNo);
				fileInfo.setServiceType(serviceType);
				fileInfo.setRegUser(userId);
				fileInfo.setUsrIp(userIp);
				
				fileInfo.setFileName(attach.getOriginalFilename());
				
				fileInfo.setSaveName(UUID.randomUUID().toString());
				fileInfo.setSavePath(String.format("%s%s%s",File.separator ,serviceType,File.separator));
				fileInfo.setSaveSize(attach.getSize());
				fileInfo.setSaveContentType(attach.getContentType());
				//db 파일 정보 등록...
				 attachMapper.insertFileInfo(fileInfo);
				 //파일 생성시 오류 발생시 DB 롤백...
				StringBuilder serverSavePath = new StringBuilder();
				
				serverSavePath.append(savePath);
				serverSavePath.append(fileInfo.getSavePath());
				serverSavePath.append(fileInfo.getSaveName());
				//서버에 저장될 경로 + 파일 명 저아
				File saveFile = new File(serverSavePath.toString());
				//FileUtils.copyToFile(attach.getInputStream(), saveFile);
			
				FileUtils.copyInputStreamToFile(attach.getInputStream(), saveFile);
			
				}
			}
			result.put("status", true);
			result.put("message", "파일업로드 완료");
			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("status",false);
			result.put("message", e.getMessage());
		}	
		return result;
	}

	@Override
	public List<AttachVo> selectFileList(String groupSeqNo) throws Exception {
		// TODO Auto-generated method stub
		List<AttachVo> attachList = attachMapper.selectFileList(groupSeqNo);
		
		return attachList;
	}

	@Override
	public AttachVo selectFileInfo(int seqNo) throws Exception {
		//조회 하거나 다운로드 버튼 클릭시 조회수 +1
		attachMapper.updateFileInfoCnt(seqNo);
		
		AttachVo attachVo = attachMapper.selectFileInfo(seqNo);
		//null 포인트 에러 발생이유는 return 꼭 확인하자! 
		return attachVo;
	}
	
	
}
