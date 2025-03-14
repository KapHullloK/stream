package com.streamhw.stream.employee;

import java.util.Objects;


public class Employee {
    private String firstName;
    private String lastName;
    private Integer department;
    private Integer salary;

    public Employee(String firstName, String lastName, Integer department, Integer salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getDepartment() {
        return department;
    }

    public Integer getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("{'%s'}", firstName, lastName);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName);
    }


    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
