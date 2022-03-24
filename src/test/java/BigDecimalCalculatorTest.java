import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class BigDecimalCalculatorTest {

    BigDecimalCalculator calculator;

    private BigDecimal eval(String expression) {
        return calculator.evaluate(expression);
    }

    @BeforeEach
    void setUp() {
        calculator = new BigDecimalCalculator();
    }

    // number recognition tests
    @Test
    public void testRationalNumber() {
        BigDecimal result = eval("1.54");
        assertEquals(1.54, result.doubleValue());
    }

    @Test
    public void testNegativeRationalNumber() {
        BigDecimal result = eval("-88.9234");
        assertEquals(-88.9234, result.doubleValue());
    }

    @Test
    public void testNaturalNumberBelowIntLimit() {
        BigDecimal result = eval("91827364");
        assertEquals(91827364, result.intValue());
    }

    @Test
    public void testNegativeNumberBelowIntLimit() {
        BigDecimal result = eval("-198590");
        assertEquals(-198590, result.intValue());
    }

    // addition tests
    @Test
    public void testBasicAddition() {
        assertEquals(2, eval("1+1").intValue());
        assertEquals(333, eval("234+99").intValue());
    }

    @Test
    public void testBasicAdditionWithRationalNumbers() {
        BigDecimal result = eval("1.12345+5.43210");
        assertEquals(6.55555, result.doubleValue());
    }

    @Test
    public void testAdditionWithMixedNumbers() {
        BigDecimal result = eval("42+0.42");
        assertEquals(42.42, result.doubleValue());
    }

    @Test
    public void testMultipleAdditions() {
        BigDecimal result = eval("10 + 40 + 50");
        assertEquals(100, result.intValue());

        result = eval("10 + 40 + 50 + 60 + 70");
        assertEquals(230, result.intValue());
    }

    // test subtraction
    @Test
    public void testBasicSubtraction() {
        BigDecimal result = eval("10-7");
        assertEquals(3, result.intValue());
    }

    @Test
    public void testBasicSubtractionWithRationalNumbers() {
        BigDecimal result = eval("1.725444-0.025442");
        assertEquals(1.700002, result.doubleValue());
    }

    @Test
    public void testMultipleSubtractions() {
        BigDecimal result = eval("10-7-3");
        assertEquals(0, result.intValue());
    }

    @Test
    public void testSubtractionWithMixedNumbers() {
        BigDecimal result = eval("100-24.5-0.5-12.125-12.875");
        assertEquals(50, result.doubleValue());
    }

    @Test
    public void testSubtractionPositiveToNegative() {
        BigDecimal result = eval("10-15");
        assertEquals(-5, result.intValue());
    }

    // test multiplication
    @Test
    public void testBasicMultiplication() {
        BigDecimal result = eval("8*9");
        assertEquals(72, result.intValue());
    }

    @Test
    public void testBasicMultiplicationWithRationalNumbers() {
        BigDecimal result = eval("1.5*1.5");
        assertEquals(2.25, result.doubleValue());
    }

    @Test
    public void testMultipleMultiplications() {
        BigDecimal result = eval("1*2*3*4*5*6*7*8*9");
        assertEquals(362880, result.intValue());
    }

    @Test
    public void testPositiveNegativeMultiplication() {
        BigDecimal result = eval("-8*19");
        assertEquals(-152, result.intValue());
    }

    @Test
    public void testNegativeNegativeMultiplication() {
        BigDecimal result = eval("-12*-15");
        assertEquals(180, result.intValue());
    }

    // test division
    @Test
    public void testBasicDivision() {
        BigDecimal result = eval("225/15");
        assertEquals(15, result.intValue());
    }

    @Test
    public void testMultipleDivisions() {
        BigDecimal result = eval("2048/2/512");
        assertEquals(2, result.intValue());
    }

    @Test
    public void testPositiveNegativeDivision() {
        BigDecimal result = eval("1024/-4");
        assertEquals(-256, result.intValue());
    }

    @Test
    public void testNegativeNegativeDivision() {
        BigDecimal result = eval("-81/-9");
        assertEquals(9, result.intValue());
    }

    // brackets
    @Test
    public void testSingleBrackets() {
        BigDecimal result = eval("(5)");
        assertEquals(5, result.intValue());
    }

    @Test
    public void testMultipleBrackets() {
        BigDecimal result = eval("((((((42))))))");
        assertEquals(42, result.intValue());
    }

    @Test
    void testBracketsMultiplication() {
        BigDecimal result = eval("(15)(20)");
        assertEquals(300, result.intValue());
    }

    @Test
    void testMultipleBracketsMultiplication() {
        BigDecimal result = eval("(2+3)(7-2)(5*2)(15/3)");
        assertEquals(1250, result.intValue());
    }

    // unary minus
    @Test
    public void testBasicUnaryMinus() {
        BigDecimal result = eval("-7");
        assertEquals(-7, result.intValue());
    }

    @Test
    public void testMultipleUnaryMinuses() {
        BigDecimal result = eval("--7");
        assertEquals(7, result.intValue());
        result = eval("-----------42");
        assertEquals(-42, result.intValue());
    }

    // power
    @Test
    public void testBasicPower() {
        BigDecimal result = eval("5^3");
        assertEquals(125, result.intValue());
    }

    @Test
    void testMultiplePowers() {
        BigDecimal result = eval("2^3^2");
        assertEquals(512, result.intValue());
    }

    // test precedence
    @Test
    public void testAddSubMulDivPrecedence() {
        BigDecimal result = eval("2+3*2");
        assertEquals(8, result.intValue());
        result = eval("10+20/2-2");
        assertEquals(18, result.intValue());
    }

    @Test
    public void testAllPrecedenceRules() {
        BigDecimal result = eval("2+(3-2)^3-2/(1+1)");
        assertEquals(2, result.intValue());
    }

    @Test void testPrecedenceWithUnaryMinusAndPower() {
        BigDecimal result = eval("-1^2");
        assertEquals(-1, result.intValue());

        result = eval("(-1)^2");
        assertEquals(1, result.intValue());
    }

    @Test
    public void testPrecedenceWithImplicitMultiplication() {
        BigDecimal result = calculator.evaluate("(2)(2)+2");
        assertEquals(6, result.intValue());
    }

    // white space tests
    @Test
    public void testWithWhiteSpaceInBetween() {
        BigDecimal result = eval("1       +            4");
        assertEquals(5, result.intValue());
    }

    @Test
    public void testWithLeadingWhitespace() {
        BigDecimal result = eval("           198+123");
        assertEquals(321, result.intValue());
    }

    @Test
    public void testWithTrailingWhitespace() {
        BigDecimal result = eval("700000+12323                ");
        assertEquals(712323, result.intValue());
    }

    @Test
    public void testWithWhitespaceAsNumberSeparator() {
        BigDecimal result = eval("4 000 190 + 10 000 310");
        assertEquals(14000500, result.intValue());
    }

    // percentage
    @Test
    public void testPercentageSuffix() {
        BigDecimal result = eval("10%");
        assertEquals(0.1, result.doubleValue());
    }

    @Test
    public void testPercentageAdd() {
        BigDecimal result = eval("100+15%");
        assertEquals(115, result.intValue());
    }

    @Test
    public void testPercentageSub() {
        BigDecimal result = eval("200-50%");
        assertEquals(100, result.intValue());
    }

    @Test
    public void testPercentageOver100Percent() {
        BigDecimal result = eval("20-150%");
        assertEquals(-10, result.intValue());
    }

    @Test
    public void testPercentageMultiplication() {
        BigDecimal result = eval("40*75%");
        assertEquals(30, result.intValue());
    }

    // factorial
    @Test
    public void testFactorial() {
        BigDecimal result = eval("5!");
        assertEquals(120, result.intValue());
    }

    // functions
    @Test
    public void testFunction() {
        BigDecimal result = eval("√(9)");
        assertEquals(3, result.intValue());
    }

    // constants
    @Test
    public void testConstant() {
        BigDecimal result = eval("e");
        assertEquals(2.7, result.doubleValue());
    }
}