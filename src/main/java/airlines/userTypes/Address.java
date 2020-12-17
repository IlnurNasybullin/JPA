package airlines.userTypes;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Address implements Serializable {

    @Column(nullable = false, length = 30)
    private String country;

    @Column(nullable = false, length = 30)
    private String region;

    @Column(nullable = false, length = 20)
    private String city;

    @Column(nullable = false, length = 30)
    private String street;

    @Column(nullable = false, length = 10)
    private String house;

    @Column(nullable = false, length = 5)
    private String flat;

    @Column(name = "postal_code", nullable = false, length = 10)
    private String postalCode;

    public Address() { }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    public String getFlat() {
        return flat;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(country, address.country) &&
                Objects.equals(region, address.region) &&
                Objects.equals(city, address.city) &&
                Objects.equals(street, address.street) &&
                Objects.equals(house, address.house) &&
                Objects.equals(flat, address.flat) &&
                Objects.equals(postalCode, address.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, region, city, street, house, flat, postalCode);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Address{");
        sb.append("\n\t").append("country='").append(country).append('\'');
        sb.append("\n\tregion='").append(region).append('\'');
        sb.append("\n\tcity='").append(city).append('\'');
        sb.append("\n\tstreet='").append(street).append('\'');
        sb.append("\n\thouse='").append(house).append('\'');
        sb.append("\n\tflat='").append(flat).append('\'');
        sb.append("\n\tpostalCode='").append(postalCode).append('\'');
        sb.append("\n").append('}');
        return sb.toString();
    }
}
