package bridge.controller;

import bridge.domain.Bridge;
import bridge.mapper.BridgeMapper;
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
        boolean isRetry = true;
        while (isRetry) {
            gamePlay(bridge);
            if (!gameManager.isFail()) {
                break;
            }
            isRetry = requestRetry();
        }
        outputView.printResult(gameManager);
    }

    private Bridge requestBridgeLength() {
        return InputHandler.handle(() -> {
            int length = inputView.readBridgeSize();
            return BridgeMapper.createBridge(length);
        });
    }

    private String requestMoving() {
        return InputHandler.handle(inputView::readMoving);
    }

    private void gamePlay(Bridge bridge) {
        gameManager.retry();
        for (int i = 0; i < bridge.getLength(); i++) {
            String moving = requestMoving();
            gameManager.move(bridge, moving, i);
            outputView.printMap(gameManager);
            if (gameManager.isFail()) {
                break;
            }
        }
    }

    private boolean requestRetry() {
        return InputHandler.handle(() -> {
            String retry = inputView.readGameCommand();
            return retry.equals("R");
        });
    }
}
