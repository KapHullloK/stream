package com.streamhw.stream.employee;

import com.streamhw.stream.exceptions.EmployeeAlreadyAddedException;
import com.streamhw.stream.exceptions.EmployeeNotFoundException;
import com.streamhw.stream.exceptions.EmployeeStorageIsFullException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceImpTest {


    private static EmployeeService employeeService = new EmployeeServiceImp();
    String firstName;
    String secondName;
    Integer salary;
    Integer department;


    @BeforeEach
    void setUp() {
        firstName = "as";
        secondName = "asd";
        salary = 1000;
        department = 1;
    }

    @Test
    public void addEmployee() {

        Employee newEmpl = employeeService.addEmpl(firstName, secondName, department, salary);
        assertEquals(newEmpl, new Employee(firstName, secondName, department, salary));

        assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService.addEmpl(firstName, secondName, department, salary));

        for (int i = 1; i < 1000; ++i) {
            employeeService.addEmpl(firstName + i, secondName, department, salary);
        }
        assertThrows(EmployeeStorageIsFullException.class,
                () -> employeeService.addEmpl(firstName + "m", secondName, department, salary));


        employeeService.popEmpl(firstName, secondName, department, salary);
        for (int i = 1; i < 1000; ++i) {
            employeeService.popEmpl(firstName + i, secondName, department, salary);
        }
    }

    @Test
    public void popEmployee() {
        assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.popEmpl(firstName, secondName, department, salary));

        Employee newEmpl = employeeService.addEmpl(firstName, secondName, department, salary);
        assertEquals(newEmpl, employeeService.popEmpl(firstName, secondName, department, salary));
    }


    @Test
    public void findEmployee() {
        assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.findEmpl(firstName, secondName, department, salary));

        employeeService.addEmpl(firstName, secondName, department, salary);
        Employee newEmpl = employeeService.findEmpl(firstName, secondName, department, salary);
        assertEquals(newEmpl, employeeService.findEmpl(firstName, secondName, department, salary));
    }
}
