package com.amaderorg.myjobapp.Model.Database.Tables;

/**
 * Created by souvi_000 on 3/28/2016.
 */
public class ContactInformation {
    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public String getCompanyName() {
        return mCompanyName;
    }

    public void setCompanyName(String mCompanyName) {
        this.mCompanyName = mCompanyName;
    }

    public int getLocation() {
        return mLocation;
    }

    public void setLocation(int mLocation) {
        this.mLocation = mLocation;
    }

    public String getEmailId() {
        return mEmailId;
    }

    public void setEmailId(String mEmailId) {
        this.mEmailId = mEmailId;
    }

    private String mFirstName;
    private String mLastName;
    private String mCompanyName;
    private int mLocation;
    private String mEmailId;

    public ContactInformation(){}

    /**
     * Senders Contact information
     * @param firstName
     * @param lastName
     * @param companyName
     * @param location
     * @param emailId
     */
    public ContactInformation(String firstName,
                              String lastName,
                              String companyName,
                              int location,
                              String emailId) {
        mFirstName = firstName;
        mLastName = lastName;
        mCompanyName = companyName;
        mLocation = location;
        mEmailId = emailId;
    }
}
