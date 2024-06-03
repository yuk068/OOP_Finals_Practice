package yukwork.algorithm.numberconverter;

import java.math.BigInteger;

public class Base12NumberConverter extends AbstractNumberConverter {

    public Base12NumberConverter(RadixBigInteger originalNumber) {
        super(originalNumber);
    }

    @Override
    public String decimalTo(String decimal) {
        BigInteger decimalValue = new BigInteger(decimal);
        StringBuilder result = new StringBuilder();

        if (decimalValue.equals(BigInteger.ZERO)) {
            return "0";
        }

        while (!decimalValue.equals(BigInteger.ZERO)) {
            BigInteger[] quotientAndRemainder = decimalValue.divideAndRemainder(BigInteger.valueOf(12));
            int remainder = quotientAndRemainder[1].intValue();
            char digit = (char) (remainder < 10 ? remainder + '0' : remainder - 10 + 'A');
            result.insert(0, digit);
            decimalValue = quotientAndRemainder[0];
        }

        return result.toString();
    }

    @Override
    public int getConvertedRadix() {
        return 12;
    }

}
