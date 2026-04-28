package com.example.student_management.system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseRequest {
    private String courseName;
    private String description;
    private String duration;
}
