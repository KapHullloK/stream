package com.streamhw.stream.department;


import com.streamhw.stream.employee.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/department")
public class DepartmentsController {

    private final DepartmentsService departmentsService;

    public DepartmentsController(DepartmentsService departmentsService) {
        this.departmentsService = departmentsService;
    }

    @GetMapping(path = "/{id}/salary/max")
    public Integer maxSalary(@PathVariable Integer id) {
        return departmentsService.maxSalaryByDepartment(id);
    }

    @GetMapping(path = "/{id}/salary/min")
    public Integer minSalary(@PathVariable Integer id) {
        return departmentsService.minSalaryByDepartment(id);
    }

    @GetMapping(path = "/{id}/salary/sum")
    public Integer sumSalary(@PathVariable Integer id) {
        return departmentsService.sumSalaryByDepartment(id);
    }

        @GetMapping(path = "/{id}/emplo yees")
    public List<Employee> EmployeesByDepartment(@PathVariable Integer id) {
        return departmentsService.employeeByDepartment(id);
    }

    @GetMapping(path = "/employees")
    public Map<Integer, List<Employee>> allEmployeesByDepartment() {
        return departmentsService.allByDepartment();
    }
}
