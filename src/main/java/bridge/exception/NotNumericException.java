package bridge.exception;

public class NotNumericException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 숫자가 아닙니다. 다시 입력해주세요.";

    private NotNumericException(String message) {
        super(message);
    }

    public static NotNumericException of() {
        return new NotNumericException(ERROR_MESSAGE);
    }
}
