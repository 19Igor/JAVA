package ru.nsu.epov.lab2.OperationFabric;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisionTest {

    @Test
    void command() {

        int a = 5;
        int b = 1;
        int result = a / b;
        assertEquals(5, result);
    }
}