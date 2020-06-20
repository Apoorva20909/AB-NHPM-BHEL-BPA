package com.xtranet.bhel.ctl;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xtranet.bhel.dto.BPAFeeSettlementDTO;
import com.xtranet.bhel.form.BPAFeeSettlementForm;
import com.xtranet.bhel.service.BPAFeeSettlementServiceInt;

@Controller
@RequestMapping(value = "/ctl/BPAFeeSettlement")
public class BPAFeeSettlementCtl {
	
	protected static final String OP_SEARCH = "Search";
	protected static final String OP_RESET = "Reset";
	protected static final String OP_SUBMIT = "Submit";
	
	@Autowired
	private BPAFeeSettlementServiceInt service;
	
	@RequestMapping(value = "/sidno", method = RequestMethod.GET)
	public String sidScreen(@RequestParam(required = false) Long sid, 
			 Model model, HttpServletRequest request) {
	
		List rows = service.sidPopUpSearch(sid);
		
		model.addAttribute("list", rows);
		
		return "BPAFeeSidNoView";
	}
	
	@RequestMapping(value = "/paymentdetail", method = RequestMethod.GET)
	public String paymentScreen(Model model) {
		
		
		return "BPAFeeSidPaymentScr";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchList(@ModelAttribute("form") BPAFeeSettlementForm form, Model model) {
		
		BPAFeeSettlementDTO dto = (BPAFeeSettlementDTO) form.getDto();
		
		List rows = service.sidsearch(dto);
		long sid = dto.getCP_SID_NO();
		System.out.println("Sid = "+dto.getCP_SID_NO());
		
		return "BPAFeeSettlementView";
	}
	
	@RequestMapping(value = "/search", method = { RequestMethod.POST })
	public String searchList(@RequestParam(required = false) String operation, 
			@ModelAttribute("form") @Valid BPAFeeSettlementForm form, BindingResult bindingResult,
			Model model) {
		
		System.out.println("Operation : "+operation);
		

		if (OP_RESET.equalsIgnoreCase(operation)) {
			System.out.println("We receive Reset Operation");
			 return "/BPAFeeSettlementView";
		}
		
		if (OP_SUBMIT.equalsIgnoreCase(operation)) {
			 System.out.println("We receive Submit Operation");
			 return "/BPAFeePayment/newEmployee";
		}
		
		// Get search attributes
		BPAFeeSettlementDTO dto = (BPAFeeSettlementDTO) form.getDto();
		long sid = dto.getCP_SID_NO();
		System.out.println("Sid = "+dto.getCP_SID_NO());
		if(sid==0){
			model.addAttribute("message", "Please Enter Valid Sid");
		}
		
		
				
		List rows = service.sidsearch(dto);
		
		
		Iterator it=rows.iterator();
		Object[] columns;
		
		while(it.hasNext()){
		 columns = (Object[])it.next();
		 
		 Integer No_of_Claims = (Integer) columns[0];
		 BigDecimal totalGrssfee = (BigDecimal) columns[1];
		 BigDecimal totaltaxonbpafee = (BigDecimal) columns[2];
		 BigDecimal totalbpatdsfee = (BigDecimal) columns[3];
		 BigDecimal totalbpanetfee = (BigDecimal) columns[4];
		 
		 System.out.println(No_of_Claims+"\t"+totalGrssfee+"\t"+totaltaxonbpafee
				 +"\t"+totalbpatdsfee+"\t"+totalbpanetfee);
		 
		 model.addAttribute("CP_SID_NO", dto.getCP_SID_NO());
		 model.addAttribute("No_of_Claims", No_of_Claims);
		 model.addAttribute("totalGrssfee", totalGrssfee);
		 model.addAttribute("totaltaxonbpafee", totaltaxonbpafee);
		 model.addAttribute("totalbpatdsfee", totalbpatdsfee);
		 model.addAttribute("totalbpanetfee", totalbpanetfee);
		 
		}

		model.addAttribute("list", rows);
		
		return "BPAFeeSettlementView";
	}
	
}
