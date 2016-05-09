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
import com.dropwizard.primes.core.PrimeNumber;


@Path("PrimesFork")
@Produces(MediaType.APPLICATION_JSON)
public class ForkJoinPoolResource {
	
	private final AtomicLong counter;
	private final int cpus;
	    
    public ForkJoinPoolResource(int cpus) {         
        this.counter = new AtomicLong(); 
        this.cpus = cpus;
    }

    @GET
    @Timed
    public PrimeNumber isThisNumberPrime(@QueryParam("integerToCheck") @Min(1) @Max(2147483647) int integerToCheck) throws Exception {        
    	PrimeNumber primer = new PrimeNumber(counter.incrementAndGet());
    	primer.setIsPrime(new CalculatePrimesFork(cpus).IsPrime(integerToCheck)); 
    	primer.setPrimeCount(primer.getIsPrime() ? 1 : 0); 
    	return primer;
    }   
}