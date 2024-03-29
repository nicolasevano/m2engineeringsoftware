package com.sodifrance.referential_book;

import java.text.SimpleDateFormat;
import java.util.Date;
 
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateXmlFormater extends XmlAdapter<String, Date> {
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	 
    @Override
    public String marshal(Date date) throws Exception {
        return dateFormat.format(date);
    }
 
    @Override
    public Date unmarshal(String date) throws Exception {
        return dateFormat.parse(date);
    }
    
}
