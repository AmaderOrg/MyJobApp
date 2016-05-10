package com.amaderorg.myjobapp.UserInterface.Views.Contacts;

import android.content.Context;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amaderorg.myjobapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by souvi_000 on 3/28/2016.
 */
public class AddContactInformationView extends LinearLayout {
    private static final String EMPTY_STRING = "";

    private Button mAddSenderInfoButton;
    private Button mCancelSenderInfoButton;
    private EditText mFirstName;
    private EditText mLastName;
    private EditText mCompanyName;
    private EditText mLocation;
    private EditText mEmailId;
    private List<OnClickListener> mListeners;

    private TextWatcher mFirstNameWatcher, mLastNameWatcher,
    mCompanyNameWatcher, mLocationWatcher,
    mEmailWatcher;

    public AddContactInformationView(Context context) {
        super(context);
        View view = View.inflate(context, R.layout.add_sender_info_view, this);

        mListeners = new ArrayList<OnClickListener>();

        mFirstName = (EditText) view.findViewById(R.id.et_first_name);
        mLastName = (EditText) view.findViewById(R.id.et_last_name);
        mCompanyName = (EditText) view.findViewById(R.id.et_company_name);
        mLocation = (EditText) view.findViewById(R.id.et_location);
        mEmailId = (EditText) view.findViewById(R.id.et_email_id);

        mAddSenderInfoButton = (Button) view.findViewById(R.id.button_add_sender_info);
        if (mAddSenderInfoButton != null) {
            mAddSenderInfoButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (OnClickListener listener : mListeners) {
                        listener.onClick(v);
                    }
                }
            });
        }
        mCancelSenderInfoButton = (Button) view.findViewById(R.id.button_cancel_sender_info);
        if(mCancelSenderInfoButton != null) {
            mCancelSenderInfoButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (OnClickListener listener : mListeners) {
                        listener.onClick(v);
                    }
                }
            });
        }
    }


    public void addButtonClickListener(View.OnClickListener listener) {
        mListeners.add(listener);
    }

    public void addTextWatchers(TextWatcher firstNameWatcher, TextWatcher lastNameWatcher,
                                TextWatcher companyNameWatcher, TextWatcher locationWatcher,
                                TextWatcher emailWatcher) {
        mFirstNameWatcher = firstNameWatcher;
        mLastNameWatcher = lastNameWatcher;
        mCompanyNameWatcher = companyNameWatcher;
        mLocationWatcher = locationWatcher;
        mEmailWatcher = emailWatcher;
        if (mFirstName != null) {
            mFirstName.addTextChangedListener(firstNameWatcher);
        }
        if(mLastName != null) {
            mLastName.addTextChangedListener(lastNameWatcher);
        }
        if (mCompanyName != null) {
            mCompanyName.addTextChangedListener(companyNameWatcher);
        }
        if (mLocation != null) {
            mLocation.addTextChangedListener(locationWatcher);
        }
        if (mEmailId != null) {
            mEmailId.addTextChangedListener(emailWatcher);
        }
    }

    public void removeTextWatchers() {
        mFirstName.removeTextChangedListener(mFirstNameWatcher);
        mLastName.removeTextChangedListener(mLastNameWatcher);
        mCompanyName.removeTextChangedListener(mCompanyNameWatcher);
        mLocation.removeTextChangedListener(mLocationWatcher);
        mEmailId.removeTextChangedListener(mEmailWatcher);
    }

    /**
     * Clearing all editable fields in the form
     */
    public void clearEditTextViews() {
        mFirstName.setText(EMPTY_STRING);
        mLastName.setText(EMPTY_STRING);
        mCompanyName.setText(EMPTY_STRING);
//        mLocation.setHint("");
        mLocation.setText("", TextView.BufferType.EDITABLE);
        mEmailId.setText(EMPTY_STRING);
    }
}
