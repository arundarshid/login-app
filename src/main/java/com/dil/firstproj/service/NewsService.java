package com.dil.firstproj.service;

import java.util.List;

import com.dil.firstproj.model.Article;

public interface NewsService {
	
	public String getHomePage();
	public List<Article> getNews(String searchQuery, String sortBy);
	public List<Article> getNewHeadline(String country, String category);

}
