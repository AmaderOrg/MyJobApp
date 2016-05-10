package com.amaderorg.myjobapp.UserInterface.Views.Contacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.amaderorg.myjobapp.R;

/**
 * Created by souvi_000 on 4/15/2016.
 */
public class ContactDetailsRow extends RelativeLayout {
    private TextView mFName, mLName, mCompany, mEmail;
    public ContactDetailsRow(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.contact_row, this);
        mFName = (TextView) findViewById(R.id.tv_first_name);
        mLName = (TextView) findViewById(R.id.tv_last_name);
        mCompany = (TextView) findViewById(R.id.tv_company);
        mEmail = (TextView) findViewById(R.id.tv_email);
    }

    public void setContactDetails(String fName, String lName, String company, String email) {
        mFName.setText(fName);
        mLName.setText(lName);
        mCompany.setText(company);
        mEmail.setText(email);
    }
}
