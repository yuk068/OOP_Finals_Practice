package yukwork.algorithm.numberconverter.primitiveinteger;

public abstract class AbstractNumberConverter implements NumberConverter {

    protected RadixInteger originalNumber;
    protected String convertedNumber;
    protected int convertedRadix;

    public AbstractNumberConverter(RadixInteger originalNumber) {
        this.originalNumber = originalNumber;
    }

    public String toDecimal() {
        String original = this.originalNumber.getStringRepresentation();
        int radix = this.originalNumber.getRadix();
        int decimalValue = 0;
        int power = 0;

        for (int i = original.length() - 1; i >= 0; i--) {
            char c = original.charAt(i);
            int digitValue = Character.isDigit(c) ? c - '0' : (c - 'A' + 10);
            decimalValue += (int) (digitValue * Math.pow(radix, power));
            power++;
        }

        return String.valueOf(decimalValue);
    }

    public abstract String decimalTo(String decimal);

    public abstract int getConvertedRadix();

    @Override
    public void updateOriginalNumber() {
        if (convertedNumber == null) {
            System.out.println("Haven't converted, can't update original number");
        } else {
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
