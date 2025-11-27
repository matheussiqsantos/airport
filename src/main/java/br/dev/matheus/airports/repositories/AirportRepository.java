package br.dev.matheus.airports.repositories;

import br.dev.matheus.airports.entities.Airport;
import br.dev.matheus.airports.projections.AirportNearMeProjection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author DIT2B
 */
public interface AirportRepository extends JpaRepository<Airport, Long> {
    
    List<Airport> findByCityIgnoreCase(String city);
    List<Airport> findByCountryIgnoreCase(String country);
    
    Airport findByIataCode(String iataCode);
    
    @Query(nativeQuery = true, value = """
        SELECT
            airport.id,
            airport.name,
            airport.city,
            airport.iatacode,
            airport.latitude,
            airport.longitude,
            airport.altitude,
            SQRT(
                power(airport.latitude - -23.164400, 2 ) +
                power(airport.longitude - -45.896675, 2)) * 60 * 1.852 as distanciaKM
                                       
        from AIRPORT
        order by distanciaKM
        limit 10; """
    )                                   
    List<AirportNearMeProjection> findNearMe(double latOrigem, double lonOrigem);
}

