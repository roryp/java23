package com.example;

import java.util.concurrent.*;
import java.util.List;
import java.util.stream.Collectors;
import jdk.classfile.ClassFile;
import jdk.incubator.vector.*;

public class Java23Features {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Primitive Patterns (JEP 455)
        Object obj = 42;
        if (obj instanceof Integer i) {
            System.out.println("Primitive Patterns - Integer value: " + i);
        }

        // Flexible Constructor Bodies (JEP 482)
        FlexibleConstructor flexibleConstructor = new FlexibleConstructor(5);
        System.out.println("Flexible Constructor Bodies - x: " + flexibleConstructor.getX() + ", y: " + flexibleConstructor.getY());

        // Simplified Main (JEP 477)
        simplifiedMain();

        // Module Imports (JEP 476)
        System.out.println("Module Imports Example");

        // Structured Concurrency & Scoped Values (JEP 481 & 480)
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            Future<String> future1 = scope.fork(() -> {
                return "Result 1";
            });
            Future<String> future2 = scope.fork(() -> {
                return "Result 2";
            });
            scope.join();
            scope.throwIfFailed();

            System.out.println("Structured Concurrency - " + future1.resultNow() + ", " + future2.resultNow());
        }

        // Class-File API (JEP 466)
        // Uncomment the following line when running in an environment where jdk.classfile is available
        // ClassFile cf = ClassFile.read("MyClass.class");
        // System.out.println("Class-File API - " + cf.toString());

        // Stream Gatherers (JEP 473)
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        List<Integer> result = numbers.stream()
            .collect(Collectors.toList());
        System.out.println("Stream Gatherers - " + result);

        // Vector API (JEP 469)
        VectorSpecies<Integer> SPECIES = IntVector.SPECIES_PREFERRED;
        IntVector a = IntVector.fromArray(SPECIES, new int[]{1, 2, 3, 4}, 0);
        IntVector b = IntVector.fromArray(SPECIES, new int[]{5, 6, 7, 8}, 0);
        IntVector c = a.add(b);
        int[] array = new int[4];
        c.intoArray(array, 0);
        System.out.println("Vector API - " + c.toString());

        // Markdown in Comments (JEP 467)
        // See the comments throughout this file for examples of markdown-like comments
    }

    // Simplified Main (JEP 477) - Simplified Java file
    static void simplifiedMain() {
        System.out.println("Simplified Main - Hello, World!"); // Uses implicit import of print and println
    }
}

// Supporting class for Flexible Constructor Bodies (JEP 482)
class FlexibleConstructor {
    private int x;
    private int y;

    public FlexibleConstructor(int x) {
        this.x = x;
        {
            this.y = x * 2; // Allowed assignment to fields in the same class
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}