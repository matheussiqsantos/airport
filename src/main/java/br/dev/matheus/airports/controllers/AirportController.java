package br.dev.matheus.airports.controllers;

import br.dev.matheus.airports.entities.Airport;
import br.dev.matheus.airports.service.AirportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DIT2B
 */

@RestController
public class AirportController 
{
    
    @Autowired
    private AirportService airportService;
    
    @GetMapping("/airport")
    public List<Airport> findAll() 
    {
        
        List<Airport> result = airportService.findAll();
        return result;
    }
    
}
