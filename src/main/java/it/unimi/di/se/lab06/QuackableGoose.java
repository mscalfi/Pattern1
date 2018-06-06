package it.unimi.di.se.lab06;

public class QuackableGoose extends Goose implements Quackable {
    @Override
    public void quack() {
        this.honk();
    }
}
