package bridge.domain;

import bridge.exception.InvalidBridgeLengthException;
import java.util.List;

public class Bridge {
    private final int length;
    private final List<Boolean> upper;
    private final List<Boolean> lower;

    private Bridge(int length, List<Boolean> upper, List<Boolean> lower) {
        this.upper = upper;
        this.lower = lower;
        validateLength(length);
        this.length = length;
    }

    public static Bridge create(int length, List<Boolean> upper, List<Boolean> lower) {
        return new Bridge(length, upper, lower);
    }

    private void validateLength(int length) {
        if (length < 3 || length > 20) {
            throw InvalidBridgeLengthException.of();
        }
    }
}
