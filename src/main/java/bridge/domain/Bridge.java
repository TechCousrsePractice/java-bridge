package bridge.domain;

import bridge.exception.InvalidBridgeLengthException;

public class Bridge {
    private final int length;

    private Bridge(int length) {
        validateLength(length);
        this.length = length;
    }

    public static Bridge create(int length){
        return new Bridge(length);
    }

    private void validateLength(int length){
        if (length < 3 || length > 20){
            throw InvalidBridgeLengthException.of();
        }
    }
}
