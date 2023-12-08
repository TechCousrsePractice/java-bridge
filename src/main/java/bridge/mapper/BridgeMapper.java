package bridge.mapper;

import bridge.domain.Bridge;
import java.util.ArrayList;
import java.util.List;

public class BridgeMapper {
    public static Bridge createBridge(List<String> bridge) {
        List<Boolean> upper = new ArrayList<>();
        List<Boolean> lower = new ArrayList<>();

        bridge.forEach(cross -> {
            boolean isUpper = isUpper(cross);
            upper.add(isUpper);
            lower.add(!isUpper);
        });

        return Bridge.create(bridge.size(), upper, lower);
    }

    private static boolean isUpper(String cross) {
        return cross.equals("U");
    }
}
