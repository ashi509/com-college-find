package com.college.find.repo;

import com.college.find.entity.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeFind extends JpaRepository<College,Long> {

}
