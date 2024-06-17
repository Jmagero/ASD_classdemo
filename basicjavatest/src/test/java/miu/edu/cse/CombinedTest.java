package miu.edu.cse;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({CalculatorTest.class, ParameterizedTest.class})
@SelectPackages({"miu.edu.cse"})
public class CombinedTest {
}
