package org.anonymousclass;

public class Employee {
    String name;
    Integer age;
    public Employee(String name, Integer age){
        this.name=name;
        this.age=age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
