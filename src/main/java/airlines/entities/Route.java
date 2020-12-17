package airlines.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"\"from\"", "\"to\""})})
public class Route {

    @Id
    @Column(name = "\"id\"")
    @GeneratedValue(strategy=GenerationType.SEQUENCE,
            generator="route_seq")
    @SequenceGenerator(name="route_seq",
            sequenceName="SEQ_ROUTE", allocationSize = 1)
    private Long ID;

    @ManyToOne
    @JoinColumn(name = "\"from\"", nullable = false, referencedColumnName = "ID")
    private final Airport from;

    @ManyToOne
    @JoinColumn(name = "\"to\"", nullable = false, referencedColumnName = "ID")
    private final Airport to;

    private Route() {
        this(null, null);
    }

    public static Route of(Airport from, Airport to) {
        checkAirports(from, to);
        return new Route(from, to);
    }

    private static void checkAirports(Airport from, Airport to) {
        if (Objects.isNull(from) || Objects.isNull(to) || Objects.equals(from, to)) {
            throw new IllegalArgumentException(String.format("Аэропорты указаны неверно! (%s, %s)", from, to));
        }
    }

    public Route(Airport from, Airport to) {
        this.from = from;
        this.to = to;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Airport getFrom() {
        return from;
    }

    public Airport getTo() {
        return to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return Objects.equals(ID, route.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Route{");
        sb.append("\n\t").append("ID=").append(ID);
        sb.append("\n\tfrom=").append(from);
        sb.append("\n\tto=").append(to);
        sb.append("\n").append('}');
        return sb.toString();
    }
}
