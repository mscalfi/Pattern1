package it.unimi.di.se.lab06;

import java.util.ArrayList;
import java.util.List;

public class Flock implements Quackable {

    private List<Quackable> quackables = new ArrayList<>();

    @Override
    public void quack() {
        for (Quackable quacker : quackables) {
            quacker.quack();

        }
    }

    public void add(Quackable quacker) {
    }
}
