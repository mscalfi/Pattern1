package it.unimi.di.se.lab06;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DuckTaleTest {

    @Rule
    public final SystemOutRule output = new SystemOutRule().enableLog();

    @Rule
    public Timeout globalTimeout = Timeout.seconds(2);

    @Test
    public void mallardAndRedHeadDucksQuackQuack() {
        Quackable duck = new MallardDuck();
        Quackable reddy = new RedHeadDuck();
        duck.quack();
        reddy.quack();
        assertThat(output.getLog()).isEqualTo("quack\nquack\n");
    }

}
