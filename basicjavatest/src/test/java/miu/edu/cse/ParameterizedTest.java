package miu.edu.cse;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParameterizedTest {
    public static Stream<Integer> feedMyData() {
        return Stream.of(2, 4,  6,  8, 10);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @ValueSource(ints = {2,4,6,8})
    public void test(int num) {
        assertTrue(num %2 == 0);
    }
    @org.junit.jupiter.params.ParameterizedTest
    @MethodSource("feedMyData")
    public void myTest2(int num) {
        assertTrue(num %2 == 0);
    }
}
