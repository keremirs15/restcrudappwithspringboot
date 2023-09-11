package com.example.cruddemo.rest;

import com.example.cruddemo.entity.Employee;
import com.example.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService service;

    // constructor injection
    @Autowired
    public EmployeeRestController(EmployeeService theService){
        service=theService;
    }

    // expose /employees and return a list of employees

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return service.findAll();
    }
    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId){
        Employee theEmployee = service.findById(employeeId);

        if (theEmployee == null){
            throw new RuntimeException("employee id not found "+ employeeId);
        }
        else{
            return theEmployee;
        }
    }
    @PostMapping("/employees")
    public Employee add(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        Employee dbEmployee=service.save(theEmployee);
        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee update(@RequestBody Employee theEmployee){
        Employee dbemployee= service.save(theEmployee);
        return dbemployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String delete(@PathVariable int employeeId){

        Employee tempEmployee=service.findById(employeeId);

        if(tempEmployee == null){
            throw new RuntimeException("couldnt find it ");
        }

        service.deleteById(employeeId);

        return "employee with "+ employeeId+" has deleted";

    }


}
