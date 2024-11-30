package com.adobe.aem.guides.demo.core.services;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "EmployeeConfiguration", description = "about EmployeeConfiguration")
 
public @interface EmployeeConfigurtation {

    @AttributeDefinition(name= "empID",
    description = "about empID",
    defaultValue= "Plz Enter Emp Id",
    type = AttributeType.STRING
    )
    public String empID();


    @AttributeDefinition(name= "empName",
    description = "about empName",
    defaultValue= "Plz Enter Emp Name",
    type = AttributeType.STRING
    )
    public String empName();

    @AttributeDefinition(name= "empSecret",
    description = "about empSecret",
    defaultValue= "Plz Enter Emp Secret",
    type = AttributeType.STRING
    )
    public String empSecret();

    @AttributeDefinition(name= "restApi",
    description = "about restApi",
    defaultValue= "Plz Enter Rest Api",
    type = AttributeType.STRING
    )
    public String restApi();

}
