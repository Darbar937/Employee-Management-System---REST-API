package com.example.demo.Controller;

import com.example.demo.Service.EmployeeService;
import com.example.demo.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/emp")
public class EmpController {
    @Autowired
    EmployeeService empSer;
    public  EmpController( EmployeeService empSer){
        empSer=this.empSer;
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmp(@RequestBody EmployeeDto empDto){
        EmployeeDto deg=empSer.saveEmp(empDto);
        return new ResponseEntity<>(deg, HttpStatus.CREATED);
    }
    @GetMapping("/{empId}")
    public ResponseEntity<EmployeeDto>getEmpId(@PathVariable long empId ){
        EmployeeDto deg=empSer.fetEmp(empId);
        return new ResponseEntity<>(deg,HttpStatus.OK);
    }

    @DeleteMapping("/{empId}")
    public ResponseEntity<EmployeeDto>getDelEmp(@PathVariable long empId){
        EmployeeDto deg=empSer.delEmp(empId);
        return new ResponseEntity<>(deg,HttpStatus.ACCEPTED);
    }
    @PutMapping("/{empId}")
    public ResponseEntity<EmployeeDto> updatEmp(@PathVariable long empId,@RequestBody EmployeeDto empDto){
        EmployeeDto empDDto=empSer.upDateemp(empId,empDto);
        return new ResponseEntity<>(empDDto,HttpStatus.CREATED);
    }




}
