package com.adobe.aem.guides.demo.core.models;

import java.util.List;

public interface CourseListModel {

    /**
     * Get the placeholder text for the search bar.
     * 
     * @return the placeholder text.
     */
    String getSearchBarPlaceholder();

    /**
     * Check if filters are enabled.
     * 
     * @return true if filters are enabled, false otherwise.
     */
    boolean isFiltersEnabled();

    /**
     * Get the list of available categories for the filter.
     * 
     * @return list of categories.
     */
    List<String> getCategories();

    /**
     * Get the list of available price options for the filter.
     * 
     * @return list of price options.
     */
    List<String> getPriceOptions();
}