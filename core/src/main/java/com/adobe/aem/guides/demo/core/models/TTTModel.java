// package com.adobe.aem.guides.demo.core.models;




// import java.util.List;

// import org.apache.sling.api.resource.Resource;
// import org.apache.sling.models.annotations.DefaultInjectionStrategy;
// import org.apache.sling.models.annotations.Model;
// import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

// @Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
// public interface TTTModel {

//     @ValueMapValue
//     String getTextarea();  // For the Title field

//     @ValueMapValue
//     String getPath();  // For the Path field

//     @ValueMapValue
//     boolean getCheckbox();  // For the Checkbox field

//     List<MultifieldItem> getMultifield();  // For the Multifield (Text and Date Picker)

//     // Define a helper class to represent each item in the multifield
//     public static class MultifieldItem {
//         private String text;
//         private String date;

//         public MultifieldItem(String text, String date) {
//             this.text = text;
//             this.date = date;
//         }

//         public String getText() {
//             return text;
//         }

//         public String getDate() {
//             return date;
//         }
//     }
// }




package com.adobe.aem.guides.demo.core.models;

import java.util.Date;
import java.util.List;

public interface TTTModel {

    public String getTextarea(); // For the Title field

    public String getPath(); // For the Path field

    public boolean getCheckbox(); // For the Checkbox field

    public List<MultifieldItem> getMultifield(); // For the Multifield (Text and Date Picker)

    public static class MultifieldItem {
        private String text;
        private String date;

        public MultifieldItem(String text, String date) {
            this.text = text;
            this.date = date;
        }

        public String getText() {
            return text;
        }

        public String getDate() {
            return date;
        }
    }
}
