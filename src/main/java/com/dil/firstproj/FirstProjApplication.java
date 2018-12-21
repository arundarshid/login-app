package com.dil.firstproj;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.dil.firstproj.service.NewsService;

@SpringBootApplication
@EnableScheduling
public class FirstProjApplication {
	
	@Autowired
	private NewsService service;

	public static void main(String[] args) {
		SpringApplication.run(FirstProjApplication.class, args);
	}
	
	/*@Scheduled(initialDelay = 1000, fixedRate = 1000)
	public String run() {
		System.out.println("Current time is :: " + Calendar.getInstance().getTime());
		service.someRestCall();
		return "actual implementaion";
	}*/
}
