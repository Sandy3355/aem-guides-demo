package com.adobe.aem.guides.demo.core.models;

import java.util.Date;
import java.util.List;

public interface HinduModel {

    public String getHinduTitle();

    public String getHinduDes();

    public String getHinduImage();

    public Date getHinduPublishDate();

    public int getHinduNumber();

    public List<String> getHinduMultifield();

    public String getPageName();

    public String getJcrCreated();
}