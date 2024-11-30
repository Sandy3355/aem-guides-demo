package com.adobe.aem.guides.demo.core.models;

import java.util.Date;
import java.util.List;

public interface ArticleModel {

    public String getArticleTitle();

    public String getArticleDes();

    public String getArticleImage();

    public Date getArticlePublishDate();

    public int getArticleNumber();

    public List<String> getArticleMultifield();

    public String getPageName();

    public String getJcrCreated();
}
