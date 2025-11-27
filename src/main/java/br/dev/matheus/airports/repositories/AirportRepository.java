package br.dev.matheus.airports.repositories;

import br.dev.matheus.airports.entities.Airport;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author DIT2B
 */
public interface AirportRepository extends JpaRepository<Airport, Long> {
    
    List<Airport> findByCityIgnoreCase(String city);
    
}
