package com.rubles_exchange_rate.openexchangerateApi;


public class Currency implements Comparable<Currency>{
    private float rate;

    public float getRate() {
        return rate;
    }

    public Currency(float rate) {
        this.rate = rate;
    }


    @Override
    public int compareTo(Currency o) {
        return Float.compare(rate, o.getRate());
    }

    public boolean isLessThan(Currency that) {
        return this.compareTo(that) < 0;
    }
}
