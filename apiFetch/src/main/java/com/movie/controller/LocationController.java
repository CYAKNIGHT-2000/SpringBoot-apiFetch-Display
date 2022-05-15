package com.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movie.model.location;
import com.movie.service.LocationService;

@RestController
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	@GetMapping("/locations")
	public Object[] findAllLocations()
	{
		return locationService.getAllLocations();
	}
	@GetMapping("/terrain")
	public List<location> findAllLocationsByTerrain(@RequestParam("k")String terrain)
	{
		return locationService.getAllLocationsByTerrain(terrain);
	}


}
