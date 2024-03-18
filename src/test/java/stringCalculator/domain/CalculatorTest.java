package stringCalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowableOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import stringCalculator.error.ErrorMessage;

public class CalculatorTest {

    @Test
    @DisplayName("계산기는 숫자 2개가 입력될때 더한값을 반환한다")
    public void Calculator_Should_Return_Sum_When_Two_Numbers_Entered() throws Exception {
        //given
        Calculator sutCalculator = new Calculator();

        //when
        long sum = sutCalculator.add(1, 2);

        //then
        assertThat(sum).isEqualTo(3);
    }

    @Test
    @DisplayName("계산기에 음수 2개가 전달될 때 더한 값이 정상적으로 반환되어야 한다")
    public void Calculator_Should_Return_Minus_When_Two_Numbers_Entered() throws Exception {
        //given
        Calculator sutCalculator = new Calculator();

        //when
        long sum = sutCalculator.add(-1, -5);

        //then
        assertThat(sum).isEqualTo(-6);
    }

    @Test
    @DisplayName("계산기에 숫자 2개가 덧셈 되었을 때 최대 범위를 검증해야한다")
    public void Maximum_range_should_Be_Verified_When_Two_Numbers_Are_Added() throws Exception {
        //given
        Calculator sutCalculator = new Calculator();

        //when
        long sum1 = sutCalculator.add(Long.MAX_VALUE, 0);
        long sum2 = sutCalculator.add(Long.MAX_VALUE, 1);

        //then
        assertThat(sum1).isEqualTo(9223372036854775807L);
        assertThat(sum2).isEqualTo(-9223372036854775808L);
    }

    @Test
    @DisplayName("계산기에 숫자 2개가 뺄셈 되었을 때 최대 범위를 검증해야한다")
    public void Calculator_Maximum_range_should_Be_Verified_When_Two_Numbers_Are_Minus() throws Exception {
        //given
        Calculator sutCalculator = new Calculator();

        //when
        long sum1 = sutCalculator.minus(-1, Long.MAX_VALUE);
        long sum2 = sutCalculator.minus(-2, Long.MAX_VALUE);

        //then
        assertThat(sum1).isEqualTo( -9223372036854775808L);
        assertThat(sum2).isEqualTo( 9223372036854775807L);
    }


    @Test
    @DisplayName("계산기는 숫자 2개가 입력될때 곱셈이 가능하다")
    public void Calculator_Should_Multiply_When_Two_Numbers_Are_Entered() throws Exception{
        //given
        Calculator sutCalculator = new Calculator();

        //when
        long sum = sutCalculator.multiply(1, 5);

        //then
        assertThat(sum).isEqualTo( 5);
    }

    @Test
    @DisplayName("계산기는 숫자 2개가 입력될때 나눗셈이 가능하다")
    public void Calculator_Should_Division() throws Exception{
        //given
        Calculator sutCalculator = new Calculator();

        //when
        long sum = sutCalculator.divide(5, 1);

        //then
        assertThat(sum).isEqualTo( 5);
    }

    @Test
    @DisplayName("사칙연산 사이 빈 공백 문자열이 없을 경우 예외 발생")
    public void Calculator_Should_Occur_Exception_When_Input_Empty_String () throws Exception{
        //given

        //when

        //then
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  "})
    @DisplayName("빈 공백 문자일 경우 IllegalArgumentException throw 예외를 발생한다.")
    public void Calculator_Should_Occur_Exception_When_Input_Is_Null_Or_Empty(String input) throws Exception{
        //given
        Calculator sutCalculator = new Calculator();

        //when
        IllegalArgumentException actual = catchThrowableOfType(
            () -> sutCalculator.isValidInput(input), IllegalArgumentException.class);

        //then
        assertThat(actual).hasMessageContaining(ErrorMessage.INPUT_VALUE_NOT_VALID.getErrorMessage());
    }
}
