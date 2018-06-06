package it.unimi.di.se.lab06;

public class CounterDuckFactory extends AbstractDuckFactory {
    @Override
    public Quackable createMallardDuck() {
        return new QuackCounter(new MallardDuck());
    }

    @Override
    public Quackable createRedHeadDuck() {
        return new QuackCounter(new RedHeadDuck());
    }

    @Override
    public Quackable createQuackableRubberDuck() {
        return new QuackCounter(new QuackableRubberDuck());
    }

    @Override
    public Quackable createQuackableGoose() {
        return new QuackCounter(new QuackableGoose());
    }
}
