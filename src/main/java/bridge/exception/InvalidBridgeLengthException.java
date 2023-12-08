package bridge.exception;

public class InvalidBridgeLengthException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 다리의 길이는 3부터 20 사이의 숫자여야 합니다.";

    private InvalidBridgeLengthException(String message) {
        super(message);
    }

    public static InvalidBridgeLengthException of() {
        return new InvalidBridgeLengthException(ERROR_MESSAGE);
    }
}
