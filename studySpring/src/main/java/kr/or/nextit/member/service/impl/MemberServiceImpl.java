package kr.or.nextit.member.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.nextit.member.service.MemberSearchVo;
import kr.or.nextit.member.service.MemberService;
import kr.or.nextit.member.service.MemberVo;

@Service("MemberService")
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public List<MemberVo> selectMemberList(MemberSearchVo searchVo) throws Exception {
		//mybatis MemberMapper.xml 에서 동적 쿼리로 변경...
		/*if(searchVo.getSearchType() !=null || !"".equals(searchVo.getSearchType())) {
			searchVo.setSearchType("usr_id");
		}
		*/
		
		List<MemberVo> resultList = memberMapper.selectMemberList(searchVo);
		
		return resultList;
		
	}

	@Override
	public void insertMemberInfo(MemberVo memberVo) throws Exception {
		// 비지니스 로직을 수행후 => 회원정보를 DB에 등록!(데이터 레이어)
		memberMapper.insertMemberInfo(memberVo);
	}

	@Override
	public MemberVo selectMemberInfo(String seqNo) throws Exception {
	
		return memberMapper.selectMemberInfo(seqNo);
	}

	@Override
	public void updateMemberInfo(HashMap<String, Object> params) throws Exception {
		
		memberMapper.updateMemberInfo(params);
		
	}

	@Override
	public void deleteMemberInfo(String seqNo, MemberSearchVo searchVo) throws Exception {
		
		if(seqNo==null) {
			throw new NullPointerException("seqNo 값이 넘어 오지 않았습니다. *.jsp 파일input name을 확인하세요!");
			
		}
		
		
//		memberMapper.deleteMemberInfo(seqNo); //물리적 삭제 논리적 삭제...
		memberMapper.deleteFlagMemberInfo(searchVo);
		
	}

	@Override
	public int selectMemberTotalCnt(MemberSearchVo searchVo) throws Exception {
		
		try {
			return  memberMapper.selectMemberTotalCnt(searchVo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public MemberVo findIdCheck(String userId) throws Exception {
	
		
		
		
		return memberMapper.findIdCheck(userId);
	}

}
