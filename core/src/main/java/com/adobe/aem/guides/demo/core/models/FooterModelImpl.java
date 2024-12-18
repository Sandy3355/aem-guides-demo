package com.adobe.aem.guides.demo.core.models;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.api.resource.ResourceResolver;

import javax.jcr.Node;
import java.util.HashMap;
import java.util.Map;

public class FooterModelImpl implements FooterModel {

    private final Resource resource;

    public FooterModelImpl(Resource resource) {
        this.resource = resource;
    }

    // Fetch individual links from the resource
    @Override
    public String getUdemyLink() {
        return getLink("udemyLink");
    }

    @Override
    public String getAboutUsLink() {
        return getLink("aboutUsLink");
    }

    @Override
    public String getEventsLink() {
        return getLink("eventsLink");
    }

    @Override
    public String getPartnersLink() {
        return getLink("partnersLink");
    }

    @Override
    public String getPartnerWithUdemyLink() {
        return getLink("partnerWithUdemyLink");
    }

    @Override
    public String getProductTourLink() {
        return getLink("productTourLink");
    }

    @Override
    public String getNewsLink() {
        return getLink("newsLink");
    }

    @Override
    public String getInvestorRelationsLink() {
        return getLink("investorRelationsLink");
    }

    @Override
    public String getCareersLink() {
        return getLink("careersLink");
    }

    @Override
    public String getContactUsLink() {
        return getLink("contactUsLink");
    }

    @Override
    public String getHelpLink() {
        return getLink("helpLink");
    }

    @Override
    public String getTermsLink() {
        return getLink("termsLink");
    }

    @Override
    public String getPrivacyLink() {
        return getLink("privacyLink");
    }

    @Override
    public String getSitemapLink() {
        return getLink("sitemapLink");
    }

    @Override
    public String getFacebookLink() {
        return getLink("facebookLink");
    }

    @Override
    public String getLinkedInLink() {
        return getLink("linkedinLink");
    }

    @Override
    public String getTwitterLink() {
        return getLink("twitterLink");
    }

    @Override
    public String getInstagramLink() {
        return getLink("instagramLink");
    }

    // Helper method to fetch the URL based on the key
    private String getLink(String linkName) {
        ValueMap properties = resource.adaptTo(ValueMap.class);
        if (properties != null) {
            return properties.get(linkName, String.class);
        }
        return null;
    }

    @Override
    public Map<String, String> getAllLinks() {
        Map<String, String> allLinks = new HashMap<>();
        allLinks.put("Udemy Link", getUdemyLink());
        allLinks.put("About Us Link", getAboutUsLink());
        allLinks.put("Events Link", getEventsLink());
        allLinks.put("Partners & Integrations Link", getPartnersLink());
        allLinks.put("Partner with Udemy Link", getPartnerWithUdemyLink());
        allLinks.put("Product Tour Link", getProductTourLink());
        allLinks.put("News Link", getNewsLink());
        allLinks.put("Investor Relations Link", getInvestorRelationsLink());
        allLinks.put("Careers Link", getCareersLink());
        allLinks.put("Contact Us Link", getContactUsLink());
        allLinks.put("Help Link", getHelpLink());
        allLinks.put("Terms of Service Link", getTermsLink());
        allLinks.put("Privacy Policy Link", getPrivacyLink());
        allLinks.put("Sitemap Link", getSitemapLink());
        allLinks.put("Facebook Link", getFacebookLink());
        allLinks.put("LinkedIn Link", getLinkedInLink());
        allLinks.put("Twitter Link", getTwitterLink());
        allLinks.put("Instagram Link", getInstagramLink());

        return allLinks;
    }
}

