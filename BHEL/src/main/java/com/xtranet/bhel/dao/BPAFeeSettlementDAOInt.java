package com.xtranet.bhel.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.xtranet.bhel.dto.BPAFeeSettlementDTO;

public interface BPAFeeSettlementDAOInt {
	
	public BPAFeeSettlementDTO findByClaimId(int pk) throws DataAccessException;	

	public BPAFeeSettlementDTO findBySid(long sid) throws DataAccessException;
	
	public List search(BPAFeeSettlementDTO dto) throws DataAccessException;
	
	public List sidsearch(BPAFeeSettlementDTO dto) throws DataAccessException;
	
	public List sidPopUpSearch(long sid) throws DataAccessException;

}
