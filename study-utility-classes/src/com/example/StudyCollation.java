package com.example;

import java.text.Collator;
import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.ArrayList;
import java.util.Locale;

public class StudyCollation {

	public static void main(String[] args) throws ParseException {
		var name1 = "müller";
		var name2 = "mueller";
		System.out.println(name1.equals(name2));
		var names = new ArrayList<String>();
		names.add("şule");	
		names.add("şima");	
		names.add("sema");	
		names.add("ayşegül");	
		names.add("zehra");	
		names.add("ali");	
		names.add("veli");
		System.out.println(names);
		names.sort(String::compareTo);
		System.out.println(names);
		// şule == schule
		System.out.println("şule".equals("schule"));
		// şima == shema
		System.out.println("şima".equals("shema"));
		String basicRules=  "< z < b < c < ç < d < e < f < g < ğ < h "+
		        "< ı < i < j < k < l < m < n < o < ö < p "+
		       "< r < s < ş < t < u < ü < v < y < a ";
		String trExpension= "& şi ; she & ş ; sch & s ; ş & u ; ü & i ; ı " + 
		                    "& c ; ç & o ; ö & ğ ; g" ;
		final Collator collator= new RuleBasedCollator(basicRules + trExpension);
		Collator.getInstance(new Locale("tr","TR"));
		collator.setStrength(Collator.PRIMARY);
		System.out.println(collator.equals("şule","schule"));
		System.out.println(collator.equals("şima","shema"));
		names.sort(collator::compare);
		System.out.println(names);
	}

}
