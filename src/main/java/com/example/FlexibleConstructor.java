package com.example;

public class FlexibleConstructor {
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