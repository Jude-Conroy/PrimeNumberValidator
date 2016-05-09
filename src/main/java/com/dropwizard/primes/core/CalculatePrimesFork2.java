package com.dropwizard.primes.core;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RejectedExecutionException;

public class CalculatePrimesFork2{

	private int primeCount;
	private ForkJoinPool forkJoinPool;
		
	public CalculatePrimesFork2(int cpuCores){	
		forkJoinPool = new ForkJoinPool(cpuCores);		
	}
		
	public int IsPrimeNumber(int numberStart, int numberEnd) throws InterruptedException, ExecutionException	{		
				
		try{
			primeCount = forkJoinPool.submit(() -> new IntStreamCalculation().countPrimes(numberStart, numberEnd)).get();
		}
		catch(NullPointerException | RejectedExecutionException ex){
			return 0;
		} catch (InterruptedException | ExecutionException e) {
			return 0;
		}
		finally{
			forkJoinPool.shutdown();
		}		
		return primeCount;
	}
}
