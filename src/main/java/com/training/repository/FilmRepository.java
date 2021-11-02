package com.training.repository;

import org.springframework.data.repository.CrudRepository;

import com.training.model.Film;

public interface FilmRepository extends CrudRepository<Film, Integer> {

}
