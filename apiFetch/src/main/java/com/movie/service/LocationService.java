package com.movie.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.movie.model.location;


@Service
public class LocationService {
	@Autowired
	private RestTemplate restTemplate;
    public Object[] getAllLocations() {
		
		return restTemplate.getForObject("https://ghibliapi.herokuapp.com/locations", Object[].class);
	}
    public List<location> getAllLocationsByTerrain(String terrain){
    	List<location>terrainList= new ArrayList<>();
    	location[] forObject = restTemplate.getForObject("https://ghibliapi.herokuapp.com/locations",location[].class);
    	for(int i=0 ; i< forObject.length;i++)
    	{
    	    location Location = forObject[i];
    		String locTerrain = Location.getTerrain().toLowerCase();
    		if(locTerrain.contains(terrain.toLowerCase())) {
    			terrainList.add(Location);
    		}
    	}
    	return terrainList;
    }
   

}
