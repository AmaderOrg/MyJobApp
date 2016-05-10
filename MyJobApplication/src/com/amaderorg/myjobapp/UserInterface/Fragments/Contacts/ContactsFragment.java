package com.amaderorg.myjobapp.UserInterface.Fragments.Contacts;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.amaderorg.myjobapp.Model.Database.Tables.Contact;
import com.amaderorg.myjobapp.Presenter.Contacts.IContactInformationPresenter;
import com.amaderorg.myjobapp.Presenter.Contacts.ContactInformationPresenter;
import com.amaderorg.myjobapp.R;
import com.amaderorg.myjobapp.UserInterface.Views.Contacts.AddContactInformationView;
import com.amaderorg.myjobapp.UserInterface.Views.Contacts.ContactInformationSummaryView;
import com.amaderorg.myjobapp.UserInterface.Views.Contacts.ContactInformationView;

/**
 * Created by souvi_000 on 3/28/2016.
 */
public class ContactsFragment extends Fragment implements Button.OnClickListener {
    private ContactInformationView mContactDetailsView;
    private AddContactInformationView mAddSenderView;
    private ContactInformationSummaryView mContactSummaryView;
    private Context mContext;
    private ViewGroup mContainer;
    private IContactInformationPresenter mSenderInfoPresenter;
    private TextWatcher mFirstNameWatcher;
    private TextWatcher mLastNameWatcher;
    private TextWatcher mCompanyNameWatcher;
    private TextWatcher mLocationWatcher;
    private TextWatcher mEmailWatcher;
    private String mFirstName;
    private String mLastName;
    private String mCompanyName;
    private int mLocation;
    private String mEmailId;
    private Contact mCurrentContact;

    @Override
    public void onCreate (Bundle savedInstanceState){
        mContext = getActivity();
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        // refresh view
        mContactDetailsView.populateContactList(mSenderInfoPresenter.getContactList());
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View mainView;
        mainView = inflater.inflate(R.layout.contacts_frag,container,false);
        initTextWatchers();
        mContactDetailsView = new ContactInformationView(mContext);
        mAddSenderView = new AddContactInformationView(mContext);
        mContactSummaryView = new ContactInformationSummaryView(mContext);
        mContainer = (ViewGroup)mainView.findViewById(R.id.rl_contacts_container);
        mContainer.addView(mContactDetailsView);
        mContactDetailsView.addButtonClickListener(this);
        mAddSenderView.addButtonClickListener(this);
        mContactSummaryView.addButtonClickListener(this);
        mSenderInfoPresenter = new ContactInformationPresenter(mContext);
        mAddSenderView.addTextWatchers(mFirstNameWatcher,
                mLastNameWatcher,
                mCompanyNameWatcher,
                mLocationWatcher,
                mEmailWatcher);

        return mainView;
    }

    private void initTextWatchers() {
        mFirstNameWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFirstName = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        mLastNameWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mLastName = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        mCompanyNameWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCompanyName =s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        mLocationWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mLocation = Integer.parseInt(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        mEmailWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mEmailId = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.button_add_contacts:
                mContainer.removeAllViews();
                mContainer.addView(mAddSenderView);
                break;
            case R.id.button_add_sender_info:
                mContainer.removeAllViews();
                mContainer.addView(mContactSummaryView);
                mCurrentContact = getContactObject(mFirstName,
                        mLastName,
                        mCompanyName,
                        mLocation,
                        mEmailId);
                mContactSummaryView.populateContactInformation(mCurrentContact);
                mAddSenderView.removeTextWatchers(); // removing text watches before clearing data
                mAddSenderView.clearEditTextViews();
                mAddSenderView.addTextWatchers(mFirstNameWatcher, mLastNameWatcher, mCompanyNameWatcher,
                        mLocationWatcher, mEmailWatcher); // adding text watchers back
                break;
            case R.id.button_cancel_sender_info:
                mContainer.removeAllViews();
                mContainer.addView(mContactDetailsView);
                mContactDetailsView.populateContactList(mSenderInfoPresenter.getContactList());
                break;
            case R.id.button_cancel_contact_details:
                getActivity().finish();
                break;
            case R.id.button_confirm_summary_contact:
                mSenderInfoPresenter.addContactInformation(mCurrentContact);
                mContainer.removeAllViews();
                mContainer.addView(mContactDetailsView);
                mContactDetailsView.populateContactList(mSenderInfoPresenter.getContactList());
                break;
            case R.id.button_cancel_summary_contact:
                mContainer.removeAllViews();
                mContainer.addView(mContactDetailsView);
                mContactDetailsView.populateContactList(mSenderInfoPresenter.getContactList());
        }
    }

    private Contact getContactObject(String firstName,
                                     String lastName,
                                     String companyName,
                                     int location,
                                     String emailId) {
        return new Contact(firstName, lastName, companyName, location, emailId);
    }
}
