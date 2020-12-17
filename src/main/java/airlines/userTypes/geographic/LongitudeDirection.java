package airlines.userTypes.geographic;

import java.io.Serializable;

public enum LongitudeDirection implements Serializable {
    EAST("в.д."), WEST("з.д.");

    LongitudeDirection(String direction) {
        this.direction = direction;
    }

    String direction;

    @Override
    public String toString() {
        return direction;
    }
}
