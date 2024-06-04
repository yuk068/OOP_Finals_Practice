package yukwork.algorithm.numberconverter.radixbiginteger;

import java.math.BigInteger;

public abstract class AbstractNumberConverter implements NumberConverter {

    protected RadixBigInteger originalNumber;
    protected String convertedNumber;
    protected int convertedRadix;

    public AbstractNumberConverter(RadixBigInteger originalNumber) {
        this.originalNumber = originalNumber;
    }

    public String toDecimal() {
        String original = this.originalNumber.getStringRepresentation();
        int radix = this.originalNumber.getRadix();
        BigInteger decimalValue = BigInteger.ZERO;
        for (int i = 0; i < original.length(); i++) {
            int digitValue = original.charAt(i) -
                    (Character.isDigit(original.charAt(i)) ? '0' : ('A' - 10));
            decimalValue = decimalValue.multiply(BigInteger.valueOf(radix)).add(BigInteger.valueOf(digitValue));
        }

        return decimalValue.toString();
    }

    public abstract String decimalTo(String decimal);

    public abstract int getConvertedRadix();

    @Override
    public void updateOriginalNumber() {
        if (convertedNumber == null) System.out.println("Haven't converted, can't update original number");
        else {
            originalNumber.updateState(convertedNumber, convertedRadix);
        }
    }

    @Override
    public void convert() {
        convertedNumber = decimalTo(toDecimal());
        convertedRadix = getConvertedRadix();
    }

    @Override
    public void display() {
        if (convertedNumber == null) {
            System.out.println("Haven't converted, can't display");
        } else {
            System.out.println("(" + originalNumber + ") to radix " + convertedRadix + ": " + convertedNumber);
        }
    }

    @Override
    public void refresh() {
        convertedNumber = null;
        convertedRadix = 0;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " with original number (" + originalNumber + ")";
    }

}
