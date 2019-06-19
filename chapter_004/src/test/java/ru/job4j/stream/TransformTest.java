package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TransformTest {
    @Test
    public void transformTest() {
        Integer[][] arr = new Integer[][]{{1, 2}, {3, 4}};
        Transform transform = new Transform();
        assertThat(transform.transofrmMatrixToList(arr), equalTo(List.of(1, 2, 3, 4)));
    }
}
