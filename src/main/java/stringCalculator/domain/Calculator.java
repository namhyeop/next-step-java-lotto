package stringCalculator.domain;

import stringCalculator.error.ErrorMessage;

public class Calculator {

    public long add(long leftOperands, long rightOperands){
        return leftOperands + rightOperands;
    }

    public long minus(long leftOperands, long rightOperands){
        return leftOperands - rightOperands;
    }

    public long multiply(long leftOperands, long rightOperands){
        return leftOperands * rightOperands;
    }

    public long divide(long leftOperands, long rightOperands){
        if (leftOperands % rightOperands != 0){
            throw new ArithmeticException(ErrorMessage.DIVIDE_VALUE_ERROR.getErrorMessage());
        }
        return leftOperands / rightOperands;
    }

    public void isValidInput(String operands){
        if (operands == null || operands.isBlank()){
            throw new IllegalArgumentException(ErrorMessage.INPUT_VALUE_NOT_VALID.getErrorMessage());
        }
    }
}
