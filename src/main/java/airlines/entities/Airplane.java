package airlines.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.function.BiPredicate;

@Entity(name = "airplane")
public class Airplane {

    @Id
    @Column(name = "\"id\"")
    @GeneratedValue(strategy=GenerationType.SEQUENCE,
            generator="airplane_seq")
    @SequenceGenerator(name="airplane_seq",
            sequenceName="SEQ_AIRPLANE", allocationSize = 1)
    private Long ID;

    @Column(name = "registration_number", unique = true, nullable = false)
    private final String registrationNumber;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(name = "airline_name", nullable = false, length = 30)
    private String airlineName;

    @Column(name = "rolling_date", nullable = false)
    private LocalDate rollingDate;

    @Column(name = "maiden_flight_date", nullable = false)
    private LocalDate maidenFlightDate;

    @Column(name = "registration_date", nullable = false)
    private LocalDate registrationDate;

    @Column(name = "nearest_operation_date", nullable = false)
    private LocalDate nearestOperationDate;

    @OneToOne
    @JoinColumn(name = "technical_passport", nullable = false, unique = true)
    private TechnicalPassport technicalPassport;

    private Airplane() {
        this("");
    }

    public Airplane(String registrationNumber) {
        Objects.requireNonNull(registrationNumber);
        this.registrationNumber = registrationNumber;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public LocalDate getRollingDate() {
        return rollingDate;
    }

    public void setRollingDate(LocalDate rollingDate) {
        checkRollingDate(rollingDate);
        this.rollingDate = rollingDate;
    }

    private void checkRollingDate(LocalDate rollingDate) {
        checkDate(rollingDate, LocalDate::isBefore, maidenFlightDate, registrationDate, nearestOperationDate);
    }

    private void checkDate(LocalDate checkDate, BiPredicate<LocalDate, LocalDate> predicate, LocalDate... dates) {
        for (LocalDate date : dates) {
            if (Objects.nonNull(date) && predicate.negate().test(checkDate, date)) {
                throw new IllegalArgumentException("Дата установлена неверно!");
            }
        }
    }

    public LocalDate getMaidenFlightDate() {
        return maidenFlightDate;
    }

    public void setMaidenFlightDate(LocalDate maidenFlightDate) {
        checkMaidenFlightDate(maidenFlightDate);
        this.maidenFlightDate = maidenFlightDate;
    }

    private void checkMaidenFlightDate(LocalDate maidenFlightDate) {
        checkDate(maidenFlightDate, LocalDate::isAfter, rollingDate);
        checkDate(maidenFlightDate, LocalDate::isBefore, registrationDate, nearestOperationDate);
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        checkRegistrationDate(registrationDate);
        this.registrationDate = registrationDate;
    }

    private void checkRegistrationDate(LocalDate registrationDate) {
        checkDate(registrationDate, LocalDate::isAfter, rollingDate, maidenFlightDate);
        checkDate(registrationDate, LocalDate::isBefore, nearestOperationDate);
    }

    public LocalDate getNearestOperationDate() {
        return nearestOperationDate;
    }

    public void setNearestOperationDate(LocalDate nearestOperationDate) {
        checkNearestOperationDate(nearestOperationDate);
        this.nearestOperationDate = nearestOperationDate;
    }

    private void checkNearestOperationDate(LocalDate nearestOperationDate) {
        checkDate(nearestOperationDate, LocalDate::isAfter, rollingDate, maidenFlightDate, registrationDate);
    }

    public TechnicalPassport getTechnicalPassport() {
        return technicalPassport;
    }

    public void setTechnicalPassport(TechnicalPassport technicalPassport) {
        this.technicalPassport = technicalPassport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airplane airplane = (Airplane) o;
        return Objects.equals(ID, airplane.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Airplane{");
        sb.append("\n\t").append("ID=").append(ID);
        sb.append("\n\tregistrationNumber='").append(registrationNumber).append('\'');
        sb.append("\n\tname='").append(name).append('\'');
        sb.append("\n\tairlineName='").append(airlineName).append('\'');
        sb.append("\n\trollingDate=").append(rollingDate);
        sb.append("\n\tmaidenFlightDate=").append(maidenFlightDate);
        sb.append("\n\tregistrationDate=").append(registrationDate);
        sb.append("\n\tnearestOperationDate=").append(nearestOperationDate);
        sb.append("\n\ttechnicalPassport=").append(technicalPassport);
        sb.append("\n").append('}');
        return sb.toString();
    }
}
