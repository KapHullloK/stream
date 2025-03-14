package com.streamhw.stream.employee;


import com.streamhw.stream.exceptions.EmployeeAlreadyAddedException;
import com.streamhw.stream.exceptions.EmployeeNotFoundException;
import com.streamhw.stream.exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {
    private static List<Employee> db_employees = new ArrayList<>();
    private int max_employees = 1000;

    @Override
    public Employee addEmpl(String firstName, String lastName, Integer department, Integer salary) {
        if (db_employees.size() == max_employees) {
            throw new EmployeeStorageIsFullException("Employee storage is already full");
        }

        Employee newEmpl = new Employee(firstName, lastName, department, salary);

        if (db_employees.contains(newEmpl)) {
            throw new EmployeeAlreadyAddedException("Employee already added");
        }

        db_employees.add(newEmpl);

        return newEmpl;
    }

    @Override
    public Employee popEmpl(String firstName, String lastName, Integer department, Integer salary) {
        Employee popEmpl = new Employee(firstName, lastName, department, salary);
        if (db_employees.contains(popEmpl)) {
            db_employees.remove(popEmpl);
            return popEmpl;
        }
        throw new EmployeeNotFoundException("Employee not found");
    }

    @Override
    public Employee findEmpl(String firstName, String lastName, Integer department, Integer salary) {
        Employee popEmpl = new Employee(firstName, lastName, department, salary);
        if (db_employees.contains(popEmpl)) {
            return popEmpl;
        }
        throw new EmployeeNotFoundException("Employee not found");
    }

    public static List<Employee> getDb_employees() {
        return db_employees;
    }
}
