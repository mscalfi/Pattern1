package it.unimi.di.se.lab06;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DuckTaleTest {

    @Rule
    public final SystemOutRule output = new SystemOutRule().enableLog().muteForSuccessfulTests();

    @Rule
    public Timeout globalTimeout = Timeout.seconds(2);

    @Before
    public void resetCounter() {
        QuackCounter.reset();
    }

    @Test
    public void mallardAndRedHeadDucksQuackQuack() {
        AbstractDuckFactory factory = new SimpleDuckFactory();
        Quackable duck = factory.createMallardDuck();
        Quackable reddy = factory.createRedHeadDuck();

        duck.quack();
        reddy.quack();

        assertThat(output.getLog()).isEqualTo("quack\nquack\n");
    }

    @Test
    public void testRubberDuck() {
        RubberDuck rubberDuck = new RubberDuck();

        rubberDuck.squeak();

        assertThat(output.getLog()).isEqualTo("squeak\n");
    }

    @Test
    public void testGoose() {
        Goose goose = new Goose();

        goose.honk();

        assertThat(output.getLog()).isEqualTo("honk\n");
    }

    @Test
    public void testQuackableRubberDuck() {
        Quackable quackableRubberDuck = new SimpleDuckFactory().createQuackableRubberDuck();

        quackableRubberDuck.quack();

        assertThat(output.getLog()).isEqualTo("squeak\n");
    }

    @Test
    public void testQuackableGoose() {
        Quackable quackableGoose = new SimpleDuckFactory().createQuackableGoose();

        quackableGoose.quack();

        assertThat(output.getLog()).isEqualTo("honk\n");
    }

    @Test
    public void testQuackCounter() {
        QuackCounter quackCounter = new QuackCounter(new QuackableGoose());

        quackCounter.quack();
        quackCounter.quack();
        quackCounter.quack();

        assertThat(QuackCounter.getQuackCount()).isEqualTo(3);

        resetCounter();

        quackCounter.quack();
        assertThat(QuackCounter.getQuackCount()).isEqualTo(1);

    }

    @Test
    public void testSimpleDuckFactory() {
        AbstractDuckFactory simpleDuckFactory = new SimpleDuckFactory();
        Quackable mallardDuck = simpleDuckFactory.createMallardDuck();

        mallardDuck.quack();

        assertThat(output.getLog()).isEqualTo("quack\n");
    }

    @Test
    public void testCounterDuckFactory() {
        AbstractDuckFactory counterDuckFactory = new CounterDuckFactory();
        Quackable countableMallardDuck = counterDuckFactory.createMallardDuck();
        Quackable countableRedHeaDuck = counterDuckFactory.createRedHeadDuck();
        Quackable countableQuackableRubberDuck = counterDuckFactory.createQuackableRubberDuck();
        Quackable countableQuackableGoose = counterDuckFactory.createQuackableGoose();


        countableMallardDuck.quack();
        countableMallardDuck.quack();
        countableMallardDuck.quack();

        assertThat(QuackCounter.getQuackCount()).isEqualTo(3);

        resetCounter();

        countableRedHeaDuck.quack();
        countableRedHeaDuck.quack();
        countableRedHeaDuck.quack();

        assertThat(QuackCounter.getQuackCount()).isEqualTo(3);

        resetCounter();

        countableQuackableRubberDuck.quack();
        countableQuackableRubberDuck.quack();
        countableQuackableRubberDuck.quack();

        assertThat(QuackCounter.getQuackCount()).isEqualTo(3);

        resetCounter();

        countableQuackableGoose.quack();
        countableQuackableGoose.quack();
        countableQuackableGoose.quack();

        assertThat(QuackCounter.getQuackCount()).isEqualTo(3);
    }

    @Test
    public void testFlock() {
        Flock flock = new Flock();
        AbstractDuckFactory simpleDuckFactory = new SimpleDuckFactory();

        flock.add(simpleDuckFactory.createMallardDuck());
        flock.add(simpleDuckFactory.createRedHeadDuck());

        flock.quack();

        assertThat(output.getLog()).isEqualTo("quack\nquack\n");
    }


}
