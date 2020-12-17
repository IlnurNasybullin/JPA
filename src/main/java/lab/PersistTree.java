package lab;

import airlines.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Set;

public class PersistTree {

    private final EntityManager manager;

    public PersistTree(EntityManager manager, EntityTransaction transaction) {
        this.manager = manager;
    }


    public void persist(Flight flight) {
        persist(flight.getFlightPassport());
        persist(flight.getRoute());
        persist(flight.getPlainTickets());
        manager.persist(flight);
    }

    private void persist(Set<PlainTicket> plainTickets) {
        for (PlainTicket plainTicket: plainTickets) {
            persist(plainTicket);
        }
    }

    private void persist(PlainTicket plainTicket) {
        persist(plainTicket.getPassenger());
        manager.persist(plainTicket);
    }

    private void persist(Passenger passenger) {
        manager.persist(passenger);
    }

    private void persist(Route route) {
        persist(route.getFrom());
        persist(route.getTo());
        manager.persist(route);
    }

    private void persist(Airport airport) {
        manager.persist(airport);
    }

    private void persist(FlightPassport flightPassport) {
        persist(flightPassport.getAirplane());
        persist(flightPassport.getStaffs());
        manager.persist(flightPassport);
    }

    private void persist(List<Staff> staffs) {
        for (Staff staff: staffs) {
            persist(staff);
        }
    }

    private void persist(Staff staff) {
        manager.persist(staff);
    }

    private void persist(Airplane airplane) {
        persist(airplane.getTechnicalPassport());
        manager.persist(airplane);
    }

    private void persist(TechnicalPassport technicalPassport) {
        manager.persist(technicalPassport);
    }
}
