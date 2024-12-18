package com.adobe.aem.guides.demo.core.models;



import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class)
public class CapHeaderModel {

    @Inject
    @Default(values = "/content/dam/Demo/logo.jpeg")
    private String platformLogo;

    @Inject
    @Default(values = "Search here...")
    private String searchPlaceholder;

    public String getPlatformLogo() {
        return platformLogo;
    }

    public String getSearchPlaceholder() {
        return searchPlaceholder;
    }
}
