package com.xtranet.bhel.ctl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xtranet.bhel.dto.BPAFeePaymentDTO;
import com.xtranet.bhel.dto.BPAFeeSettlementDTO;
import com.xtranet.bhel.service.BPAFeePaymentService;
import com.xtranet.bhel.service.BPAFeeSettlementServiceInt;


@Controller
public class BPAFeePaymentCtl {

	private static final Logger logger = Logger
			.getLogger(BPAFeePaymentCtl.class);

	public BPAFeePaymentCtl() {
		System.out.println("BPAFeePaymentCtl()");
	}

	@Autowired
	private BPAFeePaymentService employeeService;
	
	@Autowired
	private BPAFeeSettlementServiceInt service;
	
	@RequestMapping(value = "/BPAFeePayment/newEmployee/{sid}", method = RequestMethod.GET)
	public String newContactpath(@PathVariable int sid, ModelMap model) {
		BPAFeePaymentDTO employee = new BPAFeePaymentDTO();
		model.addAttribute("employee", employee);
		
		// Get search attributes
		BPAFeeSettlementDTO dto = new BPAFeeSettlementDTO();
		
		System.out.println("sid : "+(long)sid);
		
		long sidd=(long)sid;
		dto.setCP_SID_NO(sidd);
		
		List rows = service.sidsearch(dto);
		
		System.out.println("Sid = "+dto.getCP_SID_NO());
		
		Iterator it=rows.iterator();
		Object[] columns;
		
		while(it.hasNext()){
		 columns = (Object[])it.next();
		 
		 Integer No_of_Claims = (Integer) columns[0];
		 BigDecimal totalGrssfee = (BigDecimal) columns[1];
		 BigDecimal totaltaxonbpafee = (BigDecimal) columns[2];
		 BigDecimal totalbpatdsfee = (BigDecimal) columns[3];
		 BigDecimal totalbpanetfee = (BigDecimal) columns[4];
		 
		 model.addAttribute("CP_SID_NO", dto.getCP_SID_NO());
		 model.addAttribute("No_of_Claims", No_of_Claims);
		 model.addAttribute("totalGrssfee", totalGrssfee);
		 model.addAttribute("totaltaxonbpafee", totaltaxonbpafee);
		 model.addAttribute("totalbpatdsfee", totalbpatdsfee);
		 model.addAttribute("totalbpanetfee", totalbpanetfee);
		 
		}
		
		return "BPAFeeSidPaymentScr";
	}

	@RequestMapping(value = "/BPAFeePayment/newEmployee/saveEmployee", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute BPAFeePaymentDTO employee, Model model) {
		if (employee.getBps_id() == 0) { // if employee id is 0 then creating the
			// employee other updating the employee
			employeeService.addEmployee(employee);
		}
		return "redirect:/ctl/BPAFeeSettlement/search";
	}

}