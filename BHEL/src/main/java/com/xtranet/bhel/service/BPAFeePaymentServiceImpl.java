package com.xtranet.bhel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xtranet.bhel.dao.BPAFeePaymentDAO;
import com.xtranet.bhel.dto.BPAFeePaymentDTO;

@Service
@Transactional
public class BPAFeePaymentServiceImpl implements BPAFeePaymentService {

	@Autowired
	private BPAFeePaymentDAO employeeDAO;

	@Transactional
	public void addEmployee(BPAFeePaymentDTO employee) {
		employeeDAO.addEmployee(employee);
	}

	public void setEmployeeDAO(BPAFeePaymentDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

}
