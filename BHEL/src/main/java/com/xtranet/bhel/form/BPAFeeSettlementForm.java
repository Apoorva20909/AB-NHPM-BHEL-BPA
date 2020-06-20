package com.xtranet.bhel.form;

import javax.persistence.Column;
import javax.servlet.http.HttpSession;

import com.xtranet.bhel.dto.BPAFeeSettlementDTO;

public class BPAFeeSettlementForm {

	/**
	 * Contains non-business primary key
	 */
	protected int CP_CLAIM_ID;

	protected int[] CP_CLAIM_IDS;

	private int pageNo = 1;

	private int pageSize = 5;

	private String operation;

	protected long CP_SID_NO;

	protected double CP_BPA_GRSS_FEE;

	protected double CP_BPA_TAX_ON_BPAFEE;

	protected double CP_BPA_TDS_FEE;

	protected double CP_BPA_NET_FEE;

	/**
	 * accessor
	 */

	public int getCP_CLAIM_ID() {
		return CP_CLAIM_ID;
	}

	public void setCP_CLAIM_ID(int cP_CLAIM_ID) {
		CP_CLAIM_ID = cP_CLAIM_ID;
	}

	public int[] getCP_CLAIM_IDS() {
		return CP_CLAIM_IDS;
	}

	public void setCP_CLAIM_IDS(int[] cP_CLAIM_IDS) {
		CP_CLAIM_IDS = cP_CLAIM_IDS;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public long getCP_SID_NO() {
		return CP_SID_NO;
	}

	public void setCP_SID_NO(long cP_SID_NO) {
		CP_SID_NO = cP_SID_NO;
	}

	public double getCP_BPA_GRSS_FEE() {
		return CP_BPA_GRSS_FEE;
	}

	public void setCP_BPA_GRSS_FEE(double cP_BPA_GRSS_FEE) {
		CP_BPA_GRSS_FEE = cP_BPA_GRSS_FEE;
	}

	public double getCP_BPA_TAX_ON_BPAFEE() {
		return CP_BPA_TAX_ON_BPAFEE;
	}

	public void setCP_BPA_TAX_ON_BPAFEE(double cP_BPA_TAX_ON_BPAFEE) {
		CP_BPA_TAX_ON_BPAFEE = cP_BPA_TAX_ON_BPAFEE;
	}

	public double getCP_BPA_TDS_FEE() {
		return CP_BPA_TDS_FEE;
	}

	public void setCP_BPA_TDS_FEE(double cP_BPA_TDS_FEE) {
		CP_BPA_TDS_FEE = cP_BPA_TDS_FEE;
	}

	public double getCP_BPA_NET_FEE() {
		return CP_BPA_NET_FEE;
	}

	public void setCP_BPA_NET_FEE(double cP_BPA_NET_FEE) {
		CP_BPA_NET_FEE = cP_BPA_NET_FEE;
	}
	
	public BPAFeeSettlementDTO getDto() {

		BPAFeeSettlementDTO dto = new BPAFeeSettlementDTO();
		
		dto.setCP_CLAIM_ID(CP_CLAIM_ID);
		dto.setCP_SID_NO(CP_SID_NO);
		dto.setCP_BPA_GRSS_FEE(CP_BPA_GRSS_FEE);
		dto.setCP_BPA_TAX_ON_BPAFEE(CP_BPA_TAX_ON_BPAFEE);
		dto.setCP_BPA_TDS_FEE(CP_BPA_TDS_FEE);
		dto.setCP_BPA_NET_FEE(CP_BPA_NET_FEE);

		return dto;
	}

	/**
	 * Populate from from dto
	 */
	public void populate(BPAFeeSettlementDTO bDto) {

		BPAFeeSettlementDTO dto = (BPAFeeSettlementDTO) bDto;
		CP_CLAIM_ID = dto.getCP_CLAIM_ID();
		CP_SID_NO = dto.getCP_SID_NO();
		CP_BPA_GRSS_FEE = dto.getCP_BPA_GRSS_FEE();
		CP_BPA_TDS_FEE = dto.getCP_BPA_TDS_FEE();
		CP_BPA_TAX_ON_BPAFEE = dto.getCP_BPA_TAX_ON_BPAFEE();
		CP_BPA_NET_FEE = dto.getCP_BPA_NET_FEE();

	}

}
