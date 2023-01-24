package com.uat.scheduler;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ExpireScheduler {

	  private static final Logger LOGGER  = LoggerFactory.getLogger(ExpireScheduler.class);
	  
	  
	   @Scheduled(initialDelay = 10000,fixedDelay = 10000)
	    public void markExpired() {
	        
	        LOGGER.info("Subcription Expired: {}", new Date());
	        
	   }
}
