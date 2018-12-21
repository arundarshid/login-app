package com.dil.firstproj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dil.firstproj.service.NewsService;

@Controller
public class NavigationController {

	@Autowired
	NewsService service;

	@GetMapping(value = "/")
	public String getIndexPage(Model model) {
		return "index";
	}
	
	@GetMapping(value = "/test")
	public String getvalues() {

		return service.getHomePage(); 

	}

	@GetMapping(value = "/news")
	public String getNews(@RequestParam("search") String searchQuery, Model model) {
		model.addAttribute("newsList", service.getNews(searchQuery, "publishedAt"));
		return "news";
	}
	
	@GetMapping(value = "/news/headline")
	public String getNewsHeadlines(@RequestParam("country") String country, Model model) {
		System.out.println("############### here");
		model.addAttribute("newsList", service.getNewHeadline(country, ""));
		return "news";
	}

}
