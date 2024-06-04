package yukwork.algorithm.numberconverter.primitiveinteger;

public class BinaryNumberConverter extends AbstractNumberConverter {

    public BinaryNumberConverter(RadixInteger originalNumber) {
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
            int remainder = decimalValue % 2;
            char digit = (char) (remainder + '0');
            result.insert(0, digit);
            decimalValue /= 2;
        }

        return result.toString();
    }

    @Override
    public int getConvertedRadix() {
        return 2;
    }

}
