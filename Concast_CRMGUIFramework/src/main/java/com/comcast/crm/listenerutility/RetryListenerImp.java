package com.comcast.crm.listenerutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListenerImp implements IRetryAnalyzer{

	int count=0;
	int limitcount=4;
	@Override
	public boolean retry(ITestResult result) {
		if(count<limitcount)
		{
			count++;
		return true;
	}
     return false;
	
}
}