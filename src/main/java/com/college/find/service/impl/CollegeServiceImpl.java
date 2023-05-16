package com.college.find.service.impl;

import com.college.find.entity.College;
import com.college.find.exception.GenericException;
import com.college.find.repo.CollegeFind;
import com.college.find.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CollegeServiceImpl implements CollegeService {
    @Autowired
    private CollegeFind collegeFind;
    @Override
    public ResponseEntity<?> getAllCollege() {
        var college=collegeFind.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(college);
    }

    @Override
    public ResponseEntity<?> addCollege(College college) {
        college.setId(0);
        college.getCourseFee().setId(0);
        var colleges=collegeFind.save(college);
        if(colleges==null)
            throw new GenericException(HttpStatus.NOT_FOUND.value(), "Data you have enter does not exists ");
        return ResponseEntity.ok(colleges);
    }

    @Override
    public ResponseEntity<?> findByCourseName(String courseName) {
        var college=collegeFind.findAll();
        if (college==null)
            throw new GenericException(HttpStatus.NO_CONTENT.value(), "can not found all detail of table");
       college= college.stream().filter(e->e.getCourseName().equalsIgnoreCase(courseName)).collect(Collectors.toList());
       if(college==null)
           throw new GenericException(HttpStatus.NOT_FOUND.value(), "Course not found with given course "+courseName);
       return ResponseEntity.status(HttpStatus.OK).body(college);
    }

    @Override
    public ResponseEntity<?> findByCollegeName(String collegeName) {
        var colleges= collegeFind.findAll();
         colleges =colleges.stream().filter(college1 -> college1.getCollegeName().equalsIgnoreCase(collegeName)).collect(Collectors.toList());
    if(colleges==null)
        throw new GenericException(HttpStatus.NO_CONTENT.value(), "college not found "+collegeName);
    return ResponseEntity.status(HttpStatus.OK).body(colleges);
    }
}
