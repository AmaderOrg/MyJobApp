package com.amaderorg.myjobapp.Presenter.Contacts;

import com.amaderorg.myjobapp.Model.Database.Tables.Contact;

/**
 * Contact information presenter
 */
public interface IContactInformationPresenter {

    /**
     * Adding contact information to the database
     *
     * @param contact : contact information for a person
     */
    void addContactInformation(Contact contact);
}
