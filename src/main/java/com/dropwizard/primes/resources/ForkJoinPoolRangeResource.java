package com.dropwizard.primes.resources;

import java.util.concurrent.atomic.AtomicLong;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.dropwizard.primes.core.CalculatePrimesFork;
import com.dropwizard.primes.core.CalculatePrimesFork2;
import com.dropwizard.primes.core.PrimeNumber;

@Path("PrimesCount")
@Produces(MediaType.APPLICATION_JSON)
public class ForkJoinPoolRangeResource {
	
	private final AtomicLong counter;
	private final int cpus;
	    
    public ForkJoinPoolRangeResource(int cpus) {         
        this.counter = new AtomicLong(); 
        this.cpus = cpus;
    }

    @GET
    @Timed
    public PrimeNumber isThisNumberPrime(@QueryParam("start") @Min(1) @Max(2147483646) int start, @QueryParam("finish") @Min(2) @Max(2147483647) int finish) throws Exception {        
    	PrimeNumber primer = new PrimeNumber(counter.incrementAndGet());
    	primer.setPrimeCount(new CalculatePrimesFork2(cpus).IsPrimeNumber(start, finish)); 
    	primer.setIsPrime(primer.getPrimeCount() > 0); 
    	return primer;
    }   
}