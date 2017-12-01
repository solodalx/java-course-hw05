package ru.sbt.javacourse.hw05;

import java.lang.reflect.Method;

public class BeanUtils {
    public static void assign(Object to, Object from) {

        Method[] methodsFrom = from.getClass().getMethods();
        Method[] methodsTo = to.getClass().getMethods();

    }
}
