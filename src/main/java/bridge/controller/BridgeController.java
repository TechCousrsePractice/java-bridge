package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.mapper.BridgeMapper;
import bridge.util.BridgeMaker;
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
        String moving = requestMoving();
    }

    private Bridge requestBridgeLength() {
        return InputHandler.handle(() -> {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            int length = inputView.readBridgeSize();
            return BridgeMapper.createBridge(bridgeMaker.makeBridge(length));
        });
    }

    private String requestMoving() {
        return InputHandler.handle(inputView::readMoving);
    }
}
