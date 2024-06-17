package miu.edu.cse;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        //before every test
        Calculator calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        //after every test method
        calculator = null;
    }

    @Test
    @Order(1)
    void add() {
        int actualResult = calculator.add(1,1);
        int expectedResult = 2;
        assertEquals(expectedResult,actualResult);
    }

    @Test
    @Order(2)
    void subtract() {
        int actualResult = calculator.subtract(1,1);
        int expectedResult = 0;
        assertEquals(expectedResult,actualResult);
    }

    @Test
    @Order(3)
    void multiply() {
        int actualResult = calculator.multiply(1,1);
        int expectedResult = 1;
        assertEquals(expectedResult,actualResult);
    }
}