package com.adobe.aem.guides.demo.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.scripting.SlingScriptHelper;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.Value;

import java.util.List;

import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = SlingScriptHelper.class)
public class LessonModel {

    @Self
    private Resource resource;

    @ValueMapValue
    private String lessontitle;

    @ValueMapValue
    private String video;

    @ValueMapValue
    private List<String> fields;

    // Getters for the properties
    public String getLessontitle() {
        return lessontitle;
    }

    public String getVideo() {
        return video;
    }

    public List<String> getFields() {
        return fields;
    }

}
