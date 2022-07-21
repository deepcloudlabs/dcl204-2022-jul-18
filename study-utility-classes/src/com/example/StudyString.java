package com.example;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.ResourceBundle;

public class StudyString {

	public static void main(String[] args) {
		System.setProperty("user.language", "tr"); // ISO2
		System.setProperty("user.country", "TR");
		System.getenv().forEach((key,value) -> System.out.println("%s: %s".formatted(key,value)));
		System.getProperties().forEach((key,value) -> System.out.println("%s: %s".formatted(key,value)));
		String city = "izmir";
		Locale tr_TR= new Locale("tr", "TR");
		System.out.println(city.toUpperCase(tr_TR));
		
		var now = ZonedDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
				                                 .withLocale(Locale.GERMAN);
		System.out.println(dtf.format(now));
		
		double money = 12_345.67;
		DecimalFormat df = (DecimalFormat) DecimalFormat.getCurrencyInstance(Locale.CHINA);
		System.out.println(df.format(money));
		
		String fullname= "Jack Bauer";
		var resourceBundle= ResourceBundle.getBundle("messages",Locale.US);
		var helloTemplate = resourceBundle.getString("hello");
		var formatter = new MessageFormat(helloTemplate, tr_TR);
		
		System.out.println(formatter.format(new Object[] {fullname}));
	}

}
