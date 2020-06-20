package com.xtranet.bhel.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xtranet.bhel.dto.BPAFeeSettlementDTO;
import com.xtranet.bhel.form.BPAFeeSettlementForm;
import com.xtranet.bhel.service.BPAFeeSettlementServiceInt;

@RestController
@RequestMapping(value = "/rest/BPAFeeSettlement")
public class BPAFeeSettlementRestWs {

	@Autowired
	private BPAFeeSettlementServiceInt service;

	@RequestMapping(value = "/{pk}", method = RequestMethod.GET)
	@ResponseBody
	public BPAFeeSettlementDTO get(@PathVariable int pk) {
		return service.findByClaimId(pk);
	}		

	@RequestMapping(value = "/sid/{sid}", method = RequestMethod.GET)
	@ResponseBody
	public BPAFeeSettlementDTO getbysid(@PathVariable long sid) {
		BPAFeeSettlementDTO dto = service.findBySid(sid);
		return dto;
	}	

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@ResponseBody
	public List Search(BPAFeeSettlementForm form) {
		BPAFeeSettlementDTO dto = (BPAFeeSettlementDTO) form.getDto();
		return service.search(dto);
	}
	
	@RequestMapping(value = "/sidsearch", method = RequestMethod.GET)
	@ResponseBody
	public List SidSearch(BPAFeeSettlementForm form) {
		BPAFeeSettlementDTO dto = (BPAFeeSettlementDTO) form.getDto();
		return service.sidsearch(dto);
	}

}
