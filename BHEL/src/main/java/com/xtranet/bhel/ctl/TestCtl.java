package com.xtranet.bhel.ctl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestCtl {
	
	@RequestMapping(value = "/testctl", method = RequestMethod.GET)
	public String display(Model model) {
		
		System.out.println("this is test Ctl Get");
		
		model.addAttribute("message", "Programmer Gate");

		return "TestView";
	}

}
