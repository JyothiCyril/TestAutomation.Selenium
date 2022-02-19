package com.qa.testNGDemo;

import org.testng.annotations.Test;

public class TC_FundTransfer_001 extends TestBase{
	
	@Test(priority=1)
	public void fundTransferIMPS() {
		System.out.println("steps to do IMPS FundTransfer");		
	}

	@Test(priority=2)
	public void fundTransferNEFT() {
		System.out.println("steps to do NEFT FundTransfer");		
	}

	@Test(priority=3)
	public void fundTransferInternational() {
		System.out.println("steps to do international FundTransfer");		
	}

}
