package com.ftg.learn.aacc;

abstract public class P30 {
    protected abstract double getSalesAmount();
    public double getCommision() {
        return getSalesAmount() * 0.15;
    }
}
class Sales extends P30 {
    @Override
    protected double getSalesAmount() {
        return 0;
    }
    // insert method here
}
