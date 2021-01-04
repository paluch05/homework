package pl.orzechsoft.paluch.tasks.Task15;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.orzechsoft.paluch.tasks.Task6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Task6Test {

    @Test
    @DisplayName("Test whichFibonacciNumber")
    void testWhichFibonacciNumber() {
        int fib = Task6.fib(4);
        int expected = 3;
        assertEquals(expected, fib);
    }

    @Test
    @DisplayName("Should throw an exception when passed negative argument")
    void shouldThrowExceptionWhenPassedNegativeArgument() {
        assertThrows(IllegalArgumentException.class, () -> Task6.fib(-2));
    }

    @Test
    @DisplayName("Should work correctly for whichFibonacciNumber Zero")
    void shouldWorkCorrectlyforWhichFibonacciNumberZero() {
        assertEquals(0, Task6.fib(0));
    }

    @Test
    @DisplayName("Should work correctly for whichFibonacciNumber One")
    void shouldWorkCorrectlyforWhichFibonacciNumberOne() {
        assertEquals(1, Task6.fib(1));
    }
}