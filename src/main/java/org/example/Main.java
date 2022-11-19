package org.example;


import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


import static java.lang.Character.toUpperCase;

public class Main {
    public static void main(String[] args) {
        binaryAddition("101", "1000");
    }

    public static void binaryConverter(String binary) {
        List<Integer> binaryList = binary.chars()
                .mapToObj(c -> toUpperCase((char) c))
                .mapToInt(c -> Integer.parseInt(String.valueOf(c)))
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

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

    public static void binaryAddition(String num1, String num2) {
        List<Integer> num1List = num1.chars()
                .mapToObj(c -> toUpperCase((char) c))
                .mapToInt(c -> Integer.parseInt(String.valueOf(c)))
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        List<Integer> num2List = num2.chars()
                .mapToObj(c -> toUpperCase((char) c))
                .mapToInt(c -> Integer.parseInt(String.valueOf(c)))
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        if (num1List.size() > num2List.size()) {
            while (num1List.size() != num2List.size()) {
                num2List.add(0, 0);
            }
        } else if (num2List.size() > num1List.size()) {
            while (num2List.size() != num1List.size()) {
                num1List.add(0, 0);
            }
        }
        System.out.println(num1List + " " + num2List);

    }
}




