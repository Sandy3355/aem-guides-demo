package com.adobe.aem.guides.demo.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import java.util.ArrayList;
import java.util.List;

@Model(
    adaptables = Resource.class,
    adapters = CourseDetailsModel.class,
    resourceType = "your-project/components/course-details", // Update with the correct resource type
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class CourseDetailsModelImpl implements CourseDetailsModel {

    @ChildResource(name = "courses")
    private Resource courses;

    @Override
    public List<Course> getCourses() {
        List<Course> courseList = new ArrayList<>();
        if (courses != null) {
            for (Resource courseResource : courses.getChildren()) {
                courseList.add(courseResource.adaptTo(CourseImpl.class));
            }
        }
        return courseList;
    }

    public static class CourseImpl implements Course {

        @ValueMapValue
        private String courseLogo;

        @ValueMapValue
        private String courseName;

        @ValueMapValue
        private String courseDescription;

        @ValueMapValue
        private String courseCost;

        @ValueMapValue
        private String courseRating;

        @ValueMapValue
        private Boolean learnMore;

        @ChildResource(name = "instructors")
        private Resource instructors;

        @Override
        public String getCourseLogo() {
            return courseLogo;
        }

        @Override
        public String getCourseName() {
            return courseName;
        }

        @Override
        public String getCourseDescription() {
            return courseDescription;
        }

        @Override
        public String getCourseCost() {
            return courseCost;
        }

        @Override
        public String getCourseRating() {
            return courseRating;
        }

        @Override
        public Boolean getLearnMore() {
            return learnMore;
        }

        @Override
        public List<Instructor> getInstructors() {
            List<Instructor> instructorList = new ArrayList<>();
            if (instructors != null) {
                for (Resource instructorResource : instructors.getChildren()) {
                    instructorList.add(instructorResource.adaptTo(InstructorImpl.class));
                }
            }
            return instructorList;
        }
    }

    public static class InstructorImpl implements Instructor {

        @ValueMapValue
        private String instructorLogo;

        @ValueMapValue
        private String instructorName;

        @ValueMapValue
        private String instructorExperience;

        @Override
        public String getInstructorLogo() {
            return instructorLogo;
        }

        @Override
        public String getInstructorName() {
            return instructorName;
        }

        @Override
        public String getInstructorExperience() {
            return instructorExperience;
        }
    }
}