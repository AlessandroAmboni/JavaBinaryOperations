package org.example;


import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Character.toUpperCase;

public class BinaryOperators {

    public void binaryConverter(String binary) {
        List<Integer> binaryList = convertToIntegerList(binary);

        AtomicInteger sum = new AtomicInteger();
        Iterator<Integer> iterator = binaryList.iterator();
        Collections.reverse(binaryList);

        int counter = 0;
        while (iterator.hasNext()) {
            int i = iterator.next();
            if (i == 1) {
                sum.addAndGet((int) Math.pow(2, counter));
            }
            counter++;
        }

        System.out.println(sum);
    }

    public String binaryAddition(String num1, String num2) {
        //Convert the binary strings to integers arrayLists
        List<Integer> num1List = convertToIntegerList(num1);
        List<Integer> num2List = convertToIntegerList(num1);
        //add 0 to the smaller arrayList to make them the same length
        if (num1List.size() > num2List.size()) {
            while (num1List.size() != num2List.size()) {
                num2List.add(0, 0);
            }
        } else {
            while (num2List.size() != num1List.size()) {
                num1List.add(0, 0);
            }
        }
        System.out.println(num1List + "\n" + num2List);
        //reverse the ArrayLists for easier addition
        Collections.reverse(num1List);
        Collections.reverse(num2List);

        ArrayList<Integer> sumList = new ArrayList<>();
        int carry = 0;
        for (int i = 0; i < num1List.size(); i++) {
            int sum = num1List.get(i) + num2List.get(i) + carry;
            if (sum == 0) {
                sumList.add(0);
                carry = 0;
            } else if (sum == 1) {
                sumList.add(1);
                carry = 0;
            } else if (sum == 2) {
                sumList.add(0);
                carry = 1;
            } else if (sum == 3) {
                sumList.add(1);
                carry = 1;
            }
        }
        StringBuilder result = new StringBuilder();
        for (Integer i : sumList) {
            result.append(i);
        }
        return result.toString();

    }

    public List<Integer> convertToIntegerList(String binary) {
        return binary.chars()
                .mapToObj(c -> toUpperCase((char) c))
                .mapToInt(c -> Integer.parseInt(String.valueOf(c)))
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

}
