package kr.or.nextit.session.service.impl;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.or.nextit.session.service.LoginInfoVo;

@Mapper
public interface SessionMapper {
	
	/**
	 * ID,PWD 값을 DB에서 where 조건으로 검색
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public LoginInfoVo selectMemberInfo(
			HashMap<String, Object>params //파라미터를 하나만 받기때문에 VO에담거나 Map에담아서 보내줘야좋겠지요
			
			) throws Exception;
	
	
}
