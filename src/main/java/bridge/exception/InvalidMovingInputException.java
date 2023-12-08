package bridge.exception;

public class InvalidMovingInputException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 이동할 칸은 U 또는 D로 입력해주세요.";

    private InvalidMovingInputException(String message) {
        super(message);
    }

    public static InvalidMovingInputException of() {
        return new InvalidMovingInputException(ERROR_MESSAGE);
    }
}
