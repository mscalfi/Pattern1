package it.unimi.di.se.lab06;

public class SimpleDuckFactory extends AbstractDuckFactory {
    @Override
    public Quackable createMallardDuck() {
        return new MallardDuck();
    }

    @Override
    public Quackable createRedHeadDuck() {
        return new RedHeadDuck();
    }

    @Override
    public Quackable createQuackableRubberDuck() {
        return new QuackableRubberDuck();
    }

    @Override
    public Quackable createQuackableGoose() {
        return new QuackableGoose();
    }
}
