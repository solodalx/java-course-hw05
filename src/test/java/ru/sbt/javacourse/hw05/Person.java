package ru.sbt.javacourse.hw05;

public class Person {
    private String name;
    private int age;

    public Person() {
        this.name = null;
        this.age = -1;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Employee extends Person {
    String company;
    int salary;

    public Employee() {
        super();
        company = null;
        salary = -1;
    }

    public Employee(String name, int age, String company, int salary) {
        super(name, age);
        this.company = company;
        this.salary = salary;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getSalary() {
        return salary;
    }
}


class FullNamePerson extends Person {
    private String firstName;
    private String lastName;

    public FullNamePerson() {
        this.firstName = null;
        this.lastName = null;
    }

    public FullNamePerson(String firstName, String lastName, int age) {
        super(null, age);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getName() {
        return firstName + " " + lastName;
    }
}
