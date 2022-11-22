package bridge.domain;

import bridge.utils.enums.GameState;

import java.util.List;

public class Result {
    private boolean moveSuccess;
    private boolean remainBridge;

    public void updateResult(int moveCount, String moveInput, List<String> answerBridge) {
        int lastIndex = moveCount - 1;
        updateMoveSuccess(answerBridge, lastIndex, moveInput);
        updateRemainBridge(moveCount, answerBridge);
    }

    public boolean isMoveSuccess() {
        return moveSuccess;
    }

    public String getGameState() {
        if (!moveSuccess) {
            return GameState.LOOSE.name();
        }
        if (remainBridge) {
            return GameState.WIN.name();
        }
        return GameState.PLAYING.name();
    }

    private void updateMoveSuccess(List<String> answerBridge, int lastIndex, String moveInput) {
        moveSuccess = answerBridge.get(lastIndex).equals(moveInput);
    }

    private void updateRemainBridge(int moveCount, List<String> answerBridge) {
        remainBridge = moveCount == answerBridge.size();
    }
}
