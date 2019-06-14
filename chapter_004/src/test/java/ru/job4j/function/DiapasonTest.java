package ru.job4j.function;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DiapasonTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        Diapason function = (start, end, func) -> {
            List<Double> result = new ArrayList<>();
            for (int i = start; i < end; i++) {
                result.add(func.apply((double) i));
            }
            return result;
        };
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenLinearResults() {
        Diapason function = (start, end, func) -> {
            List<Double> result = new ArrayList<>();
            for (int i = start; i < end; i++) {
                result.add(func.apply((double) i));
            }
            return result;
        };
        List<Double> result = function.diapason(5, 8, x -> x * x);
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogFunctionThenLinearResults() {
        Diapason function = (start, end, func) -> {
            List<Double> result = new ArrayList<>();
            for (int i = start; i < end; i++) {
                result.add(func.apply((double) i));
            }
            return result;
        };
        List<Double> result = function.diapason(5, 8, Math::log);
        List<Double> expected = Arrays.asList(1.6094379124341003, 1.791759469228055, 1.9459101490553132);
        assertThat(result, is(expected));
    }
}
