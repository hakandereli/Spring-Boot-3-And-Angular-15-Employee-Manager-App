package com.hakandereli.employeemanager.controller.v1;

import com.hakandereli.employeemanager.model.Employee;
import com.hakandereli.employeemanager.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(path = "employeemanager/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.findAllEmployee();
        return new ResponseEntity<>(employees, OK);
    }

    @GetMapping(path = "/find/{employeeID}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("employeeID") Long id) {
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, CREATED);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(OK);

    }
}
