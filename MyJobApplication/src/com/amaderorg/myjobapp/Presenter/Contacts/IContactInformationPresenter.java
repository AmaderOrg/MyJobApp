package com.amaderorg.myjobapp.Presenter.Contacts;

/**
 * Created by souvi_000 on 3/28/2016.
 */
public interface IContactInformationPresenter {

    /**
     * Adding sender information to the database
     *
     * @param firstName : first name
     * @param lastName  : last name
     * @param company   : company name
     * @param location  : location
     * @param email     : email id
     */
    void addSenderInformation(String firstName,
                              String lastName,
                              String company,
                              int location,
                              String email);
}
