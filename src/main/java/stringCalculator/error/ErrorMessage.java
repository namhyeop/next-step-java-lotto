package stringCalculator.error;

public enum ErrorMessage {

    DIVIDE_VALUE_ERROR("나눗셈의 결과는 정수여야 합니다"),
    INPUT_VALUE_NOT_VALID("입력값은 NULL 또는 빈 문자열일수 없습니다");

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }
}
