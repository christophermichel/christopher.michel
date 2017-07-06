package br.com.crescer.social.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author christopher.michel
 */
@RestController
@RequestMapping("/map")
public class MapController {
    
    
    @GetMapping
    public String getMap() {
        RestTemplate restTemplate =  new RestTemplate();
        return  restTemplate.getForObject("https://maps.googleapis.com/maps/api/directions/json?origin=75+9th+Ave+New+York,+NY&destination=MetLife+Stadium+1+MetLife+Stadium+Dr+East+Rutherford,+NJ+07073&key=AIzaSyAaH-xsbg_stjsxt2ngJZ4gIsDKkDGDeZ8", String.class);
    }
    
}
