package com.dropwizard.primes.resources;

import com.dropwizard.primes.core.SieveOptomised;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SieveOptomisedTest extends TestCase{
	
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SieveOptomisedTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SieveOptomisedTest.class );
    }
    
    public void testIntegerMINVALUE() throws Exception {		
		SieveOptomised sieve = new SieveOptomised();		
		assertFalse(sieve.sieve(Integer.MIN_VALUE));
		
	}
    
    public void testMinus1() throws Exception {		
		SieveOptomised sieve = new SieveOptomised();		
		assertFalse(sieve.sieve(-1));
		
	}
       
    public void test2() throws Exception {		
		SieveOptomised sieve = new SieveOptomised();		
		assertTrue(sieve.sieve(2));
		
	}	
    
    public void test3() throws Exception {		
		SieveOptomised sieve = new SieveOptomised();		
		assertTrue(sieve.sieve(3));
		
	}	
    
    public void test5() throws Exception {		
		SieveOptomised sieve = new SieveOptomised();		
		assertTrue(sieve.sieve(5));
		
	}	
    
    public void test7() throws Exception {		
		SieveOptomised sieve = new SieveOptomised();		
		assertTrue(sieve.sieve(7));
		
	}	
    
	public void test100() throws Exception {		
		SieveOptomised sieve = new SieveOptomised();		
		assertFalse(sieve.sieve(100));
		
	}
	
	public void test101() throws Exception {		
		SieveOptomised sieve = new SieveOptomised();		
		assertTrue(sieve.sieve(101));
		
	}	
	
	public void test1001() throws Exception {		
		SieveOptomised sieve = new SieveOptomised();		
		assertFalse(sieve.sieve(1001));
		
	}
	
	public void test10001() throws Exception {
		SieveOptomised sieve = new SieveOptomised();		
		assertTrue(!sieve.sieve(10001));
	}
	
	public void testIntegerMaxa() throws Exception {
		SieveOptomised sieve = new SieveOptomised();		
		assertTrue(sieve.sieve(Integer.MAX_VALUE));
	}
	
	public void testIntegerMaxMinusOne() throws Exception {
		SieveOptomised sieve = new SieveOptomised();		
		assertFalse(sieve.sieve(Integer.MAX_VALUE-1));
	}
	
	public void testIntegerMaxMinusTwo() throws Exception {
		SieveOptomised sieve = new SieveOptomised();		
		assertFalse(sieve.sieve(Integer.MAX_VALUE-2));
	}
}
