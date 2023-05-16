package com.college.find.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name= "course_fee")
public class CourseFee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private  long id;

    private double courseFee;

}
