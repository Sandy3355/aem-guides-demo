package com.adobe.aem.guides.demo.core.schedulers;



import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.osgi.service.component.annotations.Deactivate;

@Component(service = Runnable.class, immediate = true)
@Designate(ocd = ArticleExpiryDateConfiguration.class)
public class ArticleExpiryDate implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(ArticleExpiryDate.class);

    @Reference
    private Scheduler scheduler;

    @Activate
    public void activate(ArticleExpiryDateConfiguration articleExpiryDateConfiguration){
        updateLatestValues(articleExpiryDateConfiguration);
        LOG.info("ArticleExpiryDate activate()");
    }

    @Deactivate
    public void deActivate(ArticleExpiryDateConfiguration articleExpiryDateConfiguration){
        updateLatestValues(articleExpiryDateConfiguration);
        
    }

    @Modified
    public void modified(ArticleExpiryDateConfiguration articleExpiryDateConfiguration){
        updateLatestValues(articleExpiryDateConfiguration);
        
    }

    public void updateLatestValues(ArticleExpiryDateConfiguration articleExpiryDateConfiguration){

        if(articleExpiryDateConfiguration.enabled()){
            ScheduleOptions options = scheduler.EXPR(articleExpiryDateConfiguration.schedulerExpression());
                        options.name(articleExpiryDateConfiguration.schedulerName());
                        options.canRunConcurrently(false);
        scheduler.schedule(this, options);
        } else{
            scheduler.unschedule(articleExpiryDateConfiguration.schedulerName());
        }
    }

    @Override
    public void run() {
        LOG.info("ArticleExpiryDate run()  Excuting");
    }
}