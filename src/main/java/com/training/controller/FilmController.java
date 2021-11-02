package com.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.model.Film;
import com.training.service.FilmService;

@RestController
public class FilmController {

	//autowiring the FilmService class
	@Autowired
	FilmService filmService;

//	//creating a get mapping that retrieves all the films detail from the database 
//	@GetMapping("/film")
//	private List<Film> getAllFilm() {
//		return filmService.getAllFilm();
//	}

	//creating a get mapping that retrieves the detail of a specific film
	@GetMapping("/api/film/{id}")
	private Film getFilm(@PathVariable("id") int id) {
		return filmService.getFilmById(id);
	}

	//creating post mapping that post the film detail in the database
	@PostMapping("/api/film")
	private Film saveFilm(@RequestBody Film film) {
		filmService.saveOrUpdate(film);
		return film;
	}
	
}
