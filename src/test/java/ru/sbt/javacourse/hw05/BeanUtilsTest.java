package ru.sbt.javacourse.hw05;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BeanUtilsTest {
    @Test
    public void test01_assign() throws Exception {
        String from = "Hello world";
        String to = "";

        BeanUtils.assign(to, from);

//        assertEquals("Hello world", to);
    }

    @Test
    public void test02_person() throws Exception {
        Person a = new Person("Alex", 37);
        Person b = new Person();

        BeanUtils.assign(b, a);

        assertEquals("Alex", b.getName());
        assertEquals(37, b.getAge());
    }

    @Test
    public void test03_employee() throws Exception {
        Employee a = new Employee("Alex", 37, "SBT", 100);
        Employee b = new Employee();

        BeanUtils.assign(b, a);

        assertEquals("Alex", b.getName());
        assertEquals(37, b.getAge());
        assertEquals("SBT", b.getCompany());
        assertEquals(-1, b.getSalary());
    }

    @Test
    public void test04_superClass() throws Exception {
        Employee a = new Employee("Alex", 37, "SBT", 100);
        Person b = new Person();

        BeanUtils.assign(b, a);

        assertEquals("Alex", b.getName());
        assertEquals(37, b.getAge());
    }

//    @Test
//    public void test05_fullNamePerson() throws Exception {
//        FullNamePerson a = new FullNamePerson("John", "Lee", 25);
//        FullNamePerson b = new FullNamePerson();
//
//        BeanUtils.assign(b, a);
//
//        assertEquals("John Lee", b.getName());
//        assertEquals(25, b.getAge());
//    }

//    @Test
//    public void test06_setterWithSuperClass() throws Exception {
//        FullNamePerson a = new FullNamePerson("John", "Lee", 25);
//        Person b = new Person();
//
//        BeanUtils.assign(b, a);
//
//        assertEquals("Alex", b.getName());
//        assertEquals(37, b.getAge());
//    }
}
