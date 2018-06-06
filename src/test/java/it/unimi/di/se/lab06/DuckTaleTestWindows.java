package it.unimi.di.se.lab06;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.rules.Timeout;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DuckTaleTestWindows {

    @Rule
    public final SystemOutRule output = new SystemOutRule().enableLog().muteForSuccessfulTests();

    @Rule
    public Timeout globalTimeout = Timeout.seconds(2);

    @Test
    public void mallardAndRedHeadDucksQuackQuack() {
        Quackable duck = new MallardDuck();
        Quackable reddy = new RedHeadDuck();

        duck.quack();
        reddy.quack();

        assertThat(output.getLog()).isEqualToNormalizingNewlines("quack\nquack\n");
    }

    @Test
    public void testRubberDuck() {
        RubberDuck rubberDuck = new RubberDuck();

        rubberDuck.squeak();

        assertThat(output.getLog()).isEqualToNormalizingNewlines("squeak\n");
    }

    @Test
    public void testGoose() {
        Goose goose = new Goose();

        goose.honk();

        assertThat(output.getLog()).isEqualToNormalizingNewlines("honk\n");
    }

    @Test
    public void testQuackableRubberDuck() {
        Quackable quackableRubberDuck = new QuackableRubberDuck();

        quackableRubberDuck.quack();

        assertThat(output.getLog()).isEqualToNormalizingNewlines("squeak\n");
    }

    @Test
    public void testQuackableGoose() {
        Quackable quackableGoose = new QuackableGoose();

        quackableGoose.quack();

        assertThat(output.getLog()).isEqualToNormalizingNewlines("honk\n");
    }

    @Test
    public void testQuackCounter() {
        QuackCounter quackCounter = new QuackCounter(new QuackableGoose());

        quackCounter.quack();
        quackCounter.quack();
        quackCounter.quack();

        assertThat(QuackCounter.getQuackCount()).isEqualTo(3);

        quackCounter.reset();

        quackCounter.quack();
        assertThat(QuackCounter.getQuackCount()).isEqualTo(1);
    }


}
