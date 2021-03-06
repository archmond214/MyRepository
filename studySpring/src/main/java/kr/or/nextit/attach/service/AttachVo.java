package kr.or.nextit.attach.service;

import org.apache.commons.lang3.builder.ToStringBuilder;


public class AttachVo {

	private String groupSeqNo         ;
	private String seqNo               ;
	private String serviceType         ;
	private String fileName            ;
	private String fileDownCnt        ;
	private String savePath            ;
	private String saveName            ;
	private String saveContentType    ;
	private long saveSize            ;
	private String usrIp               ;
	private String delAt               ;
	private String regUser             ;
	private String regDt				;
	
	@Override
	public String toString() {

		return ToStringBuilder.reflectionToString(this);
	}

	public String getGroupSeqNo() {
		return groupSeqNo;
	}

	public void setGroupSeqNo(String groupSeqNo) {
		this.groupSeqNo = groupSeqNo;
	}

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileDownCnt() {
		return fileDownCnt;
	}

	public void setFileDownCnt(String fileDownCnt) {
		this.fileDownCnt = fileDownCnt;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}

	public String getSaveContentType() {
		return saveContentType;
	}

	public void setSaveContentType(String saveContentType) {
		this.saveContentType = saveContentType;
	}



	public String getUsrIp() {
		return usrIp;
	}

	public void setUsrIp(String usrIp) {
		this.usrIp = usrIp;
	}

	public String getDelAt() {
		return delAt;
	}

	public void setDelAt(String delAt) {
		this.delAt = delAt;
	}

	public String getRegUser() {
		return regUser;
	}

	public void setRegUser(String regUser) {
		this.regUser = regUser;
	}

	public String getRegDt() {
		return regDt;
	}

	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	public long getSaveSize() {
		return saveSize;
	}

	public void setSaveSize(long saveSize) {
		this.saveSize = saveSize;
	}
	
	
}
