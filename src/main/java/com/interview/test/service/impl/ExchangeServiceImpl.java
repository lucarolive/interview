package com.interview.test.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;

import com.interview.test.domain.Currency;
import com.interview.test.domain.Quote;
import com.interview.test.repository.impl.ExchangeDAOImpl;
import com.interview.test.service.ExchangeService;

@Service
public class ExchangeServiceImpl implements ExchangeService{

	@Autowired
	private ExchangeDAOImpl exchangeDAO;

	private static Predicate<Quote> isDateEqual(Date date) {
        return p -> p.getDate().compareTo(date) == 0;
    }
	
	@Override
	public Quote getQuote(Date date) {
		List<Quote> list = exchangeDAO.getAll();
		Optional<Quote> quota = null;
		try {
			quota = list.stream().filter(isDateEqual(date))
			.findFirst();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return quota.get();
	}

	@Override
	public Double exchangeCurrency(Date date, String sourceCurrency, String targetCurrency, Double amount) {
		Quote quote = getQuote(date);
		Currency sourceC = null;
		Currency targetC = null;
		for(Currency cur : quote.getListCurrency()) {
			if(cur.getName().equals(sourceCurrency))
				sourceC = cur;
			if(cur.getName().equals(targetCurrency))
				targetC = cur;
		}
		Double result;
		if(sourceC.getValue().equals("N/A") || targetC.getValue().equals("N/A"))
			//throw Exception
			result = null;
		else
			result = Double.valueOf(sourceC.getValue())/Double.valueOf(targetC.getValue())*amount;
		return result;
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
	
	public Double getAverage2(Date startDate, Date endDate, String currency) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Double getAverage3(Date startDate, Date endDate, String currency) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Double getAverage4(Date startDate, Date endDate, String currency) {
		// TODO Auto-generated method stub
		return null;
	}

}
