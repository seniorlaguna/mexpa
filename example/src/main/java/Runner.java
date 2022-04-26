import org.seniorlaguna.mexpa.BigDecimalCalculator;

public class Runner {

    public static void main(String[] args) {

        BigDecimalCalculator calculator = new BigDecimalCalculator();
        calculator.setDecimalPlaces(10);
        calculator.setUseRadians(true);
        System.out.println(calculator.evaluate("sin(1)/3!"));

    }

}
