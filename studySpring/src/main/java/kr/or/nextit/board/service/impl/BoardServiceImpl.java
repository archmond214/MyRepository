package kr.or.nextit.board.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.nextit.board.service.BoardSearchVo;
import kr.or.nextit.board.service.BoardService;
import kr.or.nextit.board.service.BoardVo;
@Service("BoardService")
public class BoardServiceImpl implements BoardService {

	private final Logger log =  LoggerFactory.getLogger(this.getClass());
	
	
	
	@Autowired //스프링프레임워크가 자동으로 싱글톤으로 인스턴스 가져온다아아아아ㅏ아아
	private BoardMapper boardMapper ;

	@Override
	public List<BoardVo> selectBoardList(BoardSearchVo searchVo) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			List<BoardVo> resultList = boardMapper.selectBoardList(searchVo);
			
			return resultList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			//return null;
			throw new SQLException("질의어 수행중 에러 발생하였습니다(*Mapper.xml확인부탁)",e);
		}
		
	}

	@Override
	public BoardVo insertBoardInfo(BoardVo boardVo) throws Exception {
		// TODO Auto-generated method stub
		
		log.debug("boardVo : {}", boardVo);
		log.debug("boardVo : {}", boardVo);
		log.debug("boardVo : {}", boardVo);
		
		boardMapper.insertBoardInfo(boardVo);
		
		log.debug("boardVo : {}", boardVo);
		log.debug("boardVo : {}", boardVo);
		log.debug("boardVo : {}", boardVo);
		
		return  boardVo;
		/*	
 		*트랜잭션 테스트 한거라 주석!	 	
 		* boardMapper.insertBoardInfo(boardVo);
		boardMapper.insertBoardInfo(boardVo);
		boardMapper.insertBoardInfo(boardVo);
		boardMapper.insertBoardInfo(boardVo);
		
		//error
		String test = "말짜~";
		//강제 exception 발생
		int Str2Int = Integer.parseInt(test);
		
		boardMapper.insertBoardInfo(boardVo);
		boardMapper.insertBoardInfo(boardVo);
		boardMapper.insertBoardInfo(boardVo);
		boardMapper.insertBoardInfo(boardVo);
		boardMapper.insertBoardInfo(boardVo);
		*/
		
	}

	@Override
	public BoardVo selectBoardInfo(String seqNo) throws Exception {
		// TODO Auto-generated method stub
		//seqNo 값에 해당하는 조회수를 +1 증가 시킴!
		boardMapper.updateBoardInfoCnt(seqNo);
		//boardMapper.updateBoardInfoCnt(seqNo);
		
		//seqNo값에 해당하는 정보를 조회...
		BoardVo boardVo = boardMapper.selectBoardInfo(seqNo);
		
		return boardVo;
	}

	@Override
	public void deleteBoardInfo(HashMap<String, Object> params) throws Exception {
		// TODO Auto-generated method stub
		
		 boardMapper.deleteBoardInfo(params);
		
	}

	@Override
	public boolean updateBoardInfo(HashMap<String, Object> params) throws Exception {
		try {
			//true 면 변경 성공! 에러없으면!
			boardMapper.updateBoardInfo(params);
			return true;
		} catch (Exception e) {
			//false 면 변경 실패!  실패면 error 
			e.printStackTrace();
			return false;
		}

	}
	
	
}
