package yukwork.algorithm.numberconverter.primitiveinteger;

public class HexadecimalNumberConverter extends AbstractNumberConverter {

    public HexadecimalNumberConverter(RadixInteger originalNumber) {
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
            int remainder = decimalValue % 16;
            char digit = (char) (remainder < 10 ? remainder + '0' : remainder - 10 + 'A');
            result.insert(0, digit);
            decimalValue /= 16;
        }

        return result.toString();
    }

    @Override
    public int getConvertedRadix() {
        return 16;
    }

}
