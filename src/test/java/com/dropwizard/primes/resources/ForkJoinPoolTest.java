package com.dropwizard.primes.resources;

import com.dropwizard.primes.core.SieveofEratosthenes;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ForkJoinPoolTest extends TestCase{
	
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ForkJoinPoolTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ForkJoinPoolTest.class );
    }
    
    public void testIntegerMINVALUE() throws Exception {		
    	SieveofEratosthenes sieveOfEratosthenes = new SieveofEratosthenes();		
		assertFalse(sieveOfEratosthenes.runEratosthenesSieve(Integer.MIN_VALUE));
		
	}
    public void testMinus() throws Exception {		
		SieveofEratosthenes sieveOfEratosthenes = new SieveofEratosthenes();		
		assertFalse(sieveOfEratosthenes.runEratosthenesSieve(-1));
		
	}
    
    public void test2() throws Exception {		
    	SieveofEratosthenes sieveOfEratosthenes = new SieveofEratosthenes();		
		assertTrue(sieveOfEratosthenes.runEratosthenesSieve(2));
		
	}	
    
    public void test3() throws Exception {		
    	SieveofEratosthenes sieveOfEratosthenes = new SieveofEratosthenes();		
		assertTrue(sieveOfEratosthenes.runEratosthenesSieve(3));
		
	}	
    
    public void test5() throws Exception {		
    	SieveofEratosthenes sieveOfEratosthenes = new SieveofEratosthenes();		
		assertTrue(sieveOfEratosthenes.runEratosthenesSieve(5));
		
	}	
    
    public void test7() throws Exception {		
    	SieveofEratosthenes sieveOfEratosthenes = new SieveofEratosthenes();		
		assertTrue(sieveOfEratosthenes.runEratosthenesSieve(7));
		
	}	
    
	public void test100() throws Exception {		
		SieveofEratosthenes sieveOfEratosthenes = new SieveofEratosthenes();		
		assertFalse(sieveOfEratosthenes.runEratosthenesSieve(100));
		
	}
	
	public void test101() throws Exception {		
		SieveofEratosthenes sieveOfEratosthenes = new SieveofEratosthenes();		
		assertTrue(sieveOfEratosthenes.runEratosthenesSieve(101));
		
	}	
	
	public void test1001() throws Exception {		
		SieveofEratosthenes sieveOfEratosthenes = new SieveofEratosthenes();		
		assertFalse(sieveOfEratosthenes.runEratosthenesSieve(1001));
		
	}
	
	public void test10001() throws Exception {
		SieveofEratosthenes sieveOfEratosthenes = new SieveofEratosthenes();		
		assertTrue(!sieveOfEratosthenes.runEratosthenesSieve(10001));
	}
		
	//public void testIntegerMaxHalf() throws Exception {
	//	SieveofEratosthenes sieveOfEratosthenes = new SieveofEratosthenes();		
	//	assertFalse(sieveOfEratosthenes.runEratosthenesSieve(Integer.MAX_VALUE/2));
	//}
			
	public void testIntegerMax() throws Exception {
		SieveofEratosthenes sieveOfEratosthenes = new SieveofEratosthenes();		
		assertTrue(sieveOfEratosthenes.runEratosthenesSieve(Integer.MAX_VALUE));
	}
}
