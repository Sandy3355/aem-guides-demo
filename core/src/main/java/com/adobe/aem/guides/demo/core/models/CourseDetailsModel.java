package com.adobe.aem.guides.demo.core.models;

import java.util.List;

public interface CourseDetailsModel {

    List<Course> getCourses();

    interface Course {
        String getCourseLogo();
        String getCourseName();
        String getCourseDescription();
        String getCourseCost();
        String getCourseRating();
        Boolean getLearnMore();
        List<Instructor> getInstructors();
    }

    interface Instructor {
        String getInstructorLogo();
        String getInstructorName();
        String getInstructorExperience();
    }
}