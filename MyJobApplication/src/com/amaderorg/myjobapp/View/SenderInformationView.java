package com.amaderorg.myjobapp.View;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.Button.*;
import android.widget.LinearLayout;

import com.amaderorg.myjobapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by souvi_000 on 3/28/2016.
 */
public class SenderInformationView extends LinearLayout {
    private LinearLayout mSenderDetailsView;
    private View mMainView;
    private Button mAddButton;
    private List<OnClickListener> mListeners;

    public SenderInformationView (Context context) {
        super(context);
        mMainView = View.inflate(context, R.layout.show_sender_info_view, this);
        mSenderDetailsView = (LinearLayout) mMainView.findViewById(R.id.ll_contacts_detail);
        mAddButton = (Button) mMainView.findViewById(R.id.button_add_contacts);
        mAddButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                for (OnClickListener listener : mListeners) {
                    listener.onClick(v);
                }
            }
        });
        mListeners = new ArrayList<OnClickListener>();
    }

    public void addButtonClickListener(OnClickListener listener) {
        mListeners.add(listener);
    }
}
