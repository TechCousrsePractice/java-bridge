package bridge;

import bridge.controller.BridgeController;

public class Application {

    public static void main(String[] args) {
        BridgeController bridgeController = BridgeController.setUp();
        bridgeController.run();
    }
}
