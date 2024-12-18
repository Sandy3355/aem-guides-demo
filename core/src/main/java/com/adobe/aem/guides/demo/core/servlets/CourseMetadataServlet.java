package com.adobe.aem.guides.demo.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;

@Component(service = Servlet.class, immediate = true)
@SlingServletResourceTypes(resourceTypes = "demo/courseMetadata")
public class CourseMetadataServlet extends SlingAllMethodsServlet {

    // This method handles GET requests
    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {
        // Fetch metadata (e.g., course name, description, lessons, etc.)
        String courseId = request.getParameter("courseId"); // assuming the courseId is passed as a query parameter

        // Fetch course metadata (can be fetched from JCR repository or elsewhere)
        String courseMetadata = getCourseMetadata(courseId);

        // Send metadata as response
        response.setContentType("application/json");
        response.getWriter().write(courseMetadata);
    }

    // This method handles PUT requests (to update course metadata)
    @Override
    protected void doPut(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {
        // Logic for updating course metadata (not implemented in this example)
        response.getWriter().write("response coming from CourseMetadataServlet-->PUT");
    }

    // This method handles POST requests (to create new courses)
    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {
        // Logic for creating a new course (not implemented in this example)
        response.getWriter().write("response coming from CourseMetadataServlet-->POST");
    }

    // This method handles DELETE requests (to delete a course)
    @Override
    protected void doDelete(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {
        // Logic for deleting a course (not implemented in this example)
        response.getWriter().write("response coming from CourseMetadataServlet-->DELETE");
    }

    // Utility method to simulate fetching course metadata (replace with actual JCR querying or database call)
    private String getCourseMetadata(String courseId) {
        // For demo purposes, returning a mock metadata in JSON format
        // In a real scenario, this would query the JCR or another data source for metadata
        return "{"
            + "\"courseId\": \"" + courseId + "\","
            + "\"courseName\": \"Introduction to AEM\","
            + "\"description\": \"Learn the basics of Adobe Experience Manager\","
            + "\"lessons\": ["
            + "{ \"lessonId\": \"1\", \"lessonName\": \"Getting Started with AEM\" },"
            + "{ \"lessonId\": \"2\", \"lessonName\": \"Working with Components\" }"
            + "]"
            + "}";
    }
}