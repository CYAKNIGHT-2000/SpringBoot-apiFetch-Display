package com.movie.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.movie.model.Film;

@Service
public class FilmService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Object[] findAllFilmsComplete() {
		
		return restTemplate.getForObject("https://ghibliapi.herokuapp.com/films", Object[].class);
	}
    public Film[] findAllFilms() {
		
		return restTemplate.getForObject("https://ghibliapi.herokuapp.com/films", Film[].class);
	}
    
    public List<Film> findFilmsByTitle(String title){
    	List<Film>filmList= new ArrayList<>();
    	Film[] forObject = restTemplate.getForObject("https://ghibliapi.herokuapp.com/films",Film[].class);
    	for(int i=0 ; i< forObject.length;i++)
    	{
    		Film film = forObject[i];
    		String englishTitle = film.getTitle().toLowerCase();
    		String romanTitle= film.getOriginal_title_romanised().toLowerCase();
    		if(englishTitle.contains(title.toLowerCase())|| romanTitle.contains(title.toLowerCase())) {
    			filmList.add(film);
    		}
    	}
    	return filmList;
    }
   
}
