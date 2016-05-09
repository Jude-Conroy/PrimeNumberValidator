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
import com.dropwizard.primes.core.PrimeNumber;
import com.dropwizard.primes.core.SieveOptomised;

@Path("TrialDivision")
@Produces(MediaType.APPLICATION_JSON)
public class TrialDivisionOptomisedResource {
	
	private final AtomicLong counter;
    
    public TrialDivisionOptomisedResource() {         
        this.counter = new AtomicLong();  
    }

    @GET
    @Timed
    public PrimeNumber isNumberPrime(@QueryParam("integerToCheck") @Min(1) @Max(2147483647) int integerToCheck) throws Exception {        
          	   	
    	PrimeNumber primer = new PrimeNumber(counter.incrementAndGet());
    	primer.setIsPrime(new SieveOptomised().sieve(integerToCheck));     	
    	primer.setPrimeCount(primer.getIsPrime() ? 1 : 0);    
    	    	
    	return primer;
    }   
}