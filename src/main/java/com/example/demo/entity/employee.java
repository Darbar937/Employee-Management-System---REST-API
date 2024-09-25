package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class employee {
    @Id
    public long empId;
    public String empName;
    public String empDept;
    public String email;
    public String mobile;


}
