package stringCalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExpressionTest {

    @Test
    @DisplayName("사칙연산 사이 빈 공백 문자열이 없을 경우 예외가 발생해야한다")
    public void Calculator_Should_Occur_Exception_When_Input_Empty_String () throws Exception{
        //given

        //when

        //then
    }

    @Test
    @DisplayName("입력 연산자가 사칙연산 기호가 아닌 경우 IllegalArgumentException throw 예외를 발생한다.")
    public void Calculator_Should_Occur_Exception_When_Input_Is_Not_Four_Arithmetic_Operations() throws Exception{
        //given

        //when

        //then
    }
}
