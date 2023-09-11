package com.example.cruddemo.service;

import com.example.cruddemo.dao.EmployeeRepository;
import com.example.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theRepository){
        employeeRepository=theRepository;
    }
    @Override
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id);
    }
    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }
    @Transactional
    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);

    }


}
