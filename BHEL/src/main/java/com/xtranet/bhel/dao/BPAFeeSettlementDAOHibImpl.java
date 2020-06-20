package com.xtranet.bhel.dao;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.BigDecimalType;
import org.hibernate.type.IntegerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.xtranet.bhel.dto.BPAFeeSettlementDTO;

@Repository("BPAFeeSettlementDAO")
public class BPAFeeSettlementDAOHibImpl implements BPAFeeSettlementDAOInt {

	@Autowired
	SessionFactory sessionFactory;

	public BPAFeeSettlementDTO findByClaimId(int pk) throws DataAccessException {
		BPAFeeSettlementDTO dto = null;
		dto = (BPAFeeSettlementDTO) sessionFactory.getCurrentSession().get(BPAFeeSettlementDTO.class, pk);
		return dto;
	}

	public BPAFeeSettlementDTO findBySid(long sid) throws DataAccessException {
		System.out.println("This is findByName method in College DAO Hibernate Implementation");
		BPAFeeSettlementDTO dto = null;
		List list = sessionFactory.getCurrentSession().createCriteria(BPAFeeSettlementDTO.class)
				.add(Restrictions.eq("CP_SID_NO", sid)).list();
		if (list.size() == 1) {
			dto = (BPAFeeSettlementDTO) list.get(0);
		}
		return dto;
	}

	public List search(BPAFeeSettlementDTO dto) throws DataAccessException {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(BPAFeeSettlementDTO.class);

		if (dto != null) {
			if (dto.getCP_CLAIM_ID() > 0) {
				criteria.add(Restrictions.eq("CP_CLAIM_ID", dto.getCP_CLAIM_ID()));
			}

			if (dto.getCP_SID_NO() > 0) {
				criteria.add(Restrictions.eq("CP_SID_NO", dto.getCP_SID_NO()));
			}

		}

		List list = criteria.list();

		return list;

	}

	public List sidsearch(BPAFeeSettlementDTO dto) throws DataAccessException {
		
		long sid = dto.getCP_SID_NO();
		System.out.println(dto.getCP_SID_NO());

		String queryscreen = "SELECT CP_SID_NO, COUNT(CP_CLAIM_ID) AS No_of_Claims, SUM(IFNULL(CP_BPA_GRSS_FEE,0)) AS totalGrssfee, SUM(IFNULL(CP_BPA_TAX_ON_BPAFEE,0)) AS totaltaxonbpafee , SUM(IFNULL(CP_BPA_TDS_FEE,0)) AS totalbpatdsfee,SUM(IFNULL(CP_BPA_NET_FEE,0)) AS totalbpanetfee FROM bhel.claim_process WHERE CP_SID_NO= IFNULL(:sidd_id,CP_SID_NO) GROUP BY CP_SID_NO";
		Query sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(queryscreen)
				.addScalar("No_of_Claims", new IntegerType()).addScalar("totalGrssfee", new BigDecimalType())
				.addScalar("totaltaxonbpafee", new BigDecimalType()).addScalar("totalbpatdsfee", new BigDecimalType())
				.addScalar("totalbpanetfee", new BigDecimalType()).setParameter("sidd_id", sid);

		List rows = sqlQuery.list();

		return rows;

	}

	public List sidPopUpSearch(long sid) throws DataAccessException {

		String queryscreen = "SELECT PD_RFRL_UNT,dm_div_name,CP_BILL_NO,CP_BILL_DATE,PD_PATIENT_NAME,CP_CLAIM_ID,CP_NET_CLAIM_AMT Hosp_claim_amt, CP_SANCTION_AMT aprv_amt,CP_BPA_GRSS_FEE gross_fee, CP_BPA_TAX_ON_BPAFEE tax,CP_BPA_TDS_FEE TDS,CP_BPA_NET_FEE net_fee FROM bhel.claim_process, bhel.patient_admission,bhel.patient_referral,bhel.patient_details LEFT JOIN bhel.division_master ON (dm_div_id=PD_RFRL_UNT) WHERE CP_SID_NO= :sidd_id AND PA_CLAIM_ID =CP_CLAIM_ID AND PD_REFERRAL_ID = PR_REFERRAL_ID AND PA_REFERRAL_ID = PD_REFERRAL_ID;";
		Query sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(queryscreen).setParameter("sidd_id", sid);

		List rows = sqlQuery.list();

		return rows;

	}

}
