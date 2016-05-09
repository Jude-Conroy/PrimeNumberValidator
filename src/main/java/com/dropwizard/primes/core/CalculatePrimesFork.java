package com.dropwizard.primes.core;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RejectedExecutionException;

public class CalculatePrimesFork{

	private boolean isPrime;
	private ForkJoinPool forkJoinPool;
	
	public CalculatePrimesFork(int cpuCores){	
		forkJoinPool = new ForkJoinPool(cpuCores);		
	}
		
	public boolean IsPrime(int numberToCheck) {	

		isPrime = false;
		
		try{
			isPrime = forkJoinPool.submit(() -> new IntStreamCalculation().isPrime(numberToCheck)).get();	
		}
		catch(NullPointerException | RejectedExecutionException ex){
			System.out.println(ex.getMessage());
		} catch (InterruptedException | ExecutionException e) {
			System.out.println(e.getMessage());
		}
		finally{
			forkJoinPool.shutdown();
		}
		
		return isPrime;
	}	
}
