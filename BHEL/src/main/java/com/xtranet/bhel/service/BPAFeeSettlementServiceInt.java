package com.xtranet.bhel.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.xtranet.bhel.dto.BPAFeeSettlementDTO;

public interface BPAFeeSettlementServiceInt {
	
	public BPAFeeSettlementDTO findByClaimId(int pk);
	
    public BPAFeeSettlementDTO findBySid(long sid);
    
    public List search(BPAFeeSettlementDTO dto);
    
    public List sidsearch(BPAFeeSettlementDTO dto);
    
    public List sidPopUpSearch(long sid);

}
