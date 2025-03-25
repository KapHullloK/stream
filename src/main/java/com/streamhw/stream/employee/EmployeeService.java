package com.streamhw.stream.employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmpl(String firstName, String lastName, Integer department, Integer salary);

    Employee popEmpl(String firstName, String lastName, Integer department, Integer salary);

    Employee findEmpl(String firstName, String lastName, Integer department, Integer salary);

    List<Employee> getDbEmployees();
}
