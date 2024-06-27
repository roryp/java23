package com.example;

import java.util.List;
import java.util.stream.Collectors;

public class StreamGatherers {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        List<Integer> result = numbers.stream()
            .collect(Collectors.toList());
        System.out.println(result);
    }
}