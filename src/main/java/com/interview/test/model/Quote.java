package com.interview.test.model;

import java.util.Date;
import java.util.List;

public class Quote {
	private Date date;	
	private List<Currency> listCurrency;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<Currency> getListCurrency() {
		return listCurrency;
	}
	public void setListCurrency(List<Currency> listCurrency) {
		this.listCurrency = listCurrency;
	}
	
}
