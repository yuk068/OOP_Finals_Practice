package yukwork.algorithm.numberconverter.primitiveinteger;

public class Base6NumberConverter extends AbstractNumberConverter {

    public Base6NumberConverter(RadixInteger originalNumber) {
        super(originalNumber);
    }

    @Override
    public String decimalTo(String decimal) {
        int decimalValue = Integer.parseInt(decimal);
        StringBuilder result = new StringBuilder();

        if (decimalValue == 0) {
            return "0";
        }

        while (decimalValue != 0) {
            int remainder = decimalValue % 6;
            char digit = (char) (remainder + '0');
            result.insert(0, digit);
            decimalValue /= 6;
        }

        return result.toString();
    }

    @Override
    public int getConvertedRadix() {
        return 6;
    }

}
