package com.streamhw.stream.department;

import com.streamhw.stream.employee.Employee;
import com.streamhw.stream.employee.EmployeeService;
import com.streamhw.stream.employee.EmployeeServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
class DepartmentsServiceImplTest {

    @Mock
    private EmployeeService employeeService;

    private DepartmentsService departmentsService;

    @BeforeEach
    void setUp() {
        departmentsService = new DepartmentsServiceImpl(employeeService);

        Mockito.when(employeeService.getDbEmployees()).thenReturn(List.of(
                new Employee("John", "Doe", 1, 5000),
                new Employee("Jin", "Lee", 1, 5500),
                new Employee("Jane", "Smith", 2, 6000)
        ));
    }

    @Test
    void maxSalaryByDepartment() {

        assertEquals(5500, departmentsService.maxSalaryByDepartment(1));
    }


    @Test
    void minSalaryByDepartment() {

        assertEquals(5000, departmentsService.minSalaryByDepartment(1));
    }

    @Test
    void sumSalaryByDepartment() {

        assertEquals(10500, departmentsService.sumSalaryByDepartment(1));
    }

    @Test
    void employeeByDepartment() {

        List<Employee> actual = departmentsService.employeeByDepartment(1);
        assertEquals(List.of(
                new Employee("John", "Doe", 1, 5000),
                new Employee("Jin", "Lee", 1, 5500)
        ), actual);
    }

    @Test
    void allByDepartment() {

        Map<Integer, List<Employee>> actual = departmentsService.allByDepartment();
        assertEquals(Map.of(
                1, List.of(
                        new Employee("John", "Doe", 1, 5000),
                        new Employee("Jin", "Lee", 1, 5500)
                ),
                2, List.of(
                        new Employee("Jane", "Smith", 2, 6000)
                )), actual);
    }
}