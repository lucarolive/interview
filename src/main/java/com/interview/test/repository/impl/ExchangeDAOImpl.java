package com.interview.test.repository.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.interview.test.domain.Currency;
import com.interview.test.domain.Quote;
import com.interview.test.repository.ExchangeDAO;

@Repository
public class ExchangeDAOImpl implements ExchangeDAO{

	private final Logger logger = LoggerFactory.getLogger(ExchangeDAOImpl.class);
	
	public List<Quote> getAll(){
		List<Quote> result = new ArrayList<Quote>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File("C:\\temp\\eurofxref-hist.csv")));
	        // Read first line
	    	String line;
	        String[] currencyTitle = br.readLine().split(",");
	        // Run through following lines
	        while ((line = br.readLine()) != null) {
	            // Break line into entries using comma
	            String[] items = line.split(",");
	            try {
	                // Convert data to person record
	                Quote quote = new Quote();
	                quote.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(items[0]));
	                List<Currency> list = new ArrayList<Currency>();
	                for(int i = 1; i<items.length; i++) {
	                	Currency c = new Currency();
	                	c.setName(currencyTitle[i]);
	                	c.setValue(items[i]);
	                	list.add(c);
	                }
	                quote.setListCurrency(list);
	                result.add(quote);
	                br.close();
	            } catch (ArrayIndexOutOfBoundsException|NumberFormatException|NullPointerException | ParseException e) {
	                // Caught errors indicate a problem with data format -> Print warning and continue
	                System.out.println("Invalid line: "+ line);
	            }
	        	
	        }
	        return result;
	    } catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
	    }
		return result;
	}

}
