package kz.dar.academy.backend.employeecoreapi.services;

import kz.dar.academy.backend.employeecoreapi.model.EmployeeRequest;
import kz.dar.academy.backend.employeecoreapi.model.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    EmployeeResponse createEmployee(EmployeeRequest employeeRequest);

    EmployeeResponse updateEmployee(EmployeeRequest employeeRequest);

    EmployeeResponse getEmployeeById(String id);

    List<EmployeeResponse> getAllEmployees();

    void deleteEmployeeById(String id);
}
