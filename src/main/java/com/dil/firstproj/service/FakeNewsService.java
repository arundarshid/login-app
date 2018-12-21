package com.dil.firstproj.service;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.dil.firstproj.model.Article;

@Service
@Profile("mock")
public class FakeNewsService implements NewsService {

	@Override
	public List<Article> getNews(String searchQuery, String sortBy) {
		System.out.println("##### Fake");
		return null;
	}

	@Override
	public String getHomePage() {
		return "fake implementaion";
	}

	@Override
	public List<Article> getNewHeadline(String country, String category) {
		// TODO Auto-generated method stub
		return null;
	}

}
