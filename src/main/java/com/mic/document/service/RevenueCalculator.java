package com.mic.document.service;

import java.math.BigDecimal;

import com.mic.document.service.exceptions.RevenueException;

public class RevenueCalculator {
	
	static BigDecimal calculateRevenue( BigDecimal marginPercentage, BigDecimal costOfGoods) throws RevenueException {
		
		// In business, the "margin" is calculated as the percentage difference between 
		// "revenue" and "cost of goods" (COGS), for example if costs are £400, and revenue 
		// is £500, then the margin is 20% (i.e. £100 is 20% of £500)	 

		if(costOfGoods.doubleValue()<0.0) {
			throw new RevenueException("Cost Of Goods must be greater than zero");
		}
		
		BigDecimal marginDiff = new BigDecimal(1.00).subtract(marginPercentage);
		BigDecimal revenue =  costOfGoods.divide(marginDiff,2, BigDecimal.ROUND_HALF_UP);
		
		return revenue ;
		
	}

}
