package bridge.util;

import bridge.exception.EmptyException;
import bridge.exception.InvalidMovingInputException;

public class InputValidator {
    /**
     * U 또는 D의 값이 아니면 예외를 던진다
     */
    public static String validateMoving(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            throw InvalidMovingInputException.of();
        }
        if (input.isBlank()) {
            throw EmptyException.of();
        }
        return input;
    }
}
