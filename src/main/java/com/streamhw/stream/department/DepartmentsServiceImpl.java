package com.streamhw.stream.department;


import com.streamhw.stream.employee.Employee;
import com.streamhw.stream.employee.EmployeeServiceImp;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentsServiceImpl implements DepartmentsService {

    @Override
    public Integer maxSalaryByDepartment(Integer departmentId) {
        Optional<Employee> maxSalary = EmployeeServiceImp.getDb_employees().stream().filter(
                e1 -> departmentId.equals(e1.getDepartment())
        ).max(
                (e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary())
        );

        return maxSalary.isPresent() ? maxSalary.get().getSalary() : 0;
    }

    @Override
    public Integer minSalaryByDepartment(Integer departmentId) {
        Optional<Employee> minSalary = EmployeeServiceImp.getDb_employees().stream().filter(
                e1 -> departmentId.equals(e1.getDepartment())
        ).min(
                (e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary())
        );

        return minSalary.isPresent() ? minSalary.get().getSalary() : 0;
    }

    @Override
    public Integer sumSalaryByDepartment(Integer departmentId) {
        return EmployeeServiceImp.getDb_employees().stream()
                .filter(e1 -> departmentId.equals(e1.getDepartment()))
                .mapToInt(e -> e.getSalary()).sum();
    }

    @Override
    public List<Employee> employeeByDepartment(Integer departmentId) {

        return EmployeeServiceImp.getDb_employees().stream().filter(
                e1 -> departmentId.equals(e1.getDepartment())).toList();
    }

    @Override
    public Map<Integer, List<Employee>> allByDepartment() {
        return EmployeeServiceImp.getDb_employees().stream().collect(Collectors.groupingBy(e -> e.getDepartment()));
    }
}
