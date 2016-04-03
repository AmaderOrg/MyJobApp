package com.amaderorg.myjobapp.Model.Database.Tables;

/**
 * Contact temple class
 */
public class Contact {
    // contact first name
    private String mFirstName;
    // contact last name
    private String mLastName;
    // contact company name
    private String mCompanyName;
    // contact location
    private int mLocation;
    // contact email address
    private String mEmailAddress;

    /**
     * Empty default constructor
     */
    public Contact(){}

    /**
     * Getter for first name
     * @return first name for the contact
     */
    public String getFirstName() {
        return mFirstName;
    }

    /**
     * Setter for first name
     * @param mFirstName : first name for the contact
     */
    public void setFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    /**
     * Getter for last name
     * @return last name for the contact
     */
    public String getLastName() {
        return mLastName;
    }

    /**
     * Setter for last name
     * @param mLastName : last name for the contact
     */
    public void setLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    /**
     * Getter for company name
     * @return company name for the contact
     */
    public String getCompanyName() {
        return mCompanyName;
    }

    /**
     * Setter for company name
     * @param mCompanyName : company name for the contact
     */
    public void setCompanyName(String mCompanyName) {
        this.mCompanyName = mCompanyName;
    }

    /**
     * Getter for location
     * @return location for the contact
     */
    public int getLocation() {
        return mLocation;
    }

    /**
     * Setter for location
     * @return location for the contact
     */
    public void setLocation(int mLocation) {
        this.mLocation = mLocation;
    }

    /**
     * Getter for email address
     * @return email address for the contact
     */
    public String getEmailAddress() {
        return mEmailAddress;
    }

    /**
     * Setter for email address
     * @param mEmailId : email address for the contact
     */
    public void setEmailId(String mEmailId) {
        this.mEmailAddress = mEmailId;
    }

    /**
     * Senders Contact information
     * @param firstName  : First name of a contact
     * @param lastName   : Last name of a contact
     * @param companyName: Company name of a contact
     * @param location   : Location of a contact
     * @param emailAddress    : Email address of a contact
     */
    public Contact(String firstName,
                   String lastName,
                   String companyName,
                   int location,
                   String emailAddress) {
        mFirstName = firstName;
        mLastName = lastName;
        mCompanyName = companyName;
        mLocation = location;
        mEmailAddress = emailAddress;
    }
}
