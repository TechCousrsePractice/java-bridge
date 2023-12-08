package bridge.view;

import bridge.util.InputValidator;
import bridge.util.Parser;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리 건너기 게임을 시작합니다." + System.lineSeparator());
        System.out.println("다리의 길이를 입력해주세요.");
        return Parser.parseToInt(Console.readLine());
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(System.lineSeparator() + "이동할 칸을 선택해주세요. (위: U, 아래: D)");
        return InputValidator.validateMoving(Console.readLine());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
