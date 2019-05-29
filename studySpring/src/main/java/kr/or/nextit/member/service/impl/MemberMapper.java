package kr.or.nextit.member.service.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.nextit.member.service.MemberSearchVo;
import kr.or.nextit.member.service.MemberVo;

@Mapper
public interface MemberMapper {

	/**
	 * 등록 하고자 하는 아이디 를 가지고 기존 정보 검색....
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public MemberVo findIdCheck(String userId) throws Exception;
	
	
	
	
	/**
	 * selectMemberList 기능과 동일한 조건으로 카운터를 함.
	 * 
	 * @param searchVo
	 * @return
	 * @throws Exception
	 */
	public int selectMemberTotalCnt(MemberSearchVo searchVo) throws Exception;
	
	/**
	 * seqNo값에 해당하는 delAt = Y변경
	 * 조회시 검색 조건이 delAt = N 값만 조회 되도록 변경...
	 * @param searchVo
	 * @throws Exception
	 */
	public void deleteFlagMemberInfo(
			MemberSearchVo searchVo
			) throws Exception;
	
	
	
	/**
	 * seqNo값으로 회원 정보 수정하기..
	 * @param params
	 * @throws Exception
	 */
	public void updateMemberInfo(
			HashMap<String, Object> params
			) throws Exception;
		
	/**
	 * 물리데이터 삭제...
	 * @param seqNo
	 * @throws Exception
	 */
	public void deleteMemberInfo(
			String seqNo
			) throws Exception;
	
	
	
	
	
	
	
	/**
	 * select * from tableName where seq_no = #{seqNo}
	 * 해당하는 테이블에서 seqNo값이 같은 레코드 정보를 반환(Vo)
	 * @param seqNo
	 * @return
	 * @throws Exception
	 */
	public MemberVo selectMemberInfo(String seqNo) throws Exception;
			

	
	
	
	
	public void insertMemberInfo(
				MemberVo memberVo
			
			) throws Exception;
	
	
	/**
	 * 검색 조건에 해당하는 데이터를 조회 하는 기능..(목록 반환)
	 * return List<MemberVo>
	 * @param searchVo
	 * @return
	 * @throws Exception
	 */
	public List<MemberVo> selectMemberList(
			//param 객체는 1단 1개만 넘길수 있음 
			// Map,Vo,String,int,등...param2개이상을 넣을 수 없음.
			MemberSearchVo searchVo
			) throws Exception;
	/*public List<MemberVo> selectMemberList( 이렇게 파라미터가 1개이상이면 절대 안됌! 
			//param 객체는 1단 1개만 넘길수 있음 
			// Map,Vo,String,int,등...param2개이상을 넣을 수 없음.
			MemberSearchVo searchVo, String seqNo 
			) throws Exception;
	*/
}
