package com.interview.test.resource.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.test.domain.Currency;
import com.interview.test.domain.Quote;
import com.interview.test.resource.ExchangeResource;
import com.interview.test.service.ExchangeService;

@RestController
@RequestMapping(path = "/exchange")
public class ExchangeResourceImpl implements ExchangeResource{

	@Autowired
	private ExchangeService exchangeService;
	
	@Override
	@GetMapping(path = "/allquotes")
	public Quote getQuote(Date date) {
		return exchangeService.getQuote(date);
	}

	@Override
	@GetMapping(path = "/convert")
	public Double exchangeCurrency(Date date, String sourceCurrency, String targetCurrency, Double amount) {
		return exchangeService.exchangeCurrency(date, sourceCurrency, targetCurrency, amount);
	}

	@Override
	@GetMapping(path = "/highest")
	public Currency getHighestReference(Date startDate, Date endDate, String currency) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping(path = "/average")
	public Double getAverage(Date startDate, Date endDate, String currency) {
		// TODO Auto-generated method stub
		return null;
	}


}
