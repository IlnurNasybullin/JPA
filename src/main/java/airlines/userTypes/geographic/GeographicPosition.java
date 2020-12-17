package airlines.userTypes.geographic;

import airlines.userTypes.metrics.Length;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Transient;
import java.io.Serializable;
import java.time.ZoneId;
import java.util.Objects;

@Embeddable
public class GeographicPosition implements Serializable {

    @Transient
    private final GeographicCoordinates coordinates;

    @Transient
    private ZoneId timeZone;

    @Column(nullable = false, length = 30)
    private String country;

    @Column(nullable = false, length = 30)
    private String city;

    @Transient
    private Length altitude;

    private GeographicPosition() {
        this(GeographicCoordinates.DEFAULT);
    }

    public GeographicPosition(GeographicCoordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public GeographicCoordinates getCoordinates() {
        return coordinates;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public Length getAltitude() {
        return altitude;
    }

    public void setAltitude(Length altitude) {
        this.altitude = altitude;
    }

    public ZoneId getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(ZoneId timeZone) {
        this.timeZone = timeZone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeographicPosition position = (GeographicPosition) o;
        return Objects.equals(coordinates, position.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(coordinates);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GeographicPosition{");
        sb.append("\n\t").append("coordinates=").append(coordinates);
        sb.append("\n\ttimeZone=").append(timeZone);
        sb.append("\n\tcountry='").append(country).append('\'');
        sb.append("\n\tcity='").append(city).append('\'');
        sb.append("\n\taltitude=").append(altitude);
        sb.append("\n").append('}');
        return sb.toString();
    }
}
