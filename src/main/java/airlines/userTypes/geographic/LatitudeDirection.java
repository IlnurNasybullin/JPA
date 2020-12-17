package airlines.userTypes.geographic;

import java.io.Serializable;

public enum LatitudeDirection implements Serializable {
    NORTH("с.ш."), SOUTH("ю.ш.");

    String direction;

    LatitudeDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return direction;
    }
}
