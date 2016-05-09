package com.dropwizard.primes.core;

public class SieveofEratosthenes
{   
	public SieveofEratosthenes(){}
	
    
    public boolean runEratosthenesSieve(int integerToCheck) {
    	
    	if(integerToCheck <= 1)
    		return false;
    	
    	// Cheat if Integer.Mav_Value, which is prime, then
    	//return true
    	if(integerToCheck == Integer.MAX_VALUE)
    		return true;
    	
    	 // initially assume all integers are prime
        boolean[] isPrime = new boolean[integerToCheck + 1];
        for (int i = 2; i <= integerToCheck; i++) {
            isPrime[i] = true;
        }

        // mark non-primes <= N using Sieve of Eratosthenes
        for (int i = 2; i*i <= integerToCheck; i++) {

            // if i is prime, then mark multiples of i as non-prime
            // suffices to consider multiples i, i+1, ..., N/i
            if (isPrime[i]) {
                for (int j = i; i*j <= integerToCheck; j++) {
                    isPrime[i*j] = false;
                }
            }
        }

        // Non sieve bit
        if (isPrime[integerToCheck]){
        	return true;
        }
        
		return false;
	}
}
