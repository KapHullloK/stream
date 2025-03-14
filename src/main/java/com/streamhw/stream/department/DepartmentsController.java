package com.streamhw.stream.department;


import com.streamhw.stream.employee.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentsController {

    private final DepartmentsService departmentsService;

    public DepartmentsController(DepartmentsService departmentsService) {
        this.departmentsService = departmentsService;
    }

    @GetMapping(path = "/max-salary")
    public Employee maxSalary(@RequestParam("departmentId") Integer depId) {
        return departmentsService.maxSalaryByDepartment(depId);
    }

    @GetMapping(path = "/min-salary")
    public Employee minSalary(@RequestParam("departmentId") Integer depId) {
        return departmentsService.minSalaryByDepartment(depId);
    }

    @GetMapping(path = "/all", params = "departmentId")
    public List<Employee> EmployeesByDepartment(@RequestParam("departmentId") Integer depId) {
        return departmentsService.employeeByDepartment(depId);
    }

    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> allEmployeesByDepartment() {
        return departmentsService.allByDepartment();
    }
}
