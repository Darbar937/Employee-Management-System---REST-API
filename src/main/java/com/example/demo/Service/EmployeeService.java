package com.example.demo.Service;

import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.employee;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository empRep;

    @Autowired
    ModelMapper modelMapper;

    public EmployeeDto saveEmp(EmployeeDto empDto) {
        employee emp=mapToEntity(empDto);
        employee savedEntity= empRep.save(emp);
        EmployeeDto emppDto=mapToDto(savedEntity);
        return emppDto;
    }

    public EmployeeDto mapToDto(employee emp){
        return modelMapper.map(emp, EmployeeDto.class);
    }
    public employee mapToEntity(EmployeeDto empDto){
        return modelMapper.map(empDto, employee.class);
    }

    public EmployeeDto fetEmp(long empId) {
       employee emp=empRep.findById(empId).orElseThrow(
        ()-> new RuntimeException("id not found")
        );
        return  mapToDto(emp);
    }

    public EmployeeDto delEmp(long empId) {
        empRep.deleteById(empId);
        return null;
    }

    public EmployeeDto upDateemp(long empId, EmployeeDto empDto) {
        employee emppDto=empRep.findById(empId).orElseThrow(
                ()->new RuntimeException("Resource not found")
        );
        employee emp=mapToEntity(empDto);
        employee savedEntity= empRep.save(emp);
        EmployeeDto empppDto=mapToDto(savedEntity);
        return empppDto;
    }
}
