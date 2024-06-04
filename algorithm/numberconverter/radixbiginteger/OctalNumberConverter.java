package yukwork.algorithm.numberconverter.radixbiginteger;

import java.math.BigInteger;

public class OctalNumberConverter extends AbstractNumberConverter {

    public OctalNumberConverter(RadixBigInteger originalNumber) {
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
            BigInteger[] quotientAndRemainder = decimalValue.divideAndRemainder(BigInteger.valueOf(8));
            int remainder = quotientAndRemainder[1].intValue();
            char digit = (char) (remainder + '0');
            result.insert(0, digit);
            decimalValue = quotientAndRemainder[0];
        }

        return result.toString();
    }

    @Override
    public int getConvertedRadix() {
        return 8;
    }

}
