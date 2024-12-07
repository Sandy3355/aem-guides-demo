package com.adobe.aem.guides.demo.core.schedulers;


import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "ArticleExpiryDateConfiguration", description = "Scheduler configuration for demonstration")
public @interface ArticleExpiryDateConfiguration {

    @AttributeDefinition(
        name = "schedulerName",
        description = "about schedulerName",
        defaultValue = "Please mention schedular name"
    )
    public String schedulerName() default "0 0/1 * 1/1 * ? *"; // Default: Every 1 minute

    @AttributeDefinition(
        name = "Scheduler Expression",
        description = "about schedulerExpression",
        defaultValue = "* * * * * ?"
    )
    public String schedulerExpression() default "0 0/1 * 1/1 * ? *"; // Default: Every 1 minute

    @AttributeDefinition(
        name = "Scheduler_Concurrent",
        description = "about scheduler_Concurrent"
    )
    public boolean concurrent_Scheduler() default false;


    @AttributeDefinition(
        name = "Scheduler_Enabled",
        description = "about scheduler_Enabled"
    )
    public boolean enabled() default true;

}
