package ru.sbt.javacourse.hw05;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BeanUtilsTest {
    @Test
    public void test01_assign() throws Exception {
        String from = "Hello world";
        String to = "Empty";

        BeanUtils.assign(to, from);

        assertEquals("Empty", to);
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

    @Test
    public void test06_setterWithSuperClass() throws Exception {
        Employee employee = new Employee("Nick", 50, "Comp", 100);
        Person person = new Person();

        B from = new B(employee);
        A to = new A();

        BeanUtils.assign(to, from);

        assertEquals("Nick", to.getPerson().getName());
        assertEquals(50, to.getPerson().getAge());
    }

    @Test
    public void test07_setterWithChildClass() throws Exception {
        Person person = new Person("Nick", 50);
        Employee employee = new Employee();

        A from = new A(person);
        B to = new B();

        BeanUtils.assign(to, from);

        assertNull(to.getPerson());
    }
}


class A {
    Person person;

    public A() {
        this.person = null;
    }

    public A(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}

class B {
    Employee employee;

    public B() {
        this.employee = null;
    }

    public B(Employee employee) {
        this.employee = employee;
    }

    public Employee getPerson() {
        return employee;
    }

    public void setPerson(Employee employee) {
        this.employee = employee;
    }
}
