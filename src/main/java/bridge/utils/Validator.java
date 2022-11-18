package bridge.utils;

public class Validator {
    public static void checkSizeInRange(int size) {
        if (3 > size || size > 20) {
            throw new IllegalArgumentException("3 이상 20 이하의 숫자만 입력가능합니다");
        }
    }

    public static void checkMoveInput(String moveInput) {
        if(!moveInput.equals("U") && !moveInput.equals("D")) {
            throw new IllegalArgumentException("보기에 있는 값만 입력 가능합니다.");
        }
    }
}
