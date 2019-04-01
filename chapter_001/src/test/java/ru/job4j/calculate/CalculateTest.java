package ru.job4j.calculate;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Andrey Takmazian (takmazian@mail.ru)
 * @version $Id$
 * @since 13.12.2018
 */
public class CalculateTest {
    /**
     * Test echo.
     */
    @Test
    public void whenTakeNameThenThreeEchoPlusName() {
        String input = "Andrey Takmazian";
        String expect = "Echo, echo, echo : Andrey Takmazian";
        //Calculate calc = new Calculate();
        String result = Calculate.echo(input);
        assertThat(result, is(expect));
    }

}