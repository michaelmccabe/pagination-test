package com.mic.document.service;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.mic.document.service.exceptions.RevenueException;

public class RevenueCalculatorTest {
	
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void testRevenue() throws Exception {
		
		BigDecimal revenue = RevenueCalculator.calculateRevenue(new BigDecimal("0.2"), new BigDecimal("400"));
		assertEquals(new BigDecimal("500.00"), revenue);
	}
	
	@Test
	public void testNegativeCostOfGoods() throws Exception {

		expectedException.expect(RevenueException.class);
		expectedException.expectMessage(containsString("Cost Of Goods must be greater than zero"));		
		
		RevenueCalculator.calculateRevenue(new BigDecimal("0.2"), new BigDecimal("-400"));
		
	}
	
	@Test
	public void testNegativePercentage() throws Exception {
		
		BigDecimal revenue = RevenueCalculator.calculateRevenue(new BigDecimal("-0.2"), new BigDecimal("400"));
		assertEquals(new BigDecimal("333.33"), revenue);		
		
	}
		
	@Test
	public void testZeroCostOfGoods() throws Exception {
		
		BigDecimal revenue = RevenueCalculator.calculateRevenue(new BigDecimal("0.2"), new BigDecimal("0.00"));
		assertEquals(new BigDecimal("0.00"), revenue);		
		
	}	
}
