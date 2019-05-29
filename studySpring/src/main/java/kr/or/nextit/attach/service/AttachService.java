package kr.or.nextit.attach.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface AttachService {

	/**
	 * 시컨스로 생성되 seqNo 값:(pk) 값으로 파일 정보를 읽어옴!
	 * @param seqNo
	 * @return
	 * @throws Exception
	 */
	public AttachVo selectFileInfo(
			int seqNo
			) throws Exception;
	
	/**
	 * groupSeqNo 값에 해당하는 레코드를 조회 
	 * @param groupSeqNo
	 * @return
	 * @throws Exception
	 */
	public List<AttachVo> selectFileList(
			String groupSeqNo 
			) throws Exception;
	
	
	
	
	/**
	 * 첨부파일 등록 기능....
	 * 첨부파일 groupSeqNo... 등의 정보를 받아서 업무 로직 수행
	 * @param groupSeqNo
	 * @param ServiceType
	 * @param userId
	 * @param userIp
	 * @param attachFiles
	 * @return
	 * @throws Exception
	 */
	public HashMap<String, Object> insertFileUploads(
			String groupSeqNo,
			String serviceType,
			String savePath,
			String userId,
			String userIp,
			List<MultipartFile> attachFiles
			) throws Exception; 
	
	
	
	
	
}
