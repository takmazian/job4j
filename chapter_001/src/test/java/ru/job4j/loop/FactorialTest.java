package ru.job4j.loop;
import org.junit.Test;
import ru.job4j.loop.Factorial;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {

    @Test
    public void testFact0() {
        assertThat(new Factorial().calc(0),is(1));
    }
    @Test
    public void testFact1() {
        assertThat(new Factorial().calc(1),is(1));
    }
    @Test
    public void testFact5() {
        assertThat(new Factorial().calc(5),is(120));
    }
}
