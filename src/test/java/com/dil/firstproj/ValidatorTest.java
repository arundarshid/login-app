package com.dil.firstproj;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.dil.firstproj.controller.Validator;
import com.dil.firstproj.service.FakeNewsService;

public class ValidatorTest {
	@InjectMocks
	private Validator validator;
	
	@Mock
	private FakeNewsService fakeservice;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void validate_whenEmptyValue_ThenReturnEmpty() {
		Mockito.when(fakeservice.getHomePage()).thenReturn("");
		MatcherAssert.assertThat(validator.validateInput(""), Matchers.equalTo(""));
	}
}
