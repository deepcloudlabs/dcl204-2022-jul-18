package com.example.exercises;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.example.dao.CityDao;
import com.example.dao.CountryDao;
import com.example.dao.InMemoryWorldDao;
import com.example.domain.City;
import com.example.domain.Country;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise2 {
	private static final CountryDao countryDao = InMemoryWorldDao.getInstance();
	private static final CityDao cityDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Find the most populated city of each continent
		var highPopulatedCityOfEachContinent = 
				countryDao.findAllCountries()
				          .stream()
				          .map( country -> country.getCities().stream().map(city -> new ContinentCityPair(country.getContinent(),city)).toList())
				          .flatMap(Collection::stream)
				          .collect(Collectors.groupingBy(ContinentCityPair::continent,Collectors.maxBy( ContinentCityPair::compareTo )));
		highPopulatedCityOfEachContinent.forEach(ContinentCityPair::printEntry);

		var countries = countryDao.findAllCountries();
		var continents =    // Lazy Evaluation
		countries.stream() // Stream<Country>
		         .map( Country::getContinent ) // Stream<String>
		         .distinct() // Stream<String>
		         .sorted() // Stream<String>
		         .toList(); // List<String>
		System.out.println(continents);
		var maxPopulatedCapital = // Optional<City>
		countries.stream()                     // Stream<Country> 
		         .map( Country::getCapital )   // Stream<Integer> // intermediary methods
		         .map( cityDao::findCityById ) // Stream<City>    // intermediary methods
		         .filter( Objects::nonNull )   // Stream<City>    // intermediary methods
		                                                          // terminal method
		         .max(Comparator.comparing(City::getPopulation));
		maxPopulatedCapital.ifPresent(System.out::println);
		var maxPopulatedCity = // Optional<City>
		countries.stream()                     // Stream<Country> 
		         .map(Country::getCities)      // Stream<List<City>>
		         .flatMap(List::stream)        // Stream<City> 
		         .max(Comparator.comparing(City::getPopulation));
		maxPopulatedCity.ifPresent(System.out::println);
		 
		countries.stream()                     // Stream<Country> 
				 .collect(Collectors.groupingBy(Country::getContinent,Collectors.maxBy(Comparator.comparing(Country::getPopulation))))
				 .forEach((continent,country) -> System.out.println("%s: %s".formatted(continent,country.get())));
	}
}