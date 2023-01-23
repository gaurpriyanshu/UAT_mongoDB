package com.uat.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.uat.model.User;
import com.uat.repository.UserRepository;



@RestController
public class UserController {

	Optional<User> vr ;
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping("/findAllUsers")
	public List<User> getUsers()
	{
		Date current_date = new Date();
		Long Count = 0L;
		List<User> list = repository.findAll();
		List<User> ret = new ArrayList<>();
		for(User ls : list)
		{
			if(ls.getEndDate()!= null && ls.getEndDate().before(current_date))
			{
				Count++;
				System.out.println(ls);
				ret.add(ls);
			}
		}
		System.out.println("Count=" + Count);
		return ret;
	}
	
	@GetMapping("/findUser/{userId}")
	public Optional<User> getUser(@PathVariable String userId)
	{
		vr= repository.findById(userId);
		return vr;
	}
	
}
