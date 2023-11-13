package kz.dar.academy.backend.employeecoreapi.controllers;

import kz.dar.academy.backend.employeecoreapi.model.EmployeeRequest;
import kz.dar.academy.backend.employeecoreapi.model.EmployeeResponse;
import kz.dar.academy.backend.employeecoreapi.services.EmployeeService;
import kz.dar.academy.backend.employeecoreapi.services.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/check")
    public String check() {
        return "Employee-core-api is working at";
    }

    @PostMapping()
    public EmployeeResponse createEmployee(@RequestBody EmployeeRequest employeeRequest){
        return employeeService.createEmployee(employeeRequest);
    }

    @PutMapping()
    public EmployeeResponse updateEmployee(@RequestParam String id, @RequestBody EmployeeRequest employeeRequest){
        employeeRequest.setEmployeeId(id);
        return employeeService.updateEmployee(employeeRequest);
    }

    @GetMapping("/all")
    public List<EmployeeResponse> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping()
    public EmployeeResponse getEmployeeById(@RequestParam String id){
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping()
    public void deleteById(@RequestParam String id){
        employeeService.deleteEmployeeById(id);
    }
}
