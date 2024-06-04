package yukwork.algorithm.numberconverter.primitiveinteger;

public class Base12NumberConverter extends AbstractNumberConverter {

    public Base12NumberConverter(RadixInteger originalNumber) {
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
            int remainder = decimalValue % 12;
            char digit = (char) (remainder < 10 ? remainder + '0' : remainder - 10 + 'A');
            result.insert(0, digit);
            decimalValue /= 12;
        }

        return result.toString();
    }

    @Override
    public int getConvertedRadix() {
        return 12;
    }

}
