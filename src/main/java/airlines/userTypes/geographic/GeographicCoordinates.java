package airlines.userTypes.geographic;

import java.io.Serializable;
import java.util.Objects;

public class GeographicCoordinates implements Serializable {

    private final Latitude latitude;

    private final Longitude longitude;

    public static final GeographicCoordinates DEFAULT = new GeographicCoordinates();

    private GeographicCoordinates() {
        this(Latitude.DEFAULT, Longitude.DEFAULT);
    }

    public GeographicCoordinates(Latitude latitude, Longitude longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Latitude getLatitude() {
        return latitude;
    }

    public Longitude getLongitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeographicCoordinates that = (GeographicCoordinates) o;
        return Objects.equals(latitude, that.latitude) &&
                Objects.equals(longitude, that.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }

    @Override
    public String toString() {
        return String.format("%s %s", latitude, longitude);
    }
}
