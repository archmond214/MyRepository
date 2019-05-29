package kr.or.nextit.member.service;

import java.util.HashMap;
import java.util.List;

public interface MemberService {

	/**
	 * 등록된 아이디 인지 체크 하는 기능...
	 * 등록된 회원이면.. 회원 아이디 반환...
	 * 미등록 아이디면.. null반환 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public MemberVo findIdCheck(String userId) throws Exception;
	
	
	
	
	
	
	
	
	
	/**
	 * selectMemberList 검색 조건과 동일한 조건의 카운터를가지고옴
	 * @param searchVo
	 * @return
	 * @throws Exception
	 */
	public int selectMemberTotalCnt(
			MemberSearchVo searchVo
			) throws Exception;
	
	
	
	/**
	 * memberSearchVo 값에 해당하는 List<MemberVo> 값을 반환..
	 * 회원 정보를 검색 하는 기능 .. 
	 * @param searchVo
	 * @return
	 * @throws Exception
	 */
	public List<MemberVo> selectMemberList(
			MemberSearchVo searchVo
			
			) throws Exception;
	
	/**
	 * 회원 가입 MemberVo 변수에 값을 업무 로직 수행후 , 데이터 베이스에
	 * 저장 (데이터 레이어) 
	 * @param member
	 * @throws Exception
	 */
	public void insertMemberInfo(
			MemberVo memberVo
			
			) throws Exception;
	
	/**
	 * seqNo 값에 해당하는 정보를 Vo객체로 반환 하는 기능....
	 * @param seqNo
	 * @return
	 * @throws Exception
	 */
	public MemberVo selectMemberInfo(
			String seqNo
			
			) throws Exception;
	
	
	/**
	 * 화면에서 입력된 데이터를 MAP으로 받아서 seqNo에 해당하는 값을 반환
	 * @param params
	 * @throws Exception
	 */
	public void updateMemberInfo(
			HashMap<String, Object> params
			) throws Exception;

	void deleteMemberInfo(String seqNo, MemberSearchVo searchVo) throws Exception;
	
	/**
	 * seqNo값으로 회원 정보를 삭제
	 * 1.물리 데이터 삭제...delete실행..
	 * 2.del_at 여부를 N값에서 Y 값으로 변경  update 실행...
	 * @param seqNo
	 * @throws Exception
	 */
	
	
}
