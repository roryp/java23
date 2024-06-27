package com.example;

import jdk.incubator.vector.*;

public class VectorAPI {
    public static void main(String[] args) {
        VectorSpecies<Integer> SPECIES = IntVector.SPECIES_PREFERRED;
        IntVector a = IntVector.fromArray(SPECIES, new int[]{1, 2, 3, 4}, 0);
        IntVector b = IntVector.fromArray(SPECIES, new int[]{5, 6, 7, 8}, 0);
        IntVector c = a.add(b);
        int[] array = new int[4];
        c.intoArray(array, 0);
        System.out.println(c.toString());
    }
}