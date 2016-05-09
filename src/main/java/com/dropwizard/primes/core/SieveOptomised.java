package com.dropwizard.primes.core;

public class SieveOptomised
{   
	public SieveOptomised(){}
		
	// A stripped down function. No collections just returning true if the number is prime.	
    public boolean sieve(int number)
    {    	
    	 if(number < 1)
         	return false;
    	 
    	// Fast even number test.
        if(number > 2 && (number & 1) == 0)
        	return false;
        
        if(number == 2 || number == 3 || number == 5)
        	return true;
        
        /*
         * If a number n is not a prime, it can be factored into two factors a and b: n = a*b
         * If both a and b were greater than the square root of n, a*b would be greater than n. 
         * So at least one of those factors must be less or equal to the square root of n, and 
         * to check if n is prime, we only need to test for factors less than or equal to the square root.
         */	 
        int step = 4;
        for(int i = 7; i <= Math.sqrt(number); i=i+(step=step==4?2:4)){        	
        	if (number % i == 0) 
        		return false;
        }
                
        return true;
    }
}
