package com.adobe.aem.guides.demo.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class HomepageModel {

    // Banner Section
    @ValueMapValue
    private String bannerTitle;

    @ValueMapValue
    private String bannerSubtitle;

    @ValueMapValue
    private String bannerImage;

    // Featured Courses Section
    @ChildResource(name = "featuredCourses/courses")
    private Resource featuredCoursesResource;

    // Course Categories Section
    @ChildResource(name = "courseCategories/categories")
    private Resource courseCategoriesResource;

    // Testimonials Section
    @ChildResource(name = "testimonials/items")
    private Resource testimonialsResource;

    // Getters for Banner Section
    public String getBannerTitle() {
        return bannerTitle;
    }

    public String getBannerSubtitle() {
        return bannerSubtitle;
    }

    public String getBannerImage() {
        return bannerImage;
    }

    // Getters for Featured Courses Section
    public List<Course> getFeaturedCourses() {
        return getItemsFromResource(featuredCoursesResource, Course::new);
    }

    // Getters for Course Categories Section
    public List<Category> getCourseCategories() {
        return getItemsFromResource(courseCategoriesResource, Category::new);
    }

    // Getters for Testimonials Section
    public List<Testimonial> getTestimonials() {
        return getItemsFromResource(testimonialsResource, Testimonial::new);
    }

    // Utility method to extract items from a resource
    private <T> List<T> getItemsFromResource(Resource resource, ItemMapper<T> mapper) {
        if (resource != null) {
            return StreamSupport.stream(resource.getChildren().spliterator(), false)
                    .map(mapper::map)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    @FunctionalInterface
    private interface ItemMapper<T> {
        T map(Resource resource);
    }

    // Nested Class for Course
    public static class Course {
        private final String title;
        private final String image;
        private final String link;

        public Course(Resource resource) {
            ValueMap properties = resource.getValueMap();
            this.title = properties.get("title", String.class);
            this.image = properties.get("image", String.class);
            this.link = properties.get("link", String.class);
        }

        public String getTitle() {
            return title;
        }

        public String getImage() {
            return image;
        }

        public String getLink() {
            return link;
        }
    }

    // Nested Class for Category
    public static class Category {
        private final String name;
        private final String image;
        private final String link;

        public Category(Resource resource) {
            ValueMap properties = resource.getValueMap();
            this.name = properties.get("name", String.class);
            this.image = properties.get("image", String.class);
            this.link = properties.get("link", String.class);
        }

        public String getName() {
            return name;
        }

        public String getImage() {
            return image;
        }

        public String getLink() {
            return link;
        }
    }

    // Nested Class for Testimonial
    public static class Testimonial {
        private final String name;
        private final String quote;
        private final String photo;

        public Testimonial(Resource resource) {
            ValueMap properties = resource.getValueMap();
            this.name = properties.get("name", String.class);
            this.quote = properties.get("quote", String.class);
            this.photo = properties.get("photo", String.class);
        }

        public String getName() {
            return name;
        }

        public String getQuote() {
            return quote;
        }

        public String getPhoto() {
            return photo;
        }
    }
}
