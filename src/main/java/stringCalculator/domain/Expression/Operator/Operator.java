package stringCalculator.domain.Expression.Operator;

public interface Operator {

    long calculate(long leftOperand, long rightOperand);

    public boolean isEqualsOperator(String other);
}
