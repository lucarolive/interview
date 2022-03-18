package com.interview.test.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.interview.test.model.Currency;
import com.interview.test.model.Quote;

@Repository
public class ExchangeDAOImpl {

	public List<Quote> init() throws IOException{
		List<Quote> result = new ArrayList<Quote>();
	    BufferedReader br = new BufferedReader(new FileReader(new File("C:\\temp\\eurofxref-hist.csv")));
	    try {
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
	                quote.setListCurrency(new ArrayList<Currency>());
	                quote.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(items[0]));
	                for(int i = 1; i<items.length; i++) {
	                	Currency c = new Currency();
	                	c.setCurrency(currencyTitle[i]);
	                	c.setValue(items[i]);
	                	quote.getListCurrency().add(c);
	                }
	                result.add(quote);
	            } catch (ArrayIndexOutOfBoundsException|NumberFormatException|NullPointerException | ParseException e) {
	                // Caught errors indicate a problem with data format -> Print warning and continue
	                System.out.println("Invalid line: "+ line);
	            }
	        	
	        }
	        return result;
	    } finally {
	        br.close();
	    }
	}

}
