package com.adobe.aem.guides.demo.core.services;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


@Component(service = EmployeeDetails.class,immediate = true, enabled = true)
@Designate(ocd=EmployeeConfigurtation.class)
public class EmployeeDetails {

    private static final Logger LOG=LoggerFactory.getLogger(EmployeeDetails.class);

    private String empID;

    private String empName;

    private String empSecret;

    private String restApi;

    @Activate
    public void activate(EmployeeConfigurtation employeeConfiguration){
        
        
        LOG.info ("EmployeeDetails activate()");
        updateEmpDetails(employeeConfiguration);
    }
    
    @Deactivate
    public void deactivate(EmployeeConfigurtation employeeConfiguration){
        LOG.info("EmployeeDetails deactivate()");
        updateEmpDetails(employeeConfiguration);
    }

    @Modified
    public void modified(EmployeeConfigurtation employeeConfiguration){
        LOG.info("EmployeeDetails mpdify()");
        updateEmpDetails(employeeConfiguration);
    }

    public void updateEmpDetails(EmployeeConfigurtation employeeConfiguration){
        
        this.empID = employeeConfiguration.empID();

        this.empName = employeeConfiguration.empName();

        this.empSecret = employeeConfiguration.empSecret();

        this.restApi = employeeConfiguration.restApi();

        LOG.info("empID is {}, empName{}, empSecret{},restApi", empID, empName,empSecret,restApi);
    }


}
