package ru.sbt.javacourse.hw05;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BeanUtilsTest {
    @Test
    public void assign() throws Exception {
        String from = "Hello world";
        String to = "";

        BeanUtils.assign(to, from);

        assertEquals("Hello world", to);
    }
}