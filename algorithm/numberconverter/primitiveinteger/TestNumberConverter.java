package yukwork.algorithm.numberconverter.primitiveinteger;

import java.util.LinkedList;
import java.util.List;

public class TestNumberConverter {

    public static void main(String[] args) {
        RadixInteger radixInteger = new RadixInteger("25", 10);
        System.out.println("RadixInteger 2: " + radixInteger);

        NumberConverter binaryConverter = new BinaryNumberConverter(radixInteger);
        binaryConverter.convert();
        binaryConverter.display();

        NumberConverter base6Converter = new Base6NumberConverter(radixInteger);
        base6Converter.convert();
        base6Converter.display();

        NumberConverter octalConverter = new OctalNumberConverter(radixInteger);
        octalConverter.convert();
        octalConverter.display();

        NumberConverter base12Converter = new Base12NumberConverter(radixInteger);
        base12Converter.convert();
        base12Converter.display();

        NumberConverter hexConverter = new HexadecimalNumberConverter(radixInteger);
        hexConverter.convert();
        hexConverter.display();

        List<NumberConverter> converters = new LinkedList<>();
        converters.add(binaryConverter);
        converters.add(base6Converter);
        converters.add(octalConverter);
        converters.add(base12Converter);
        converters.add(hexConverter);

        radixInteger.addAllConverters(converters);

        radixInteger.updateState("1111", 2);

        radixInteger.convertersConvert();
        radixInteger.convertersDisplay();
    }

}