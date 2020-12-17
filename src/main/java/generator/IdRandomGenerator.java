package generator;

import java.util.Random;

public class IdRandomGenerator implements RandomInfinityGenerator<Long> {

    @Override
    public Long next() {
        return Math.abs(new Random().nextLong());
    }
}
