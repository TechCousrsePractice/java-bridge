package bridge.exception;

public class InvalidRetryInputException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 재시도 여부는 R 또는 Q로 입력해주세요.";

    private InvalidRetryInputException(String message) {
        super(message);
    }

    public static InvalidRetryInputException of() {
        return new InvalidRetryInputException(ERROR_MESSAGE);
    }
}
