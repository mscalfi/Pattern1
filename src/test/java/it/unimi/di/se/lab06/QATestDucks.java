package it.unimi.di.se.lab06;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.assertj.core.api.Assertions.assertThat;

public class QATestDucks {

    private final static String NEW_LINE = System.lineSeparator();
    private final static String QUACK = "quack";
    private final static String SQUEAK = "squeak";
    private final static String HONK = "honk";

    @Rule
    public Timeout globalTimeout = Timeout.seconds(2);

    @Rule
    public final SystemOutRule output = new SystemOutRule().enableLog().muteForSuccessfulTests();

    @Before
    public void resetCounter() {
        QuackCounter.reset();
    }

    @Test
    public void mallardDuckQuacks() {
        Quackable duck = new MallardDuck();
        duck.quack();
        assertThat(output.getLog()).isEqualTo(QUACK + NEW_LINE);
    }

    @Test
    public void otherDucksQuack() {
        RubberDuck rubby = new RubberDuck();
        Quackable reddy = new RedHeadDuck();
        rubby.squeak();
        reddy.quack();
        assertThat(output.getLog()).isEqualTo(SQUEAK + NEW_LINE + QUACK + NEW_LINE);
    }

    @Test
    public void gooseHonks() {
        Goose goose = new Goose();
        goose.honk();
        assertThat(output.getLog()).isEqualTo(HONK + NEW_LINE);
    }

    private Flock setupAMixedFlock(AbstractDuckFactory factory) {
        Flock flock = new Flock();
        flock.add(factory.createMallardDuck());
        flock.add(factory.createRedHeadDuck());
        flock.add(factory.createQuackableRubberDuck());
        flock.add(factory.createQuackableGoose());
        flock.add(setupNumberedFlock(factory, 2));
        return flock;
    }

    @Test
    public void aFlockQuacks() {
        AbstractDuckFactory factory = new SimpleDuckFactory();
        Flock flock = setupAMixedFlock(factory);
        flock.quack();
        assertThat(output.getLog()).isEqualTo(QUACK + NEW_LINE + QUACK + NEW_LINE + SQUEAK + NEW_LINE + HONK + NEW_LINE + QUACK + NEW_LINE + QUACK + NEW_LINE);
    }

    @Test
    public void countQuacks() {
        AbstractDuckFactory factory = new CounterDuckFactory();
        Flock flock = setupAMixedFlock(factory);
        flock.quack();
        assertThat(QuackCounter.getQuackCount()).isEqualTo(6);
    }

    private Flock setupNumberedFlock(AbstractDuckFactory fact, int n) {
        Flock flock = new Flock();
        for (int i = 0; i < n; i++)
            flock.add(fact.createRedHeadDuck());
        return flock;
    }

    @Test
    public void aFlockIsQuackable() {
        AbstractDuckFactory factory = new CounterDuckFactory();
        Flock quackableFlock = setupNumberedFlock(factory, 10);
        Flock flock = setupNumberedFlock(factory, 5);
        flock.add(quackableFlock);
        flock.quack();
        assertThat(QuackCounter.getQuackCount()).isEqualTo(15);
    }

}