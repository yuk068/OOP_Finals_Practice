package yukwork.algorithm.numberconverter.primitiveinteger;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class RadixInteger {

    private static final String DIGITS = "0123456789ABCDEF";
    private static final Random RANDOM = new Random();

    private int integerValue; 
    private String stringRepresentation;
    private final String originalRepresentation;
    private int radix;
    private final int originalRadix;
    private final List<NumberConverter> converters;

    public RadixInteger(String representation, int radix) {
        setRadix(radix);
        originalRadix = radix;
        converters = new LinkedList<>();
        checkValidStringRepresentation(representation);
        stringRepresentation = representation;
        integerValue = Integer.parseInt(stringRepresentation, radix); 
        originalRepresentation = stringRepresentation;
        ensureIntegerLimit();
    }

    public RadixInteger(int lengthLowerBound, int lengthUpperBound) {
        checkBound(lengthLowerBound, lengthUpperBound);
        radix = RANDOM.nextInt(DIGITS.length() - 1) + 2;
        originalRadix = radix;
        converters = new LinkedList<>();
        stringRepresentation = generateStringRepresentation(lengthLowerBound, lengthUpperBound, radix);
        integerValue = Integer.parseInt(stringRepresentation, radix); 
        originalRepresentation = stringRepresentation;
        ensureIntegerLimit();
    }

    public RadixInteger(int lengthLowerBound, int lengthUpperBound, int radix) {
        checkBound(lengthLowerBound, lengthUpperBound);
        setRadix(radix);
        originalRadix = radix;
        converters = new LinkedList<>();
        stringRepresentation = generateStringRepresentation(lengthLowerBound, lengthUpperBound, radix);
        integerValue = Integer.parseInt(stringRepresentation, radix); 
        originalRepresentation = stringRepresentation;
        ensureIntegerLimit();
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
        integerValue = Integer.parseInt(stringRepresentation, radix); 
        System.out.println("(" + originalString + ") updated to: " + this);
        ensureIntegerLimit();
        convertersRefresh();
    }

    public String getStringRepresentation() {
        return stringRepresentation;
    }

    public int getIntegerValue() {
        return integerValue;
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

    private void ensureIntegerLimit() {
        if (Math.abs(integerValue) - 1 >= Integer.MAX_VALUE - 1) {
            throw new IllegalArgumentException("Integer value exceeds 32-bit limit.");
        }
    }

    @Override
    public String toString() {
        return "radix " + radix + ": " + stringRepresentation;
    }

}
