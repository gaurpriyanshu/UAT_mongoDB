package com.sarvmai.subscriptionservice.cronjob;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sarvmai.subscriptionservice.domain.Subscription;
import com.sarvmai.subscriptionservice.repository.ISubscriptionRepository;

//import com.uat.schedular.Schedular;



@RestController
public class CronJob {

//	private static final Logger LOGGER  = LoggerFactory.getLogger(CronJob.class);
	
	
	
	@Autowired
	private ISubscriptionRepository repository;
	
	@GetMapping("/findAllUsers")
//	@Scheduled(cron = "0 * * * * *")
  @Scheduled(cron = "0 0 10 * * *")
	public List<String> getUsers()
	{
		LocalDateTime current_date = LocalDateTime.now();  
//		Long Count = 0L;
		List<Subscription> list = repository.findAll();
		List<String> ret = new ArrayList<>();
		for(Subscription ls : list)
		{
			LocalDateTime ls_date = ls.getEndDate();
			if(ls.getEndDate()!= null && ls_date.isBefore(current_date))
			{
//				Count++;
				ret.add(ls.getUserId());
			}
		}
//		System.out.println("Count=" + Count);
//		LOGGER.info("Subcription Expired for: {}",current_date);
		return ret;
	}
	
}
