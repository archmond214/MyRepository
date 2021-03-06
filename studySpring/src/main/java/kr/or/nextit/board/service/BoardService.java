package kr.or.nextit.board.service;

import java.util.HashMap;
import java.util.List;

public interface BoardService {

	
	/**데이터 베이스에서searchVo 조건에 맞는 데이터를 가지고 옴...
	 * @param searchVo
	 * @return
	 * @throws Exception
	 */
	public List<BoardVo> selectBoardList(
			BoardSearchVo searchVo
			) throws Exception;
	
	
	/**사용자가 입력한 정보를 처리하는 비지니스 플로우 처리... 
	 * @param boardVo
	 * @throws Exception
	 */
	public BoardVo insertBoardInfo(
			BoardVo boardVo
			) throws Exception;
	
	
	/**
	 * seqNo값에 해당하는 글 정보 조회하기능
	 * @param seqNo
	 * @return
	 * @throws Exception
	 */
	public BoardVo selectBoardInfo(
			String seqNo
			
			)throws Exception;
	
	
	
	/**
	 * 삭제할 seqNo값을 hashMap 으로 받아서 처리...
	 * @param params
	 * @throws Exception
	 */
	public void deleteBoardInfo(
			HashMap<String, Object> params
			) throws Exception;
	
	
	/**
	 * 수정화면에서 넘어온 값을 해쉬맵 객체로 받아서 seqNo(PK) 값 에 해당하는 정보를 변경 
	 * @param params
	 * @return 
	 * @throws Exception
	 */
	public boolean updateBoardInfo(
			HashMap<String, Object> params
			) throws Exception;
	
	
	
	
	
	
}
