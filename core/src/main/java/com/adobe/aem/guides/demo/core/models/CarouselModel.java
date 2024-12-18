package com.adobe.aem.guides.demo.core.models;

import java.util.List;

public interface CarouselModel {

    // Get the list of multifield items (Text + path)
    public List<MultifieldItem> getMultifield();

    // Define a nested MultifieldItem class for the outer multifield
    public static class MultifieldItem {
        private String text;
        private String path;
        private List<InnerMultifieldItem> innerMultifields; // Inner multifield items

        // Constructor for MultifieldItem
        public MultifieldItem(String text, String path, List<InnerMultifieldItem> innerMultifields) {
            this.text = text;
            this.path = path;
            this.innerMultifields = innerMultifields;
        }

        public String getText() {
            return text;
        }

        public String getPath() {
            return path;
        }

        public List<InnerMultifieldItem> getInnerMultifields() {
            return innerMultifields;
        }
    }

    // Define the inner MultifieldItem class for the nested multifield
    public static class InnerMultifieldItem {
        private String texts; // Note: renamed "text" to "texts" to avoid name conflicts

        public InnerMultifieldItem(String texts) {
            this.texts = texts;
        }

        public String getText() {
            return texts;
        }
    }
}