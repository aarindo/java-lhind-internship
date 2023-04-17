package com.lhind.repository.impl;

import com.lhind.configuration.EntityManagerConfiguration;
import com.lhind.model.entity.Flight;
import com.lhind.repository.FlightRepository;
import com.lhind.util.Queries;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class FlightRepositoryImpl implements FlightRepository{
    private EntityManager entityManager = EntityManagerConfiguration.getEntityManager();

    @Override
    public List<Flight> findAll() {
        TypedQuery<Flight> result = entityManager.createQuery(Queries.FIND_ALL_FLIGHTS, Flight.class);
        return result.getResultList();
    }

    @Override
    public Optional<Flight> findById(Integer id) {
        return Optional.ofNullable(entityManager.find(Flight.class, id));
    }

    @Override
    public List<Flight> findByOrigin(String origin) {
        TypedQuery<Flight> result = entityManager.createQuery(Queries.FIND_FLIGHT_BY_ORIGIN, Flight.class);
        result.setParameter("origin", origin);
        return result.getResultList();
    }

    @Override
    public List<Flight> findByDestination(String destination) {
        TypedQuery<Flight> result = entityManager.createQuery(Queries.FIND_FLIGHT_BY_DESTINATION, Flight.class);
        result.setParameter("destination", destination);
        return result.getResultList();
    }

    @Override
    public List<Flight> findByAirline(String airline) {
        TypedQuery<Flight> result = entityManager.createQuery(Queries.FIND_FLIGHT_BY_AIRLINE, Flight.class);
        result.setParameter("airline", airline);
        return result.getResultList();
    }

    @Override
    public List<Flight> findByFlightNumber(String flight_number) {
        TypedQuery<Flight> result = entityManager.createQuery(Queries.FIND_FLIGHT_BY_FLIGHT_NUMBER, Flight.class);
        result.setParameter("flight_number", flight_number);
        return result.getResultList();
    }

    @Override
    public List<Flight> findByDepartureDate(String departure_date) {
        TypedQuery<Flight> result = entityManager.createQuery(Queries.FIND_FLIGHT_BY_DEPARTURE_DATE,
                Flight.class);
        result.setParameter("departure_date", departure_date);
        return result.getResultList();
    }

    @Override
    public List<Flight> findByArrivalDate(String arrival_date) {
        TypedQuery<Flight> result = entityManager.createQuery(Queries.FIND_FLIGHT_BY_ARRIVAL_DATE,
                Flight.class);
        result.setParameter("arrival_date", arrival_date);
        return result.getResultList();
    }

    @Override
    public void save(Flight flight) {
        entityManager.getTransaction().begin();
        if (flight.getId() != null) {
            findById(flight.getId()).ifPresent(existingEmployee -> {
                flight.setOrigin(flight.getOrigin());
                flight.setDestination(flight.getDestination());
                flight.setAirline(flight.getAirline());
                flight.setFlightNumber(flight.getFlightNumber());
                flight.setDepartureDate(flight.getDepartureDate());
                flight.setArrivalDate(flight.getArrivalDate());
                flight.setStatus(flight.getStatus());
            });
        } else {
            entityManager.persist(flight);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Flight flight) {
        if (flight.getId() != null){
            entityManager.getTransaction().begin();
            findById(flight.getId()).ifPresent(entityManager::remove);
            entityManager.getTransaction().commit();
        }
    }
}
