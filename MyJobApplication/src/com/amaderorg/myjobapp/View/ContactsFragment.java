package com.amaderorg.myjobapp.View;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.amaderorg.myjobapp.Presenter.Contacts.IContactInformationPresenter;
import com.amaderorg.myjobapp.Presenter.Contacts.ContactInformationPresenter;
import com.amaderorg.myjobapp.R;

/**
 * Created by souvi_000 on 3/28/2016.
 */
public class ContactsFragment extends Fragment implements Button.OnClickListener {
    private SenderInformationView mSenderDetailsView;
    private AddSenderInformationView mAddSenderView;
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

    @Override
    public void onCreate (Bundle savedInstanceState){
        mContext = getActivity();
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View mainView;
        mainView = inflater.inflate(R.layout.contacts_frag,container,false);
        initTextWatchers();
        mSenderDetailsView = new SenderInformationView(mContext);
        mAddSenderView = new AddSenderInformationView(mContext);
        mContainer = (ViewGroup)mainView.findViewById(R.id.rl_contacts_container);
        mContainer.addView(mSenderDetailsView);
        mSenderDetailsView.addButtonClickListener(this);
        mAddSenderView.addButtonClickListener(this);
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
                mSenderInfoPresenter.addSenderInformation(mFirstName,
                        mLastName,
                        mCompanyName,
                        mLocation,
                        mEmailId);
                break;
            case R.id.button_cancel_sender_info:
                break;
        }
    }
}
