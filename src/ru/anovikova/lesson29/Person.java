package ru.anovikova.lesson29;

import java.util.Objects;

public class Person {
    private int age;
    private String lastName;
    private String gender;

    public Person(int age, String lastName, String gender) {

        this.age = age;
        this.lastName = lastName;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(gender, person.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, lastName, gender);
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
