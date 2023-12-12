package bridge.util;

import bridge.exception.NotNumericException;

public class Parser {
    public static int parseToInt(String input){
        try {
            return Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw NotNumericException.of();
        }
    }
}
