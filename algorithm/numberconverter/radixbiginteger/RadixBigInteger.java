package yukwork.algorithm.numberconverter.radixbiginteger;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class RadixBigInteger {

    private static final String DIGITS = "0123456789ABCDEF";
    private static final Random RANDOM = new Random();

    private String stringRepresentation;
    private final String originalRepresentation;
    private int radix;
    private final int originalRadix;
    private final List<NumberConverter> converters;

    public RadixBigInteger(String representation, int radix) {
        setRadix(radix);
        originalRadix = radix;
        converters = new LinkedList<>();
        checkValidStringRepresentation(representation);
        stringRepresentation = representation;
        originalRepresentation = representation;
    }

    public RadixBigInteger(int lengthLowerBound, int lengthUpperBound) {
        checkBound(lengthUpperBound, lengthUpperBound);
        radix = RANDOM.nextInt(DIGITS.length() - 1) + 2;
        originalRadix = radix;
        converters = new LinkedList<>();
        stringRepresentation = generateStringRepresentation(lengthLowerBound, lengthUpperBound, radix);
        originalRepresentation = stringRepresentation;
    }

    public RadixBigInteger(int lengthLowerBound, int lengthUpperBound, int radix) {
        checkBound(lengthLowerBound, lengthUpperBound);
        setRadix(radix);
        originalRadix = radix;
        converters = new LinkedList<>();
        stringRepresentation = generateStringRepresentation(lengthLowerBound, lengthUpperBound, radix);
        originalRepresentation = stringRepresentation;
    }

    private String generateStringRepresentation(int lengthLowerBound, int lengthUpperBound, int radix) {
        int length = RANDOM.nextInt(lengthUpperBound - lengthLowerBound + 1) + lengthLowerBound;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int digitIndex = RANDOM.nextInt(radix);
            char digit = DIGITS.charAt(digitIndex);
            sb.append(digit);
        }
        return sb.toString();
    }

    private void checkBound(int lower, int upper) {
        if (lower > upper) throw new IllegalArgumentException("Invalid parameters.");
    }

    private void checkValidStringRepresentation(String representation) {
        for (char c : representation.toCharArray()) {
            if (DIGITS.indexOf(c) >= radix || DIGITS.indexOf(c) == -1) {
                throw new IllegalArgumentException("Invalid string representation for the given radix.");
            }
        }
    }

    public void updateState(String representation, int radix) {
        String originalString = toString();
        setRadix(radix);
        checkValidStringRepresentation(representation);
        stringRepresentation = representation;
        System.out.println("(" + originalString + ") updated to: " + this);
        convertersRefresh();
    }

    public String getStringRepresentation() {
        return stringRepresentation;
    }

    public int getRadix() {
        return radix;
    }

    private void setRadix(int radix) {
        if (radix < 2 || radix > DIGITS.length())
            throw new IllegalArgumentException("Invalid radix.");
        this.radix = radix;
    }

    public void addConverter(NumberConverter converter) {
        System.out.println("Notice: attached " + converter);
        converters.add(converter);
    }

    public void addAllConverters(List<NumberConverter> converters) {
        converters.forEach(this::addConverter);
    }

    public void removeConverter(NumberConverter converter) {
        converters.remove(converter);
    }

    public void removeAllConverters() {
        converters.clear();
    }

    public void convertersConvert() {
        if (converters.isEmpty()) System.out.println("Notice: No converters attached to (" + this + ")");
        converters.forEach(NumberConverter::convert);
    }

    public void convertersDisplay() {
        if (converters.isEmpty()) System.out.println("Notice: No converters attached to (" + this + ")");
        converters.forEach(NumberConverter::display);
    }

    public void convertersRefresh() {
        if (converters.isEmpty()) System.out.println("Notice: No converters attached to (" + this + ")");
        converters.forEach(NumberConverter::refresh);
    }

    @Override
    public String toString() {
        return "radix " + radix + ": " + stringRepresentation;
    }

}
