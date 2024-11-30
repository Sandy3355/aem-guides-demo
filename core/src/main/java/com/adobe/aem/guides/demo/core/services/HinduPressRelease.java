package com.adobe.aem.guides.demo.core.services;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component(immediate=true)
public class HinduPressRelease {

     private static final Logger LOG = LoggerFactory.getLogger(HinduPressRelease.class);

     @Reference
     DemoService demoService;
    
    @Activate
    public void activate() {
        String result = demoService.printData();
        LOG.info("HinduPressRelease activate() started");
      
        LOG.info("Result {}", result);


    }

    
    @Deactivate
    public void deactivate() {
        LOG.info("HinduPressRelease deactivate() ended");
    }

    @Modified
    public void update() {
        LOG.info("HinduPressRelease modified() updateds");
    }

    
}


