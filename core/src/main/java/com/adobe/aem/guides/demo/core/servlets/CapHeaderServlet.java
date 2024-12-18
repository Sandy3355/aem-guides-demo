package com.adobe.aem.guides.demo.core.servlets;



import com.google.gson.JsonObject;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import java.io.IOException;

/**
 * Servlet for the Header Component
 */
@Component(
        service = Servlet.class,
        property = {
                "sling.servlet.methods=" + HttpConstants.METHOD_GET,
                "sling.servlet.paths=/bin/CapHeader/data",
                "sling.servlet.extensions=json"
        }
)
public class CapHeaderServlet extends SlingAllMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        // Set response content type
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Mock data for the header component
        String platformLogoPath = "/content/dam/Demo/logo.jpeg";
        String searchPlaceholder = "Search here...";

        // JSON response
        JsonObject jsonResponse = new JsonObject();
        jsonResponse.addProperty("platformLogo", platformLogoPath);
        jsonResponse.addProperty("searchPlaceholder", searchPlaceholder);

        // Write the JSON response
        response.getWriter().write(jsonResponse.toString());
    }
}

