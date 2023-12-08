package bridge.controller;

import bridge.domain.Bridge;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame gameManager;

    private BridgeController(InputView inputView, OutputView outputView, BridgeGame gameManager) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameManager = gameManager;
    }

    public static BridgeController setUp() {
        return new BridgeController(new InputView(), new OutputView(), new BridgeGame());
    }

    public void run() {
        Bridge bridge = requestBridgeLength();
    }

    private Bridge requestBridgeLength() {
        return InputHandler.handle(() -> {
            int length = inputView.readBridgeSize();
            return Bridge.create(length);
        });
    }
}
