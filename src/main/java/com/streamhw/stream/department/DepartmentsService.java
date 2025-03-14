package com.streamhw.stream.department;

import com.streamhw.stream.employee.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentsService {
    public Employee maxSalaryByDepartment(Integer departmentId);

    public Employee minSalaryByDepartment(Integer departmentId);

    public List<Employee> employeeByDepartment(Integer departmentId);

    public Map<Integer, List<Employee>> allByDepartment();
}
