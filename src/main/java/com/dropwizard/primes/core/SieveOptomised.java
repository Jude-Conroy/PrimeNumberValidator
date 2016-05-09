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
        
        int step = 4;
        for(int i = 7; i <= Math.sqrt(number); i=i+(step=step==4?2:4)){        	
        	if (number % i == 0) 
        		return false;
        }
                
        return true;
    }
}
