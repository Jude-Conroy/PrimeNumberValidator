package com.dropwizard.primes.core;

import java.util.List;
import java.util.stream.Collectors;
import static java.util.stream.IntStream.*;


public class IntStreamCalculation {

	public IntStreamCalculation() {
	}

	public List<Integer> collectPrimes(int max){		
		return range(2, max).parallel().filter(this::isPrime).boxed().collect(Collectors.toList());
	}
	
	public int countPrimes(int min, int max){
		
		int primeCount = 0;
		
		if(Integer.MAX_VALUE == max)
		{
			primeCount++;
			max=max-1;
		}
		
		primeCount+= (int) range(min, max).parallel().filter(this::isPrime).count();
		
		return primeCount;
	}
	
	public boolean isPrime(int n){
		return n > 1 && rangeClosed(2, (int) Math.sqrt(n)).noneMatch(divisor -> n % divisor == 0);	
	}
}
