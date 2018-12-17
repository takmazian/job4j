package ru.job4j.max;

import org.junit.Test;
import ru.job4j.max.Max;

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

    @Test
    public void threeMax1() {
        assertThat(new Max().max(12,3,4),is(12));
    }
    @Test
    public void threeMax2() {
        assertThat(new Max().max(2,13,4),is(13));
    }
    @Test
    public void threeMax3() {
        assertThat(new Max().max(2,3,4),is(4));
    }
}
