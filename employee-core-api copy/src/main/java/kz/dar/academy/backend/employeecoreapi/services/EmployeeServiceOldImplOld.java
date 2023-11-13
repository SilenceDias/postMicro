package kz.dar.academy.backend.employeecoreapi.services;

import kz.dar.academy.backend.employeecoreapi.model.EmployeeModel;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceOldImplOld implements EmployeeServiceOld {
    private static final HashMap<String, EmployeeModel> employeeMap = new HashMap<>();

    static {
        EmployeeModel employeeModel1 = new EmployeeModel(UUID.randomUUID().toString(), "Dias", "Rakhimov",
                "DAR", "Engineer",
                "dias@gmail.com", 300000);
        EmployeeModel employeeModel2 = new EmployeeModel(UUID.randomUUID().toString(), "Aidos", "Manap",
                "DAR", "Designer", "dosya@gmail.com", 500000);
        EmployeeModel employeeModel3 = new EmployeeModel(UUID.randomUUID().toString(), "Sanzhar", "Adykhanov",
                "DAR", "Engineer",
                "sancho@gmail.com", 600000);
        employeeMap.put(employeeModel1.getEmployeeId() ,employeeModel1);
        employeeMap.put(employeeModel2.getEmployeeId() ,employeeModel2);
        employeeMap.put(employeeModel3.getEmployeeId() ,employeeModel3);
    }
    @Override
    public void createEmployee(EmployeeModel employeeModel) {
        employeeModel.setEmployeeId(UUID.randomUUID().toString());
        employeeMap.put(employeeModel.getEmployeeId(),employeeModel);
    }

    @Override
    public List<EmployeeModel> getAllEmployees() {
        return new ArrayList<>(employeeMap.values());
    }

    @Override
    public EmployeeModel getEmployeeById(String employeeId) {
        return employeeMap.get(employeeId);
    }

    @Override
    public void updateEmployeeById(String employeeId, EmployeeModel employeeModel) {
        employeeModel.setEmployeeId(employeeId);
        employeeMap.put(employeeId, employeeModel);
    }

    @Override
    public void deleteEmployeeById(String employeeId) {
        employeeMap.remove(employeeId);
    }
}
