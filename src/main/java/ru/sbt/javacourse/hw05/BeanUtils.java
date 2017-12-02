package ru.sbt.javacourse.hw05;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BeanUtils {
    public static void assign(Object to, Object from) {

        Method[] methodsFrom = from.getClass().getMethods();
        Method[] methodsTo = to.getClass().getMethods();

        Map<String, Method> getters = new HashMap<String, Method>();
        String name;

        for (Method method : methodsFrom) {
            name = method.getName();
            if (name.startsWith("get") &&
                    method.getParameterCount() == 0 &&
                    method.getReturnType() != void.class &&
                    method.getReturnType() != Void.class) {
                getters.put(name.substring(3, name.length()), method);
            }
        }

        for (Method method : methodsTo) {
            name = method.getName();
            if (name.startsWith("set") &&
                    method.getParameterCount() == 1) {

            }
        }
    }
}
