package airlines.entities;

import javax.persistence.*;
import java.util.*;

@Entity(name = "flight_passport")
public class FlightPassport {

    @Id
    @Column(name = "\"id\"")
    @GeneratedValue(strategy=GenerationType.SEQUENCE,
            generator="flight_passport_seq")
    @SequenceGenerator(name="flight_passport_seq",
            sequenceName="SEQ_FLIGHT_PASSPORT", allocationSize = 1)
    private Long ID;

    @Column(name = "flight_passport_id", nullable = false, unique = true, length = 15)
    private final String flightPassportID;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Airplane airplane;

    @Column(name = "operated_company", nullable = false, length = 30)
    private String operatedCompany;

    @ManyToMany
    @JoinTable(name = "flight_passport_to_staff")
    private final Set<Staff> staffs;

    private FlightPassport() {
        this("");
    }

    public FlightPassport(String flightPassportID) {
        Objects.requireNonNull(flightPassportID);
        this.flightPassportID = flightPassportID;
        this.staffs = new HashSet<>();
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getFlightPassportID() {
        return flightPassportID;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public String getOperatedCompany() {
        return operatedCompany;
    }

    public List<Staff> getStaffs() {
        return new ArrayList<>(staffs);
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public void setOperatedCompany(String operatedCompany) {
        this.operatedCompany = operatedCompany;
    }

    public boolean addStaff(Staff staff) {
        return this.staffs.add(staff);
    }

    public boolean addStaffs(Collection<? extends Staff> staffs) {
        return this.staffs.addAll(staffs);
    }

    public boolean removeStaff(Staff staff) {
        return this.staffs.remove(staff);
    }

    public boolean removeStaffs(Collection<? extends Staff> staffs) {
        return this.staffs.removeAll(staffs);
    }

    public void clearStaffs() {
        this.staffs.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightPassport that = (FlightPassport) o;
        return Objects.equals(ID, that.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FlightPassport{");
        sb.append("\n\t").append("ID=").append(ID);
        sb.append("\n\tflightPassportID='").append(flightPassportID).append('\'');
        sb.append("\n\tairplane=").append(airplane);
        sb.append("\n\toperatedCompany='").append(operatedCompany).append('\'');
        sb.append("\n\tstaffs=").append(staffs);
        sb.append("\n").append('}');
        return sb.toString();
    }
}
