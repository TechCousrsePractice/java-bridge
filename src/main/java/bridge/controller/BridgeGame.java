package bridge.controller;

import bridge.domain.Bridge;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> upperBridge = new ArrayList<>();
    private List<String> lowerBridge = new ArrayList<>();
    private int tryCount = 0;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(Bridge bridge, String crossPosition, int count) {
        if (crossPosition.equals("U")) {
            upperBridge.add(flagSuccess(bridge, crossPosition, count));
            lowerBridge.add(" ");
            return isFail();
        }
        lowerBridge.add(flagSuccess(bridge, crossPosition, count));
        upperBridge.add(" ");
        return isFail();
    }

    private String flagSuccess(Bridge bridge, String crossPosition, int count) {
        if (bridge.matchPosition(crossPosition, count)) {
            return "O";
        }
        return "X";
    }

    public boolean isFail() {
        return upperBridge.contains("X") || lowerBridge.contains("X");
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        initialize();
        tryCount++;
    }

    /**
     * 브릿지 건넜던 기록 초기화
     */
    private void initialize() {
        upperBridge.clear();
        lowerBridge.clear();
    }

    /**
     * 사용자가 한 스텝 밟을 때마다 비교해서 출력할 다리 생성하는 기능 private static Bridge compareWithUserBridge(List<String> bridge) {
     * List<Boolean> upper = new ArrayList<>(); List<Boolean> lower = new ArrayList<>();
     * <p>
     * bridge.forEach(cross -> { boolean isUpper = isUpper(cross); upper.add(isUpper); lower.add(!isUpper); });
     * <p>
     * return Bridge.create(bridge.size(), upper, lower); }
     */

    public List<String> getUpperBridge() {
        return List.copyOf(upperBridge);
    }

    public List<String> getLowerBridge() {
        return List.copyOf(lowerBridge);
    }

    public int getTryCount() {
        return tryCount;
    }
}
