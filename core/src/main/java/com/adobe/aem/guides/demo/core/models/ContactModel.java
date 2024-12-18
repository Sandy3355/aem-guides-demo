package com.adobe.aem.guides.demo.core.models;

// Import necessary libraries
import java.util.List;

/**
 * Interface for ContactModel
 * Defines methods for getting contact details.
 */
public interface ContactModel {

    /**
     * Get the email address.
     * 
     * @return the email address as a String.
     */
    String getEmail();

    /**
     * Get the phone number.
     * 
     * @return the phone number as a String.
     */
    String getPhone();

    /**
     * Get the comments.
     * 
     * @return the comments as a String.
     */
    String getComments();
}
