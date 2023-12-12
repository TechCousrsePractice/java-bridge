package bridge.mapper;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.util.BridgeMaker;

public class BridgeMapper {
    public static Bridge createBridge(int length) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return Bridge.create(length, bridgeMaker.makeBridge(length));
    }
}
