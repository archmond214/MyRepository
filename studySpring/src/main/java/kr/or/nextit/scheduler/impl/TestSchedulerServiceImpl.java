package kr.or.nextit.scheduler.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.nextit.board.service.BoardSearchVo;
import kr.or.nextit.board.service.BoardService;
import kr.or.nextit.board.service.BoardVo;
import kr.or.nextit.board.web.BoardController;
import kr.or.nextit.scheduler.service.TestSchedulerService;
@Service("TestSchedulerService")
public class TestSchedulerServiceImpl implements TestSchedulerService {
	
	private final Logger log =  LoggerFactory.getLogger(this.getClass());
	

	@Override
	public void getTestPrint() throws Exception {
		// TODO Auto-generated method stub
		log.debug("testPrint : {}" , "말짜 시스템 배치 서비스 구동~~~");
	}


	@Override
	public void getCronPrint() throws Exception {
		// TODO Auto-generated method stub
		log.debug("getCronPrint : {}" , "시분초년월일 서비스 구동~~~");
	}

	@Autowired
	private BoardService boardService;
	
	
	@Override
	public void setBoardCount() throws Exception {

		for(int i = 20 ; i <= 50 ; i++) {
			
			BoardVo boardVo = boardService.selectBoardInfo(String.format("%s",i));

			if(boardVo != null) {
				log.debug("title: {}",boardVo.getTitle());
				log.debug("title 조회수 : {}",boardVo.getReadCount());
			}
		}
		
		
	}
}
