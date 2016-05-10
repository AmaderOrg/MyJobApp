package com.amaderorg.myjobapp.UserInterface.Views.Contacts;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.amaderorg.myjobapp.Model.Database.Tables.Contact;
import com.amaderorg.myjobapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Contact summary view required to confirm added or edited contact information
 */
public class ContactInformationSummaryView extends RelativeLayout {
    private TextView mFirstName;
    private TextView mLastName;
    private TextView mCompanyName;
    private TextView mLocation;
    private TextView mEmailId;
    private List<OnClickListener> mListeners;

    private Button mConfirmButton;
    private Button mCancelButton;


    public ContactInformationSummaryView(Context context) {
        super(context);
        View view = View.inflate(context, R.layout.contact_summary_view, this);

        mListeners = new ArrayList<OnClickListener>();

        mFirstName = (TextView) view.findViewById(R.id.tv_first_name);
        mLastName = (TextView) view.findViewById(R.id.tv_last_name);
        mCompanyName = (TextView) view.findViewById(R.id.tv_company_name);
        mLocation = (TextView) view.findViewById(R.id.tv_location);
        mEmailId = (TextView) view.findViewById(R.id.tv_email_id);

        mConfirmButton = (Button) view.findViewById(R.id.button_confirm_summary_contact);
        if (mConfirmButton != null) {
            mConfirmButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (OnClickListener listener : mListeners) {
                        listener.onClick(v);
                    }
                }
            });
        }
        mCancelButton = (Button) view.findViewById(R.id.button_cancel_summary_contact);
        if (mCancelButton != null) {
            mCancelButton.setOnClickListener(new OnClickListener() {
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

    public void populateContactInformation(Contact contact) {
        mFirstName.setText(contact.getFirstName());
        mLastName.setText(contact.getLastName());
        mCompanyName.setText(contact.getCompanyName());
        mLocation.setText(String.valueOf(contact.getLocation()));
        mEmailId.setText(contact.getEmailAddress());
    }
}
