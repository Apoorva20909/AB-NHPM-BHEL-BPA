package com.xtranet.bhel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xtranet.bhel.dao.BPAFeeSettlementDAOInt;
import com.xtranet.bhel.dto.BPAFeeSettlementDTO;

@Service("BPAFeeSettlementService")
public class BPAFeeSettlementServiceSprImpl implements BPAFeeSettlementServiceInt{

	@Autowired
	private BPAFeeSettlementDAOInt dao;

	@Transactional(readOnly = true)
	public BPAFeeSettlementDTO findByClaimId(int pk) {
		System.out.println("This is findByClaimId method in BPAFeeSettlementService Implementation");
		return dao.findByClaimId(pk);
	}

	@Transactional(readOnly = true)
	public BPAFeeSettlementDTO findBySid(long sid) {
		System.out.println("This is findBySid method in BPAFeeSettlementService Implementation");
		BPAFeeSettlementDTO dto = dao.findBySid(sid);
		return dto;
	}

	@Transactional(readOnly = true)
	public List search(BPAFeeSettlementDTO dto) {
		System.out.println("This is Search method in BPAFeeSettlementService Implementation");
		return dao.search(dto);
	}

	@Transactional(readOnly = true)
	public List sidsearch(BPAFeeSettlementDTO dto) {
		return dao.sidsearch(dto);
	}

	@Transactional(readOnly = true)
	public List sidPopUpSearch(long sid) {
		return dao.sidPopUpSearch(sid);
	}
	
}
