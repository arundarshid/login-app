package com.dil.firstproj.service;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.dil.firstproj.model.Article;
import com.dil.firstproj.model.NewsApiResponse;

@Service
@Profile("!mock")
public class NewsServiceImpl implements NewsService {


	private final RestTemplate restTemplate;

	public NewsServiceImpl(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	@Override
	public List<Article> getNews(String searchQuery, String sortBy) {
		System.out.println("##### actual");
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("https://newsapi.org/v2/everything")
				.queryParam("q", searchQuery)
				.queryParam("sortBy", sortBy)
				.queryParam("apiKey", "817965a9cc984e9fac30b53d6d1d37bb");
		System.out.println("### URL : "+builder.build().encode().toString());
		NewsApiResponse response = this.restTemplate.getForObject(builder.build().encode().toString(), NewsApiResponse.class);
		
		System.out.println("#####"+response.getStatus()+response.getTotalResults());
		return response.getArticles();
	}
	
	@Override
	public List<Article> getNewHeadline(String country, String category) {
		System.out.println("##### actual");
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("https://newsapi.org/v2/top-headlines")
				.queryParam("country", country)
				//.queryParam("category", category)
				.queryParam("apiKey", "817965a9cc984e9fac30b53d6d1d37bb");
		System.out.println("### URL : "+builder.build().encode().toString());
		NewsApiResponse response = this.restTemplate.getForObject(builder.build().encode().toString(), NewsApiResponse.class);
		
		System.out.println("#####"+response.getStatus()+response.getTotalResults());
		return response.getArticles();
	}
	
	
	
	@Override
	public String getHomePage() {
		return "actual implementaion";
	}


}
