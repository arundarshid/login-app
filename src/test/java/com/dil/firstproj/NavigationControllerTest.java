package com.dil.firstproj;

import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.dil.firstproj.controller.NavigationController;
import com.dil.firstproj.service.NewsService;

public class NavigationControllerTest {
	
	@InjectMocks
	private NavigationController controller;
	
	@Mock
	private NewsService service;
	
	private MockMvc mockMvc;
	private Locale locale;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		locale = LocaleContextHolder.getLocale();
	}
	
	@Test
	public void getIndexPage_whenServiceReturnsEmpty_thenReturn() throws Exception {
		Mockito.when(service.getHomePage()).thenReturn("");
		
		mockMvc.perform(MockMvcRequestBuilders.get("/home").locale(locale))
		.andExpect(MockMvcResultMatchers.view().name("index"));
	}
}
