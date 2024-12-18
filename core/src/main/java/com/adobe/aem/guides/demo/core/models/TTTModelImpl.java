package com.adobe.aem.guides.demo.core.models;



import java.util.ArrayList;
import java.util.List;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = {Resource.class,SlingHttpServletRequest.class}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TTTModelImpl implements TTTModel {

    @SlingObject
    private Resource resource;

    @ValueMapValue
    private String textarea;

    @ValueMapValue
    private String path;

    @ValueMapValue
    private boolean checkbox;

    @Override
    public String getTextarea() {
        return textarea;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public boolean getCheckbox() {
        return checkbox;
    }

    @Override
public List<MultifieldItem> getMultifield() {
    List<MultifieldItem> multifieldItems = new ArrayList<>();
    Resource multifieldResource = resource.getChild("multifield");

    if (multifieldResource != null) {
        for (Resource item : multifieldResource.getChildren()) {
            String text = item.getValueMap().get("text", String.class);
            String date = item.getValueMap().get("date", String.class);
            System.out.println("Text: " + text + ", Date: " + date); // Debug log
            multifieldItems.add(new MultifieldItem(text, date));
        }
    } else {
        System.out.println("Multifield resource is null"); // Debug log
    }

    return multifieldItems;
}

}