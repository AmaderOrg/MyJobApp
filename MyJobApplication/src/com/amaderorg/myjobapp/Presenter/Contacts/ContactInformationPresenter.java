package com.amaderorg.myjobapp.Presenter.Contacts;

import android.content.Context;

import com.amaderorg.myjobapp.Model.Database.DBManager;
import com.amaderorg.myjobapp.Model.Database.Tables.ContactInformation;

/**
 * Created by souvi_000 on 3/28/2016.
 */
public class ContactInformationPresenter implements IContactInformationPresenter {
    private Context mContext;
    private DBManager manager;
    public ContactInformationPresenter(Context context){
        manager = new DBManager(context);
    }

    @Override
    public void addSenderInformation(String firstName,
                                     String lastName,
                                     String company,
                                     int location,
                                     String email) {
        manager.addSenderContact(new ContactInformation(firstName, lastName, company, location, email));
    }
}
