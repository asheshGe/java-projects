package com.practice.google.guice.provider.implicitProvider;

public class NoDiscount implements Discountable {
    public double getDiscount() {
        return 0.00;
    }
}
