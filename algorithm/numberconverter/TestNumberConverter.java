package yukwork.algorithm.numberconverter;

import java.util.LinkedList;
import java.util.List;

public class TestNumberConverter {

    public static void main(String[] args) {
        RadixBigInteger firstNumber = new RadixBigInteger(10, 15);
        System.out.println("Original number: " + firstNumber);

        List<NumberConverter> converterList = new LinkedList<>();

        NumberConverter binary = new BinaryNumberConverter(firstNumber);
        NumberConverter base6 = new Base6NumberConverter(firstNumber);
        NumberConverter octal = new OctalNumberConverter(firstNumber);
        NumberConverter base12 = new Base12NumberConverter(firstNumber);
        NumberConverter hexa = new HexadecimalNumberConverter(firstNumber);

        converterList.add(binary);
        converterList.add(base6);
        converterList.add(octal);
        converterList.add(base12);
        converterList.add(hexa);

        firstNumber.addAllConverters(converterList);
        firstNumber.convertersConvert();
        firstNumber.convertersDisplay();

//        RadixBigInteger secondNumber = new
    }

}
