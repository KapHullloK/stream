package com.streamhw.stream.department;


import com.streamhw.stream.employee.Employee;
import com.streamhw.stream.employee.EmployeeServiceImp;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentsServiceImpl implements DepartmentsService {

    private static List<Employee> db_employees = EmployeeServiceImp.getDb_employees();

    @Override
    public Employee maxSalaryByDepartment(Integer departmentId) {
        Optional<Employee> maxSalary = db_employees.stream().filter(
                e1 -> departmentId.equals(e1.getDepartment())
        ).max(
                (e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary())
        );

        return maxSalary.orElse(null);
    }

    @Override
    public Employee minSalaryByDepartment(Integer departmentId) {
        Optional<Employee> minSalary = db_employees.stream().filter(
                e1 -> departmentId.equals(e1.getDepartment())
        ).min(
                (e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary())
        );

        return minSalary.orElse(null);
    }

    @Override
    public List<Employee> employeeByDepartment(Integer departmentId) {

        return db_employees.stream().filter(
                e1 -> departmentId.equals(e1.getDepartment())).toList();
    }

    @Override
    public Map<Integer, List<Employee>> allByDepartment() {
        return db_employees.stream().collect(Collectors.groupingBy(e -> e.getDepartment()));
    }
}
