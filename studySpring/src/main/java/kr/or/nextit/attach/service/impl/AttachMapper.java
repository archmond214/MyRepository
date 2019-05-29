package kr.or.nextit.attach.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.nextit.attach.service.AttachVo;

@Mapper
public interface AttachMapper {

	/** 뷰 또는 다운로드 화면 seqNo값을 다운로드 +1 해줌! ...
	 * @param seqNo
	 * @throws Exception
	 */
	public void updateFileInfoCnt(
			int seqNo) throws Exception;
	
	
	
	
	/**
	 * seqNo 값에 해당하는 1건의 데이터를 가지고옴
	 * wehere seq_no = #{seqNo} 실행..
	 * @param seqNo
	 * @return
	 * @throws Exception
	 */
	public AttachVo selectFileInfo(int seqNo) throws Exception;
	
	
	
	
	
	
	
	/**
	 * 그룹키에 해당하는 정보를 반환...(list)
	 * @param groupSeqNo
	 * @return
	 * @throws Exception
	 */
	public List<AttachVo> selectFileList(
			String groupSeqNo
			) throws Exception;
	
	
	
	/**
	 * 첨부 파일을 1건식 등록을 함!
	 * @param attachVo
	 * @throws Exception
	 */
	public void insertFileInfo(
			AttachVo attachVo
			) throws Exception;
	
}
