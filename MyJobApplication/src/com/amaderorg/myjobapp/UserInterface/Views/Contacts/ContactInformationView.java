package com.amaderorg.myjobapp.UserInterface.Views.Contacts;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amaderorg.myjobapp.Model.Database.Tables.Contact;
import com.amaderorg.myjobapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by souvi_000 on 3/28/2016.
 */
public class ContactInformationView extends LinearLayout {
    private View mMainView;
    private Button mAddButton;
    private Button mCancelButton;
    private Context mContext;
    private LinearLayout mContactListView;
    private List<ContactDetailsRow> mContactList;
    private List<OnClickListener> mListeners;

    private OnClickListener onClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            for (OnClickListener listener : mListeners) {
                listener.onClick(v);
            }
        }
    };

    public ContactInformationView(Context context) {
        super(context);
        mContext = context;
        mMainView = View.inflate(context, R.layout.show_contact_info_view, this);
        mContactList = new ArrayList<ContactDetailsRow>();
        mContactListView = (LinearLayout) mMainView.findViewById(R.id.ll_contacts_detail);
        mAddButton = (Button) mMainView.findViewById(R.id.button_add_contacts);
        mAddButton.setOnClickListener(onClickListener);
        mCancelButton = (Button) mMainView.findViewById(R.id.button_cancel_contact_details);
        mCancelButton.setOnClickListener(onClickListener);
        mListeners = new ArrayList<OnClickListener>();
    }

    public void populateContactList(List<Contact> contactList) {
        mContactListView.removeAllViews();
        mContactList.clear();
        for (Contact contact : contactList) {
            if (contactList.size() > 0) {
                ContactDetailsRow row = new ContactDetailsRow(mContext);
                row.setContactDetails(contact.getFirstName(),
                        contact.getLastName(),
                        contact.getCompanyName(),
                        contact.getEmailAddress());
                mContactList.add(row);
                mContactListView.addView(row);
            } else {
                //empty list
                TextView view = new TextView(mContext);
                view.setText("No contacts");
                mContactListView.addView(view);
            }
        }
    }

    public void addButtonClickListener(OnClickListener listener) {
        mListeners.add(listener);
    }
}
