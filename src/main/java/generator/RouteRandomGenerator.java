package generator;

import airlines.entities.Airport;
import airlines.entities.Route;

public class RouteRandomGenerator implements RandomInfinityGenerator<Route> {

    private final RandomInfinityGenerator<Airport> airportGenerator;

    public RouteRandomGenerator() {
        this.airportGenerator = new AirportRandomGenerator();
    }

    @Override
    public Route next() {
        Airport from = airportGenerator.next();
        Airport to = from;
        to = airportGenerator.next();

        return new Route(from, to);
    }
}
