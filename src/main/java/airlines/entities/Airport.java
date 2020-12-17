package airlines.entities;

import airlines.userTypes.AirportICAO;
import airlines.userTypes.IATA;
import airlines.userTypes.geographic.GeographicPosition;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "airport")
public class Airport {

    @Id
    @Column(name = "\"id\"")
    @GeneratedValue(strategy=GenerationType.SEQUENCE,
            generator="airport_seq")
    @SequenceGenerator(name="airport_seq",
            sequenceName="SEQ_AIRPORT", allocationSize = 1)
    private Long ID;

    @Embedded
    private final AirportICAO icaoID;

    @Embedded
    private IATA iataID;

    @Column(nullable = false)
    @Embedded
    private GeographicPosition position;

    private Airport() {
        this(AirportICAO.DEFAULT);
    }

    public Airport(AirportICAO icaoID) {
        Objects.requireNonNull(icaoID);
        this.icaoID = icaoID;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public AirportICAO getIcaoID() {
        return icaoID;
    }

    public IATA getIataID() {
        return iataID;
    }

    public void setIataID(IATA iataID) {
        this.iataID = iataID;
    }

    public GeographicPosition getPosition() {
        return position;
    }

    public void setPosition(GeographicPosition position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Objects.equals(ID, airport.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Airport{");
        sb.append("\n\t").append("ID=").append(ID);
        sb.append("\n\ticaoID=").append(icaoID);
        sb.append("\n\tiataID=").append(iataID);
        sb.append("\n\tposition=").append(position);
        sb.append("\n").append('}');
        return sb.toString();
    }
}
