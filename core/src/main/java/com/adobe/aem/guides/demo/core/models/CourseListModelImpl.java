package com.adobe.aem.guides.demo.core.models;


import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.Arrays;
import java.util.List;

@Model(
        adaptables = Resource.class,
        adapters = { CourseListModel.class, ComponentExporter.class },
        resourceType = "example/components/courselisting",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class CourseListModelImpl implements CourseListModel {

    @ValueMapValue
    private String searchBarPlaceholder;

    @ValueMapValue
    private boolean enableFilters;

    @ValueMapValue
    private List<String> categories;

    @ValueMapValue
    private List<String> priceOptions;

    @Override
    public String getSearchBarPlaceholder() {
        // Provide a default value if none is configured
        return searchBarPlaceholder != null ? searchBarPlaceholder : "Search for courses...";
    }

    @Override
    public boolean isFiltersEnabled() {
        return enableFilters;
    }

    @Override
    public List<String> getCategories() {
        // Default categories if none are configured
        return categories != null ? categories : Arrays.asList("JAVA", "AEM", "PYTHON", "FULLSTACK", "SALESFORCE");
    }

    @Override
    public List<String> getPriceOptions() {
        // Default price options if none are configured
        return priceOptions != null ? priceOptions : Arrays.asList("Free", "Paid");
    }

    
}