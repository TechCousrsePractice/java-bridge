package bridge.domain;

import bridge.exception.InvalidBridgeLengthException;
import java.util.List;

public class Bridge {
    private final int length;
    private final List<String> bridge;

    private Bridge(int length, List<String> bridge) {
        validateLength(length);
        this.bridge = bridge;
        this.length = length;
    }

    public static Bridge create(int length, List<String> bridge) {
        return new Bridge(length, bridge);
    }

    private void validateLength(int length) {
        if (length < 3 || length > 20) {
            throw InvalidBridgeLengthException.of();
        }
    }

    public boolean matchPosition(String position, int count) {
        return bridge.get(count).equals(position);
    }

    public int getLength() {
        return length;
    }

    public List<String> getBridge() {
        return bridge;
    }
}
