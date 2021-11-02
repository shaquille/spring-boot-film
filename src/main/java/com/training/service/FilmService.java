package com.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.model.Film;
import com.training.repository.ActeurRepository;
import com.training.repository.FilmRepository;

@Service
public class FilmService {

	@Autowired
	FilmRepository filmRepository;
	@Autowired
	ActeurRepository acteurRepository;
	
	//getting all Film records
//	public List<Film> getAllFilm() {
//		List<Film> films = new ArrayList<Film>();
//		filmRepository.findAll().forEach(film -> films.add(film));
//		return films;
//	}
	
	//getting a specific record
	public Film getFilmById(int id) {
		return filmRepository.findById(id).get();
	}
	
	@Transactional
	public void saveOrUpdate(Film film) {
//		Film f = filmRepository.save(film);
//		for(Acteur act : film.getActeurs()) {
//			act.setFilm(f);
//		}
		filmRepository.save(film);
		acteurRepository.saveAll(film.getActeurs());
	}
	
}
