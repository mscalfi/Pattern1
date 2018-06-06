package it.unimi.di.se.lab06;

public class QuackCounter implements Quackable {

    private static int quackCount = 0;
    private Quackable daDecorare;


    public QuackCounter(Quackable quackable) {
        daDecorare = quackable;
    }

    public static int getQuackCount() {
        return quackCount;
    }

    public void reset() {
        quackCount = 0;
    }

    @Override
    public void quack() {

    }
}
