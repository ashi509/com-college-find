package com.college.find.controller;

import com.college.find.entity.College;
import com.college.find.service.CollegeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/college")
public class CollegeDetail {
    @Autowired
    private CollegeService collegeService;
    @GetMapping

    ResponseEntity<?> getAllCollege(){

        return collegeService.getAllCollege();
    }
    @PostMapping
    ResponseEntity<?> addCollege(@Valid  @RequestBody College college) {
        return collegeService.addCollege(college);
    }
    @GetMapping("/course/{courseName}")
    ResponseEntity<?>findByCourseName(@PathVariable String courseName){
        return collegeService.findByCourseName(courseName);
    }
    @GetMapping("/college/{collegeName}")
    ResponseEntity<?>findByCollegeName(@PathVariable String collegeName) {
        return collegeService.findByCollegeName(collegeName);
    }
}
