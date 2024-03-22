package stringCalculator.domain.expression.operator.impl;

import stringCalculator.domain.expression.operator.Operator;
import stringCalculator.error.ErrorMessage;

public enum OperatorImpl implements Operator {

    ADD("+") {
        @Override
        public long calculate(long leftOperand, long rightOperand) {
            return leftOperand + rightOperand;
        }
    }, MINUS("-") {
        @Override
        public long calculate(long leftOperand, long rightOperand) {
            return leftOperand - rightOperand;
        }
    }, MULTIPLY("*") {
        @Override
        public long calculate(long leftOperand, long rightOperand) {
            return leftOperand * rightOperand;
        }
    }, DIVIDE("/") {
        @Override
        public long calculate(long leftOperand, long rightOperand) {
            if (leftOperand % rightOperand != 0) {
                throw new ArithmeticException(ErrorMessage.DIVIDE_VALUE_ERROR.getErrorMessage());
            }
            return leftOperand / rightOperand;
        }
    };

    private final String operator;

    OperatorImpl(String operator) {
        this.operator = operator;
    }

    @Override
    public boolean isEqualsOperator(String other){
        return operator.equals(other);
    }

    public static Operator fromOperator(String other) {
        for (Operator operator : OperatorImpl.values()) {
            if (operator.isEqualsOperator(other)) {
                return operator;
            }
        }
        throw new RuntimeException(
            new IllegalArgumentException(ErrorMessage.INPUT_VALUE_NOT_OPERATOR.getErrorMessage()));
    }
}
