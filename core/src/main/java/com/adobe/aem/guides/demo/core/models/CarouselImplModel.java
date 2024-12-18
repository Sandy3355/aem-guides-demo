package com.adobe.aem.guides.demo.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.ArrayList;
import java.util.List;

@Model(adaptables = {Resource.class, SlingHttpServletRequest.class}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CarouselImplModel implements CarouselModel {

    @SlingObject
    private Resource resource;

   

    @ValueMapValue
    private String path;

   

    @Override
    public List<MultifieldItem> getMultifield() {
        List<MultifieldItem> multifieldItems = new ArrayList<>();
        Resource multifieldResource = resource.getChild("multifield");

        if (multifieldResource != null) {
            for (Resource item : multifieldResource.getChildren()) {
                String text = item.getValueMap().get("text", String.class);
                String path = item.getValueMap().get("path", String.class);
                List<InnerMultifieldItem> innerMultifields = new ArrayList<>();

                // Nested multifield items (within each multifield item)
                Resource nestedMultifield = item.getChild("multifield");
                if (nestedMultifield != null) {
                    for (Resource nestedItem : nestedMultifield.getChildren()) {
                        String nestedText = nestedItem.getValueMap().get("texts", String.class);
                        innerMultifields.add(new InnerMultifieldItem(nestedText));
                    }
                }

                multifieldItems.add(new MultifieldItem(text, path, innerMultifields));
            }
        } else {
            System.out.println("Multifield resource is null");
        }

        return multifieldItems;
    }
   
}