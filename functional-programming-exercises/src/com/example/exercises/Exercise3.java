package com.example.exercises;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.example.domain.Genre;
import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise3 {
	private static final MovieService movieService = InMemoryMovieService.getInstance();

	public static void main(String[] args) {
		var movies = movieService.findAllMovies();
        movies.stream() // Stream<Movie>
              .parallel()
              .map(Movie::getGenres)    // Stream<List<Genre>>
              .flatMap(List::stream)    // Stream<Genre>
              .map(Genre::getName)    // Stream<String>
              .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // Map<String,Long> 
              .forEach((genre,count) -> System.out.println("%16s: %-3d".formatted(genre,count)));

        movies.stream() // Stream<Movie>
              .map(Movie::getDirectors)
              .flatMap(List::stream)
              .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
              .forEach((director,count) -> System.out.println("%16s: %-3d".formatted(director.getName(),count)));
	}

}