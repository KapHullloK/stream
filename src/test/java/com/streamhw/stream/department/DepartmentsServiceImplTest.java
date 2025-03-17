package com.streamhw.stream.department;

import com.streamhw.stream.employee.Employee;
import com.streamhw.stream.employee.EmployeeServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DepartmentsServiceImplTest {

    private DepartmentsService departmentsService;
    private List<Employee> mockEmployees;

    @BeforeEach
    void setUp() {
        departmentsService = new DepartmentsServiceImpl();

        mockEmployees = List.of(
                new Employee("John", "Doe", 1, 5000),
                new Employee("Jin", "Lee", 1, 5500),
                new Employee("Jane", "Smith", 2, 6000)
        );

    }

    @Test
    void maxSalaryByDepartment() {

        try (MockedStatic<EmployeeServiceImp> mockedStatic = Mockito.mockStatic(EmployeeServiceImp.class)) {
            mockedStatic.when(() -> EmployeeServiceImp.getDb_employees()).thenReturn(mockEmployees);

            Integer actual = departmentsService.maxSalaryByDepartment(1);
            assertEquals(5500, actual);
        }
    }

    @Test
    void minSalaryByDepartment() {

        try (MockedStatic<EmployeeServiceImp> mockedStatic = Mockito.mockStatic(EmployeeServiceImp.class)) {
            mockedStatic.when(() -> EmployeeServiceImp.getDb_employees()).thenReturn(mockEmployees);

            Integer actual = departmentsService.minSalaryByDepartment(1);
            assertEquals(5000, actual);
        }
    }

    @Test
    void sumSalaryByDepartment() {

        try (MockedStatic<EmployeeServiceImp> mockedStatic = Mockito.mockStatic(EmployeeServiceImp.class)) {
            mockedStatic.when(() -> EmployeeServiceImp.getDb_employees()).thenReturn(mockEmployees);

            Integer actual = departmentsService.sumSalaryByDepartment(1);
            assertEquals(10500, actual);
        }
    }

    @Test
    void employeeByDepartment() {

        try (MockedStatic<EmployeeServiceImp> mockedStatic = Mockito.mockStatic(EmployeeServiceImp.class)) {
            mockedStatic.when(() -> EmployeeServiceImp.getDb_employees()).thenReturn(mockEmployees);

            List<Employee> actual = departmentsService.employeeByDepartment(1);
            assertEquals(List.of(
                    new Employee("John", "Doe", 1, 5000),
                    new Employee("Jin", "Lee", 1, 5500)
            ), actual);
        }
    }

    @Test
    void allByDepartment() {

        try (MockedStatic<EmployeeServiceImp> mockedStatic = Mockito.mockStatic(EmployeeServiceImp.class)) {
            mockedStatic.when(() -> EmployeeServiceImp.getDb_employees()).thenReturn(mockEmployees);

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
}