package com.xtranet.bhel.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bpa_fee_stlmntt")
public class BPAFeePaymentDTO implements Serializable {

	private static final long serialVersionUID = -3465813074586302847L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bps_id;

	@Column(nullable = false)
	private long bps_sid_no;

	@Column(nullable = false)
	private BigDecimal bps_bpa_grss_fee;

	@Column(nullable = false)
	private BigDecimal bps_bpa_tax_on_bpafee;

	@Column(nullable = false)
	private BigDecimal bps_bpa_tds_fee;
	
	@Column(nullable = false)
	private BigDecimal bps_bpa_net_fee;

	@Column
	private Date bps_bpa_pymnt_dt;
	
	@Column
	private int bps_bpa_pymnt_md;

	@Column
	private String bps_bpa_pymnt_trnx;
	
	@Column
	private String bps_bpa_pymnt_rmrks;

	@Column
	private Date bps_bpa_rcv_dt;
	
	@Column
	private String bps_bpa_rcv_rmrks;
	
	@Column
	private Date bps_lstupdt_dt;
	
	@Column
	private String bps_lstupdt_usr;

	public long getBps_id() {
		return bps_id;
	}

	public void setBps_id(long bps_id) {
		this.bps_id = bps_id;
	}

	public long getBps_sid_no() {
		return bps_sid_no;
	}

	public void setBps_sid_no(long bps_sid_no) {
		this.bps_sid_no = bps_sid_no;
	}

	public BigDecimal getBps_bpa_grss_fee() {
		return bps_bpa_grss_fee;
	}

	public void setBps_bpa_grss_fee(BigDecimal bps_bpa_grss_fee) {
		this.bps_bpa_grss_fee = bps_bpa_grss_fee;
	}

	public BigDecimal getBps_bpa_tax_on_bpafee() {
		return bps_bpa_tax_on_bpafee;
	}

	public void setBps_bpa_tax_on_bpafee(BigDecimal bps_bpa_tax_on_bpafee) {
		this.bps_bpa_tax_on_bpafee = bps_bpa_tax_on_bpafee;
	}

	public BigDecimal getBps_bpa_tds_fee() {
		return bps_bpa_tds_fee;
	}

	public void setBps_bpa_tds_fee(BigDecimal bps_bpa_tds_fee) {
		this.bps_bpa_tds_fee = bps_bpa_tds_fee;
	}

	public BigDecimal getBps_bpa_net_fee() {
		return bps_bpa_net_fee;
	}

	public void setBps_bpa_net_fee(BigDecimal bps_bpa_net_fee) {
		this.bps_bpa_net_fee = bps_bpa_net_fee;
	}

	public Date getBps_bpa_pymnt_dt() {
		return bps_bpa_pymnt_dt;
	}

	public void setBps_bpa_pymnt_dt(Date bps_bpa_pymnt_dt) {
		this.bps_bpa_pymnt_dt = bps_bpa_pymnt_dt;
	}

	public int getBps_bpa_pymnt_md() {
		return bps_bpa_pymnt_md;
	}

	public void setBps_bpa_pymnt_md(int bps_bpa_pymnt_md) {
		this.bps_bpa_pymnt_md = bps_bpa_pymnt_md;
	}

	public String getBps_bpa_pymnt_trnx() {
		return bps_bpa_pymnt_trnx;
	}

	public void setBps_bpa_pymnt_trnx(String bps_bpa_pymnt_trnx) {
		this.bps_bpa_pymnt_trnx = bps_bpa_pymnt_trnx;
	}

	public String getBps_bpa_pymnt_rmrks() {
		return bps_bpa_pymnt_rmrks;
	}

	public void setBps_bpa_pymnt_rmrks(String bps_bpa_pymnt_rmrks) {
		this.bps_bpa_pymnt_rmrks = bps_bpa_pymnt_rmrks;
	}

	public Date getBps_bpa_rcv_dt() {
		return bps_bpa_rcv_dt;
	}

	public void setBps_bpa_rcv_dt(Date bps_bpa_rcv_dt) {
		this.bps_bpa_rcv_dt = bps_bpa_rcv_dt;
	}

	public String getBps_bpa_rcv_rmrks() {
		return bps_bpa_rcv_rmrks;
	}

	public void setBps_bpa_rcv_rmrks(String bps_bpa_rcv_rmrks) {
		this.bps_bpa_rcv_rmrks = bps_bpa_rcv_rmrks;
	}

	public Date getBps_lstupdt_dt() {
		return bps_lstupdt_dt;
	}

	public void setBps_lstupdt_dt(Date bps_lstupdt_dt) {
		this.bps_lstupdt_dt = bps_lstupdt_dt;
	}

	public String getBps_lstupdt_usr() {
		return bps_lstupdt_usr;
	}

	public void setBps_lstupdt_usr(String bps_lstupdt_usr) {
		this.bps_lstupdt_usr = bps_lstupdt_usr;
	}
	
}