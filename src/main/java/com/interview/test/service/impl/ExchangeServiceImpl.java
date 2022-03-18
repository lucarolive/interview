package com.interview.test.service.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;

import com.interview.test.dao.impl.ExchangeDAOImpl;
import com.interview.test.model.Currency;
import com.interview.test.model.Quote;
import com.interview.test.service.ExchangeService;

@Service
public class ExchangeServiceImpl implements ExchangeService{

	private ExchangeDAOImpl exchangeDAO;
	
	public ExchangeServiceImpl(ExchangeDAOImpl exchangeDAO) {
		super();
		this.exchangeDAO = exchangeDAO;
	}

	public static Predicate<Quote> isDateEqual(Date date) {
        return p -> p.getDate().compareTo(date) == 0;
    }
	
	@Override
	public Quote getQuote(Date date) {
		try {
			List<Quote> list = exchangeDAO.init();
			Optional<Quote> nova = null;
			try {
				nova = list.stream().filter(isDateEqual(date))
				.findFirst();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return nova.get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Double exchangeCurrency(Date date, String sourceCurrency, String targetCurrency, Double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Currency getHighestReference(Date startDate, Date endDate, String currency) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getAverage(Date startDate, Date endDate, String currency) {
		// TODO Auto-generated method stub
		return null;
	}

}
