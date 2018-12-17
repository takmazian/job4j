package ru.job4j;
import org.junit.Test;
import ru.job4j.loop.Counter;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CounterTest {

    @Test
    public void testSum1() {
        assertThat(new Counter().add (1,1),is(0));
    }

    @Test
    public void testSum2() {
        assertThat(new Counter().add (1,2),is(2));
    }
    @Test
    public void testSum3() {
        assertThat(new Counter().add (1,3),is(2));
    }
    @Test
    public void testSum10() {
        assertThat(new Counter().add (1,10),is(30));
    }

    @Test
    public void testEq() {
        assertThat(new Counter().add (10,10),is(10));
    }

    @Test
    public void testNeg() {
        assertThat(new Counter().add (10,1),is(0));
    }

}
