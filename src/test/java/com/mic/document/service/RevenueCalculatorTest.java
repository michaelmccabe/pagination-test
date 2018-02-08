package com.mic.document.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class RevenueCalculatorTest {

	@Test
	public void testRevenue() throws Exception {
		
		BigDecimal revenue = RevenueCalculator.calculateRevenue(new BigDecimal("0.2"), new BigDecimal("400"));
		assertEquals(new BigDecimal("500.00"), revenue);
	}
}
