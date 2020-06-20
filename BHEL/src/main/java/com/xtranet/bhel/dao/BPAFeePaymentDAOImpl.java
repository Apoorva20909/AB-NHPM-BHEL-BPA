package com.xtranet.bhel.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xtranet.bhel.dto.BPAFeePaymentDTO;

@Repository
public class BPAFeePaymentDAOImpl implements BPAFeePaymentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addEmployee(BPAFeePaymentDTO employee) {
		sessionFactory.getCurrentSession().saveOrUpdate(employee);

	}

}