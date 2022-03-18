package com.interview.test.controller;

import java.util.Date;

import com.interview.test.model.Currency;
import com.interview.test.model.Quote;

public interface ExchangeController {
	
	Quote getQuote(String date);
	Double exchangeCurrency(Date date, String sourceCurrency, String targetCurrency, Double amount);
	Currency getHighestReference(Date startDate, Date endDate, String currency);
	Double getAverage(Date startDate, Date endDate, String currency);
}
