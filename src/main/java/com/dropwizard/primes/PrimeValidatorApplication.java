package com.dropwizard.primes;

import com.dropwizard.primes.health.PrimeApplicationHealthCheck;
import com.dropwizard.primes.resources.ForkJoinPoolRangeResource;
import com.dropwizard.primes.resources.ForkJoinPoolResource;
import com.dropwizard.primes.resources.SieveEratosthenesResource;
import com.dropwizard.primes.resources.TrialDivisionOptomisedResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class PrimeValidatorApplication extends Application<PrimeValidatorConfiguration> {
		    	    		
	private static final String CONFIGURATION_FILE = "prime.yml";

    public static void main(String[] args) throws Exception {
      new PrimeValidatorApplication().run(new String[]{"server", CONFIGURATION_FILE});
    }
    
    @Override
    public void initialize(Bootstrap<PrimeValidatorConfiguration> bootstrap) {                  
    }
       
    @Override
    public void run(PrimeValidatorConfiguration configuration, Environment environment) throws Exception { 
    	
    	final PrimeApplicationHealthCheck healthCheck =
    	        new PrimeApplicationHealthCheck(configuration.getDefaultCPUNumber(), configuration.getBatchNumber(),
    	        		configuration.getRangesSpreadMax());
    	    environment.healthChecks().register("template", healthCheck);
    	    
    	environment.jersey().register(new ForkJoinPoolRangeResource(configuration.getDefaultCPUNumber()));     
    	environment.jersey().register(new ForkJoinPoolResource(configuration.getDefaultCPUNumber()));     
    	environment.jersey().register(new SieveEratosthenesResource(configuration.getDefaultCPUNumber(), configuration.getRangesSpreadMax()));     
    	environment.jersey().register(new TrialDivisionOptomisedResource());     	
    }
}
