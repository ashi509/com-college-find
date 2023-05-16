package com.college.find.service;

import com.college.find.entity.College;
import org.springframework.http.ResponseEntity;

public interface CollegeService {
    ResponseEntity<?> getAllCollege();
    ResponseEntity<?> addCollege(College college);
    ResponseEntity<?> findByCourseName(String courseName);
    ResponseEntity<?> findByCollegeName(String collegeName);
}
