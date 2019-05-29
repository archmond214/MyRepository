package kr.or.nextit.scheduler.service;

public interface TestSchedulerService {

	/**
	 * 단순히 문자열 프린트 테스트...
	 * @throws Exception
	 */
	public void getTestPrint() throws Exception;
	
	
	
	/**
	 * 년 월 일 시 분 초 설정에 따라서 배치 서비스 구동...
	 * @throws Exception
	 */
	public void getCronPrint() throws Exception;
	
	
	public void setBoardCount() throws Exception;
	
	
}
