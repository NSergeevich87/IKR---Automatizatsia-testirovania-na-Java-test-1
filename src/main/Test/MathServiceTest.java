import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class MathServiceTest {
    @Test
    void testGetAnswer_DiscriminantZero() throws NotFoundAnswerException {
        MathService mathService = new MathService();
        Pair result = mathService.getAnswer(1, 2, 1);
        assertEquals(-1.0, result.getFirst());
        assertEquals(-1.0, result.getSecond());
    }

    /** использование параметризированного теста с передачей 3х чисел */
    @Test
    @ParameterizedTest
    @CsvSource({"1, -3, 2"})
    void testGetAnswer_DiscriminantPositive(int num1, int num2, int num3) throws NotFoundAnswerException {
        MathService mathService = new MathService();
        //Pair result = mathService.getAnswer(1, -3, 2);
        Pair result = mathService.getAnswer(num1, num2, num3);
        assertEquals(1.3333333333333333, result.getFirst());
        assertEquals(0.6666666666666666, result.getSecond());
    }

    /** отрицательный дискриминант */
    @Test
    void testGetAnswer_DiscriminantNegative() {
        MathService mathService = new MathService();
        assertThrows(NotFoundAnswerException.class, () -> mathService.getAnswer(1, 1, 1));
    }

    /** a, b, c = 0 */
    @Test
    void testGetD_AllZero() {
        MathService mathService = new MathService();
        int result = mathService.getD(0, 0, 0);
        assertEquals(0, result);
    }

    /** a, b, c != 0 */
    @Test
    void testGetD_NonZeroValues() {
        MathService mathService = new MathService();
        int result = mathService.getD(2, 3, 1);
        assertEquals(1, result);
    }
}
