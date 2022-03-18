package com.interview.test.controller.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.test.model.Currency;
import com.interview.test.model.Quote;
import com.interview.test.service.ExchangeService;

@RestController
@RequestMapping(path = "/exchange")
public class ExchangeControllerImpl implements com.interview.test.controller.ExchangeController{

	private ExchangeService exchangeService;
	
	public ExchangeControllerImpl(ExchangeService exchangeService) {
		super();
		this.exchangeService = exchangeService;
	}

	@Override
	@GetMapping(path = "/allquotes/{date}")
	public Quote getQuote(@PathVariable("date") String date) {
		Date d = null;
		try {
			d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exchangeService.getQuote(d);
	}

	@Override
	@GetMapping(path = "/convert")
	public Double exchangeCurrency(Date date, String sourceCurrency, String targetCurrency, Double amount) {
		// TODO Auto-generated method stub
		return null;
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
