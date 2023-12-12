package bridge.exception;

public class EmptyException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 공백은 입력할 수 없습니다. 다시 입력해 주세요.";

    private EmptyException(String message) {
        super(message);
    }

    public static EmptyException of() {
        return new EmptyException(ERROR_MESSAGE);
    }
}
