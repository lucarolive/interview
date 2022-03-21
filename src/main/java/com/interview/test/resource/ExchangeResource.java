package com.interview.test.resource;

import java.util.Date;

import com.interview.test.domain.Currency;
import com.interview.test.domain.Quote;

public interface ExchangeResource {
	
	Quote getQuote(Date date);
	Double exchangeCurrency(Date date, String sourceCurrency, String targetCurrency, Double amount);
	Currency getHighestReference(Date startDate, Date endDate, String currency);
	Double getAverage(Date startDate, Date endDate, String currency);
}
