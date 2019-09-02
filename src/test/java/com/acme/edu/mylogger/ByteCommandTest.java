package com.acme.edu.mylogger;

import com.acme.edu.mylogger.commands.ByteCommand;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class ByteCommandTest {
    @Test
    public void shouldAccumulateWithSameCommand() {
        final ByteCommand sut = new ByteCommand((byte)1);
        final ByteCommand accumulateResult = (ByteCommand) sut.accumulate(sut);
        assertThat(accumulateResult.getMessage()).isEqualTo((byte)2);
    }

    @Test
    public void shouldBeEqualToTheSameCommand() {
        final ByteCommand sut = new ByteCommand((byte)1);
        assertThat(sut.isTypeEquals(sut)).isEqualTo(true);
    }

    @Test
    public void shouldBeGreaterThanZero() {
        final ByteCommand sut = new ByteCommand((byte)1);
        assertThat(sut.isOverflow()).isEqualTo(false);
    }

    @Test(expected = ArithmeticException.class)
    public void shouldBeOverflow() {
        final ByteCommand sut1 = new ByteCommand((byte)1);
        final ByteCommand sut2 = new ByteCommand(Byte.MAX_VALUE);
        assertThat(sut1.accumulate(sut2).isOverflow()).isEqualTo(true);
    }

    @Test
    public void shouldBeDecorated() {
        final String PRIMITIVE_PREFIX = "primitive: ";
        final ByteCommand sut = new ByteCommand((byte)1);
        assertThat(sut.getDecorated()).isEqualTo(PRIMITIVE_PREFIX + 1);
    }
}
