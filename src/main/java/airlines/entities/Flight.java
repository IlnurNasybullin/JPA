package airlines.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "flight")
public class Flight {

    @Id
    @Column(name = "\"id\"")
    @GeneratedValue(strategy=GenerationType.SEQUENCE,
            generator="flight_seq")
    @SequenceGenerator(name="flight_seq",
            sequenceName="SEQ_FLIGHT", allocationSize = 1)
    private Long ID;

    @ManyToOne
    @JoinColumn(nullable = false)
    private final Route route;

    @Column(name = "\"start\"", nullable = false)
    private LocalDateTime start;

    @Column(name = "\"end\"", nullable = false)
    private LocalDateTime end;

    @Column(name = "real_start_time", nullable = false)
    private LocalDateTime realStartTime;

    @Column(name = "real_end_time", nullable = false)
    private LocalDateTime realEndTime;

    @Column(nullable = false)
    private Boolean successful;

    @OneToOne
    @JoinColumn(name = "flight_passport", nullable = false)
    private FlightPassport flightPassport;

    @ManyToMany
    @JoinTable(name = "flight_to_plain_ticket")
    private final Set<PlainTicket> plainTickets;

    private Flight() {
        this(null);
    }

    public Flight(Route route) {
        this.route = route;
        this.plainTickets = new HashSet<>();
    }

    private static void checkData(LocalDateTime firstDateTime, LocalDateTime secondDateTime) {
        if (firstDateTime == null || secondDateTime == null || secondDateTime.isAfter(firstDateTime)) {
            return;
        }

        throw new IllegalArgumentException("Даты расположены не в хронологическом порядке!");
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Route getRoute() {
        return route;
    }

    public void setStart(LocalDateTime start) {
        checkData(start, end);
        this.start = start;
    }

    public void setEnd(LocalDateTime end) {
        checkData(start, end);
        this.end = end;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public LocalDateTime getRealStartTime() {
        return realStartTime;
    }

    public void setRealStartTime(LocalDateTime realStartTime) {
        checkData(realStartTime, realEndTime);
        this.realStartTime = realStartTime;
    }

    public LocalDateTime getRealEndTime() {
        return realEndTime;
    }

    public void setRealEndTime(LocalDateTime realEndTime) {
        checkData(realStartTime, realEndTime);
        this.realEndTime = realEndTime;
    }

    public Boolean getSuccessful() {
        return successful;
    }

    public void setSuccessful(Boolean successful) {
        this.successful = successful;
    }

    public FlightPassport getFlightPassport() {
        return flightPassport;
    }

    public void setFlightPassport(FlightPassport flightPassport) {
        this.flightPassport = flightPassport;
    }

    public boolean add(PlainTicket ticket) {
        return plainTickets.add(ticket);
    }

    public boolean addAll(Collection<? extends PlainTicket> tickets) {
        return plainTickets.addAll(tickets);
    }

    public boolean remove(PlainTicket ticket) {
        return plainTickets.remove(ticket);
    }

    public boolean removeAll(Collection<? extends PlainTicket> tickets) {
        return plainTickets.removeAll(tickets);
    }

    public Set<PlainTicket> getPlainTickets() {
        return Set.copyOf(this.plainTickets);
    }

    public void clearTickets() {
        plainTickets.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(ID, flight.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Flight{");
        sb.append("\n\t").append("ID=").append(ID);
        sb.append("\n\troute=").append(route);
        sb.append("\n\tstart=").append(start);
        sb.append("\n\tend=").append(end);
        sb.append("\n\trealStartTime=").append(realStartTime);
        sb.append("\n\trealEndTime=").append(realEndTime);
        sb.append("\n\tsuccessful=").append(successful);
        sb.append("\n\tflightPassport=").append(flightPassport);
        sb.append("\n\tplainTickets=").append(plainTickets);
        sb.append("\n").append('}');
        return sb.toString();
    }
}
