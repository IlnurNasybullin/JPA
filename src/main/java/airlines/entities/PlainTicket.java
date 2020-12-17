package airlines.entities;

import airlines.userTypes.TicketType;
import org.hibernate.annotations.Check;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class PlainTicket {

    @Id
    @Column(name = "\"id\"")
    @GeneratedValue(strategy=GenerationType.SEQUENCE,
            generator="plain_ticket_seq")
    @SequenceGenerator(name="plain_ticket_seq",
            sequenceName="SEQ_PLAIN_TICKET", allocationSize = 1)
    private Long ID;

    @Column(name = "ticket_id", nullable = false, unique = true, length = 15)
    private final String ticketID;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private TicketType ticketType;

    @Column(nullable = false, precision = 7, scale = 2)
    private Double cost;

    @Column(nullable = false, length = 5)
    private String place;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Passenger passenger;

    private PlainTicket() {
        this("");
    }

    public PlainTicket(String ticketID) {
        this.ticketID = ticketID;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public String getTicketID() {
        return ticketID;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public Double getCost() {
        return cost;
    }

    public String getPlace() {
        return place;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlainTicket that = (PlainTicket) o;
        return Objects.equals(ID, that.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PlainTicket{");
        sb.append("\n\t").append("ID=").append(ID);
        sb.append("\n\tticketID='").append(ticketID).append('\'');
        sb.append("\n\tticketType=").append(ticketType);
        sb.append("\n\tcost=").append(cost);
        sb.append("\n\tplace='").append(place).append('\'');
        sb.append("\n\tpassenger=").append(passenger);
        sb.append("\n").append('}');
        return sb.toString();
    }
}
