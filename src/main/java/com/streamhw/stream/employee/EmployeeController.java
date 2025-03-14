package com.streamhw.stream.employee;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("department") Integer department,
                                @RequestParam("salary") Integer salary) {

        return employeeService.addEmpl(firstName, lastName, department, salary);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName,
                                   @RequestParam("department") Integer department,
                                   @RequestParam("salary") Integer salary) {

        return employeeService.popEmpl(firstName, lastName, department, salary);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName,
                                 @RequestParam("department") Integer department,
                                 @RequestParam("salary") Integer salary) {

        return employeeService.findEmpl(firstName, lastName, department, salary);
    }

    @GetMapping(path = "/all")
    public List<Employee> getAllEmployees() {
        return EmployeeServiceImp.getDb_employees();
    }
}
