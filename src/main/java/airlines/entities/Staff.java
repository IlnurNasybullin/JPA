package airlines.entities;

import airlines.userTypes.StaffPosition;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Staff extends Person {

    @Column(name = "flight_hours", nullable = false)
    private Integer flightHours;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private StaffPosition position;

    private Staff() {
        super("");
    }

    public Staff(String passportID) {
        super(passportID);
    }

    public Integer getFlightHours() {
        return flightHours;
    }

    public StaffPosition getPosition() {
        return position;
    }

    public void setFlightHours(Integer flightHours) {
        if (flightHours < 0) {
            throw new IllegalArgumentException("Flight hours mustn't be less 0!");
        }
        this.flightHours = flightHours;
    }

    public void setPosition(StaffPosition position) {
        this.position = position;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Staff{");
        sb.append("\n\t").append("ID=").append(ID);
        sb.append("\n\tpassportID='").append(passportID).append('\'');
        sb.append("\n\tfullName=").append(fullName);
        sb.append("\n\taddress=").append(address);
        sb.append("\n\tphoneNumber='").append(phoneNumber).append('\'');
        sb.append("\n\tflightHours=").append(flightHours);
        sb.append("\n\tposition=").append(position);
        sb.append("\n").append('}');
        return sb.toString();
    }
}
