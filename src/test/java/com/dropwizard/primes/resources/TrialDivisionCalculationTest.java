package com.dropwizard.primes.resources;

import com.dropwizard.primes.core.TrialDivisionCalculation;

import junit.framework.TestCase;

public class TrialDivisionCalculationTest extends TestCase{

	
	public void testMin() {
		assertFalse(new TrialDivisionCalculation().isPrime(Integer.MIN_VALUE));
	}

	public void testIntegerMINVALUE() throws Exception {		
		TrialDivisionCalculation division = new TrialDivisionCalculation();		
		assertFalse(division.isPrime(Integer.MIN_VALUE));
	}
    
    public void testMinus1() throws Exception {		
		TrialDivisionCalculation division = new TrialDivisionCalculation();		
		assertFalse(division.isPrime(-1));		
	}
       
    public void test2() throws Exception {		
		TrialDivisionCalculation division = new TrialDivisionCalculation();		
		assertTrue(division.isPrime(2));		
	}	
    
    public void test3() throws Exception {		
		TrialDivisionCalculation division = new TrialDivisionCalculation();		
		assertTrue(division.isPrime(3));		
	}	
    
    public void test5() throws Exception {		
		TrialDivisionCalculation division = new TrialDivisionCalculation();		
		assertTrue(division.isPrime(5));		
	}	
    
    public void test7() throws Exception {		
		TrialDivisionCalculation division = new TrialDivisionCalculation();		
		assertTrue(division.isPrime(7));
		
	}	
    
	public void test100() throws Exception {		
		TrialDivisionCalculation division = new TrialDivisionCalculation();		
		assertFalse(division.isPrime(100));		
	}
	
	public void test101() throws Exception {		
		TrialDivisionCalculation division = new TrialDivisionCalculation();		
		assertTrue(division.isPrime(101));		
	}	
	
	public void test1001() throws Exception {		
		TrialDivisionCalculation division = new TrialDivisionCalculation();		
		assertFalse(division.isPrime(1001));		
	}
	
	public void test10001() throws Exception {
		TrialDivisionCalculation division = new TrialDivisionCalculation();		
		assertTrue(!division.isPrime(10001));
	}
	
	public void testIntegerMaxa() throws Exception {
		TrialDivisionCalculation division = new TrialDivisionCalculation();		
		assertTrue(division.isPrime(Integer.MAX_VALUE));
	}
	
	public void testIntegerMaxMinusOne() throws Exception {
		TrialDivisionCalculation division = new TrialDivisionCalculation();		
		assertFalse(division.isPrime(Integer.MAX_VALUE-1));
	}
	
	public void testIntegerMaxMinusTwo() throws Exception {
		TrialDivisionCalculation division = new TrialDivisionCalculation();		
		assertFalse(division.isPrime(Integer.MAX_VALUE-2));
	}
}
