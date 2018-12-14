package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest  {
    @Test
    public void whenAddOnePlusOneThenTwo()  {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    @Test
    public void timesTest() {
        Calculator calc = new Calculator();
        calc.tim(2D, 3D);
        double result = calc.getResult();
        double expected = 6D;
        assertThat(result, is(expected));
    }

    @Test
    public void divTest()  {
        Calculator calc = new Calculator();
        calc.div(5D, 8D);
        double result = calc.getResult();
        double expected = 0.625;
        assertThat(result, is(expected));
    }

    @Test
    public void subTest()  {
        Calculator calc = new Calculator();
        calc.sub(1D, 5D);
        double result = calc.getResult();
        double expected = -4D;
        assertThat(result, is(expected));
    }
}
