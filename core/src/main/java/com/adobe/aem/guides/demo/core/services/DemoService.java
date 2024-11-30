
// package com.adobe.aem.guides.demo.core.services;

// import org.osgi.service.component.annotations.Activate;
// import org.osgi.service.component.annotations.Component;
// import org.osgi.service.component.annotations.Deactivate;
// import org.osgi.service.component.annotations.Modified;
// import org.osgi.service.metatype.annotations.Designate;
// import org.osgi.service.metatype.annotations.ObjectClassDefinition;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

// @Component(service = DemoService.class, immediate = true)
// @Designate(ocd = DemoService.Config.class)
// public class DemoService {

//     private static final Logger LOG = LoggerFactory.getLogger(DemoService.class);

//     private String configMessage;

//     @ObjectClassDefinition(name = "Demo Service Configuration")
//     public @interface Config {
//         String message() default "Default service message";
//     }

//     @Activate
//     protected void activate(Config config) {
//         this.configMessage = config.message();
//         LOG.info("DemoService Activated with message: {}", configMessage);
//     }

//     @Deactivate
//     protected void deactivate() {
//         LOG.info("DemoService Deactivated");
//     }

//     @Modified
//     protected void modified(Config config) {
//         this.configMessage = config.message();
//         LOG.info("DemoService Modified with new message: {}", configMessage);
//     }

//     public String getMessage() {
//         return configMessage;
//     }
// }




package com.adobe.aem.guides.demo.core.services;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component(service = DemoService.class ,immediate = true,enabled = true)
public class DemoService {

    private static final Logger LOG = LoggerFactory.getLogger(DemoService.class);

    
    @Activate
    public void activate() {
        LOG.info("DemoService activate() started");
    }

    
    @Deactivate
    public void deactivate() {
        LOG.info("DemoService deactivate() ended");
    }

    @Modified
    public void update() {
        LOG.info("DemoService modified() update");
    }

    public String printData(){
        return "print data of HinduPressRelease";
    }
}