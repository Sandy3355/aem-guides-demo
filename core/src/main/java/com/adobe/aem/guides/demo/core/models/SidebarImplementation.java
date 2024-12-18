package com.adobe.aem.guides.demo.core.models;

import java.util.ArrayList;
import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SidebarImplementation {

    @ValueMapValue
    private String logopath;

    @ValueMapValue
    private String logoMobileImage;

    @ValueMapValue
    private String logoLink;

    @ValueMapValue
    private boolean enableSwitch;

    @ChildResource
    private List<HeaderLink> headerLinks;

    @ChildResource
    private List<NavigationItem> navigationItems;

    @ValueMapValue
    private String country;

    public String getLogopath() {
        return logopath;
    }

    public String getLogoMobileImage() {
        return logoMobileImage;
    }

    public String getLogoLink() {
        return logoLink;
    }

    public boolean isEnableSwitch() {
        return enableSwitch;
    }

    public List<HeaderLink> getHeaderLinks() {
        return headerLinks != null ? headerLinks : new ArrayList<>();
    }

    public List<NavigationItem> getNavigationItems() {
        return navigationItems != null ? navigationItems : new ArrayList<>();
    }

    public String getCountry() {
        return country;
    }

    // Inner Class for Header Links
    public static class HeaderLink {
        @ValueMapValue
        private String textField;

        @ValueMapValue
        private String imagePath;

        public String getTextField() {
            return textField;
        }

        public String getImagePath() {
            return imagePath;
        }
    }

    // Inner Class for Navigation Items
    public static class NavigationItem {
        @ValueMapValue
        private String desktopIcon;

        @ValueMapValue
        private String mobileIcon;

        @ChildResource
        private List<NestedUrl> nestedNavigationUrls;

        public String getDesktopIcon() {
            return desktopIcon;
        }

        public String getMobileIcon() {
            return mobileIcon;
        }

        public List<NestedUrl> getNestedNavigationUrls() {
            return nestedNavigationUrls != null ? nestedNavigationUrls : new ArrayList<>();
        }
    }

    // Inner Class for Nested URLs
    public static class NestedUrl {
        @ValueMapValue
        private String navigationUrl;

        public String getNavigationUrl() {
            return navigationUrl;
        }
    }
}