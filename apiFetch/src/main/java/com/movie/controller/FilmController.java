package com.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movie.model.Film;
import com.movie.service.FilmService;

@RestController
public class FilmController {
	
	@Autowired
	private FilmService filmService;
	
	@GetMapping("/completed")
	public Object[] getAllCompletedFilms()
	{
		return filmService.findAllFilmsComplete();
	}
	@GetMapping("/all")
	public Film[] getFilms()
	{
		return filmService.findAllFilms();
	}
	@GetMapping("/title")
	public List<Film> getFilmsByTitle(@RequestParam("q")String title)
	{
		return filmService.findFilmsByTitle(title);
	}
	

}
