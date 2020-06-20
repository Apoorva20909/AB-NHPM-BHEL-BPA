package in.co.test;

import com.xtranet.bhel.dto.BPAFeeSettlementDTO;
import com.xtranet.bhel.service.BPAFeeSettlementServiceSprImpl;

public class test {
	
	public static void main(String[] args) {
		
		BPAFeeSettlementServiceSprImpl service = new BPAFeeSettlementServiceSprImpl();
		BPAFeeSettlementDTO dto =  service.findBySid(25);
		System.out.println(dto.getCP_BPA_TAX_ON_BPAFEE());
			
	}

}
