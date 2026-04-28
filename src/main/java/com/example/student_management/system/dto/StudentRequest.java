package com.example.student_management.system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequest {
    private String studentName;
    private String email;
    private String phone;
    private String address;
    private String age;
    private String course;

}
