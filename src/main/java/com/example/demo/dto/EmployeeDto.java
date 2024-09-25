package com.example.demo.dto;


import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {
    public long empId;
    @NotNull(message = "name is compulusory")
    @NotBlank(message = "name is mandatory")
    @Size(min = 2,max = 10,message = "name must be min 2 to mx 10")
    public String empName;
    @NotEmpty(message = "Department is mandatory")
    public String empDept;
    @Email(message = "email in correct form")
    public String email;
    @Size(min=2,max=10)
    public String mobile;


}
