package com.college.find.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name= "college")
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotEmpty(message = "College name can not empty")
    @Size(min=3,max=30,message = "college name must be have 3 to 30  character")
    @Column(name="college_name")
    private String collegeName;
    @NotEmpty(message = "Course name can not empty")
    @Column(name = "course_name")
    private String courseName;


    @NotEmpty
    @Column(name = "duration_of_course")
    private String durationOfCourse;

    @NotEmpty
    @Column(name = "accommodation_Ac")
    private String accommodationAc;
    @NotEmpty
    @Column(name = "accommodation_Non_AC")
    private String accommodationNonAc;

    @Column(name="accommodation_fee")
    private double accommodationFee;
    @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER,orphanRemoval = true)

    private CourseFee courseFee;


}
