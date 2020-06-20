package com.xtranet.bhel.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "claim_process")
public class BPAFeeSettlementDTO implements Serializable, Comparable<BPAFeeSettlementDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Non Business primary key
	 */
	@Id
	@GenericGenerator(name="hiIncrement",strategy="increment")
	@GeneratedValue(generator="hiIncrement")
	@Column(name = "CP_CLAIM_ID", unique = true, nullable = false)
	protected int CP_CLAIM_ID;
	
	@Column(name = "CP_SID_NO")
	protected long CP_SID_NO;

	@Column(name = "CP_BPA_GRSS_FEE")
	protected double CP_BPA_GRSS_FEE;

	@Column(name = "CP_BPA_TAX_ON_BPAFEE")
	protected double CP_BPA_TAX_ON_BPAFEE;

	@Column(name = "CP_BPA_TDS_FEE")
	protected double CP_BPA_TDS_FEE;

	@Column(name = "CP_BPA_NET_FEE")
	protected double CP_BPA_NET_FEE;

	/**
	 * Accessor
	 */	

	public int getCP_CLAIM_ID() {
		return CP_CLAIM_ID;
	}

	public void setCP_CLAIM_ID(int cP_CLAIM_ID) {
		CP_CLAIM_ID = cP_CLAIM_ID;
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
	
	public int compareTo(BPAFeeSettlementDTO arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
