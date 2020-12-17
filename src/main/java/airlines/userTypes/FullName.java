package airlines.userTypes;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FullName implements Serializable {

    @Column(name = "last_name", nullable = false, length = 15)
    private String lastName;

    @Column(nullable = false, length = 15)
    private String name;

    @Column(name = "father_name", nullable = false, length = 15)
    private String fatherName;

    public FullName() { }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public String getFatherName() {
        return fatherName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FullName fullName = (FullName) o;
        return Objects.equals(lastName, fullName.lastName) &&
                Objects.equals(name, fullName.name) &&
                Objects.equals(fatherName, fullName.fatherName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, name, fatherName);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", lastName, name, fatherName);
    }
}
