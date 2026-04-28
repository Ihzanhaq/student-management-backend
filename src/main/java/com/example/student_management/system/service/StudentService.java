package com.example.student_management.system.service;

import com.example.student_management.system.dto.StudentRequest;
import com.example.student_management.system.entity.Student;
import com.example.student_management.system.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student createStudent(StudentRequest request) {
        Student student = Student.builder()
                .studentName(request.getStudentName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .course(request.getCourse())
                .age(request.getAge())
                .address(request.getAddress())
                .build();

        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    public Student updateStudent(Long id, StudentRequest request) {
        Student student = getStudentById(id);

        student.setStudentName(request.getStudentName());
        student.setEmail(request.getEmail());
        student.setPhone(request.getPhone());
        student.setCourse(request.getCourse());
        student.setAge(request.getAge());
        student.setAddress(request.getAddress());

        return studentRepository.save(student);
    }

    public String deleteStudent(Long id) {
        Student student = getStudentById(id);
        studentRepository.delete(student);
        return "Student deleted successfully";
    }
}
