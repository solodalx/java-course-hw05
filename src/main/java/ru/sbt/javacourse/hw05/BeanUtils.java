package ru.sbt.javacourse.hw05;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BeanUtils {
    public static void assign(Object to, Object from) throws InvocationTargetException, IllegalAccessException {

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
                Method setter = method;
                Method getter = getters.get(name.substring(3, name.length()));
                if (getter == null) continue;

                Class[] parameterTypes = setter.getParameterTypes();
                boolean equalTypes = false;
                Class typeToCheck = getter.getReturnType();
                do {
                    if (typeToCheck.equals(parameterTypes[0])) {
                        equalTypes = true;
                        break;
                    }
                    typeToCheck = typeToCheck.getSuperclass();
                } while (typeToCheck != null);
                if (!equalTypes) continue;

                setter.invoke(to, getter.invoke(from));
            }
        }
    }
}
