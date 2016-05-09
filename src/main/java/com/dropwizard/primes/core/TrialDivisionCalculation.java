package com.dropwizard.primes.core;

public class TrialDivisionCalculation {

	public boolean isPrime(long numberToCheck) {
		
		if(numberToCheck < 1)
			return false;
		
		if(numberToCheck == Integer.MAX_VALUE)
			return true;
		
		boolean isPrime = true;
		long sqr_root = (long) Math.sqrt(numberToCheck);

		for (long i = 2; i <= sqr_root; i++) {
			if (numberToCheck % i == 0) {
				isPrime = false;
			}
		}
		return isPrime;
	}
}
