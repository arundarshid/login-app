package com.dil.firstproj.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.dil.firstproj.service.FakeNewsService;

public class Validator {
	
	@Autowired
	private FakeNewsService fakeservice;

	public String validateInput(String input) {
		if(StringUtils.isNotBlank(input)) {
			fakeservice.getHomePage();
			return input;
		}
		return "";
	}

}
