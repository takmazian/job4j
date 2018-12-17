package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {

    @Test
    public void firstGreater() {
        assertThat(new Max().max(11,2),is(11));
    }
    @Test
    public void lastGreater() {
        assertThat(new Max().max(1,2),is(2));
    }
    @Test
    public void equal() {
        assertThat(new Max().max(2,2),is(2));
    }
}
