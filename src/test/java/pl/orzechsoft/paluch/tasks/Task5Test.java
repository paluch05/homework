package pl.orzechsoft.paluch.tasks;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class Task5Test {

    @Test
    @DisplayName("Test if half is equal")
    void testIfHalfIsEqual() {
        assertTrue(Task5.halfEqual("abcdef", "kbhdjf"));
    }

    @Test
    @DisplayName("Test if even are equal")
    void testIfEvenAreEqual() {
        assertTrue(Task5.halfEqual("okpluh", "rkglmh"));
    }

    @Test
    @DisplayName("Test if odd are equal")
    void testIfOddAreEqual() {
        assertTrue(Task5.halfEqual("ikhyrb", "ivhpre"));
    }

    @Test
    @DisplayName("Test if none are equal")
    void testIfNoneAreEqual() {
        assertFalse(Task5.halfEqual("rfwgf", "lohpv"));
    }

    @Test
    @DisplayName("Test if both are empty")
    void testIfBothAreEmpty() {
        assertTrue(Task5.halfEqual("", ""));
    }

    @Test
    @DisplayName("Test if one is empty")
    void testIfOneIsEmpty() {
        assertTrue(Task5.halfEqual("", "ghjk"));
    }

    @Test
    @DisplayName("Should throw exception when passed one null String")
    void shouldThrowEsceptionWhenStringsAreNull() {
        assertThrows(IllegalArgumentException.class, () -> Task5.halfEqual(null, "ahbsgk"));
    }
}