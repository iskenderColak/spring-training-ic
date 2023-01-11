import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorParameterizedTest {

    @ParameterizedTest
    @ValueSource(strings = {"Java", "JS", ""})
    void testCase1(String arg) {
        Assertions.assertFalse(arg.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 6, 9})
    void testCase2(int num) {
        Assertions.assertEquals(0, num % 3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Java", "JS", "TS"})
//    @EmptySource
//    @NullSource
    @NullAndEmptySource
    void testCase3(String arg) {
        Assertions.assertFalse(arg.isEmpty());
    }
}
