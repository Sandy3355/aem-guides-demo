package com.adobe.aem.guides.demo.core.models;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.day.cq.wcm.api.Page;

@Model(adaptables = {Resource.class,SlingHttpServletRequest.class}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class HinduModelImpl implements  HinduModel{

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String des;

    @ValueMapValue
    private String image;

    @ValueMapValue
    private Date date;

    @ValueMapValue
    private int number;

    @ValueMapValue
    private List<String> company;

    @ValueMapValue
    @Named(value = "jcr:createdBy")
    private String name;

    @ScriptVariable
    Page currentPage;

    @Override
    public Date getHinduPublishDate() {
        // TODO Auto-generated method stub
        return date;
    }

    @Override
    public String getHinduDes() {
        // TODO Auto-generated method stub
        return des;
    }

    @Override
    public String getHinduImage() {
        // TODO Auto-generated method stub
        return image;
    }

    @Override
    public List<String> getHinduMultifield() {
        // TODO Auto-generated method stub
        return company;
    }

    @Override
    public int getHinduNumber() {
        // TODO Auto-generated method stub
        return number;
    }

    @Override
    public String getHinduTitle() {
        // TODO Auto-generated method stub
        return title;
    }

    @Override
    public String getPageName() {
        // TODO Auto-generated method stub
        return currentPage.getPageTitle();
    }

    @Override
    public String getJcrCreated() {
        // TODO Auto-generated method stub
        return name;
    }

}
