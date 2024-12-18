package com.adobe.aem.guides.demo.core.models;



import org.apache.sling.api.resource.Resource;

import java.util.Map;

public interface FooterModel {
    String getUdemyLink();
    String getAboutUsLink();
    String getEventsLink();
    String getPartnersLink();
    String getPartnerWithUdemyLink();
    String getProductTourLink();
    String getNewsLink();
    String getInvestorRelationsLink();
    String getCareersLink();
    String getContactUsLink();
    String getHelpLink();
    String getTermsLink();
    String getPrivacyLink();
    String getSitemapLink();
    String getFacebookLink();
    String getLinkedInLink();
    String getTwitterLink();
    String getInstagramLink();
    
    // A method to fetch all the properties
    Map<String, String> getAllLinks();
}
