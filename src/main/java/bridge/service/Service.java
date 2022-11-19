package bridge.service;

import bridge.domain.*;
import bridge.utils.Converter;

import java.util.List;

public class Service {
    BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    Converter converter = new Converter();
    Result result = new Result();
    BridgeGame game;

    public void prepareGame(String bridgeSizeInput) {
        int bridgeSize = converter.toIntFromString(bridgeSizeInput);
        List<String> answerBridge = bridgeMaker.makeBridge(bridgeSize);
        User user = new User();
        game = new BridgeGame(answerBridge, user);
    }

    public void move(String moveInput) {
        boolean moveSuccess = game.move(moveInput);
        result.write(moveInput, moveSuccess);
    }

    public List<String> getCurrentResult() {
        return result.getResult();
    }

    public boolean checkMoveSuccess() {
        return game.checkMoveSuccess();
    }

    public boolean isFinishedGame() {
        return game.checkFinish();
    }

    public List<String> getFinalResult() {
        return result.getFinalResultToString();
    }
}
